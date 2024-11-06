# **Introduction to Spring Boot - Product Management API**

This project is a simple Spring Boot REST API for managing products, including endpoints to create and retrieve products. This example is designed to help you understand the basics of building a Spring Boot application without a database, focusing on foundational components like the model, service, and controller layers.

## **Table of Contents**

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Endpoints](#endpoints)
- [Testing the API](#testing-the-api)

## **Features**

- RESTful API for basic product management.
- Endpoints for adding and retrieving products.
- Basic in-memory list used for storing products (no database setup required).

## **Technologies Used**

- **Java 17**: Programming language.
- **Spring Boot 3.x.x**: Framework for creating RESTful APIs.
- **Maven**: Build and dependency management.
  
## **Getting Started**

### **Step 1: Setting up the Project**

1. **Initialize Spring Boot Project**:
   - Go to [Spring Initializr](https://start.spring.io/).
   - Set up the project with the following configurations:
     - **Project**: Maven Project
     - **Language**: Java
     - **Spring Boot Version**: 3.x.x
     - **Dependencies**: Spring Web
   - Click **Generate** to download the project, then extract and open it in your preferred IDE (Spring Tools Suite or IntelliJ).

### **Step 2: Defining the Model**

1. **Create a Model Class**:
   - In `src/main/java/com/example/demo/model`, create a `Product` class.
   - Define the following attributes:
     - `id` (Long)
     - `name` (String)
     - `price` (Double)

   ```java
   public class Product {
       private Long id;
       private String name;
       private Double price;

       // Getters and setters
   }
### **Step 3: Creating the Service Layer**

1. **Define Service Interface and Implementation**:
   - In the `service` package, create an interface `ProductService` with methods like `findAll()` and `save()`.
   - Implement this interface in a class named `ProductServiceImpl` within the `impl` subpackage.

   ```java
   @Service
   public class ProductServiceImpl implements ProductService {
       private List<Product> products = new ArrayList<>();

       @Override
       public List<Product> findAll() {
           return products;
       }

       @Override
       public Product save(Product product) {
           products.add(product);
           return product;
       }
   }
### **Step 4: Building the Controller**

1. **Create a REST Controller**:
   - In the `controller` package, create a `ProductController` class.
   - Annotate it with `@RestController` and map it to `/api/products`.
   - Implement the following endpoints:
     - `GET /api/products`: Retrieve all products.
     - `POST /api/products`: Add a new product.

   ```java
   @RestController
   @RequestMapping("/api/products")
   public class ProductController {

       private final ProductService productService;

       @Autowired
       public ProductController(ProductService productService) {
           this.productService = productService;
       }

       @GetMapping
       public List<Product> getAllProducts() {
           return productService.findAll();
       }

       @PostMapping
       public Product createProduct(@RequestBody Product product) {
           return productService.save(product);
       }
   }
## **Project Structure**

src ├── main 
    │ ├── java 
    │ │ └── com.example.demo 
    │ │ ├── model 
    │ │ │ └── Product.java 
    │ │ ├── service 
    │ │ │ ├── ProductService.java 
    │ │ │ └── impl 
    │ │ │ └── ProductServiceImpl.java 
    │ │ └── controller 
    │ │ └── ProductController.java 
    └── resources 
    └── application.properties

---

This shows the project’s directory layout, reflecting the structure of packages and key files in the application.

## **Endpoints**

| HTTP Method | Endpoint         | Description               | Request Body              |
|-------------|------------------|---------------------------|---------------------------|
| `GET`       | `/api/products`  | Retrieve all products     | None                      |
| `POST`      | `/api/products`  | Create a new product      | JSON `{ "id": 1, "name": "Sample", "price": 100.0 }` |

## **Testing the API**

1. **Run the Application**:
   - Start the Spring Boot application from your IDE.

2. **Use Postman or cURL**:
   - **GET /api/products**:
     - Make a GET request to retrieve all products. It should return an empty list initially.
   - **POST /api/products**:
     - Make a POST request to add a product. Use the JSON format shown below.

   **Sample JSON for POST**:
   ```json
   {
       "id": 1,
       "name": "Sample Product",
       "price": 100.0
   }

This section details the available API endpoints and instructions for testing them using Postman or cURL.
