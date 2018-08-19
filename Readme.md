## Spring Boot Rest APIs

## Steps to Setup

**1. Clone the repository** 

```bash
git clone https://github.com/SifuUA/cashup.git
```

**2. Run the app using maven**

```bash
cd cashup
mvn spring-boot:run
```

The application can be accessed at `http://localhost:8080`.

**3. See the database configuration** `application.properties`

**4. You mast have installed Postgresql DB, than you can run file** `database.sql`
**for creating database, tables and some data**

## Explore Rest APIs
The app defines following CRUD APIs.

##### Crete client, POST method 
`localhost:8080/clients/create`
```
{
   "lastName" : "Sidorov",

   "firstName" : "Ivan",
   
   "birthDate" : "2001-10-01",
   
   "gender" : "male",
	
   "inn" : "123456789"
 }
 ```
 ##### Get all clients, GET method 
 `localhost:8080/clients/all`
 
 ##### Get information about client by id, GET method 
 `localhost:8080/clients/1`
 
 ##### Edit information about client by id, POST method 
      `localhost:8080/clients/84`
      ```
      {
         "lastName" : "Petrov",
      
         "firstName" : "Oleg",
         
         "birthDate" : "2002-02-07",
         
      	 "gender" : "male",
      	
      	 "inn" : "123456789111"
       }
       ```
  ##### Crete order, POST method 
  `localhost:8080/orders/create`
  ```
  {
  	"clientId" : "1",
  	
     "dateOfOrder" : "2001-01-01",
     
     "sumOfOrder" : "1555.3",
     
  	"currency" : "dollar"
   }
   ```
  ##### Get all orders, GET method 
  `localhost:8080/orders/all`
    
  ##### Get all orders of client, GET method 
  `localhost:8080/orders/1`
     
  ##### Confirm status of order, POST method 
  `localhost:8080/orders/confirm/1`
    