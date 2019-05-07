CREATE TABLE task(
	id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(200) NOT NULL,
    deadline DATE NOT NULL,
    description VARCHAR(500),
    columns_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(columns_id) REFERENCES columns(id)
);