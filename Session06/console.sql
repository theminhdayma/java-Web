DROP DATABASE IF EXISTS session06_javaWeb;
CREATE DATABASE session06_javaWeb;
USE session06_javaWeb;

CREATE TABLE books (
                       book_id INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255),
                       author VARCHAR(255),
                       category VARCHAR(100),
                       quantity INT
);

INSERT INTO books (title, author, category, quantity) VALUES
                                                          ('Harry Potter and the Sorcerer\'s Stone', 'J.K. Rowling', 'Fantasy', 12),
                                                          ('To Kill a Mockingbird', 'Harper Lee', 'Classic', 8),
                                                          ('1984', 'George Orwell', 'Dystopian', 10),
                                                          ('The Great Gatsby', 'F. Scott Fitzgerald', 'Classic', 5),
                                                          ('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 7),
                                                          ('The Catcher in the Rye', 'J.D. Salinger', 'Classic', 6),
                                                          ('The Da Vinci Code', 'Dan Brown', 'Thriller', 9),
                                                          ('Pride and Prejudice', 'Jane Austen', 'Romance', 11),
                                                          ('The Alchemist', 'Paulo Coelho', 'Adventure', 4),
                                                          ('A Game of Thrones', 'George R.R. Martin', 'Fantasy', 13);


CREATE TABLE users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50)  NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email    VARCHAR(100),
    phone    VARCHAR(20)
);

CREATE TABLE Product
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255)   NOT NULL,
    price    DECIMAL(10, 2) NOT NULL,
    imageUrl VARCHAR(500)
);

INSERT INTO Product (name, price, imageUrl) VALUES
                                                ('Áo thun nam basic', 199000, 'https://example.com/images/ao-thun-nam.jpg'),
                                                ('Quần jeans nữ skinny', 350000, 'https://example.com/images/quan-jeans-nu.jpg'),
                                                ('Áo khoác bomber nam', 499000, 'https://example.com/images/ao-khoac-bomber.jpg'),
                                                ('Đầm dự tiệc đỏ', 599000, 'https://example.com/images/dam-do.jpg'),
                                                ('Giày thể thao unisex', 799000, 'https://example.com/images/giay-the-thao.jpg'),
                                                ('Túi xách da nữ', 650000, 'https://example.com/images/tui-xach-nu.jpg'),
                                                ('Mũ lưỡi trai đen', 99000, 'https://example.com/images/mu-luoi-trai.jpg'),
                                                ('Quần short nam kaki', 220000, 'https://example.com/images/quan-short-nam.jpg'),
                                                ('Áo sơ mi nữ công sở', 289000, 'https://example.com/images/ao-so-mi-nu.jpg'),
                                                ('Váy maxi đi biển', 379000, 'https://example.com/images/vay-maxi.jpg');


CREATE TABLE Cart
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    userId    INT NOT NULL ,
    productId INT NOT NULL,
    quantity  INT NOT NULL DEFAULT 1,
    FOREIGN KEY (productId) REFERENCES Product (id)
);

CREATE TABLE employees (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(100),
                           birthday DATE,
                           phone VARCHAR(15),
                           email VARCHAR(100),
                           salary DOUBLE,
                           position VARCHAR(50)
);
INSERT INTO employees (name, birthday, phone, email, salary, position) VALUES
                                                                           ('Nguyen Van A', '1990-01-15', '0901234567', 'vana@example.com', 15000000, 'Developer'),
                                                                           ('Tran Thi B', '1992-03-20', '0912345678', 'thib@example.com', 18000000, 'Tester'),
                                                                           ('Le Van C', '1988-07-12', '0987654321', 'vanc@example.com', 20000000, 'Project Manager'),
                                                                           ('Pham Thi D', '1995-11-05', '0932123456', 'thid@example.com', 14000000, 'HR'),
                                                                           ('Hoang Van E', '1993-09-30', '0945678910', 'vane@example.com', 16000000, 'Developer'),
                                                                           ('Do Thi F', '1991-05-25', '0956789012', 'thif@example.com', 15500000, 'Accountant'),
                                                                           ('Nguyen Van G', '1985-02-18', '0967890123', 'vang@example.com', 22000000, 'CTO'),
                                                                           ('Tran Van H', '1994-08-09', '0978901234', 'vanh@example.com', 17000000, 'BA'),
                                                                           ('Le Thi I', '1996-12-01', '0989012345', 'thii@example.com', 14500000, 'Intern'),
                                                                           ('Pham Van K', '1989-06-14', '0990123456', 'vank@example.com', 19000000, 'QA');

DELIMITER //

DROP PROCEDURE IF EXISTS sp_getAllBooks;
CREATE PROCEDURE sp_getAllBooks()
BEGIN
    SELECT * FROM books;
END //

