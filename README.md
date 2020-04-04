# Book Library Application
### Description
A project presenting part of the library's capabilities using .json form google-books-api, such as:
- displaying information about the book by her ISBN,
- displaying books by category
- display author ratings from the highest rate

## Technologies:
* Java (language lvl - 8)
* Spring Boot 2.2.4
* JUnit 5.5.2
* REST-assured 4.3.0
* Maven 3.6.3
* Git 2.24

## Endpoints:
##### Item (Book):

* GET by ISBN: /item?isbn=isbnNumber
* GET by category: /item?category=category

##### Author:

* GET rating: /author/rating
* GET rating by name: /author/rating?name=name

## Compilation Command:
To download the project:
* `git clone https://github.com/cezary-ptaszek/cognifide-library`

To run the project:
* `mvn spring-boot:run`

Project by default runs at port 8080.
