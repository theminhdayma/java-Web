DROP DATABASE IF EXISTS session10_javaWeb;
CREATE DATABASE session10_javaWeb;
USE session10_javaWeb;

CREATE TABLE accounts
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100),
    email    VARCHAR(100)
);

DELIMITER //
DROP PROCEDURE IF EXISTS register;
CREATE PROCEDURE register(
    IN p_username VARCHAR(100),
    IN p_password VARCHAR(100),
    IN p_email    VARCHAR(100)
)
BEGIN
    INSERT INTO accounts (username, password, email)
    VALUES (p_username, p_password, p_email);
END //
DELIMITER ;

CREATE TABLE documents
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(255),
    description TEXT,
    file_name   VARCHAR(255)
);

DELIMITER //
DROP PROCEDURE IF EXISTS uploadDocument;
CREATE PROCEDURE uploadDocument(
    IN p_title       VARCHAR(255),
    IN p_description TEXT,
    IN p_file_name   VARCHAR(255)
)
BEGIN
    INSERT INTO documents (title, description, file_name)
    VALUES (p_title, p_description, p_file_name);
END //
DELIMITER ;

CREATE TABLE uploads (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         description TEXT,
                         file_url VARCHAR(500)
);

DELIMITER //
DROP PROCEDURE IF EXISTS uploadFile;
CREATE PROCEDURE uploadFile(
    IN p_description TEXT,
    IN p_file_url    VARCHAR(500)
)
BEGIN
    INSERT INTO uploads (description, file_url)
    VALUES (p_description, p_file_url);
END //
DELIMITER ;

CREATE TABLE projects (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255),
                          description TEXT
);

CREATE TABLE document (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           project_id INT,
                           filename VARCHAR(255),
                           FOREIGN KEY (project_id) REFERENCES projects(id)
);


DELIMITER //
DROP PROCEDURE IF EXISTS createProject;
CREATE PROCEDURE createProject(
    IN p_name VARCHAR(255),
    IN p_description TEXT,
    OUT id_out INT
)
BEGIN
    INSERT INTO projects (name, description) VALUES (p_name, p_description);
    SET id_out = LAST_INSERT_ID();
END //

DROP PROCEDURE IF EXISTS insertDocument;
CREATE PROCEDURE insertDocument(
    IN p_project_id INT,
    IN p_filename VARCHAR(255)
)
BEGIN
    INSERT INTO document (project_id, filename)
    VALUES (p_project_id, p_filename);
END //
DELIMITER ;
