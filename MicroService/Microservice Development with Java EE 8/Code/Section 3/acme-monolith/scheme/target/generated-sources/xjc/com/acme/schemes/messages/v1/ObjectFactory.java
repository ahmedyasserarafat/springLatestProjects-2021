//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.20 at 03:21:32 PM IST 
//


package com.acme.schemes.messages.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.acme.schemes.messages.v1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RetrieveProductRequestMessageId_QNAME = new QName("http://acme.com/schemes/messages/v1", "id");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.acme.schemes.messages.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetrieveProductRequestMessage }
     * 
     */
    public RetrieveProductRequestMessage createRetrieveProductRequestMessage() {
        return new RetrieveProductRequestMessage();
    }

    /**
     * Create an instance of {@link RetrieveProductResponseMessage }
     * 
     */
    public RetrieveProductResponseMessage createRetrieveProductResponseMessage() {
        return new RetrieveProductResponseMessage();
    }

    /**
     * Create an instance of {@link ECommerceError }
     * 
     */
    public ECommerceError createECommerceError() {
        return new ECommerceError();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.com/schemes/messages/v1", name = "id", scope = RetrieveProductRequestMessage.class)
    public JAXBElement<String> createRetrieveProductRequestMessageId(String value) {
        return new JAXBElement<String>(_RetrieveProductRequestMessageId_QNAME, String.class, RetrieveProductRequestMessage.class, value);
    }

}