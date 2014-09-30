package edu.luc.comp433.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.common.i18n.Exception;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import edu.luc.comp433.service.Address;
import edu.luc.comp433.service.AddressService;
import edu.luc.comp433.service.Book;
import edu.luc.comp433.service.BookService;
import edu.luc.comp433.service.Customer;
import edu.luc.comp433.service.CustomerService;
import edu.luc.comp433.service.OrderService;
import edu.luc.comp433.service.Payment;
import edu.luc.comp433.service.PaymentService;
import edu.luc.comp433.service.PaymentType;

/**
 *
 * @author Thiago Vieira Puluceno
 *
 */
public final class BookClient {

	protected static final String BOOK_SERVICE_ADDRESS = "http://localhost:8080/project2/Book";
	protected static final String CUSTOMER_SERVICE_ADDRESS = "http://localhost:8080/project2/Customer";
	private static final String ORDER_SERVICE_ADDRESS = "http://localhost:8080/project2/Order";
	private static final String ADDRESS_SERVICE_ADDRESS = "http://localhost:8080/project2/Address";
	private static final String PAYMENT_SERVICE_ADDRESS = "http://localhost:8080/project2/Payment";

	private static Map<Integer, Integer> fieldSize = new HashMap<Integer, Integer>();
	private static List<Short> selectedBooks = new ArrayList<Short>();

	protected static BookService bookService;
	private static CustomerService customerService;
	private static OrderService orderService;
	private static AddressService addressService;
	private static PaymentService paymentService;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static {
		fieldSize.put(0, 5);
		fieldSize.put(1, 50);
		fieldSize.put(2, 40);
		fieldSize.put(3, 30);
	}

	public static void _1_listAll() {
		printBooks("=+- List of available books -+=\n", getBookService()
				.listAllBooks());
	}

	public static void _2_searchByTitle() throws IOException {
		System.out.println("Type book title or part of it: ");
		String term = br.readLine();
		printBooks("=+- List of books of title like \"" + term + "\" -+=",
				getBookService().searchBookByTitle(term));
	}

	public static void _3_searchByAuthor() throws IOException {
		System.out.println("Type author name or part of it: ");
		String term = br.readLine();
		printBooks("=+- List of books from author name like \"" + term
				+ "\" -+=", getBookService().searchBookByAuthor(term));

	}

	public static void _4_searchByPriceRange()
			throws IOException {
		System.out.println("Min price: ");
		String minPrice = br.readLine();
		System.out.println("Max price: ");
		String maxPrice = br.readLine();
		printBooks(
				"=+- List of books by range price -+=",
				getBookService().searchBookByPrice(new BigDecimal(minPrice),
						new BigDecimal(maxPrice)));
	}

	public static void _5_selectBooksToBuy()
			throws NumberFormatException, IOException {
		System.out.println("Type the id's separated by ',': ");
		String ids = br.readLine();
		for (String id : ids.split(",")) {
			selectedBooks.add(new Short(id));
		}
	}

	public static void _6_printSelectedBooks() {
		printBooks("=+- List of selected books -+=", getBookService()
				.searchBookByIds(selectedBooks));
	}

	public static void _7_buySelectedBooks()
			throws IOException {
		_6_printSelectedBooks();
		
		System.out.print("\nType your login (empty if you don't have one): ");
		String login = br.readLine();

		Customer customer = getCustomerService().findCustomerByLogin(login);
		Address address = null;
		Payment payment = null;
		List<Address> addresses = null;
		List<Payment> payments = null;

		if (null != customer) {
			addresses = getAddressService().findAddressByCustomerId(customer.getId());
			payments = getPaymentService().findPaymentByCustomerId(customer.getId());
			printAddress(addresses);
			System.out.print("Choose one address to ship or empty to register new one: ");
			String addressId = br.readLine();
			
			if ("".equals(addressId)) {
				address = createAddress();
			} else {
				address = getAddressService().findAddressById(new Short(addressId));
			}
			
			printPayment(payments);
			System.out.print("Choose one payment to ship or empty to register new one: ");
			String paymentId = br.readLine();
			
			if ("".equals(paymentId)) {
				payment = createPayment();
			} else {
				payment = getPaymentService().findPaymentById(new Short(paymentId));
			}
		} else {
			customer = createCustomer();
			address = createAddress();
			payment = createPayment();
		}

		getOrderService().createOrder(customer, address,
				getBookService().searchBookByIds(selectedBooks), payment);
	}

