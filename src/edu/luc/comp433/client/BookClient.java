package edu.luc.comp433.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.common.i18n.Exception;

import edu.luc.comp433.client.util.WebClientUtil;
import edu.luc.comp433.representation.Address;
import edu.luc.comp433.representation.Book;
import edu.luc.comp433.representation.Customer;
import edu.luc.comp433.representation.Order;
import edu.luc.comp433.representation.Payment;
import edu.luc.comp433.representation.enumerator.OrderStatus;
import edu.luc.comp433.representation.enumerator.PaymentType;

/**
 *
 * @author Thiago Vieira Puluceno
 *
 */
public final class BookClient {

	private static final String BOOK_PATH = "books/";

	private static final String CUSTOMER_ID_PATH_PARAM = "{customerId}";
	private static final String CUSTOMER_LOGIN_PATH_PARAM = "{login}";
	private static final String ADDRESS_ID_PATH_PARAM = "{addressId}";
	private static final String ORDER_ID_PATH_PARAM = "{orderId}";

	private static final String CUSTOMER_PATH = "customers/";
	private static final String CUSTOMER_BY_LOGIN_PATH = CUSTOMER_PATH
			+ CUSTOMER_LOGIN_PATH_PARAM;
	private static final String ORDER_PATH = "orders/";

	private static final String ADDRESS_PATH = "addresses/";
	private static final String ADDRESS_OF_CUSTOMER_PATH = ADDRESS_PATH
			+ CUSTOMER_PATH + CUSTOMER_ID_PATH_PARAM;
	private static final String ADDRESS_BY_ID_PATH = ADDRESS_PATH
			+ ADDRESS_ID_PATH_PARAM;

	private static final String ORDER_BY_CUST_LOGIN_PATH = ORDER_PATH
			+ CUSTOMER_LOGIN_PATH_PARAM;
	private static final String ORDER_STATUS_PATH = ORDER_PATH
			+ ORDER_ID_PATH_PARAM + "/status";
	private static final String ORDER_CANCEL_PATH = ORDER_PATH
			+ ORDER_ID_PATH_PARAM + "/cancel";

	private static String uri = "http://localhost:8080/project3/";

	private static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
	private static Map<Integer, Integer> fieldSize = new HashMap<Integer, Integer>();
	private static List<Short> selectedBooks = new ArrayList<Short>();

	static {
		fieldSize.put(0, 5);
		fieldSize.put(1, 50);
		fieldSize.put(2, 40);
		fieldSize.put(3, 30);
	}

