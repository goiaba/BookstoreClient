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
import edu.luc.comp433.service.Order;
import edu.luc.comp433.service.OrderService;
import edu.luc.comp433.service.OrderStatus;
import edu.luc.comp433.service.Payment;
import edu.luc.comp433.service.PaymentType;

/**
 *
 * @author Thiago Vieira Puluceno
 *
 */
public final class BookClient {

	private static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
	private static Map<Integer, Integer> fieldSize = new HashMap<Integer, Integer>();
	private static List<Short> selectedBooks = new ArrayList<Short>();

	private static AddressService addressService;
	private static BookService bookService;
	private static CustomerService customerService;
	private static OrderService orderService;

	private static String uri = "http://localhost:8080/project2";
	private static String addressServiceAddress;
	private static String bookServiceAddress;
	private static String customerServiceAddress;
	private static String orderServiceAddress;

	static {
		fieldSize.put(0, 5);
		fieldSize.put(1, 50);
		fieldSize.put(2, 40);
		fieldSize.put(3, 30);
	}

	public static void main(String args[]) throws Exception {

		if (args.length != 1) {
			System.out
					.println("**********************************************************************************");
			System.out
					.println("***                                                                            ***");
			System.out
					.println("*** Using http://localhost:8080/project2. You can pass another URI as argument ***");
			System.out
					.println("***                                                                            ***");
			System.out
					.println("**********************************************************************************");
			waitEnter();
		} else
			uri = args[0];

		addressServiceAddress = uri + "/Address";
		bookServiceAddress = uri + "/Book";
		customerServiceAddress = uri + "/Customer";
		orderServiceAddress = uri + "/Order";

		int option = 0;

		do {
			printMenu();
			try {
				option = new Integer(br.readLine());
				System.out.println();
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
					_6_printSelectedBooks(true);
					break;
				case 7:
					_7_buySelectedBooks();
					break;
				case 8:
					_8_clearSelectedBooks();
					break;
				case 9:
					_9_getOrderStatus();
					break;
				case 10:
					_10_cancelOrder();
					break;
				case 11:
					break;
				default:
					System.out.println("Invalid option. Try again.");
				}

			} catch (NumberFormatException | IOException e) {
				System.out.println("Invalid option. Try again.");
				option = 0;
			} catch (RuntimeException e) {
				System.out.println("Error processing your request.");
				waitEnter();
				e.printStackTrace();
			}
		} while (option != 11);

	}

	public static void _1_listAll() {
		List<Book> books = getBookService().listAllBooks();
		if (!books.isEmpty())
			printBooks("=+- List of available books -+=\n", books);
		else
			System.out.println("No book found.");
		waitEnter();
	}

	public static void _2_searchByTitle() throws IOException {
		System.out.print("Type book title or part of it: ");
		String term = br.readLine();
		List<Book> books = getBookService().searchBookByTitle(term);
		if (!books.isEmpty())
			printBooks("=+- List of books of title like \"" + term + "\" -+=",
					books);
		else
			System.out.println("No book found.");
		waitEnter();
	}

	public static void _3_searchByAuthor() throws IOException {
		System.out.print("Type author name or part of it: ");
		String term = br.readLine();
		List<Book> books = getBookService().searchBookByAuthor(term);
		if (!books.isEmpty())
			printBooks("=+- List of books from author name like \"" + term
					+ "\" -+=", books);
		else
			System.out.println("No book found.");
		waitEnter();
	}

	public static void _4_searchByPriceRange() throws IOException {
		System.out.print("Min price: ");
		String minPrice = br.readLine();
		System.out.print("Max price: ");
		String maxPrice = br.readLine();
		List<Book> books = getBookService().searchBookByPrice(
				new BigDecimal(minPrice), new BigDecimal(maxPrice));
		if (!books.isEmpty())
			printBooks("=+- List of books by range price -+=", books);
		else
			System.out.println("No book found.");
		waitEnter();
	}

	public static void _5_selectBooksToBuy() throws NumberFormatException,
			IOException {
		System.out.print("Type the id's separated by ',': ");
		String ids = br.readLine();
		for (String id : ids.split(",")) {
			selectedBooks.add(new Short(id.trim()));
		}
		System.out.println("Book(s) added to the list.");
		waitEnter();
	}

	public static void _6_printSelectedBooks(boolean waitEnter) {
		printBooks("=+- List of selected books -+=", getBookService()
				.searchBookByIds(selectedBooks));
		if (waitEnter)
			waitEnter();
	}

	public static void _7_buySelectedBooks() throws IOException {
		_6_printSelectedBooks(false);

		System.out.print("\nType your login (empty if you don't have one): ");
		String login = br.readLine();

		Customer customer = getCustomerService().findCustomerByLogin(login);
		Address address = null;
		Payment payment = null;
		List<Address> addresses = null;

		if (null != customer) {
			addresses = getAddressService().findAddressByCustomerId(
					customer.getId());
			if (!addresses.isEmpty()) {
				printAddress(addresses);
				System.out
						.print("Choose one address to ship or empty to register new one: ");
				String addressId = br.readLine();
				if ("".equals(addressId)) {
					address = createAddress();
				} else {
					address = getAddressService().findAddressById(
							new Short(addressId));
				}
			} else {
				address = createAddress();
			}

			payment = createPayment();
		} else {
			customer = createCustomer();
			address = createAddress();
			payment = createPayment();
		}

		Short orderId = getOrderService().createOrder(customer, address,
				getBookService().searchBookByIds(selectedBooks), payment);
		selectedBooks.clear();
		System.out.println("Order created with id=" + orderId);
		waitEnter();
	}

	public static void _8_clearSelectedBooks() {
		selectedBooks.clear();
		System.out.println("List of selected book is empty");
		waitEnter();
	}

	public static void _9_getOrderStatus() throws IOException {
		System.out.print("\nType your login: ");
		String login = br.readLine();
		List<Order> orders = getOrderService().findOrderByCustomerLogin(login);

		if (!orders.isEmpty()) {
			printOrder(orders, false);
			System.out.print("\nType id of order to see status: ");
			Short orderId = new Short(br.readLine().trim());
			if (customerOwnsOrder(orders, orderId)) {
				OrderStatus status = orderService.checkOrderStatus(orderId);
				System.out.println("Order [id=" + orderId + "] status: "
						+ status);
			} else {
				System.out.println("There is no order with id=" + orderId
						+ " associated with this customer.");
			}
		} else {
			System.out
					.println("There is no order associated with this customer.");
			br.readLine();
		}
		waitEnter();
	}

	public static void _10_cancelOrder() throws IOException {
		System.out.print("\nType your login: ");
		String login = br.readLine();
		List<Order> orders = getOrderService().findOrderByCustomerLogin(login);

		if (!orders.isEmpty()) {
			printOrder(orders, true);
			System.out
					.println("\nNote: Only orders in 'PROCESSING' status can be cancelled.");
			System.out.print("\nType id of order you want to cancel: ");
			Short orderId = new Short(br.readLine().trim());
			if (customerOwnsOrder(orders, orderId)) {
				if (orderService.cancelOrder(orderId))
					System.out.println("Order canceled.");
				else
					System.out.println("Order could not be canceled.");
			} else {
				System.out.println("There is no order with id=" + orderId
						+ " associated with this customer.");
			}
		} else {
			System.out
					.println("There is no order associated with this customer.");
		}
		waitEnter();
	}

	private static AddressService getAddressService() {
		if (null == addressService) {
			addressService = createService(AddressService.class,
					addressServiceAddress);
		}
		return addressService;
	}

	private static OrderService getOrderService() {
		if (null == orderService) {
			orderService = createService(OrderService.class,
					orderServiceAddress);
		}
		return orderService;
	}

	private static CustomerService getCustomerService() {
		if (null == customerService) {
			customerService = createService(CustomerService.class,
					customerServiceAddress);
		}
		return customerService;
	}

	private static BookService getBookService() {
		if (null == bookService) {
			bookService = createService(BookService.class, bookServiceAddress);
		}
		return bookService;
	}

	@SuppressWarnings("unchecked")
	private static <T> T createService(Class<T> serviceClass, String address) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(serviceClass);
		factory.setAddress(address);
		return (T) factory.create();
	}

	private static void printMenu() {
		StringBuilder result = new StringBuilder(
				"Choose one of the options below:\n");
		result.append(" 1 - List all available books\n")
				.append(" 2 - Search book by title\n")
				.append(" 3 - Search book by author\n")
				.append(" 4 - Search book by price range\n")
				.append(" 5 - Select books to buy\n")
				.append(" 6 - Print selected books\n")
				.append(" 7 - Buy selected books\n")
				.append(" 8 - Clear selected books\n")
				.append(" 9 - Get Order Status\n")
				.append("10 - Cancel Order\n").append("11 - Exit\n")
				.append("\nOption: ");
		System.out.print(result.toString());
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

	private static void printOrder(List<Order> orders, boolean printStatus) {
		System.out.println("=+- List of registered orders -+=");
		StringBuilder row = new StringBuilder();
		for (Order order : orders) {
			row.append("| ")
					.append(tabulate(order.getId().toString(), 0))
					.append(" | ")
					.append(tabulate(order.getPayment().getAmount()
							.toPlainString(), 1)).append(" | ")
					.append(tabulate(order.getPayment().getType().name(), 2));
			if (printStatus)
				row.append(" | ")
						.append(tabulate(order.getStatus().value(), 3));
			row.append("|\n");
		}
		System.out.println(row.toString());
	}

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

	private static Payment createPayment() throws NumberFormatException,
			IOException {
		System.out.println("=+- New Payment Method -+=");
		Payment payment = new Payment();
		System.out.print("Payment type (1= Cash; 2= Credit; 3= Debit): ");
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

	private static boolean customerOwnsOrder(List<Order> orders, Short orderId) {
		for (Order order : orders) {
			if (order.getId().equals(orderId))
				return true;
		}
		return false;
	}

	private static void waitEnter() {
		System.out.print("\nPress <enter> to continue...");
		try {
			System.in.read();
		} catch (IOException ex) {
		}
	}
}
