On a retail website, the following discounts apply:
1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.



## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally:

Way1: Import as maven project on your IDE and run a Spring Boot application using main method in DiscountApplication class.

Way2: Used to Spring Boot Maven plugin like this command 

```shell
mvn spring-boot:run
```

### Build an executable JAR
Way3: Using maven command to create executable JAR and run the JAR file with:

```
mvn clean package
```
Then you can run the JAR file with:
```
java -jar target/nGage-Discount-System.jar
```	   
	   
	   





