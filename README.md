# CoffeeShopMenuAPI

CoffeeShopMenuAPI is a RESTful API designed for managing coffee shop menus. This API allows coffee shops to create, update, and manage their menus efficiently.

## Features
- **Customer Functionality:** 
  - View menu items with details like name, description, price, and availability.
  - Search for specific items.
- **Admin Functionality:** 
  - Add new products to the menu.
  - Update existing product information.
  - Remove products from the menu.
- **Authentication:**
  - Secure login for admin users.
  - Different roles and permissions for customers and administrators.

## Technologies Used
- **Java Spring:** Framework used for building the backend system.
- **MongoDb:** Database to store menu information.
- **Spring Security:** For authentication and authorization.
- **Swagger:** API documentation.

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/EmreCerrah/CoffeeShopMenuAPI.git
   cd CoffeeShopMenuAPI
   ```

2. **Install Dependencies**:
   Install project dependencies using Maven:
   ```bash
   mvn install
   ```

3. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

## Usage

The application runs on `http://localhost:8080` by default. Below are some example API requests:

- **Get All Menu Items**:
  ```bash
  GET /api/v1/products
  ```

- **Add a New Menu Item**:
  ```bash
  POST /api/v1/product
  Content-Type: application/json

  {
    "tier": 1,
    "categoriesId": "676d56bbf129d5479271e302",
    "price": 0,
    "name": {
      "en": "string",
      "tr": "string"
    },
    "detail": {
      "en": "string",
      "tr": "string"
    }
  }
  ```

- **Delete a Menu Item**:
  ```bash
  DELETE /api/v1/product/{id}
  ```

## API Endpoints1
Customer Endpoints:

`GET /categories` - View all categories.

`GET /product/orderTear/{CategoryId}` - View products of a specific category.

Admin Endpoints:

`GET /secret/dashboard` - login to admin dasboard.

## Project Structure

```
CoffeeShopMenuAPI
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── coffeeshop
│   │   │           └── menu
│   │   │               ├── controller
│   │   │               ├── model
│   │   │               ├── repository
│   │   │               └── service
│   │   └── resources
│   │       └── application.properties
├── .gitignore
├── Dockerfile
├── LICENSE
├── README.md
└── pom.xml
```

- **controller**: Handles API requests.
- **model**: Defines data models.
- **repository**: Manages database operations.
- **service**: Contains business logic.

## Architecture Diagram

Below is a simple architecture diagram illustrating how the CoffeeShopMenuAPI processes requests:

```
[Client] ---> [Controller] ---> [Service] ---> [Repository] ---> [Database]
```

This diagram represents how client requests are processed and interact with the database.

## License

This project is licensed under the MIT License. For more details, see the [LICENSE](LICENSE) file.

### Reference Documentation

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.1/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.1/maven-plugin/build-image.html)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/3.4.1/reference/actuator/index.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.4.1/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/3.4.1/reference/data/nosql.html#data.nosql.mongodb)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.4.1/reference/using/devtools.html)
* [Validation](https://docs.spring.io/spring-boot/3.4.1/reference/io/validation.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.1/reference/web/servlet.html)

### Guides

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