DROP PROCEDURE IF EXISTS sp_addBook;
CREATE PROCEDURE sp_addBook (
    IN p_title VARCHAR(255),
    IN p_author VARCHAR(255),
    IN p_category VARCHAR(100),
    IN p_quantity INT
)
BEGIN
    INSERT INTO books (title, author, category, quantity)
    VALUES ( p_title, p_author, p_category, p_quantity);
END //

DROP PROCEDURE IF EXISTS sp_updateBook;
CREATE PROCEDURE sp_updateBook (
    IN p_book_id VARCHAR(20),
    IN p_title VARCHAR(255),
    IN p_author VARCHAR(255),
    IN p_category VARCHAR(100),
    IN p_quantity INT
)
BEGIN
    UPDATE books
    SET title = p_title,
        author = p_author,
        category = p_category,
        quantity = p_quantity
    WHERE book_id = p_book_id;
END //

DROP PROCEDURE IF EXISTS sp_deleteBook;
CREATE PROCEDURE sp_deleteBook (
    IN p_book_id VARCHAR(20)
)
BEGIN
    DELETE FROM books WHERE book_id = p_book_id;
END //

DROP PROCEDURE IF EXISTS sp_getBookById;
CREATE PROCEDURE sp_getBookById (
    IN p_book_id VARCHAR(20)
)
BEGIN
    SELECT * FROM books WHERE book_id = p_book_id;
END //

DELIMITER ;

DELIMITER //

DROP PROCEDURE IF EXISTS sp_getAllUser;
CREATE PROCEDURE sp_getAllUser()
BEGIN
    SELECT * FROM users;
END //

DROP PROCEDURE IF EXISTS sp_register;
CREATE PROCEDURE sp_register (
    IN p_username VARCHAR(50),
    IN p_password VARCHAR(255),
    IN p_email VARCHAR(100),
    IN p_phone VARCHAR(20)
)
BEGIN
    INSERT INTO users (username, password, email, phone)
    VALUES (p_username, p_password, p_email, p_phone);
END //

DROP PROCEDURE IF EXISTS sp_login;
CREATE PROCEDURE sp_login (
    IN p_username VARCHAR(50),
    IN p_password VARCHAR(255)
)
BEGIN
    SELECT * FROM users
    WHERE username = p_username AND password = p_password;
END //

DELIMITER ;

DELIMITER //

create procedure find_all_products()
begin
    select * from Product;
end;

create procedure add_product_to_cart(
    userId_in int,
    productId_in int,
    quantity_in int
)
begin
    if exists(select 1 from cart where userId = userId_in and productId = productId_in) then
        update cart
        set quantity = quantity + quantity_in
        where userId = userId_in and productId = productId_in;
    else
        insert into Cart(userId, productId, quantity)
        values (userId_in, productId_in, quantity_in);
    end if;
end;

create procedure find_cart_by_userId(
    userId_in int
)
begin
    select p.id as product_id,
           p.name as product_name,
           p.price as product_price,
           c.id as cart_id,
           c.userId as cart_userId,
           c.quantity as cart_quantity
    from Cart c
             join Product p on c.productId = p.id
    where c.userId = userId_in;
end;

create procedure remove_product_from_cart(
    userId_in int,
    productId_in int
)
begin
    delete from Cart
    where userId = userId_in and productId = productId_in;
end;
DELIMITER ;

DELIMITER //

CREATE PROCEDURE sp_add_employee(
    IN p_name VARCHAR(100),
    IN p_birthday DATE,
    IN p_phone VARCHAR(15),
    IN p_email VARCHAR(100),
    IN p_salary DOUBLE,
    IN p_position VARCHAR(50)
)
BEGIN
    INSERT INTO employees(name, birthday, phone, email, salary, position)
    VALUES(p_name, p_birthday, p_phone, p_email, p_salary, p_position);
END //

CREATE PROCEDURE sp_update_employee(
    IN p_id INT,
    IN p_name VARCHAR(100),
    IN p_birthday DATE,
    IN p_phone VARCHAR(15),
    IN p_email VARCHAR(100),
    IN p_salary DOUBLE,
    IN p_position VARCHAR(50)
)
BEGIN
    UPDATE employees
    SET name = p_name,
        birthday = p_birthday,
        phone = p_phone,
        email = p_email,
        salary = p_salary,
        position = p_position
    WHERE id = p_id;
END //


CREATE PROCEDURE sp_delete_employee(
    IN p_id INT
)
BEGIN
    DELETE FROM employees WHERE id = p_id;
END //

CREATE PROCEDURE sp_get_all_employees()
BEGIN
    SELECT * FROM employees;
END //

CREATE PROCEDURE sp_get_employee_by_id(
    IN p_id INT
)
BEGIN
    SELECT * FROM employees WHERE id = p_id;
END //

CREATE PROCEDURE sp_search_employee_by_name(
    IN p_name VARCHAR(100)
)
BEGIN
    SELECT * FROM employees
    WHERE name LIKE CONCAT('%', p_name, '%');
END //

DELIMITER ;