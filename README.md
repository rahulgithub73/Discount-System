On a retail website, the following discounts apply:
1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.



Requirements
For building and running the application you need:

JDK 1.8
Maven 3
Running the application locally:

Way1: Import as maven project on your IDE and run a Spring Boot application using main method in DiscountApplication class.

Way2: Used to Spring Boot Maven plugin like this command  
      mvn spring-boot:run 

Way3: Using maven command to create executable JAR and run the JAR file with:
       3.1 mvn clean package
       3.2 java -jar target/nGage-Discount-System.jar





