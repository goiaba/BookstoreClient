BookstoreClient
===============

WS client for bookstore project (COMP433 @ LUC)

There is a jar file stored under distrib folder that can be run to test the Bookstore services. To try it just type the following command in a terminal:

java -jar BookstoreClient.jar <URI>

The default URI points to http://puluceno.com/ws so the user can omit the URI argument. Tip: You can redirect the stderr to somewhere else than default output to have a better experience (for example, 2> /dev/null in linux or 2> nil in windows)

The common steps to buy a book (or books):

        1 - Use one of the options to retrieve available books (options 1 to 4 of menu);
        2 - Select the books to buy (option 5 of menu);
        3 - Buy selected books (option 7 of menu).

To get order status just choose option 9 of menu. The program will ask the user login, will print all his orders and will ask the order id to print its status.

To cancel an order choose option 10 of menu. The program will ask the user login, will print all his orders and will ask the order id to be cancelled.
