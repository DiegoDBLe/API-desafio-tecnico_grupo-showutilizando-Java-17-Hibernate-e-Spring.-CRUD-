CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO usuarios (username, password)
VALUES (
  'admin',
  '$2a$10$yZ5N0c2uPzv9K8sT2GZ0kOHVYqF4X1mZb7qU5KxZcY7Z1y1n0p3rG'
);
