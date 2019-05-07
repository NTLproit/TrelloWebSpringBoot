CREATE TABLE users_role(
	id INT AUTO_INCREMENT NOT NULL,
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(role_id) REFERENCES role(id)
);