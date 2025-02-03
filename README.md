# Automated Testing OpenCart(v4.1.0.0) E-Commerce
<p align="center">
  <img src="image.png" alt="alt text">
</p>


## Objective
- Automated tests for the OpenCart E-Commerce
- The OpenCart application was run locally (the demo application is hosted [here](https://demo.opencart.com/))

## Installing OpenCart
- To download the application and run it locally please access this [link](https://www.opencart.com/index.php?route=cms/download)

## Run the Project

- Download install Java 21
- Download and install Maven 3.9.9
- Configure the appURL variable in the config.properties file (src/test/resources) with the opencart URL
- Go to the root folder and run the command on cmd

```
mvn test
````

- The reports are inside the folder /reports


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
| TC08         | Checkout process                                                   | 1. Create user<br>2. Add product to the cart<br>3. Go to the checkout page<br>4. Register the address for the new user<br>5. Select the address<br>6. Select the payment method<br>7. Confirm order |
