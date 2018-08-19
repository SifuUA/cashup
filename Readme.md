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

##### POST request 
localhost:8080/clients/create
```
{
   "lastName" : "Sidorov",

   "firstName" : "Ivan",
   
   "birthDate" : "2001-10-01",
   
   "gender" : "male",
	
   "inn" : "123456789"
 }```
