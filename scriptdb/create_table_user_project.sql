CREATE TABLE users_project(
	id INT AUTO_INCREMENT NOT NULL,
    users_id INT NOT NULL,
    project_id INT NOT NULL,
    isManage BOOLEAN NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(users_id) REFERENCES users(id),
    FOREIGN KEY(project_id) REFERENCES project(id)
);