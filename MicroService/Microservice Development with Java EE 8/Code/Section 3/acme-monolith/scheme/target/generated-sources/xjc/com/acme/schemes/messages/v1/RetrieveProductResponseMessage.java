//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.20 at 03:21:32 PM IST 
//


package com.acme.schemes.messages.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.acme.schemes.common.v1.BaseMessageType;
import com.acme.schemes.ecommerce.v1.Product;


/**
 * <p>Java class for RetrieveProductResponseMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveProductResponseMessage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://acme.com/schemes/common/v1}BaseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="product" type="{http://acme.com/schemes/ecommerce/v1}Product" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveProductResponseMessage", propOrder = {
    "product"
})
public class RetrieveProductResponseMessage
    extends BaseMessageType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected Product product;

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setProduct(Product value) {
        this.product = value;
    }

}
