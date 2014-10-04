BookstoreClient
===============

WS client for bookstore project (COMP433 @ LUC)

There is a jar file stored under distrib folder that can be run to test the Bookstore services. To try it just type the following command in a terminal:

java -jar BookstoreClient.jar <URI>

The default URI points to http://localhost:8080/project2 for testing purposes. Our services are located at http://puluceno.com/ws so the right way of executing the client is:

java -jar BookstoreClient.jar http://puluceno.com/ws

The common steps to buy a book (or books):

        1 - Use one of the options to retrieve available books (options 1 to 4 of menu);
        2 - Select the books to buy (option 5 of menu);
        3 - Buy selected books (option 7 of menu).

To get order status just choose option 9 of menu. The program will ask the user login, will print all his orders and will ask the order id to print its status.

To cancel an order choose option 10 of menu. The program will ask the user login, will print all his orders and will ask the order id to be cancelled.
