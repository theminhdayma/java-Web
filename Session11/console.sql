DROP DATABASE IF EXISTS javaWeb_session11;
CREATE DATABASE javaWeb_session11;
USE javaWeb_session11;

-- Bảng category
CREATE TABLE category (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          categoryName VARCHAR(50) NOT NULL UNIQUE,
                          status BIT DEFAULT 1
);

INSERT INTO category (categoryName, status) VALUES
                                                ('Thời trang nam', 1),
                                                ('Thời trang nữ', 1),
                                                ('Giày dép', 1),
                                                ('Phụ kiện', 1),
                                                ('Đồng hồ', 1),
                                                ('Túi xách', 1),
                                                ('Trang sức', 1),
                                                ('Đồ thể thao', 1),
                                                ('Đồ công nghệ', 1),
                                                ('Sách và văn phòng phẩm', 1);

DELIMITER //

-- Procedure thêm
DROP PROCEDURE IF EXISTS saveCategory;
CREATE PROCEDURE saveCategory(IN p_categoryName VARCHAR(50))
BEGIN
    DECLARE countName INT;
    SELECT COUNT(*) INTO countName FROM category WHERE categoryName = p_categoryName;
    IF countName > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Tên danh mục đã tồn tại';
    ELSE
        INSERT INTO category (categoryName) VALUES (p_categoryName);
    END IF;
END //

-- Procedure sửa
DROP PROCEDURE IF EXISTS updateCategory;
CREATE PROCEDURE updateCategory(IN p_id INT, IN p_categoryName VARCHAR(50), IN p_status BIT)
BEGIN
    DECLARE countName INT;
    SELECT COUNT(*) INTO countName FROM category WHERE categoryName = p_categoryName AND id != p_id;
    IF countName > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Tên danh mục đã tồn tại';
    ELSE
        UPDATE category SET categoryName = p_categoryName, status = p_status WHERE id = p_id;
    END IF;
END //

-- Procedure xóa
DROP PROCEDURE IF EXISTS deleteCategory;
CREATE PROCEDURE deleteCategory(IN p_id INT)
BEGIN
    DELETE FROM category WHERE id = p_id;
END //

DROP PROCEDURE IF EXISTS getCategoryById;
CREATE PROCEDURE getCategoryById(IN p_id INT)
BEGIN
    SELECT * FROM category WHERE id = p_id;
END //

DROP PROCEDURE IF EXISTS getAllCategory;
CREATE PROCEDURE getAllCategory()
BEGIN
    SELECT * FROM category;
END //

DROP PROCEDURE IF EXISTS checkCategoryExists;
CREATE PROCEDURE checkCategoryExists(
    IN p_categoryName VARCHAR(50),
    OUT p_exists BOOLEAN
)
BEGIN
    DECLARE countName INT;
    SELECT COUNT(*) INTO countName FROM category WHERE categoryName = p_categoryName;
    SET p_exists = countName > 0;
END //

DELIMITER ;
