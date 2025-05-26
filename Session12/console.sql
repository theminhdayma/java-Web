DROP DATABASE IF EXISTS product_session12;
CREATE DATABASE product_session12;
USE product_session12;

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL UNIQUE ,
    price DECIMAL(10, 2),
    description TEXT,
    image VARCHAR(255),
    status ENUM('AVAILABLE', 'NOT_AVAILABLE') DEFAULT 'AVAILABLE' NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO products (name, price, description, image, status)
VALUES
    ('T-Shirt Basic', 199000.00, 'Áo thun cotton 100% mềm mại, thoáng mát cho mùa hè.', 'tshirt_basic.jpg', 'AVAILABLE'),
    ('Jeans Slim Fit', 399000.00, 'Quần jeans ôm vừa vặn, thích hợp cho cả nam và nữ.', 'jeans_slimfit.jpg', 'AVAILABLE'),
    ('Jacket Windbreaker', 499000.00, 'Áo khoác gió nhẹ, chống nước, thích hợp đi phượt.', 'jacket_windbreaker.jpg', 'AVAILABLE'),
    ('Sneakers Street Style', 599000.00, 'Giày thể thao phong cách đường phố, năng động.', 'sneakers_street.jpg', 'AVAILABLE'),
    ('Dress Floral', 349000.00, 'Váy hoa nhẹ nhàng cho những buổi dạo phố mùa hè.', 'dress_floral.jpg', 'NOT_AVAILABLE'),
    ('Backpack Classic', 259000.00, 'Balo vải bền chắc, nhiều ngăn tiện lợi.', 'backpack_classic.jpg', 'AVAILABLE'),
    ('Hat Bucket', 129000.00, 'Mũ bucket thời trang, che nắng tốt.', 'hat_bucket.jpg', 'AVAILABLE'),
    ('Sunglasses Trendy', 179000.00, 'Kính mát thời trang, bảo vệ mắt khỏi tia UV.', 'sunglasses_trendy.jpg', 'AVAILABLE'),
    ('Sweater Hoodie', 319000.00, 'Áo hoodie ấm áp cho mùa đông.', 'sweater_hoodie.jpg', 'NOT_AVAILABLE'),
    ('Shorts Casual', 209000.00, 'Quần short thoải mái, thích hợp cho mùa hè.', 'shorts_casual.jpg', 'AVAILABLE');

DELIMITER //

DROP PROCEDURE IF EXISTS get_all_products;
CREATE PROCEDURE get_all_products()
BEGIN
    SELECT * FROM products;
END //

DROP PROCEDURE IF EXISTS get_product_by_id;
CREATE PROCEDURE get_product_by_id(IN product_id INT)
BEGIN
    SELECT * FROM products WHERE id = product_id;
END //

DROP PROCEDURE IF EXISTS add_product;
CREATE PROCEDURE add_product(
    IN product_name VARCHAR(150),
    IN product_price DECIMAL(10, 2),
    IN product_description TEXT,
    IN product_image VARCHAR(255)
)
BEGIN
    INSERT INTO products (name, price, description, image)
    VALUES (product_name, product_price, product_description, product_image);
END //

DROP PROCEDURE IF EXISTS update_product;
CREATE PROCEDURE update_product(
    IN product_id INT,
    IN product_name VARCHAR(150),
    IN product_price DECIMAL(10, 2),
    IN product_description TEXT,
    IN product_image VARCHAR(255)
)
BEGIN
    UPDATE products
    SET name = product_name,
        price = product_price,
        description = product_description,
        image = product_image
    WHERE id = product_id;
END //

DROP PROCEDURE IF EXISTS delete_product;
CREATE PROCEDURE delete_product(IN product_id INT)
BEGIN
    DELETE FROM products WHERE id = product_id;
END //

DROP PROCEDURE IF EXISTS search_products;
CREATE PROCEDURE search_products(IN search_term VARCHAR(150))
BEGIN
    SELECT * FROM products
    WHERE name LIKE CONCAT('%', search_term, '%');
END //

DELIMITER ;