CREATE TABLE columns_project(
	id INT AUTO_INCREMENT NOT NULL,
    columns_id INT NOT NULL,
    users_project_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(columns_id) REFERENCES columns(id),
    FOREIGN KEY(users_project_id) REFERENCES users_project(id)
);