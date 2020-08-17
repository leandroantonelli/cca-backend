package br.com.cca.correios.webservice;

import br.com.cca.correios.domain.CorreiosRequest;
import br.com.cca.correios.domain.CorreiosResponse;
import br.com.cca.correios.domain.ErrorResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * User: Leandro Antonelli
 * Date: 04/08/20
 */
@Service
public class CorreiosWebServiceSoap {

    @Value("${correios.webservice}")
    public String dsUrlCorreios;

    public CorreiosResponse sendRequest(String dsCep) throws Exception {

        CorreiosRequest correiosRequest = new CorreiosRequest();
        correiosRequest.setCep(dsCep);

        WebServiceTemplate webServiceTemplate = createWebServiceTemplate(correiosRequest);

        CorreiosResponse response = (CorreiosResponse) webServiceTemplate.marshalSendAndReceive(correiosRequest);

        return response;
    }

    private WebServiceTemplate createWebServiceTemplate(CorreiosRequest correiosRequest) throws Exception {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(correiosRequest.getClass(), CorreiosResponse.class, ErrorResponse.class);
        marshaller.afterPropertiesSet();

        webServiceTemplate.setDefaultUri(dsUrlCorreios);
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        webServiceTemplate.afterPropertiesSet();
        return webServiceTemplate;
    }
}
