## Register API Documentation
### Overview
This project is a RESTful API developed using Spring Boot and PostgreSQL. It 
provides endpoints to manage Person, Answer, and Question entities. The 
application supports full CRUD operations and adheres to industry best practices, 
including the use of DTOs to control data exposure.

### Overview
- Manage Person entities with attributes like name, email, age, and height.
- Manage Answer entities linked to Person and Question.
- Manage Question entities with a simple text field.

### Relationships:
- One-to-Many between Person and Answer.
- One-to-Many between Question and Answer.
- JSON responses tailored for efficiency using DTOs.

### Technologies Used
- Java 21
- Spring Boot 3
  - Spring Data JPA
  - Spring Web
- PostgreSQL for database
- Maven for dependency management
#
### API Endpoints
`Person` Endpoints
- Get all persons:
> `GET /persons`
- Get person by ID
> `GET /persons/{id}`
- Create person
> `POST /persons`
- Update person
> `PUT /persons/{id}`
- Delete person
> `DELETE /persons/{id}`
#
`Answer` Endpoints
- Get all answers:
> `GET /answers`
- Get answer by ID
> `GET /answers/{id}`
- Create answer
> `POST /answers`
- Update answer
> `PUT /answers/{id}`
- Delete answer
> `DELETE /answers/{id}`
#
`Question` Endpoints
- Get all questions:
> `GET /questions`
- Get question by ID
> `GET /questions/{id}`
- Create question
> `POST /questions`
- Update question
> `PUT /questions/{id}`
- Delete question
> `DELETE /questions/{id}`