	public static void _8_clearSelectedBooks() {
		selectedBooks.clear();
	}

	public static void main(String args[]) throws Exception {

		Customer c = new Customer();
		c.setLogin("bruno");
		c.setName("Bruno Godoy");
		c.setPassword("senha");
		
		Address a = new Address();
		a.setCity("Chicago");
		a.setComplement("apt 401");
		a.setNumber("6230");
		a.setState("IL");
		a.setStreet("N Kenmore");
		a.setZipcode(60660);
		
		Payment p = new Payment();
		p.setCardHolderName("BRUNO G M CORREA");
		p.setCardNumber("1234123412345678");
		p.setExpirationMonth(12);
		p.setExpirationYear(2017);
		p.setSecurityCode(123);
		p.setType(PaymentType.DEBIT);
		
		getOrderService().createOrder(c, a,
				getBookService().searchBookByIds(Arrays.asList(Short.valueOf("1"), Short.valueOf("2"))), p);
		
		System.exit(0);
		int option = 0;

		do {
			printMenu();
			try {
				option = new Integer(br.readLine());
				switch (option) {
				case 1:
					_1_listAll();
					break;
				case 2:
					_2_searchByTitle();
					break;
				case 3:
					_3_searchByAuthor();
					break;
				case 4:
					_4_searchByPriceRange();
					break;
				case 5:
					_5_selectBooksToBuy();
					break;
				case 6:
					_6_printSelectedBooks();
					break;
				case 7:
					_7_buySelectedBooks();
					break;
				case 8:
					_8_clearSelectedBooks();
					break;
				case 9:
					break;
				default:
					System.out.println("Invalid option. Try again.");
				}

			} catch (NumberFormatException | IOException e) {
				System.out.println("Invalid option. Try again.");
				option = 0;
			}
		} while (option != 9);

	}

	private static AddressService getAddressService() {
		if (null == addressService) {
			addressService = (AddressService) getFactory(AddressService.class,
					ADDRESS_SERVICE_ADDRESS).create();
		}
		return addressService;
	}

	private static PaymentService getPaymentService() {
		if (null == paymentService) {
			paymentService = (PaymentService) getFactory(PaymentService.class,
					PAYMENT_SERVICE_ADDRESS).create();
		}
		return paymentService;
	}

	private static OrderService getOrderService() {
		if (null == orderService) {
			orderService = (OrderService) getFactory(OrderService.class,
					ORDER_SERVICE_ADDRESS).create();
		}
		return orderService;
	}

	private static CustomerService getCustomerService() {
		if (null == customerService) {
			JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
			factory.getInInterceptors().add(new LoggingInInterceptor());
			factory.getOutInterceptors().add(new LoggingOutInterceptor());
			factory.setServiceClass(CustomerService.class);
			factory.setAddress(CUSTOMER_SERVICE_ADDRESS);
			customerService = (CustomerService) factory.create();
		}
		return customerService;
	}

	private static BookService getBookService() {
		if (null == bookService) {
			JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
			factory.getInInterceptors().add(new LoggingInInterceptor());
			factory.getOutInterceptors().add(new LoggingOutInterceptor());
			factory.setServiceClass(BookService.class);
			factory.setAddress(BOOK_SERVICE_ADDRESS);
			bookService = (BookService) factory.create();
		}
		return bookService;
	}

