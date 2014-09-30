package edu.luc.comp433.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2014-09-30T13:36:37.723-05:00
 * Generated source version: 2.7.12
 * 
 */
@WebService(targetNamespace = "http://service.comp433.luc.edu/", name = "BookService")
@XmlSeeAlso({ObjectFactory.class})
public interface BookService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "listAllBooks", targetNamespace = "http://service.comp433.luc.edu/", className = "edu.luc.comp433.service.ListAllBooks")
    @WebMethod
    @ResponseWrapper(localName = "listAllBooksResponse", targetNamespace = "http://service.comp433.luc.edu/", className = "edu.luc.comp433.service.ListAllBooksResponse")
    public java.util.List<edu.luc.comp433.service.Book> listAllBooks();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "searchBookByIds", targetNamespace = "http://service.comp433.luc.edu/", className = "edu.luc.comp433.service.SearchBookByIds")
    @WebMethod
    @ResponseWrapper(localName = "searchBookByIdsResponse", targetNamespace = "http://service.comp433.luc.edu/", className = "edu.luc.comp433.service.SearchBookByIdsResponse")
    public java.util.List<edu.luc.comp433.service.Book> searchBookByIds(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<java.lang.Short> arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "searchBookByTitle", targetNamespace = "http://service.comp433.luc.edu/", className = "edu.luc.comp433.service.SearchBookByTitle")
    @WebMethod
    @ResponseWrapper(localName = "searchBookByTitleResponse", targetNamespace = "http://service.comp433.luc.edu/", className = "edu.luc.comp433.service.SearchBookByTitleResponse")
    public java.util.List<edu.luc.comp433.service.Book> searchBookByTitle(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "searchBookByPrice", targetNamespace = "http://service.comp433.luc.edu/", className = "edu.luc.comp433.service.SearchBookByPrice")
    @WebMethod
    @ResponseWrapper(localName = "searchBookByPriceResponse", targetNamespace = "http://service.comp433.luc.edu/", className = "edu.luc.comp433.service.SearchBookByPriceResponse")
    public java.util.List<edu.luc.comp433.service.Book> searchBookByPrice(
        @WebParam(name = "arg0", targetNamespace = "")
        java.math.BigDecimal arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.math.BigDecimal arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "searchBookByAuthor", targetNamespace = "http://service.comp433.luc.edu/", className = "edu.luc.comp433.service.SearchBookByAuthor")
    @WebMethod
    @ResponseWrapper(localName = "searchBookByAuthorResponse", targetNamespace = "http://service.comp433.luc.edu/", className = "edu.luc.comp433.service.SearchBookByAuthorResponse")
    public java.util.List<edu.luc.comp433.service.Book> searchBookByAuthor(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
