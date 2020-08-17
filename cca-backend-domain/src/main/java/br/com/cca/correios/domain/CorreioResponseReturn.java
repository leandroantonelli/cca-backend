package br.com.cca.correios.domain;

import br.com.cca.commons.domain.AbstractDomain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "return", namespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@ToString
public class CorreioResponseReturn extends AbstractDomain {

    @XmlElement(name = "bairro")
    private String dsBairro;

    @XmlElement(name = "cep")
    private String dsCep;

    @XmlElement(name = "cidade")
    private String dsCidade;

    @XmlElement(name = "complemento2")
    private String dsComplemento;

    @XmlElement(name = "end")
    private String dsEndereco;

    @XmlElement(name = "uf")
    private String dsUf;
}
