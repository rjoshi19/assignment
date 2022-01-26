
  
# Technical Assignment    
 The  project consists of 3 backend modules.   
    
 - Account Service    
 - Transaction Service    
 - Eureka Naming Service      
    
## Requirements    
    
- JDK 1.8+    
 - Maven    
 - Npm 6+ (for UI part)    
    
    
## Services    
 There are 3 services.     
    
 - **Transaction Service:** Responsible for creating and listing transactions for a given account. Runs on port 8000.
 - **Account Service:** Responsible for creating and listing customers and accounts. Also sends request to transaction service for transaction related operations. Runs on port 8080.    
 - **Discovery Service:** Responsible for discovering services and allows to connect them to each other via naming. Runs on port 8761.    
    
Basic flow of the application is illustrated below:    
![Service Architecture](asset/serviceArchitecture.png/?raw=true "Service Architecture")    
    
## Running the application  
  ### Server Side  
On the main directory of the project following commands are used to run services.  

    mvn clean install
    mvn spring-boot:run -pl discovery
    mvn spring-boot:run -pl transaction   
    mvn spring-boot:run -pl account  
  

**Note:** Account service requires transaction service for transaction related operations. `account-service` still runs even if the `transaction-service` is not up yet, but transaction related operations fails until `transaction-service` is up. In such case it may still take a few seconds to run transaction related operations after `transaction-service` is up and running. 

## Endpoints

Swagger UI is configured to access services through endpoints. It can be accessed at: http://localhost:8080/swagger-ui.html once the services are up.  
  
