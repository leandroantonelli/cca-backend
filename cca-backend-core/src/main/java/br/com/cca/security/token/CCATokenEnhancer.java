package br.com.cca.security.token;

import br.com.cca.user.commons.UserCommons;
import br.com.cca.user.domain.CustomUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Leandro Antonelli
 * Date: 13/06/20
 */
@Service
public class CCATokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        customUser.getUser().setDsPassword(null);

        Map<String, Object> addInfo = new HashMap<>();
        addInfo.put("user", customUser.getUser());
        addInfo.put("authorities", UserCommons.getPermissoes(customUser.getUser()));

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);

        return accessToken;
    }
}