	public static void main(String args[]) throws Exception, NumberFormatException, IOException {
		
//		System.out.println(orderStatusPath(new Integer(1).shortValue()));
//		System.out.println(customerByLoginPath("bruno"));
//		System.out.println(addresOfCustomerPath(new Integer(3).shortValue()));
//		System.out.println(addressByIdPath("1"));
//		System.out.println(orderByCustLoginPath("bruno"));
//		System.out.println(cancelOrderPath(new Integer(2).shortValue()));
//
//		System.exit(0);

		if (args.length != 1) {
			System.out
					.println("**************************************************************************");
			System.out
					.println("***                                                                    ***");
			System.out.println("*** Using " + uri
					+ ". You can pass another URI as argument ***");
			System.out
					.println("***                                                                    ***");
			System.out
					.println("**************************************************************************");
			waitEnter();
		} else
			uri = args[0];

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
			} catch (NotFoundException e) {
				System.out.println("Resource not found.");
				waitEnter();
			} catch (RuntimeException e) {
				System.out.println("Error processing your request.");
				waitEnter();
				e.printStackTrace();
			}
		} while (option != 11);

	}

	public static void _1_listAll() {
		List<Book> books = WebClientUtil
				.createDefaultGetRequest(uri, BOOK_PATH).get(
						new GenericType<List<Book>>() {
						});
		if (!books.isEmpty())
			printBooks("=+- List of available books -+=\n", books);
		else
			System.out.println("No book found.");
		waitEnter();
	}

	public static void _2_searchByTitle() throws IOException {
		System.out.print("Type book title or part of it: ");
		String term = br.readLine();

		Map<String, String> qParams = new HashMap<String, String>();
		qParams.put("title", term);
		List<Book> books = WebClientUtil.createDefaultGetRequest(uri,
				BOOK_PATH, qParams).get(new GenericType<List<Book>>() {
		});
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
		Map<String, String> qParams = new HashMap<String, String>();
		qParams.put("author", term);
		List<Book> books = WebClientUtil.createDefaultGetRequest(uri,
				BOOK_PATH, qParams).get(new GenericType<List<Book>>() {
		});
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
		Map<String, String> qParams = new HashMap<String, String>();
		qParams.put("minPrice", minPrice);
		qParams.put("maxPrice", maxPrice);
		List<Book> books = WebClientUtil.createDefaultGetRequest(uri,
				BOOK_PATH, qParams).get(new GenericType<List<Book>>() {
		});
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
		if (selectedBooks.isEmpty()) {
			System.out.println("No books selected.");
			waitEnter();
			return;
		}

		List<Book> books = WebClientUtil.createQueryParam(
				WebClientUtil.createDefaultGetRequest(uri, BOOK_PATH), "id",
				selectedBooks).get(new GenericType<List<Book>>() {
		});

		printBooks("=+- List of selected books -+=", books);
		if (waitEnter)
			waitEnter();
	}

	public static void _7_buySelectedBooks() throws IOException {
		if (selectedBooks.isEmpty()) {
			System.out.println("You need to select some book to buy.");
			waitEnter();
			return;
		}

		_6_printSelectedBooks(false);

		System.out.print("\nType your login (empty if you don't have one): ");
		String login = br.readLine();
		Customer customer = null;

		if (null != login && login.length() > 0) {
			customer = WebClientUtil.createDefaultGetRequest(uri,
					customerByLoginPath(login)).get(Customer.class);
		}
		Address address = null;
		Payment payment = null;
		List<Address> addresses = null;

		if (null != customer) {
			addresses = WebClientUtil.createDefaultGetRequest(uri,
					addresOfCustomerPath(customer.getId())).get(
					new GenericType<List<Address>>() {
					});

			if (!addresses.isEmpty()) {
				printAddress(addresses);
				System.out
						.print("Choose one address to ship or empty to register new one: ");
				String addressId = br.readLine();
				if ("".equals(addressId)) {
					address = createAddress();
				} else {
					address = WebClientUtil.createDefaultGetRequest(uri,
							addressByIdPath(addressId)).get(Address.class);
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

		Order order = new Order();
		order.setAddress(address);
		order.setCustomer(customer);
		order.setPayment(payment);
		List<Book> books = WebClientUtil.createQueryParam(
				WebClientUtil.createDefaultGetRequest(uri, BOOK_PATH), "id",
				selectedBooks).get(new GenericType<List<Book>>() {
		});
		order.setBookList(books);

		/*
		 * Creating the order resource.
		 */
		Response response = WebClientUtil.createDefaultPostRequest(uri,
				ORDER_PATH).post(order);

		String orderId = response.getLocation().toASCIIString();
		orderId = orderId.substring(orderId.lastIndexOf("/")+1);

		if (null != orderId) {
			selectedBooks.clear();
			System.out.println("Order created with id=" + orderId);
		} else
			System.out.println("Error creating order.");
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
		List<Order> orders = WebClientUtil.createDefaultGetRequest(uri,
				orderByCustLoginPath(login)).get(
				new GenericType<List<Order>>() {
				});

		if (!orders.isEmpty()) {
			printOrder(orders, false);
			System.out.print("\nType id of order to see status: ");
			Short orderId = new Short(br.readLine().trim());
			if (null != customerOwnsOrder(orders, orderId)) {
				OrderStatus status = WebClientUtil.createDefaultGetRequest(uri,
						orderStatusPath(orderId)).get(OrderStatus.class);
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
		List<Order> orders = WebClientUtil.createDefaultGetRequest(uri,
				orderByCustLoginPath(login)).get(
				new GenericType<List<Order>>() {
				});

		if (!orders.isEmpty()) {
			printOrder(orders, true);
			System.out
					.println("\nNote: Only orders in 'PROCESSING' status can be cancelled.");
			System.out.print("\nType id of order you want to cancel: ");
			Short orderId = new Short(br.readLine().trim());
			Order orderToCancel = customerOwnsOrder(orders, orderId);
			if (null != orderToCancel) {

				Response response = WebClientUtil.createDefaultPutRequest(uri,
						cancelOrderPath(orderId)).put(orderToCancel);

				if (Status.OK.equals(response.getStatus())) {
					boolean orderCancelled = (boolean) response.getEntity();
					if (orderCancelled)
						System.out.println("Order canceled.");
					else
						System.out.println("Order could not be canceled.");
				} else if (Status.NOT_FOUND.equals(response.getStatus()))
					System.out.println("Order does not exist.");
				else if (Status.BAD_REQUEST.equals(response.getStatus()))
					System.out.println("Order id not specified.");
				else
					System.out.println("Order canceled.");
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

	private static Order customerOwnsOrder(List<Order> orders, Short orderId) {
		for (Order order : orders) {
			if (order.getId().equals(orderId))
				return order;
		}
		return null;
	}

	private static void waitEnter() {
		System.out.print("\nPress <enter> to continue...");
		try {
			System.in.read();
		} catch (IOException ex) {
		}
	}

	private static String pathAssembler(String path, String param, Object value) {
		return path.replace(param, value.toString());
	}

	private static String orderStatusPath(Short orderId) {
		return pathAssembler(ORDER_STATUS_PATH, ORDER_ID_PATH_PARAM, orderId);
	}

	private static String customerByLoginPath(String login) {
		return pathAssembler(CUSTOMER_BY_LOGIN_PATH, CUSTOMER_LOGIN_PATH_PARAM,
				login);
	}

	private static String addresOfCustomerPath(Short customerId) {
		return pathAssembler(ADDRESS_OF_CUSTOMER_PATH, CUSTOMER_ID_PATH_PARAM,
				customerId);
	}

	private static String addressByIdPath(String addressId) {
		return pathAssembler(ADDRESS_BY_ID_PATH, ADDRESS_ID_PATH_PARAM,
				addressId);
	}

	private static String orderByCustLoginPath(String login) {
		return pathAssembler(ORDER_BY_CUST_LOGIN_PATH,
				CUSTOMER_LOGIN_PATH_PARAM, login);
	}

	private static String cancelOrderPath(Short orderId) {
		return pathAssembler(ORDER_CANCEL_PATH, ORDER_ID_PATH_PARAM, orderId);
	}

}
