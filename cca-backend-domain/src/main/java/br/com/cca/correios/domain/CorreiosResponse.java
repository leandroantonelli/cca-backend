package br.com.cca.correios.domain;

import br.com.cca.commons.domain.AbstractDomain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "consultaCEPResponse", namespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({CorreioResponseReturn.class})
@Getter
@Setter
@ToString
public class CorreiosResponse extends AbstractDomain {

    @XmlElement(name = "return")
    private CorreioResponseReturn consultaCEP;
}
