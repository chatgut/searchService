# Search microservice

The Search Microservice is designed to provide search functionality and enable the user to search for a user name or chat text. It is built using Java, Spring Boot, Rest APIs, Docker, RabbitMQ, and Elasticsearch.

## API Endpoints
The Search Microservice exposes the following REST API endpoints:

- **POST** */search/add*

Add a new chat entity to be indexed for searching. (This is just for testing purposes and does not publish any message to the RabbitMQ queue)

- **GET** */search/findAll*

Retrieve all indexed chat entities from the RabbitMQ queue.

- **GET** */search/findById/{id}*

Retrieve a chat entity by its ID from the RabbitMQ queue.

- **GET** */search/findText/{text}*

Search for chat entities containing specific text from the RabbitMQ queue.