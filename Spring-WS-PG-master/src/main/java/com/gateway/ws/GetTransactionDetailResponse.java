//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.09 at 03:01:04 PM IST 
//


package com.gateway.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Resp" type="{http://gateway.com/ws}RespType"/>
 *         &lt;element name="TransactionDetails" type="{http://gateway.com/ws}TransactionDetailType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resp",
    "transactionDetails"
})
@XmlRootElement(name = "GetTransactionDetailResponse")
public class GetTransactionDetailResponse {

    @XmlElement(name = "Resp", required = true)
    protected RespType resp;
    @XmlElement(name = "TransactionDetails", required = true)
    protected List<TransactionDetailType> transactionDetails;

    /**
     * Gets the value of the resp property.
     * 
     * @return
     *     possible object is
     *     {@link RespType }
     *     
     */
    public RespType getResp() {
        return resp;
    }

    /**
     * Sets the value of the resp property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespType }
     *     
     */
    public void setResp(RespType value) {
        this.resp = value;
    }

    /**
     * Gets the value of the transactionDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transactionDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransactionDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransactionDetailType }
     * 
     * 
     */
    public List<TransactionDetailType> getTransactionDetails() {
        if (transactionDetails == null) {
            transactionDetails = new ArrayList<TransactionDetailType>();
        }
        return this.transactionDetails;
    }

}