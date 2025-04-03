# 🛒 Automated Testing OpenCart (v4.1.0.0) E-Commerce

<p align="center">
  <img src="image.png" alt="OpenCart Testing">
</p>

## 🎯 Objective
- Implement automated tests for the OpenCart E-Commerce platform.
- The OpenCart application is tested locally (a demo is hosted [here](https://demo.opencart.com/)).

## 🚀 Technologies Used
- **Eclipse** - IDE for Java development
- **Java** - Programming language
- **Maven** - Build and dependency management tool
- **Selenium** - Web automation framework
- **TestNG** - Testing framework for Java

## 🛠️ Installing OpenCart
To download and set up OpenCart locally, visit the official [download page](https://www.opencart.com/index.php?route=cms/download).

## ▶️ Running the Project

1. **Install Java**: Download and install [Java](https://www.oracle.com/br/java/technologies/downloads/#java21).
2. **Install Maven**: Download and install [Maven](https://maven.apache.org/download.cgi).
3. **Configure OpenCart URL**:
   - Edit the `config.properties` file located at `src/test/resources`.
   - Set the `appURL` variable with your OpenCart URL.
4. **Run Tests**:
   - Navigate to the project's root folder and execute:
   ```sh
   mvn test
   ```
5. **View Test Reports**:
   - Test reports are generated inside the `reports` folder.

## 🔧 Jenkins Integration
1. Download and install [Jenkins](https://www.jenkins.io/download/).
2. Create a **Multibranch Pipeline** project.
3. Select the `Jenkinsfile` for test execution automation.

## 🌐 Selenium Grid Setup

### 🔑 Configuration Properties
Before running the Selenium Grid setup, update the following variables:

```properties
appURL=http://host.docker.internal/opencart/upload  # Ensure OpenCart is running locally on this URL
host=docker
execution_env=remote
os=linux
```

### ▶️ Running Selenium Grid
The `docker-compose.yml` file includes images for `selenium-hub`, `selenium/chrome`, and `selenium/firefox`.

To start Selenium Grid, run:
```sh
docker-compose up
```

### 📌 Running Tests on Selenium Grid
Once Selenium Grid is running, execute the tests using Maven:
```sh
mvn test
```

## 🧪 Test Cases

| Test Case ID | Description                                                    | Steps                                                                                   |
|--------------|----------------------------------------------------------------|-----------------------------------------------------------------------------------------|
| **TC01**     | Add product to cart from product list                         | 1. Create a user<br>2. Add a product to the cart                                       |
| **TC02**     | Add product to wishlist                                       | 1. Create a user<br>2. Add a product to the wishlist                                   |
| **TC03**     | Register a new account                                        | 1. Create a user                                                                       |
| **TC04**     | Attempt registration without accepting privacy policy         | 1. Try creating an account without agreeing to the privacy policy                     |
| **TC05**     | Attempt login with empty fields                               | 1. Try logging in without entering any credentials                                   |
| **TC06**     | Attempt login with invalid email                              | 1. Enter an invalid email and attempt login                                          |
| **TC07**     | Successful login                                              | 1. Register a user<br>2. Logout<br>3. Log in with the newly created user               |
| **TC08**     | Complete checkout process                                     | 1. Register a user<br>2. Add a product to the cart<br>3. Proceed to checkout<br>4. Register an address<br>5. Select the address<br>6. Choose a payment method<br>7. Confirm the order |
| **TC09**     | Add product to cart from product page                         | 1. Visit a product page<br>2. Fill out the required fields<br>3. Add product to cart  |
| **TC10**     | Submit contact form                                           | 1. Go to the contact page<br>2. Fill out and submit the contact form                  |
| **TC11**     | View cart as an unregistered user                             | 1. Click the cart icon<br>2. Navigate to the cart page                              |