	private static JaxWsProxyFactoryBean getFactory(Class<?> serviceClass,
			String address) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(serviceClass);
		factory.setAddress(address);
		return factory;
	}

	private static void printMenu() {
		StringBuilder result = new StringBuilder(
				"Choose one of the options below:\n");
		result.append("1 - List all available books\n")
				.append("2 - Search book by title\n")
				.append("3 - Search book by author\n")
				.append("4 - Search book by price range\n")
				.append("5 - Select books to buy\n")
				.append("6 - Print selected books\n")
				.append("7 - Buy selected books\n")
				.append("8 - Clear selected books\n").append("9 - Exit\n")
				.append("Option: ");
		System.out.println(result.toString());
	}

	private static void printBooks(String title, List<Book> books) {
		System.out.println(title);
		StringBuilder row = new StringBuilder();
		for (Book book : books) {
			row.append("| ").append(tabulate(book.getId().toString(), 0))
					.append(" | ").append(tabulate(book.getTitle(), 1))
					.append(" | ").append(tabulate(book.getAuthor(), 2))
					.append(" | ")
					.append(tabulate(book.getPrice().toPlainString(), 3))
					.append("|\n");
		}
		System.out.println(row.toString());
	}

	/**
	 * @param payments
	 */
	private static void printPayment(List<Payment> payments) {
		System.out.println("=+- List of registered payments -+=");
		StringBuilder row = new StringBuilder();
		for (Payment payment : payments) {
			row.append("| ")
					.append(tabulate(payment.getId().toString(), 0))
					.append(" | ")
					.append(tabulate(payment.getCardHolderName(), 1))
					.append(" | ")
					.append("****"
							+ tabulate(payment.getCardNumber()
									.substring(12, 15), 2))
					.append(" | ")
					.append(tabulate(payment.getExpirationMonth() + "-"
							+ payment.getExpirationYear(), 3)).append("|\n");
		}
		System.out.println(row.toString());
	}

	/**
	 * @param addresses
	 */
	private static void printAddress(List<Address> addresses) {
		System.out.println("=+- List of registered addresses -+=");
		StringBuilder row = new StringBuilder();
		for (Address address : addresses) {
			row.append("| ")
					.append(tabulate(address.getId().toString(), 0))
					.append(" | ")
					.append(tabulate(
							address.getNumber() + " " + address.getStreet()
									+ " " + address.getComplement() + " - "
									+ address.getCity(), 1))
					.append(" | ")
					.append(tabulate(address.getState(), 2))
					.append(" | ")
					.append(tabulate(Integer.toString(address.getZipcode()), 3))
					.append("|\n");
		}
		System.out.println(row.toString());
	}

	private static String tabulate(String content, int field) {
		int size = content.length();
		int fillWithBlank = fieldSize.get(field) - size;
		StringBuilder result = new StringBuilder(content);
		if (fillWithBlank > 0) {
			char[] pad = new char[fillWithBlank];
			Arrays.fill(pad, ' ');
			result.append(pad);
		} else {
			result.delete(result.length() - 4, result.length() - 1).append(
					"...");
		}
		return result.toString();
	}
	
	private static Address createAddress() throws IOException {
		System.out.println("=+- New Address -+=");
		Address address = new Address();
		System.out.print("Number: ");
		address.setNumber(br.readLine());
		System.out.print("Street: ");
		address.setStreet(br.readLine());
		System.out.print("Complement: ");
		address.setComplement(br.readLine());
		System.out.print("City: ");
		address.setCity(br.readLine());
		System.out.print("State: ");
		address.setState(br.readLine());
		System.out.print("ZIP Code: ");
		address.setZipcode(Integer.parseInt(br.readLine()));
		return address;
	}

	private static Customer createCustomer() throws IOException {
		System.out.println("=+- New Customer -+=");
		Customer customer = new Customer();
		System.out.print("Login: ");
		customer.setLogin(br.readLine());
		System.out.print("Name: ");
		customer.setName(br.readLine());
		System.out.print("Password: ");
		customer.setPassword(br.readLine());
		return customer;
	}

	private static Payment createPayment() throws NumberFormatException, IOException {
		System.out.println("=+- New Payment Method -+=");
		Payment payment = new Payment();
		System.out.print("Payment type (1= Cash; 2= Credit; 3= Debit: ");
		switch (Integer.parseInt(br.readLine())) {
		case 1:
			payment.setType(PaymentType.CASH);
			break;
		case 2:
			payment.setType(PaymentType.CREDIT);
			break;
		case 3:
			payment.setType(PaymentType.DEBIT);
			break;
		default:
			payment.setType(PaymentType.CASH);
		}
		
		if (!PaymentType.CASH.equals(payment.getType())) {
			System.out.print("Card Holder Name: ");
			payment.setCardHolderName(br.readLine());
			System.out.print("Card Number: ");
			payment.setCardNumber(br.readLine());
			System.out.print("Expiration Month: ");
			payment.setExpirationMonth(Integer.parseInt(br.readLine()));
			System.out.print("Expiration Year: ");
			payment.setExpirationYear(Integer.parseInt(br.readLine()));
			System.out.print("Security Code: ");
			payment.setSecurityCode(Integer.parseInt(br.readLine()));
		}
		return payment;
	}
}