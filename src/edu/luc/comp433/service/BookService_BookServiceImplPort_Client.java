
package edu.luc.comp433.service;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import edu.luc.comp433.service.impl.BookServiceImplService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2014-09-30T13:36:37.572-05:00
 * Generated source version: 2.7.12
 * 
 */
public final class BookService_BookServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://impl.service.comp433.luc.edu/", "BookServiceImplService");

    private BookService_BookServiceImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = BookServiceImplService.WSDL_LOCATION;
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
      
        BookServiceImplService ss = new BookServiceImplService(wsdlURL, SERVICE_NAME);
        BookService port = ss.getBookServiceImplPort();  
        
        {
        System.out.println("Invoking listAllBooks...");
        java.util.List<edu.luc.comp433.service.Book> _listAllBooks__return = port.listAllBooks();
        System.out.println("listAllBooks.result=" + _listAllBooks__return);


        }
        {
        System.out.println("Invoking searchBookByIds...");
        java.util.List<java.lang.Short> _searchBookByIds_arg0 = new java.util.ArrayList<java.lang.Short>();
        java.lang.Short _searchBookByIds_arg0Val1 = Short.valueOf((short)-13077);
        _searchBookByIds_arg0.add(_searchBookByIds_arg0Val1);
        java.util.List<edu.luc.comp433.service.Book> _searchBookByIds__return = port.searchBookByIds(_searchBookByIds_arg0);
        System.out.println("searchBookByIds.result=" + _searchBookByIds__return);


        }
        {
        System.out.println("Invoking searchBookByTitle...");
        java.lang.String _searchBookByTitle_arg0 = "_searchBookByTitle_arg0262438866";
        java.util.List<edu.luc.comp433.service.Book> _searchBookByTitle__return = port.searchBookByTitle(_searchBookByTitle_arg0);
        System.out.println("searchBookByTitle.result=" + _searchBookByTitle__return);


        }
        {
        System.out.println("Invoking searchBookByPrice...");
        java.math.BigDecimal _searchBookByPrice_arg0 = new java.math.BigDecimal("-6161194179067199992.6841377735099080297");
        java.math.BigDecimal _searchBookByPrice_arg1 = new java.math.BigDecimal("-4342999716857573696.1872837155503617905");
        java.util.List<edu.luc.comp433.service.Book> _searchBookByPrice__return = port.searchBookByPrice(_searchBookByPrice_arg0, _searchBookByPrice_arg1);
        System.out.println("searchBookByPrice.result=" + _searchBookByPrice__return);


        }
        {
        System.out.println("Invoking searchBookByAuthor...");
        java.lang.String _searchBookByAuthor_arg0 = "_searchBookByAuthor_arg0-1960858358";
        java.util.List<edu.luc.comp433.service.Book> _searchBookByAuthor__return = port.searchBookByAuthor(_searchBookByAuthor_arg0);
        System.out.println("searchBookByAuthor.result=" + _searchBookByAuthor__return);


        }

        System.exit(0);
    }

}
