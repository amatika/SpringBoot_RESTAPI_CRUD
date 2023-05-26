
# Spring Boot REST API CRUD Application
This project is a rest application which implements the create, read, update and delete functionalities using springboot, spring data jpa, hibernate and mysql database.

## Tech Stack

**Server:** SpringBoot, Spring Data JPA, MySQL and Hibernate


## Installation

To install and test the project, use the following guide.

1.Clone the project into your eclipse workspace
2.Import the database contained in the databse folder(xampp was used in the development of the database).

Make sure that your database server is running on the port number 3306 or if no make the necessary changes in the application.properties file that exists within the project

User and password details for the database access can as well be made in the application.properties file.

3.Right click on the application and then run as a java application.

    
## Running Tests

To run tests, postman was used to test the various endpoints

Some of the endpoints that you can user are:

http://localhost:8080/subjects -this will list all the subjects from the database

http://localhost:8080/subjects/add  -this endpoint will be used to add subjects to the database

http://localhost:8080/subjects/update/109 -this end point will be used to update the subject of the specified id

http://localhost:8080/subjects/delete/103 -this endpoint will be used to delete the subject with the specified id


