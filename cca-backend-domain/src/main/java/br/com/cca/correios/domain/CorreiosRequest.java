package br.com.cca.correios.domain;

import br.com.cca.commons.domain.AbstractDomain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "consultaCEP", namespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@ToString
public class CorreiosRequest extends AbstractDomain {

    @XmlElement(name = "cep")
    private String cep;
}
