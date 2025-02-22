# Automated Testing OpenCart(v4.1.0.0) E-Commerce
<p align="center">
  <img src="image.png" alt="alt text">
</p>


## Objective
- Automated tests for the OpenCart E-Commerce
- The OpenCart application was run locally (the demo application is hosted [here](https://demo.opencart.com/))

## Technologies
- Eclipse
- Java
- Maven
- Selenium
- Test NG

## Installing OpenCart
- To download the application and run it locally please access this [link](https://www.opencart.com/index.php?route=cms/download)

## Run the Project

- Download install [Java](https://www.oracle.com/br/java/technologies/downloads/#java21)
- Download and install [Maven](https://maven.apache.org/download.cgi)
- Configure the appURL variable in the config.properties file (src/test/resources) with the opencart URL
- Go to the root folder and run the command on cmd

```
mvn test
````

- The reports are inside the folder reports

## Jenkins
- Download [Jenkins](https://www.jenkins.io/download/)
- Create a multibranch project and select the Jenkinsfile


## Test Cases
| Test Case ID | Test Case Description                                               | Steps                                                                                       |
|--------------|--------------------------------------------------------------------|---------------------------------------------------------------------------------------------|
| TC01         | User adds a product to the cart in the product list                                    | 1. Create user<br>2. Add a product to the cart                                             |
| TC02         | User adds a product to the wishlist                                | 1. Create user<br>2. Add a product to the wishlist                                         |
| TC03         | User registers an account                                          | 1. Create user                                                                             |
| TC04         | User tries to register without agreeing to the privacy policy     | 1. Create a user without clicking the privacy policy button                                |
| TC05         | Login with empty fields                                            | 1. Attempt to login without filling in any fields                                          |
| TC06         | Login with invalid email                                           | 1. Attempt to login with an invalid email                                                  |
| TC07         | Successful login                                                   | 1. Register user<br>2. Logout<br>3. Login with the newly created user                      |
| TC08         | Checkout process                                                   | 1. Create user<br>2. Add product to the cart<br>3. Go to the checkout page<br>4. Register the address for the new user<br>5. Select the address<br>6. Select the payment method<br>7. Confirm order |
| TC09         | User adds a product to the cart in the product page                                                | 1. Go to the product page<br>2. Fill the form<br>3. Add to the cart |
| TC10         | Fil the contact form                                                   | 1. Go to the contact page<br> 2.Fill the contact form |
| TC11         | Unregistered user check the cart page                                                  | 1. Click in the cart icon<br>2. Go to the cart page<br> |
