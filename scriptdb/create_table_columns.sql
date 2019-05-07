CREATE TABLE columns(
	id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(120) NOT NULL,
    project_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY (project_id) REFERENCES project(id)
);