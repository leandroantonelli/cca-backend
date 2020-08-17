package br.com.cca.correios.domain;

import br.com.cca.commons.domain.AbstractDomain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Fault", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@ToString
public class ErrorResponse extends AbstractDomain {

    @XmlElement(name = "faultcode")
    private Integer faultcode;

    @XmlElement(name = "faultstring")
    private String faultstring;
}
