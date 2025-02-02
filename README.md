# Automated Testing OpenCart E-Commerce

![alt text](image.png)

## Objective
- Automated tests for the OpenCart E-Commerce
- The OpenCart application was run locally

## Installing OpenCart
- To download the application and run it locally please access this [link](https://www.opencart.com/index.php?route=cms/download)

## Run the Project

- Download install Java 21
- Download and install Maven 3.9.9
- Go to the root folder and run the command on cmd

```
mvn test
````

## Test Cases

| Test Case ID | Test Case Description                                               | Steps                                                                                       |
|--------------|--------------------------------------------------------------------|---------------------------------------------------------------------------------------------|
| TC01         | User adds a product to the cart                                    | 1. Create user<br>2. Add a product to the cart                                             |
| TC02         | User adds a product to the wishlist                                | 1. Create user<br>2. Add a product to the wishlist                                         |
| TC03         | User registers an account                                          | 1. Create user                                                                             |
| TC04         | User tries to register without agreeing to the privacy policy     | 1. Create a user without clicking the privacy policy button                                |
| TC05         | Login with empty fields                                            | 1. Attempt to login without filling in any fields                                          |
| TC06         | Login with invalid email                                           | 1. Attempt to login with an invalid email                                                  |
| TC07         | Successful login                                                   | 1. Register user<br>2. Logout<br>3. Login with the newly created user                      |
| TC08         | Checkout process                                                   | 1. Add products to the cart<br>2. Proceed through the checkout process                     |


