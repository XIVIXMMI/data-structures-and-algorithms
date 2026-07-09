CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

INSERT INTO users(name, email) VALUES ('John Doe', 'john@example.com');
INSERT INTO users(name, email) VALUES ('Alexandro Arnold', 'alex@example.com');
