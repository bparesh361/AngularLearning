//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.09 at 03:01:04 PM IST 
//


package com.gateway.ws;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gateway.ws package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gateway.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TerminalType }
     * 
     */
    public TerminalType createTerminalType() {
        return new TerminalType();
    }

    /**
     * Create an instance of {@link TerminalRegRequest }
     * 
     */
    public TerminalRegRequest createTerminalRegRequest() {
        return new TerminalRegRequest();
    }

    /**
     * Create an instance of {@link TransactionDetailType }
     * 
     */
    public TransactionDetailType createTransactionDetailType() {
        return new TransactionDetailType();
    }

    /**
     * Create an instance of {@link TransactionRequest }
     * 
     */
    public TransactionRequest createTransactionRequest() {
        return new TransactionRequest();
    }

    /**
     * Create an instance of {@link TerminalRegResponse }
     * 
     */
    public TerminalRegResponse createTerminalRegResponse() {
        return new TerminalRegResponse();
    }

    /**
     * Create an instance of {@link AuthRequest }
     * 
     */
    public AuthRequest createAuthRequest() {
        return new AuthRequest();
    }

    /**
     * Create an instance of {@link AuthResponse }
     * 
     */
    public AuthResponse createAuthResponse() {
        return new AuthResponse();
    }

    /**
     * Create an instance of {@link GetTransactionDetailResponse }
     * 
     */
    public GetTransactionDetailResponse createGetTransactionDetailResponse() {
        return new GetTransactionDetailResponse();
    }

    /**
     * Create an instance of {@link CardType }
     * 
     */
    public CardType createCardType() {
        return new CardType();
    }

    /**
     * Create an instance of {@link GetTransactionDetailRequest }
     * 
     */
    public GetTransactionDetailRequest createGetTransactionDetailRequest() {
        return new GetTransactionDetailRequest();
    }

    /**
     * Create an instance of {@link RespType }
     * 
     */
    public RespType createRespType() {
        return new RespType();
    }

    /**
     * Create an instance of {@link TransactionResponse }
     * 
     */
    public TransactionResponse createTransactionResponse() {
        return new TransactionResponse();
    }

}
