# Book Library Application
### Description
A project presenting part of the library's capabilities, such as:
- displaying information about the book by her ISBN,
- displaying books by category
- display author ratings from the highest rate

## Technologies:
* Java (language lvl - 8)
* Spring Boot 2.2.4
* Maven 3.6.3
* Git 2.24

## Design Pattern
Helper - some consider this as OOP anti-pattern, but I think it's good practice to separate static code from logic.

## Endpoints:
##### Item (Book):

* GET by ISBN: /item?isbn=isbnNumber
* GET by category: /item?category=category

##### Author:

* GET rating: /author/rating

## Compilation Command:
To download the project:
* `git clone https://github.com/cezary-ptaszek/cognifide-library`

To run the project:
* `mvn spring-boot:run`

Project by default runs at port 8080.