
package edu.luc.comp433.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.luc.comp433.service package. 
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

    private final static QName _FindPaymentByCustomerIdResponse_QNAME = new QName("http://service.comp433.luc.edu/", "findPaymentByCustomerIdResponse");
	private final static QName _FindPaymentByIdResponse_QNAME = new QName("http://service.comp433.luc.edu/", "findPaymentByIdResponse");
	private final static QName _FindAddressByCustomerIdResponse_QNAME = new QName("http://service.comp433.luc.edu/", "findAddressByCustomerIdResponse");
	private final static QName _CreateOrUpdateCustomer_QNAME = new QName("http://service.comp433.luc.edu/", "createOrUpdateCustomer");
	private final static QName _FindCustomerByLoginResponse_QNAME = new QName("http://service.comp433.luc.edu/", "findCustomerByLoginResponse");
	private final static QName _Customer_QNAME = new QName("http://service.comp433.luc.edu/", "customer");
	private final static QName _FindOrderByCustomerLoginResponse_QNAME = new QName("http://service.comp433.luc.edu/", "findOrderByCustomerLoginResponse");
	private final static QName _FindPaymentById_QNAME = new QName("http://service.comp433.luc.edu/", "findPaymentById");
	private final static QName _CreateOrder_QNAME = new QName("http://service.comp433.luc.edu/", "createOrder");
	private final static QName _CreateOrderResponse_QNAME = new QName("http://service.comp433.luc.edu/", "createOrderResponse");
	private final static QName _FindOrderByCustomerLogin_QNAME = new QName("http://service.comp433.luc.edu/", "findOrderByCustomerLogin");
	private final static QName _CheckOrderStatus_QNAME = new QName("http://service.comp433.luc.edu/", "checkOrderStatus");
	private final static QName _FindAddressByCustomerId_QNAME = new QName("http://service.comp433.luc.edu/", "findAddressByCustomerId");
	private final static QName _FindAddressById_QNAME = new QName("http://service.comp433.luc.edu/", "findAddressById");
	private final static QName _CreateOrUpdateCustomerResponse_QNAME = new QName("http://service.comp433.luc.edu/", "createOrUpdateCustomerResponse");
	private final static QName _Order_QNAME = new QName("http://service.comp433.luc.edu/", "order");
	private final static QName _Payment_QNAME = new QName("http://service.comp433.luc.edu/", "payment");
	private final static QName _Address_QNAME = new QName("http://service.comp433.luc.edu/", "address");
	private final static QName _FindPaymentByCustomerId_QNAME = new QName("http://service.comp433.luc.edu/", "findPaymentByCustomerId");
	private final static QName _FindAddressByIdResponse_QNAME = new QName("http://service.comp433.luc.edu/", "findAddressByIdResponse");
	private final static QName _FindCustomerByLogin_QNAME = new QName("http://service.comp433.luc.edu/", "findCustomerByLogin");
	private final static QName _Book_QNAME = new QName("http://service.comp433.luc.edu/", "book");
    private final static QName _CancelOrder_QNAME = new QName("http://service.comp433.luc.edu/", "cancelOrder");
	private final static QName _CheckOrderStatusResponse_QNAME = new QName("http://service.comp433.luc.edu/", "checkOrderStatusResponse");
	private final static QName _CancelOrderResponse_QNAME = new QName("http://service.comp433.luc.edu/", "cancelOrderResponse");
	private final static QName _SearchBookByAuthorResponse_QNAME = new QName("http://service.comp433.luc.edu/", "searchBookByAuthorResponse");
    private final static QName _SearchBookByPrice_QNAME = new QName("http://service.comp433.luc.edu/", "searchBookByPrice");
    private final static QName _SearchBookByTitleResponse_QNAME = new QName("http://service.comp433.luc.edu/", "searchBookByTitleResponse");
    private final static QName _SearchBookByPriceResponse_QNAME = new QName("http://service.comp433.luc.edu/", "searchBookByPriceResponse");
    private final static QName _SearchBookByTitle_QNAME = new QName("http://service.comp433.luc.edu/", "searchBookByTitle");
    private final static QName _ListAllBooks_QNAME = new QName("http://service.comp433.luc.edu/", "listAllBooks");
    private final static QName _SearchBookByAuthor_QNAME = new QName("http://service.comp433.luc.edu/", "searchBookByAuthor");
    private final static QName _SearchBookByIds_QNAME = new QName("http://service.comp433.luc.edu/", "searchBookByIds");
    private final static QName _ListAllBooksResponse_QNAME = new QName("http://service.comp433.luc.edu/", "listAllBooksResponse");
    private final static QName _SearchBookByIdsResponse_QNAME = new QName("http://service.comp433.luc.edu/", "searchBookByIdsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.luc.comp433.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateOrderResponse }
     * 
     */
    public CreateOrderResponse createCreateOrderResponse() {
        return new CreateOrderResponse();
    }

	/**
     * Create an instance of {@link FindOrderByCustomerLogin }
     * 
     */
    public FindOrderByCustomerLogin createFindOrderByCustomerLogin() {
        return new FindOrderByCustomerLogin();
    }

	/**
     * Create an instance of {@link CheckOrderStatus }
     * 
     */
    public CheckOrderStatus createCheckOrderStatus() {
        return new CheckOrderStatus();
    }

	/**
     * Create an instance of {@link FindAddressById }
     * 
     */
    public FindAddressById createFindAddressById() {
        return new FindAddressById();
    }

	/**
     * Create an instance of {@link CreateOrUpdateCustomerResponse }
     * 
     */
    public CreateOrUpdateCustomerResponse createCreateOrUpdateCustomerResponse() {
        return new CreateOrUpdateCustomerResponse();
    }

	/**
     * Create an instance of {@link Payment }
     * 
     */
    public Payment createPayment() {
        return new Payment();
    }

	/**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

	/**
     * Create an instance of {@link FindPaymentById }
     * 
     */
    public FindPaymentById createFindPaymentById() {
        return new FindPaymentById();
    }

	/**
     * Create an instance of {@link FindPaymentByCustomerId }
     * 
     */
    public FindPaymentByCustomerId createFindPaymentByCustomerId() {
        return new FindPaymentByCustomerId();
    }

	/**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

	/**
     * Create an instance of {@link FindPaymentByCustomerIdResponse }
     * 
     */
    public FindPaymentByCustomerIdResponse createFindPaymentByCustomerIdResponse() {
        return new FindPaymentByCustomerIdResponse();
    }

	/**
     * Create an instance of {@link FindPaymentByIdResponse }
     * 
     */
    public FindPaymentByIdResponse createFindPaymentByIdResponse() {
        return new FindPaymentByIdResponse();
    }

	/**
     * Create an instance of {@link CheckOrderStatusResponse }
     * 
     */
    public CheckOrderStatusResponse createCheckOrderStatusResponse() {
        return new CheckOrderStatusResponse();
    }

	/**
     * Create an instance of {@link CancelOrder }
     * 
     */
    public CancelOrder createCancelOrder() {
        return new CancelOrder();
    }

	/**
     * Create an instance of {@link FindAddressByIdResponse }
     * 
     */
    public FindAddressByIdResponse createFindAddressByIdResponse() {
        return new FindAddressByIdResponse();
    }

	/**
     * Create an instance of {@link FindAddressByCustomerIdResponse }
     * 
     */
    public FindAddressByCustomerIdResponse createFindAddressByCustomerIdResponse() {
        return new FindAddressByCustomerIdResponse();
    }

	/**
     * Create an instance of {@link FindCustomerByLogin }
     * 
     */
    public FindCustomerByLogin createFindCustomerByLogin() {
        return new FindCustomerByLogin();
    }

	/**
     * Create an instance of {@link FindCustomerByLoginResponse }
     * 
     */
    public FindCustomerByLoginResponse createFindCustomerByLoginResponse() {
        return new FindCustomerByLoginResponse();
    }

	/**
     * Create an instance of {@link CreateOrUpdateCustomer }
     * 
     */
    public CreateOrUpdateCustomer createCreateOrUpdateCustomer() {
        return new CreateOrUpdateCustomer();
    }

	/**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

	/**
     * Create an instance of {@link FindOrderByCustomerLoginResponse }
     * 
     */
    public FindOrderByCustomerLoginResponse createFindOrderByCustomerLoginResponse() {
        return new FindOrderByCustomerLoginResponse();
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPaymentByCustomerIdResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "findPaymentByCustomerIdResponse")
    public JAXBElement<FindPaymentByCustomerIdResponse> createFindPaymentByCustomerIdResponse(FindPaymentByCustomerIdResponse value) {
        return new JAXBElement<FindPaymentByCustomerIdResponse>(_FindPaymentByCustomerIdResponse_QNAME, FindPaymentByCustomerIdResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPaymentByIdResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "findPaymentByIdResponse")
    public JAXBElement<FindPaymentByIdResponse> createFindPaymentByIdResponse(FindPaymentByIdResponse value) {
        return new JAXBElement<FindPaymentByIdResponse>(_FindPaymentByIdResponse_QNAME, FindPaymentByIdResponse.class, null, value);
    }

	/**
     * Create an instance of {@link CancelOrderResponse }
     * 
     */
    public CancelOrderResponse createCancelOrderResponse() {
        return new CancelOrderResponse();
    }

	/**
     * Create an instance of {@link CreateOrder }
     * 
     */
    public CreateOrder createCreateOrder() {
        return new CreateOrder();
    }

	/**
     * Create an instance of {@link FindAddressByCustomerId }
     * 
     */
    public FindAddressByCustomerId createFindAddressByCustomerId() {
        return new FindAddressByCustomerId();
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAddressByCustomerIdResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "findAddressByCustomerIdResponse")
    public JAXBElement<FindAddressByCustomerIdResponse> createFindAddressByCustomerIdResponse(FindAddressByCustomerIdResponse value) {
        return new JAXBElement<FindAddressByCustomerIdResponse>(_FindAddressByCustomerIdResponse_QNAME, FindAddressByCustomerIdResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrUpdateCustomer }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "createOrUpdateCustomer")
    public JAXBElement<CreateOrUpdateCustomer> createCreateOrUpdateCustomer(CreateOrUpdateCustomer value) {
        return new JAXBElement<CreateOrUpdateCustomer>(_CreateOrUpdateCustomer_QNAME, CreateOrUpdateCustomer.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerByLoginResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "findCustomerByLoginResponse")
    public JAXBElement<FindCustomerByLoginResponse> createFindCustomerByLoginResponse(FindCustomerByLoginResponse value) {
        return new JAXBElement<FindCustomerByLoginResponse>(_FindCustomerByLoginResponse_QNAME, FindCustomerByLoginResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "customer")
    public JAXBElement<Customer> createCustomer(Customer value) {
        return new JAXBElement<Customer>(_Customer_QNAME, Customer.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOrderByCustomerLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "findOrderByCustomerLoginResponse")
    public JAXBElement<FindOrderByCustomerLoginResponse> createFindOrderByCustomerLoginResponse(FindOrderByCustomerLoginResponse value) {
        return new JAXBElement<FindOrderByCustomerLoginResponse>(_FindOrderByCustomerLoginResponse_QNAME, FindOrderByCustomerLoginResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPaymentById }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "findPaymentById")
    public JAXBElement<FindPaymentById> createFindPaymentById(FindPaymentById value) {
        return new JAXBElement<FindPaymentById>(_FindPaymentById_QNAME, FindPaymentById.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrder }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "createOrder")
    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "createOrder")
	public JAXBElement<CreateOrder> createCreateOrder(CreateOrder value) {
        return new JAXBElement<CreateOrder>(_CreateOrder_QNAME, CreateOrder.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrderResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "createOrderResponse")
    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "createOrderResponse")
	public JAXBElement<CreateOrderResponse> createCreateOrderResponse(CreateOrderResponse value) {
        return new JAXBElement<CreateOrderResponse>(_CreateOrderResponse_QNAME, CreateOrderResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOrderByCustomerLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "findOrderByCustomerLogin")
    public JAXBElement<FindOrderByCustomerLogin> createFindOrderByCustomerLogin(FindOrderByCustomerLogin value) {
        return new JAXBElement<FindOrderByCustomerLogin>(_FindOrderByCustomerLogin_QNAME, FindOrderByCustomerLogin.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckOrderStatus }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "checkOrderStatus")
    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "checkOrderStatus")
	public JAXBElement<CheckOrderStatus> createCheckOrderStatus(CheckOrderStatus value) {
        return new JAXBElement<CheckOrderStatus>(_CheckOrderStatus_QNAME, CheckOrderStatus.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAddressByCustomerId }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "findAddressByCustomerId")
    public JAXBElement<FindAddressByCustomerId> createFindAddressByCustomerId(FindAddressByCustomerId value) {
        return new JAXBElement<FindAddressByCustomerId>(_FindAddressByCustomerId_QNAME, FindAddressByCustomerId.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAddressById }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "findAddressById")
    public JAXBElement<FindAddressById> createFindAddressById(FindAddressById value) {
        return new JAXBElement<FindAddressById>(_FindAddressById_QNAME, FindAddressById.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrUpdateCustomerResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "createOrUpdateCustomerResponse")
    public JAXBElement<CreateOrUpdateCustomerResponse> createCreateOrUpdateCustomerResponse(CreateOrUpdateCustomerResponse value) {
        return new JAXBElement<CreateOrUpdateCustomerResponse>(_CreateOrUpdateCustomerResponse_QNAME, CreateOrUpdateCustomerResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link Order }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "order")
    public JAXBElement<Order> createOrder(Order value) {
        return new JAXBElement<Order>(_Order_QNAME, Order.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link Payment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "payment")
    public JAXBElement<Payment> createPayment(Payment value) {
        return new JAXBElement<Payment>(_Payment_QNAME, Payment.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "address")
    public JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<Address>(_Address_QNAME, Address.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPaymentByCustomerId }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "findPaymentByCustomerId")
    public JAXBElement<FindPaymentByCustomerId> createFindPaymentByCustomerId(FindPaymentByCustomerId value) {
        return new JAXBElement<FindPaymentByCustomerId>(_FindPaymentByCustomerId_QNAME, FindPaymentByCustomerId.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAddressByIdResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "findAddressByIdResponse")
    public JAXBElement<FindAddressByIdResponse> createFindAddressByIdResponse(FindAddressByIdResponse value) {
        return new JAXBElement<FindAddressByIdResponse>(_FindAddressByIdResponse_QNAME, FindAddressByIdResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerByLogin }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "findCustomerByLogin")
    public JAXBElement<FindCustomerByLogin> createFindCustomerByLogin(FindCustomerByLogin value) {
        return new JAXBElement<FindCustomerByLogin>(_FindCustomerByLogin_QNAME, FindCustomerByLogin.class, null, value);
    }

	/**
     * Create an instance of {@link SearchBookByIds }
     * 
     */
    public SearchBookByIds createSearchBookByIds() {
        return new SearchBookByIds();
    }

    /**
     * Create an instance of {@link ListAllBooksResponse }
     * 
     */
    public ListAllBooksResponse createListAllBooksResponse() {
        return new ListAllBooksResponse();
    }

    /**
     * Create an instance of {@link SearchBookByIdsResponse }
     * 
     */
    public SearchBookByIdsResponse createSearchBookByIdsResponse() {
        return new SearchBookByIdsResponse();
    }

    /**
     * Create an instance of {@link SearchBookByAuthorResponse }
     * 
     */
    public SearchBookByAuthorResponse createSearchBookByAuthorResponse() {
        return new SearchBookByAuthorResponse();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link SearchBookByTitleResponse }
     * 
     */
    public SearchBookByTitleResponse createSearchBookByTitleResponse() {
        return new SearchBookByTitleResponse();
    }

    /**
     * Create an instance of {@link SearchBookByPrice }
     * 
     */
    public SearchBookByPrice createSearchBookByPrice() {
        return new SearchBookByPrice();
    }

    /**
     * Create an instance of {@link SearchBookByTitle }
     * 
     */
    public SearchBookByTitle createSearchBookByTitle() {
        return new SearchBookByTitle();
    }

    /**
     * Create an instance of {@link SearchBookByPriceResponse }
     * 
     */
    public SearchBookByPriceResponse createSearchBookByPriceResponse() {
        return new SearchBookByPriceResponse();
    }

    /**
     * Create an instance of {@link SearchBookByAuthor }
     * 
     */
    public SearchBookByAuthor createSearchBookByAuthor() {
        return new SearchBookByAuthor();
    }

    /**
     * Create an instance of {@link ListAllBooks }
     * 
     */
    public ListAllBooks createListAllBooks() {
        return new ListAllBooks();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Book }{@code >}}
     * 
     */
////    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "book")
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "book")
	@XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "book")
	public JAXBElement<Book> createBook(Book value) {
        return new JAXBElement<Book>(_Book_QNAME, Book.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelOrder }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "cancelOrder")
    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "cancelOrder")
	public JAXBElement<CancelOrder> createCancelOrder(CancelOrder value) {
        return new JAXBElement<CancelOrder>(_CancelOrder_QNAME, CancelOrder.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckOrderStatusResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "checkOrderStatusResponse")
    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "checkOrderStatusResponse")
	public JAXBElement<CheckOrderStatusResponse> createCheckOrderStatusResponse(CheckOrderStatusResponse value) {
        return new JAXBElement<CheckOrderStatusResponse>(_CheckOrderStatusResponse_QNAME, CheckOrderStatusResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelOrderResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "cancelOrderResponse")
    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "cancelOrderResponse")
	public JAXBElement<CancelOrderResponse> createCancelOrderResponse(CancelOrderResponse value) {
        return new JAXBElement<CancelOrderResponse>(_CancelOrderResponse_QNAME, CancelOrderResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBookByAuthorResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "searchBookByAuthorResponse")
    public JAXBElement<SearchBookByAuthorResponse> createSearchBookByAuthorResponse(SearchBookByAuthorResponse value) {
        return new JAXBElement<SearchBookByAuthorResponse>(_SearchBookByAuthorResponse_QNAME, SearchBookByAuthorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBookByPrice }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "searchBookByPrice")
    public JAXBElement<SearchBookByPrice> createSearchBookByPrice(SearchBookByPrice value) {
        return new JAXBElement<SearchBookByPrice>(_SearchBookByPrice_QNAME, SearchBookByPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBookByTitleResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "searchBookByTitleResponse")
    public JAXBElement<SearchBookByTitleResponse> createSearchBookByTitleResponse(SearchBookByTitleResponse value) {
        return new JAXBElement<SearchBookByTitleResponse>(_SearchBookByTitleResponse_QNAME, SearchBookByTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBookByPriceResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "searchBookByPriceResponse")
    public JAXBElement<SearchBookByPriceResponse> createSearchBookByPriceResponse(SearchBookByPriceResponse value) {
        return new JAXBElement<SearchBookByPriceResponse>(_SearchBookByPriceResponse_QNAME, SearchBookByPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBookByTitle }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "searchBookByTitle")
    public JAXBElement<SearchBookByTitle> createSearchBookByTitle(SearchBookByTitle value) {
        return new JAXBElement<SearchBookByTitle>(_SearchBookByTitle_QNAME, SearchBookByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllBooks }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "listAllBooks")
    public JAXBElement<ListAllBooks> createListAllBooks(ListAllBooks value) {
        return new JAXBElement<ListAllBooks>(_ListAllBooks_QNAME, ListAllBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBookByAuthor }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "searchBookByAuthor")
    public JAXBElement<SearchBookByAuthor> createSearchBookByAuthor(SearchBookByAuthor value) {
        return new JAXBElement<SearchBookByAuthor>(_SearchBookByAuthor_QNAME, SearchBookByAuthor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBookByIds }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "searchBookByIds")
    public JAXBElement<SearchBookByIds> createSearchBookByIds(SearchBookByIds value) {
        return new JAXBElement<SearchBookByIds>(_SearchBookByIds_QNAME, SearchBookByIds.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllBooksResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "listAllBooksResponse")
    public JAXBElement<ListAllBooksResponse> createListAllBooksResponse(ListAllBooksResponse value) {
        return new JAXBElement<ListAllBooksResponse>(_ListAllBooksResponse_QNAME, ListAllBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBookByIdsResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://service.comp433.luc.edu/", name = "searchBookByIdsResponse")
    public JAXBElement<SearchBookByIdsResponse> createSearchBookByIdsResponse(SearchBookByIdsResponse value) {
        return new JAXBElement<SearchBookByIdsResponse>(_SearchBookByIdsResponse_QNAME, SearchBookByIdsResponse.class, null, value);
    }

}
