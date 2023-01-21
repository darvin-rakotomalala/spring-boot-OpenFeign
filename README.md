## Spring Cloud OpenFeign
Dans ce repo, nous allons avoir comment implementer  Spring Cloud OpenFeign, un client REST déclaratif pour les applications Spring Boot (avec Exemples CRUD).

### Qu'est-ce que OpenFeign ?
---
**Feign Client** est un classeur client pour implémenter le client REST déclaratif dans une architecture de microservices. 
Feign facilite l'écriture de clients de services Web grâce à la prise en charge des annotations enfichables, qui inclut les annotations Feign et les annotations JAX-RS.
Une grande chose à propos de l'utilisation de Feign est que nous n'avons pas à écrire de code pour appeler le service, autre qu'une définition d'interface.

### Technologies
---
- Java 11
- Spring Boot 2.7.7
- Lombok
- MapStruct
- Spring Data JPA
- spring-cloud-starter-openfeign
- Maven 3+
- PostgreSQL

### Exemples
---
- `socle-spring-data-jpa` un microservice CRUD qui s'exécute sur le port 8081.
- `clientFeign-mcs` un client Spring WebClient qui s'exécute sur le port 8082 et utlise les API REST de `socle-spring-data-jpa`. 

### Exécuter et tester le projet
---
- Exécuter en premier `socle-spring-data-jpa` puis `clientFeign-mcs` : `mvn spring-boot:run`
- Importer dans Postman la collection `clientFeign.postman_collection.json` pour tester les APIs
- Vous pouver utiliser aussi l'url du Swagger ou importer l'url Swagger dans Postman
  - Les descriptions OpenAPI seront disponibles au chemin `/v3/api-docs` par défaut : http://localhost:8081/v3/api-docs/ et/ou http://localhost:8081/swagger-ui/index.html