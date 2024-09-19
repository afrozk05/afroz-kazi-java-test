
# Retail Store Discount Calculator

This Spring Boot application calculates the total payable amount on a retail bill, applying various discounts based on user eligibility.




## Features

- Store Employees: 30% discount
- Affiliates: 10% discount
- Long-term Customers (over 2 years): 5% discount
- Bulk Purchase: $5 discount for every $100 on the bill
- Excludes percentage-based discounts on groceries.
- Allows only one percentage-based discount to be applied at a time.




## Getting Started


### Prerequisites

- Java 11 or later
- Maven
- Springboot




### Clone the repository

git clone https://github.com/afrozk05/afroz-kazi-java-test.git
cd afroz-kazi-java-test


### Build the project

mvn clean install


### Run the application

mvn spring-boot:run


# API Endpoint

POST /store
#### Request Body
```json
{
  "user": {
    "employee":true
  },
  "products":[
    {
    "productName":"Laptop",
    "quantity":1,
    "price":1000.0
    },
    {
    "productName":"apple",
    "quantity":2,
    "price":50
    }
  ]
}

```



#### Request Parameters

- user
  - isEmployee
  - isAffliate
  - associationDate
- products
  - productName
  - quantity
  - price

  
## Discount Calculation Logic


#### 1. Determine the Maximum Percentage Discount for Non Grocery Item:

- If the user is an employee, apply a 30% discount.
- If the user is an affiliate, apply a 10% discount.
- If the user has been a customer for over 2 years, apply a 5% discount.
- Only one percentage discount is applicable.


#### 2. Calculate Bulk Purchase Discount:

- For every $100 on the bill, a $5 discount is applied.
#### 3. Apply Discounts:

- net amount = percentage discount + bulk discount


### Example

Products are 1 Laptop priced at 1000 dollars and 2 apples priced at 50 dollars:
- If the user is an employee and not an affliate or long-term customer, the discount will be:
  - 30% of $1000 = $300
  - Bulk discount: $5 (for $1100) = $55
  - Total discount = $300 + $55 -$355
  - Net Payable = $1100 - $355 - $5 = $745
## Run Tests and Code Coverage

mvn clean test

- Report will be generated in target/site/jacoco/index.html


## Generate Test Reports

- Post running "mvn clean test" , test reports can be found in target/surefire-reports directory
   of the project.

   
## Approach Taken:

- Three entities are defined. User, Product and Bill(user, List<Product>).
- Discount calculation logic is such
   - first total price of product is calculated(price * quantity)
   - nonGroceryItemTotal is checked, if it is non zero, Percentage calculation is applied
   - bulk discount is applied on total bill amount
   - Total discount= percentage discount + bulk discount.
- Have predefined grocery items as {"apple", "banana", "orange", "milk", "bread", "eggs", "cheese", "rice", "pasta"}