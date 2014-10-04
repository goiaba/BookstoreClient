package edu.luc.comp433.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import edu.luc.comp433.service.PaymentService;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2014-09-30T14:03:04.617-05:00
 * Generated source version: 2.7.12
 * 
 */
@WebServiceClient(name = "PaymentServiceImplService", 
                  wsdlLocation = "http://localhost:8080/project2/Payment?wsdl",
                  targetNamespace = "http://impl.service.comp433.luc.edu/") 
public class PaymentServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://impl.service.comp433.luc.edu/", "PaymentServiceImplService");
    public final static QName PaymentServiceImplPort = new QName("http://impl.service.comp433.luc.edu/", "PaymentServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/project2/Payment?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PaymentServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/project2/Payment?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PaymentServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PaymentServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PaymentServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PaymentServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PaymentServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PaymentServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns PaymentService
     */
    @WebEndpoint(name = "PaymentServiceImplPort")
    public PaymentService getPaymentServiceImplPort() {
        return super.getPort(PaymentServiceImplPort, PaymentService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PaymentService
     */
    @WebEndpoint(name = "PaymentServiceImplPort")
    public PaymentService getPaymentServiceImplPort(WebServiceFeature... features) {
        return super.getPort(PaymentServiceImplPort, PaymentService.class, features);
    }

}
