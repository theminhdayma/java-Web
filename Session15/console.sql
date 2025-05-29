DROP DATABASE IF EXISTS javaweb_session15;
CREATE DATABASE javaweb_session15;
USE javaweb_session15;

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    description TEXT
);

INSERT INTO product (name, price, description) VALUES
                                                   ('Áo thun nam', 199000, 'Áo thun cotton thoáng mát'),
                                                   ('Quần jean nữ', 399000, 'Quần jean co giãn, ôm dáng'),
                                                   ('Áo khoác gió', 499000, 'Áo khoác gió chống nước'),
                                                   ('Giày sneaker', 699000, 'Giày thể thao thời trang'),
                                                   ('Túi xách da', 899000, 'Túi xách da thật cao cấp'),
                                                   ('Đồng hồ nam', 1599000, 'Đồng hồ thời trang nam'),
                                                   ('Kính mát', 299000, 'Kính mát chống tia UV'),
                                                   ('Mũ lưỡi trai', 149000, 'Mũ thời trang phong cách'),
                                                   ('Áo sơ mi', 259000, 'Áo sơ mi tay dài công sở'),
                                                   ('Váy nữ', 349000, 'Váy nữ dạo phố thời trang');


CREATE TABLE review (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    user_id INT DEFAULT 1,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    FOREIGN KEY (product_id) REFERENCES product(id)
);

INSERT INTO review (product_id, user_id, rating, comment) VALUES
                                                              (1, 1, 5, 'Chất liệu mát, mặc rất thoải mái'),
                                                              (2, 1, 4, 'Vải co giãn tốt, rất thích'),
                                                              (3, 1, 3, 'Áo đẹp nhưng hơi rộng'),
                                                              (4, 1, 5, 'Giày rất êm, đi chạy bộ rất tốt'),
                                                              (5, 1, 4, 'Túi đẹp, màu sang trọng'),
                                                              (6, 1, 5, 'Đồng hồ đẹp, đáng giá tiền'),
                                                              (7, 1, 4, 'Kính đeo thoải mái, không đau tai'),
                                                              (8, 1, 3, 'Mũ ổn, hơi nhỏ với mình'),
                                                              (9, 1, 4, 'Áo sơ mi đẹp, nhưng giao hàng chậm'),
                                                              (10, 1, 5, 'Váy đẹp như hình, vợ mình rất thích');


CREATE TABLE cart (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT DEFAULT 1,
    product_id INT NOT NULL,
    quantity INT DEFAULT 1,
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE Orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT DEFAULT 1,
    recipient_Name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone_number VARCHAR(15) NOT NULL
);

CREATE TABLE OrderDetail  (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT DEFAULT 1,
    currentPrice DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

DELIMITER //

DROP PROCEDURE IF EXISTS saveProductReview;
CREATE PROCEDURE saveProductReview(
    IN p_product_id INT,
    IN p_rating INT,
    IN p_comment TEXT
)
BEGIN
    DECLARE v_user_id INT DEFAULT 1;

    INSERT INTO review (product_id, user_id, rating, comment)
    VALUES (p_product_id, v_user_id, p_rating, p_comment);
END //

DROP PROCEDURE IF EXISTS getAllProducts;
CREATE PROCEDURE getAllProducts()
BEGIN
    SELECT * FROM product;
END //
DROP PROCEDURE IF EXISTS getProductById;
CREATE PROCEDURE getProductById(
    IN p_product_id INT
)
BEGIN
    SELECT * FROM product WHERE id = p_product_id;
END //

DROP PROCEDURE IF EXISTS getAllReviewsByProductId;
CREATE PROCEDURE getAllReviewsByProductId(
    IN p_product_id INT
)
BEGIN
    SELECT * FROM review
    WHERE product_id = p_product_id;
END //

DROP PROCEDURE IF EXISTS addToCart;
CREATE PROCEDURE addToCart(
    IN p_product_id INT,
    IN p_quantity INT
)
BEGIN
    DECLARE v_user_id INT DEFAULT 1;

    DECLARE v_cart_count INT;

    SELECT COUNT(*) INTO v_cart_count FROM cart
    WHERE user_id = v_user_id AND product_id = p_product_id;

    IF v_cart_count > 0 THEN
        UPDATE cart
        SET quantity = quantity + p_quantity
        WHERE user_id = v_user_id AND product_id = p_product_id;
    ELSE
        INSERT INTO cart (user_id, product_id, quantity)
        VALUES (v_user_id, p_product_id, p_quantity);
    END IF;
END //

DROP PROCEDURE IF EXISTS getCartByUserId;
CREATE PROCEDURE getCartByUserId(IN p_user_id INT)
BEGIN
    SELECT * FROM cart
    WHERE user_id = p_user_id;
END //

DROP PROCEDURE IF EXISTS addorder;
CREATE PROCEDURE addOrder(
    IN p_user_id INT,
    IN p_recipient_name VARCHAR(100),
    IN p_address VARCHAR(255),
    IN p_phone_number VARCHAR(15)
)
BEGIN
    DECLARE v_order_id INT;

    INSERT INTO Orders (user_id, recipient_Name, address, phone_number)
    VALUES (p_user_id, p_recipient_name, p_address, p_phone_number);

    SET v_order_id = LAST_INSERT_ID();

    INSERT INTO OrderDetail (order_id, product_id, quantity, currentPrice)
    SELECT v_order_id, product_id, quantity, price
    FROM cart
             JOIN product ON cart.product_id = product.id
    WHERE cart.user_id = p_user_id;

    DELETE FROM cart WHERE user_id = p_user_id;
END //

DELIMITER ;