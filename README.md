# PotatoMarketManagement
Assessment-PotatoMarketManagement API

This PotatoMarketManagement application exposes two API endpoints. Please find below the details:
1. GET : /PotatoBag?itemCount={itemCount}
2. POST : /PotatoBag

#### GET : /PotatoBag?itemCount={itemCount}
This HTTP method allows to fetch the requested number (itemCount) of resources (Potato Bag's). Here the query paramter is optional, in cases where it is not mentioned a list with 3 Potato Bag's is returned as response.

#### POST : /PotatoBag
This HTTP method allows to add Potato Bags with validated details. Validations included are mentioned as below:
1. Price : 1-50
2. Size : 1-100
3. Valid Suppliers : De Coster, Owel, Patatas Ruben, Yunnan Spices


Execution:
-------------

Note: Its a maven project and in any case if you need to rebuild the project please follow the normal maven build steps either from command line or Eclipse.
1. Commandline :  Go to parent directory and execute the command : `mvn package`
2. Eclipse : Right click on project. Select Run As > Maven install from dropdown.
There are two ways to execute this application. Please find below the options:
* Clone this project in your eclipse and run the SpringBootApplication class (PotatoMarketApplication.class) containing the main method.
* Download this project in your local directory. Open CMD if you are in Windows, go to the parent directory of the project, and execute the below command.
    * java -jar target/PotatoMarketManagement-0.0.1.jar

NOTE:
-----

1. Please go through the rich documentation for all the classes, custom annotations and enumerations. HTML files are included which was generated using javadoc.

2. Junit test cases included for Repository layer, Controller layer and additional cases of validation.

3. Few features like security has not been included purposely to avoid complexity and keeping in mind the available time.

4. ID field for Potato Bag which was said to be a randomly generated string has been implemented as a randomly generated long value, since it was used as an Id for the backend H2 table.

5. A postman project with two requests has been included to test the API's for convenience. 
