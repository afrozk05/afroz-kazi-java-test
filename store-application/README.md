# Retail Store Discount Calculator

This is a simple Spring Boot application to calculate the total amount on a bill based on various discounts.

## Features

- If the user is an employee of store,he gets 30% discount
- If user is an affliate of the store, he gets 10% discount
- If user has been a customer for over 2 years, he gets a 5% discount
- For every $100 on the bill, there would be a $5 discount.
- Percentage based discounts do not apply on groceries.
- A user can get only one of the percentage based discounts on a bill

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Installation
1. Github link for application https://github.com/afrozk05/afroz-kazi-java-test/tree/main/store-application

2. Clone the repository:
   git clone https://github.com/afrozk05/afroz-kazi-java-test.git
   cd afroz-kazi-java-test

3. Build the project:
   mvn clean install

4. Run the application:
   mvn spring-boot:run

5. Run Tests:
   mvn test

6. Approach Taken:
   Three entities are defined. User, Product and Bill(user, List<Product>).
   Discount calculation logic is such that first total price of product is 
   calculated(price * quantity) , then nonGroceryItemTotal is checked, if it is non zero, 
   Percentage calculation is applied, post that bulk discount is applied on total bill amount.
   Total discount= percentage discount + bulk discount.
   Have predefined grocery items as {"apple", "banana", "orange", "milk", "bread", "eggs", "cheese", "rice", "pasta"}

7. Code Coverage
   Go to project directory from command line interface and type mvn clean test. Report will be generated
   in target/site/jacoco/index.html

8. Generate Test Report
   Post running "mvn clean test" , test reports can be found in target/surefire-reports directory
   of the project.

9. Project execution output:
   If the input is isEmployee=true and Products are 1 Laptop priced at 1000 dollars and 2 apples 
   priced at 50 dollars, output will be 745.0
   Step by Step Evaluation:
  i) First total amount of non grocery item will be calculated (1000*1=1000) and percentage will
     be applied according to isEmployee=true ie 30 percent which evaluates to 300. 
     Then at totalBillAmount{(1000*1) + (50*2)}=1100 , for per 100 dollar 5 dollar discount will 
     be given ie (1100/100)*5=55 . 
  ii) Total discount= percentage discount + bulkDiscount =355
  iii) Total payable amount = totalBillAmount - total discount= 1100 - 355 = 745