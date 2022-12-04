Installation and web setup:

1. install apache netbeans IDE 12.0
https://netbeans.apache.org/download/nb120/nb120.html
Apache-NetBeans-12.0-bin-windows-x64.exe 
(Java environment needed)

2. Go to Services tab (near new project icon)
	Expand database tab and right click to select properties
	Add ...\Inventory\db-derby-10.14.2.0-bin to Java db installation
	Add ...\Inventory\db to database location
	Click ok

3. Under Service tab, right click servers icon
	click add server and add ...\Inventory\apache-tomcat-9.0.34 to server location
	set username and password
	username: user1
	password: 12345678
	click ok

4. Create a new database 
	right click Java db icon(previous step) and click create database
	database name: inventory
	username: user1
	password: 12345678
	url: jdbc:derby://localhost:1527/inventory (if not the same by default)
	db location: \Inventory\db
	Click ok
	right click the url jdbc:derby://localhost:1527/inventory and click connect (under Java db icon)
	..if url is not the same, please go to security.xml and replace [...value="jdbc:derby://......."] with correct your url

5. Go to file(left hand concer) to open project  
  	expand other sources file to inventory.sql and double click to open it
	click run sql button(near the middle of the screen and looks like a play button)
	select the above url in the dropdown list and click ok

6. Right click the project inventory project icon(under project tab)
	click Build with dependencies
	then click run button(under the Tools tab at the top)

6. Select deployment server pop up
	select apache tomcat or Tomee
	select remember in current IDE Session
	click ok and wait for open

7. Authentication required pop up 
	click ok if there are username and password otherwise use the account created above
	wait ...

8. done 

Test
1. Use the two csv file called inventory.csv and product.csv to test add inventory page and add product page respectively (csv consumption)
	-please add product(product.csv) first then inventory.csv otherwise server error occur 
2. Go to inventorylist page or product list to view every inventory and product (store data to db)
3. Go to inventorylist page and select one inventory record to process inventory transfer function
4. Try to transfer productid 5:location: TKO, to productid 5:location: CWB with different amount
	






Daily log 
Day 0:
Task 1
Decided to use what kind of tools to build java server
	-including:  Apache NetBeans IDE 12.0, derby db(store Spring data JPA), apache-tomcat
	-framework: Spring MVC



Day 1:
Task 1 
Built some empty web pages using the tools and framework
	-connect the derby db to the tomcat web server(Success)
	-build a simple test db table for testing whether the db can store and retrieve spring data(Success)

Task 2
Build a simple form to retrieve String data from html/jsp form
	-Check whether controller's form class can retrieve data or not(Success) 

Task 3
Write sql file for creating suitable table to store data 

Task 4
Step 1
Search information about how to handle Csv file in Java Spring MVC(Never handle csv file before on any platform) AND create two csv file with header for import
	-Many medtods to hanlde csv with example; by dependencies such as org.apache.commons, opencsv

Step 2	
Try to apply the above dependencies' function to read csv in server, such as opencsv: CsvToBeanBuilder....
	-Try 1 Result: fail to read csv file by opencsv and return 400 bad request
		Reason: Forgot to add multipartResolver to dispatcher-servlet.xml
	-Try 2 Result: fail to read csv file by opencsv
	-Try 3 Result: fail to read csv file by org.apache.commons



Day 2:
Task 4 continue
Step 3
Search for any other possible solution
	-information about csv file format
		-Result: csv is similar to .txt and can be read line by line???

Step 4 
Use list of a String list to store splited csv data (split by ",")
	-Try 4 Result: Successful to read scv data and display by system.out.println
	-Stored the String list to db with correct sequence(Success)

Task 5
Design and build a new page for inventory transfer
	-Transfer with a selected target location, and input another location and amount for further process
	-Add transfer button to inventorylist page to select target location 

Test if the transfer controller is working
	-Result: Use JPA data function- findby() and save() can handle transfer inventory action easily






Day 3:
Task 6
Try to decorate the JSP page with simple bootstrap

Task 7
Use jsp if else condition(c:if,etc) to check Quantity for showing inventory level

	
Task 8
Add few inventory transfer error handling
	-the inventory cannot transfer when: not enough product to transfer, transfer amount <= 0, transfer location from and to is the same location 
	-transfer amount cannot be zero and location cannot be empty when press the submit button

Assumption: 
1. Two inventory only 
2. Maximum storage of each inventory is 500
3. 5 products available

Found Problems: No data validation for csv data 
				 -csv without header --> skip one row of data
				 -csv with wrong data type for each column, i.e. Double weight column enter String data --> server error 500
				 -any other format of csv data , i.e. sequence of data --> fail
				
			    Transfer inventory function
			  	 -Your can add a new inventory location by transfer inventory to a new location i.e. TKO to TKW
				 -The order of inventory list data may be different after transfer

				Use back to previous page button of the browser may view old data of inventory after transfer inventory
					-encourage using home/inventory list/product list button go to other pages

				
				.....

			  More problems can be found		 
		 
Inventory level:
	375- 500 Maximum
	250- 374 Average 
	125- 249 Danger
	0 - 124  Minimum
	> 500    cannot determine(empty)

p.s. A add category function is completed without test but no relationship with product or inventory table

Basic function completed<<<<



