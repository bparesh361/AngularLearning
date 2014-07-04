
package com.cb;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "GreetingImplService", targetNamespace = "http://cb.com/", wsdlLocation = "http://localhost:8080/WS/Greeting?wsdl")
public class GreetingImplService
    extends Service
{

    private final static URL GREETINGIMPLSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.cb.GreetingImplService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.cb.GreetingImplService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/WS/Greeting?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/WS/Greeting?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        GREETINGIMPLSERVICE_WSDL_LOCATION = url;
    }

    public GreetingImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GreetingImplService() {
        super(GREETINGIMPLSERVICE_WSDL_LOCATION, new QName("http://cb.com/", "GreetingImplService"));
    }

    /**
     * 
     * @return
     *     returns Greeting
     */
    @WebEndpoint(name = "GreetingImplPort")
    public Greeting getGreetingImplPort() {
        return super.getPort(new QName("http://cb.com/", "GreetingImplPort"), Greeting.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Greeting
     */
    @WebEndpoint(name = "GreetingImplPort")
    public Greeting getGreetingImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://cb.com/", "GreetingImplPort"), Greeting.class, features);
    }

}
