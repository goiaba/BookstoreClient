
package edu.luc.comp433.service;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import edu.luc.comp433.service.impl.CustomerServiceImplService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2014-09-30T13:37:01.270-05:00
 * Generated source version: 2.7.12
 * 
 */
public final class CustomerService_CustomerServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://impl.service.comp433.luc.edu/", "CustomerServiceImplService");

    private CustomerService_CustomerServiceImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = CustomerServiceImplService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        CustomerServiceImplService ss = new CustomerServiceImplService(wsdlURL, SERVICE_NAME);
        CustomerService port = ss.getCustomerServiceImplPort();  
        
        {
        System.out.println("Invoking findCustomerByLogin...");
        java.lang.String _findCustomerByLogin_arg0 = "_findCustomerByLogin_arg0-842261382";
        edu.luc.comp433.service.Customer _findCustomerByLogin__return = port.findCustomerByLogin(_findCustomerByLogin_arg0);
        System.out.println("findCustomerByLogin.result=" + _findCustomerByLogin__return);


        }
        {
        System.out.println("Invoking createOrUpdateCustomer...");
        edu.luc.comp433.service.Customer _createOrUpdateCustomer_arg0 = new edu.luc.comp433.service.Customer();
        _createOrUpdateCustomer_arg0.setId(Short.valueOf((short)5052));
        _createOrUpdateCustomer_arg0.setLogin("Login-1978013398");
        _createOrUpdateCustomer_arg0.setName("Name755889158");
        _createOrUpdateCustomer_arg0.setPassword("Password-1620517425");
        edu.luc.comp433.service.Address _createOrUpdateCustomer_arg1 = new edu.luc.comp433.service.Address();
        _createOrUpdateCustomer_arg1.setCity("City-1294840410");
        _createOrUpdateCustomer_arg1.setComplement("Complement849653294");
        _createOrUpdateCustomer_arg1.setId(Short.valueOf((short)32618));
        _createOrUpdateCustomer_arg1.setNumber("Number-1581786701");
        java.util.List<edu.luc.comp433.service.Order> _createOrUpdateCustomer_arg1OrderList = new java.util.ArrayList<edu.luc.comp433.service.Order>();
        edu.luc.comp433.service.Order _createOrUpdateCustomer_arg1OrderListVal1 = new edu.luc.comp433.service.Order();
        edu.luc.comp433.service.Address _createOrUpdateCustomer_arg1OrderListVal1Address = new edu.luc.comp433.service.Address();
        _createOrUpdateCustomer_arg1OrderListVal1Address.setCity("City-322192464");
        _createOrUpdateCustomer_arg1OrderListVal1Address.setComplement("Complement-2061751202");
        _createOrUpdateCustomer_arg1OrderListVal1Address.setId(Short.valueOf((short)-5236));
        _createOrUpdateCustomer_arg1OrderListVal1Address.setNumber("Number1921339545");
        java.util.List<edu.luc.comp433.service.Order> _createOrUpdateCustomer_arg1OrderListVal1AddressOrderList = new java.util.ArrayList<edu.luc.comp433.service.Order>();
        _createOrUpdateCustomer_arg1OrderListVal1Address.getOrderList().addAll(_createOrUpdateCustomer_arg1OrderListVal1AddressOrderList);
        _createOrUpdateCustomer_arg1OrderListVal1Address.setState("State1150989411");
        _createOrUpdateCustomer_arg1OrderListVal1Address.setStreet("Street-582695927");
        _createOrUpdateCustomer_arg1OrderListVal1Address.setZipcode(1090489066);
        _createOrUpdateCustomer_arg1OrderListVal1.setAddress(_createOrUpdateCustomer_arg1OrderListVal1Address);
        edu.luc.comp433.service.Customer _createOrUpdateCustomer_arg1OrderListVal1Customer = new edu.luc.comp433.service.Customer();
        _createOrUpdateCustomer_arg1OrderListVal1Customer.setId(Short.valueOf((short)29130));
        _createOrUpdateCustomer_arg1OrderListVal1Customer.setLogin("Login802654684");
        _createOrUpdateCustomer_arg1OrderListVal1Customer.setName("Name1650474678");
        _createOrUpdateCustomer_arg1OrderListVal1Customer.setPassword("Password1436983274");
        _createOrUpdateCustomer_arg1OrderListVal1.setCustomer(_createOrUpdateCustomer_arg1OrderListVal1Customer);
        _createOrUpdateCustomer_arg1OrderListVal1.setId(Short.valueOf((short)-30547));
        edu.luc.comp433.service.Payment _createOrUpdateCustomer_arg1OrderListVal1Payment = new edu.luc.comp433.service.Payment();
        _createOrUpdateCustomer_arg1OrderListVal1Payment.setAmount(new java.math.BigDecimal("4433485679870150652.2961840327489603000"));
        _createOrUpdateCustomer_arg1OrderListVal1Payment.setCardHolderName("CardHolderName-468214686");
        _createOrUpdateCustomer_arg1OrderListVal1Payment.setCardNumber("CardNumber285053104");
        edu.luc.comp433.service.Customer _createOrUpdateCustomer_arg1OrderListVal1PaymentCustomer = new edu.luc.comp433.service.Customer();
        _createOrUpdateCustomer_arg1OrderListVal1PaymentCustomer.setId(Short.valueOf((short)-14443));
        _createOrUpdateCustomer_arg1OrderListVal1PaymentCustomer.setLogin("Login-296184058");
        _createOrUpdateCustomer_arg1OrderListVal1PaymentCustomer.setName("Name500646236");
        _createOrUpdateCustomer_arg1OrderListVal1PaymentCustomer.setPassword("Password-251379642");
        _createOrUpdateCustomer_arg1OrderListVal1Payment.setCustomer(_createOrUpdateCustomer_arg1OrderListVal1PaymentCustomer);
        _createOrUpdateCustomer_arg1OrderListVal1Payment.setExpirationMonth(1909108344);
        _createOrUpdateCustomer_arg1OrderListVal1Payment.setExpirationYear(1283982522);
        _createOrUpdateCustomer_arg1OrderListVal1Payment.setId(Short.valueOf((short)30490));
        _createOrUpdateCustomer_arg1OrderListVal1Payment.setSecurityCode(-1980589968);
        _createOrUpdateCustomer_arg1OrderListVal1.setPayment(_createOrUpdateCustomer_arg1OrderListVal1Payment);
        edu.luc.comp433.service.OrderStatus _createOrUpdateCustomer_arg1OrderListVal1Status = edu.luc.comp433.service.OrderStatus.SHIPPED;
        _createOrUpdateCustomer_arg1OrderListVal1.setStatus(_createOrUpdateCustomer_arg1OrderListVal1Status);
        _createOrUpdateCustomer_arg1OrderList.add(_createOrUpdateCustomer_arg1OrderListVal1);
        _createOrUpdateCustomer_arg1.getOrderList().addAll(_createOrUpdateCustomer_arg1OrderList);
        _createOrUpdateCustomer_arg1.setState("State-869972765");
        _createOrUpdateCustomer_arg1.setStreet("Street-1831032860");
        _createOrUpdateCustomer_arg1.setZipcode(-981962997);
        edu.luc.comp433.service.Payment _createOrUpdateCustomer_arg2 = new edu.luc.comp433.service.Payment();
        _createOrUpdateCustomer_arg2.setAmount(new java.math.BigDecimal("-4783901748386391247.2228866256897466939"));
        _createOrUpdateCustomer_arg2.setCardHolderName("CardHolderName1391037251");
        _createOrUpdateCustomer_arg2.setCardNumber("CardNumber-1540007864");
        edu.luc.comp433.service.Customer _createOrUpdateCustomer_arg2Customer = new edu.luc.comp433.service.Customer();
        _createOrUpdateCustomer_arg2Customer.setId(Short.valueOf((short)-18072));
        _createOrUpdateCustomer_arg2Customer.setLogin("Login771025620");
        _createOrUpdateCustomer_arg2Customer.setName("Name-15366313");
        _createOrUpdateCustomer_arg2Customer.setPassword("Password-801944381");
        _createOrUpdateCustomer_arg2.setCustomer(_createOrUpdateCustomer_arg2Customer);
        _createOrUpdateCustomer_arg2.setExpirationMonth(1500999675);
        _createOrUpdateCustomer_arg2.setExpirationYear(-556551941);
        _createOrUpdateCustomer_arg2.setId(Short.valueOf((short)-18351));
        _createOrUpdateCustomer_arg2.setSecurityCode(-1863325574);
        edu.luc.comp433.service.Customer _createOrUpdateCustomer__return = port.createOrUpdateCustomer(_createOrUpdateCustomer_arg0, _createOrUpdateCustomer_arg1, _createOrUpdateCustomer_arg2);
        System.out.println("createOrUpdateCustomer.result=" + _createOrUpdateCustomer__return);


        }

        System.exit(0);
    }

}
