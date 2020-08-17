package br.com.cca.correios.service;

import br.com.cca.correios.domain.CorreioResponseReturn;
import br.com.cca.correios.domain.CorreiosResponse;
import br.com.cca.correios.webservice.CorreiosWebServiceSoap;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Leandro Antonelli
 * Date: 04/08/20
 */
@Log4j2
@Service
public class CorreiosService {

    @Autowired
    private CorreiosWebServiceSoap correiosWebServiceSoap;

    public CorreioResponseReturn getCep(String dsCep) {

        try {
            CorreiosResponse correiosResponse = correiosWebServiceSoap.sendRequest(dsCep);

            return correiosResponse.getConsultaCEP();
        } catch (Exception e) {
            log.error("Falha ao consultar o CEP: " + dsCep, e);
            return null;
        }
    }
}
