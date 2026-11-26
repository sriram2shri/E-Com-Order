\# E-Commerce Microservices

A Spring Boot-based e-commerce application built using a microservices architecture. The project consists of independent services for order management, inventory management, service discovery, and API routing.

## Microservices


1. Order Service



Manages customer orders.



Handles order creation and order-related operations.



Communicates with the Inventory Service to check product availability.



* 2\. Inventory Service



Manages product inventory.



Maintains product stock information.



Provides inventory-related REST APIs.



* 3\. API Gateway



Acts as the entry point for client requests.



Routes incoming requests to the appropriate microservices.



* 4\. Eureka Server



Provides service discovery.



Allows microservices to register and discover other services.

## Technology Stack



\- \*\*Programming Language:\*\* Java

\- \*\*Framework:\*\* Spring Boot

\- \*\*Build Tool:\*\* Maven

\- \*\*Database:\*\* MySQL

\- \*\*ORM:\*\* Spring Data JPA / Hibernate

\- \*\*Service Discovery:\*\* Netflix Eureka

\- \*\*API Gateway:\*\* Spring Cloud Gateway

\- \*\*Inter-Service Communication:\*\* REST APIs / OpenFeign

\- \*\*Resilience:\*\* Resilience4j

\- \*\*API Testing:\*\* Postman

\- \*\*Containerization:\*\* Docker

\- \*\*Version Control:\*\* Git and GitHub

\- \*\*Monitoring and Observability:\*\* Micrometer, OpenTelemetry and Jaeger

