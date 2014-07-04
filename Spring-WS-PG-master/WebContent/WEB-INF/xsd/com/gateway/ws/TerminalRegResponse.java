//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.10 at 10:05:25 PM IST 
//


package com.gateway.ws;

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
 *         &lt;element name="Terminal" type="{http://gateway.com/ws}TerminalType"/>
 *         &lt;element name="SessionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "terminal",
    "sessionId"
})
@XmlRootElement(name = "TerminalRegResponse")
public class TerminalRegResponse {

    @XmlElement(name = "Resp", required = true)
    protected RespType resp;
    @XmlElement(name = "Terminal", required = true)
    protected TerminalType terminal;
    @XmlElement(name = "SessionId", required = true)
    protected String sessionId;

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
     * Gets the value of the terminal property.
     * 
     * @return
     *     possible object is
     *     {@link TerminalType }
     *     
     */
    public TerminalType getTerminal() {
        return terminal;
    }

    /**
     * Sets the value of the terminal property.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminalType }
     *     
     */
    public void setTerminal(TerminalType value) {
        this.terminal = value;
    }

    /**
     * Gets the value of the sessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

}
