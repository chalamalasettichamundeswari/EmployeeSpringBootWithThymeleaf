# EmployeeSpringMVC
EmployeeSpringBootMVC with thyme leaf template engine(CSS, Bootstrap) to perform operations like createEmployee, updateEmployee, deleteEmployee, findEmployeeById, findAllEmployees, searchEmployeeById.Includes sending email from application including pdf, logging, security, deployment as jar file,use Transactional Management.

Steps to do at gmail account:  
https://www.google.com/settings/security/lesssecureapps.  
Allow less secure apps: ON.  

Clone the application :   
https://github.com/chalamalasettichamundeswari/EmployeeSpringMVC.git.    

In the Application.properties:    
Change mysql url, username and password and context path as per your installation :    
open src / main / resources / application.properties - change spring.datasource.url, spring.datasource.username and spring.datasource.password as per your mysql installation.   
change server.servlet.context-path as per your requirement.   
change security username and password as your requirement.  
change dirpath,body,subject as your requirement.   
Logging ->Use 2 libaries sl4j and logback. for SL4J uncomment the 2 lines related to logging.   
for logback use the xml file and use the rolling file policy.   

Build and run the app using Spring Boot App using maven install outide the application(Check target, snapshot.jar is getting or not). open terminal go to the project directory(using cd command).    
use pwd to know whether you are in present directory or not.     
java - jar springbootmvc- 0.0 .1 - SNAPSHOT.jar.  

The app will start running at http://localhost:8084.   

Create Employee : http://localhost:8084/employeerestapi/.  
Display All Employees : http://localhost:8084/employeerestapi/displayEmployees   
View Employee : http://localhost:8084/employeerestapi/viewEmployee.    
Display Employee : http://localhost:8084/employeerestapi/displayEmployee.   
Delete Employee : http://localhost:8084/employeerestapi/deleteEmployee?id=7 (any id that is inserted into database).   

Dependencies:   
1.spring-boot-starter-data-jpa.  
2.spring-boot-starter-thymeleaf.  
3.spring-boot-starter-web   
4.mysql-connector-java.     
5.spring-boot-starter-mail.   
6.spring-boot-starter-security.   
7.itextpdf.   

Database:  
Employee Table :  
create table employee(id int primary key Auto_Increment ,first_name varchar(60),last_name varchar(60),email varchar(50) unique);   
