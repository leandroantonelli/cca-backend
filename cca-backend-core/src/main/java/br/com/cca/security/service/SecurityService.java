package br.com.cca.security.service;

import br.com.cca.commons.service.AbstractService;
import org.apache.commons.codec.binary.Hex;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * User: Leandro Antonelli
 * Date: 04/07/20
 */
@Service
public class SecurityService extends AbstractService {

    private static final int ITERATION_COUNT = 4096;

    private static final int KEY_LENGTH = 512;

    public String encrypt(String dsText, String dsSalt) {

        if (Strings.isEmpty(dsText)) {
            throw new IllegalArgumentException("Texto não pode ser nulo");
        }

        if (Strings.isEmpty(dsSalt)) {
            throw new IllegalArgumentException("Salt da senha é obrigatório");
        }

        byte[] hashedBytes = getByteSecurity(dsText, dsSalt);
        String hashedString = Hex.encodeHexString(hashedBytes).toUpperCase();

        return hashedString;

    }

    private byte[] getByteSecurity(String dsText, String dsSalt) {

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            PBEKeySpec spec = new PBEKeySpec(dsText.toCharArray(), dsSalt.getBytes(), ITERATION_COUNT, KEY_LENGTH);

            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();
            return res;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

    }

}
