DROP DATABASE IF EXISTS javaweb_session16;
CREATE DATABASE javaweb_session16;
USE javaweb_session16;

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    role ENUM('USER', 'ADMIN'),
    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE'
);

INSERT INTO user (username, password, email, role, status) VALUES
                                                               ('admin1', 'admin123', 'admin1@example.com', 'ADMIN', 'ACTIVE'),
                                                               ('user1', 'user123', 'user1@example.com', 'USER', 'ACTIVE'),
                                                               ('user2', 'user234', 'user2@example.com', 'USER', 'ACTIVE'),
                                                               ('user3', 'user345', 'user3@example.com', 'USER', 'INACTIVE'),
                                                               ('admin2', 'admin234', 'admin2@example.com', 'ADMIN', 'ACTIVE'),
                                                               ('user4', 'user456', 'user4@example.com', 'USER', 'ACTIVE'),
                                                               ('user5', 'user567', 'user5@example.com', 'USER', 'INACTIVE'),
                                                               ('user6', 'user678', 'user6@example.com', 'USER', 'ACTIVE'),
                                                               ('user7', 'user789', 'user7@example.com', 'USER', 'ACTIVE'),
                                                               ('admin3', 'admin345', 'admin3@example.com', 'ADMIN', 'ACTIVE');


CREATE TABLE trip (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    start_point VARCHAR(100) NOT NULL,
    end_point VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE'
);

INSERT INTO trip (title, description, start_point, end_point, price, status) VALUES
                                                                                ('Trip to Hanoi', 'A relaxing trip to the capital city of Vietnam.', 'Ho Chi Minh City', 'Hanoi', 150.00, 'ACTIVE'),
                                                                                ('Beach Escape', 'Enjoy the beaches of Da Nang.', 'Hanoi', 'Da Nang', 120.50, 'ACTIVE'),
                                                                                ('Mountain Adventure', 'Trekking the mountains of Sapa.', 'Hanoi', 'Sapa', 180.00, 'ACTIVE'),
                                                                                ('Explore Hue', 'Historical sites and culture in Hue.', 'Da Nang', 'Hue', 90.00, 'INACTIVE'),
                                                                                ('Southern Charm', 'Discover the beauty of the Mekong Delta.', 'Can Tho', 'Soc Trang', 70.00, 'ACTIVE'),
                                                                                ('Central Highlands Tour', 'Explore the highlands of Dak Lak.', 'Ho Chi Minh City', 'Buon Ma Thuot', 160.00, 'ACTIVE'),
                                                                                ('Island Hopping', 'Visit multiple islands in Kien Giang.', 'Rach Gia', 'Phu Quoc', 140.00, 'INACTIVE'),
                                                                                ('Northern Heritage', 'Visit cultural sites in Ninh Binh.', 'Hanoi', 'Ninh Binh', 100.00, 'ACTIVE'),
                                                                                ('Beach & City', 'Mix of beach and city life in Vung Tau.', 'Ho Chi Minh City', 'Vung Tau', 85.00, 'ACTIVE'),
                                                                                ('Food Tour', 'Taste your way through Vietnam.', 'Hue', 'Ho Chi Minh City', 200.00, 'ACTIVE');

CREATE TABLE bus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    licensePlate VARCHAR(250),
    busType ENUM('VIP', 'LUXURY', 'NORMAL') NOT NULL,
    rowSeat INT,
    colSeat INT,
    totalSeat INT AS (rowSeat * colSeat) STORED,
    image VARCHAR(250)
);

INSERT INTO bus (licensePlate, busType, rowSeat, colSeat, image) VALUES
    ('29B-12345', 'VIP', 5, 2, 'bus_vip.jpg'),
    ('29B-67890', 'LUXURY', 4, 2, 'bus_luxury.jpg'),
    ('29B-54321', 'NORMAL', 6, 3, 'bus_normal.jpg'),
    ('29B-98765', 'VIP', 5, 2, 'bus_vip2.jpg'),
    ('29B-11223', 'LUXURY', 4, 2, 'bus_luxury2.jpg'),
    ('29B-44556', 'NORMAL', 6, 3, 'bus_normal2.jpg'),
    ('29B-77889', 'VIP', 5, 2, 'bus_vip3.jpg'),
    ('29B-99001', 'LUXURY', 4, 2, 'bus_luxury3.jpg'),
    ('29B-22334', 'NORMAL', 6, 3, 'bus_normal3.jpg'),
    ('29B-55667', 'VIP', 5, 2, 'bus_vip4.jpg'),
    ('29B-88990', 'LUXURY', 4, 2, 'bus_luxury4.jpg'),
    ('29B-33445', 'NORMAL', 6, 3, 'bus_normal4.jpg'),
    ('29B-66778', 'VIP', 5, 2, 'bus_vip5.jpg'),
    ('29B-00112', 'LUXURY', 4, 2, 'bus_luxury5.jpg'),
    ('29B-22356', 'NORMAL', 6, 3, 'bus_normal5.jpg');

CREATE TABLE seat (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      nameSeat VARCHAR(10),
                      price INT,
                      status bit DEFAULT 1,
                      busId INT,
                      FOREIGN KEY (busId) REFERENCES bus(id)
);

INSERT INTO seat (nameSeat, price, status, busId) VALUES
    ('1A', 100, 1, 1),
    ('1B', 100, 1, 1),
    ('2A', 100, 1, 1),
    ('2B', 100, 1, 1),
    ('3A', 100, 1, 1),
    ('3B', 100, 1, 1),
    ('4A', 100, 0, 2),
    ('4B', 100, 0, 2),
    ('5A', 100, 0, 2),
    ('5B', 100, 0, 2),
    ('6A', 100, 0, 3),
    ('6B', 100, 0, 3);


DELIMITER //

DROP PROCEDURE IF EXISTS username_exists;
CREATE PROCEDURE username_exists(
    IN p_username VARCHAR(50)
)
BEGIN
    DECLARE v_count INT DEFAULT 0;

    SELECT COUNT(*) INTO v_count
    FROM user
    WHERE username = p_username;

    IF v_count > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Tên đăng nhập đã tồn tại';
    END IF;
END //

DROP PROCEDURE IF EXISTS register_user;
CREATE PROCEDURE register_user(
    IN p_username VARCHAR(50),
    IN p_password VARCHAR(100),
    IN p_email VARCHAR(100)
)
BEGIN
    DECLARE v_username INT DEFAULT 0;

    SELECT COUNT(*) INTO v_username
    FROM user
    WHERE username = p_username;

    IF v_username > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Tên đăng nhập đã tồn tại';
    ELSE
        INSERT INTO user (username, password, email, role, status)
        VALUES (p_username, p_password, p_email, 'USER', 'ACTIVE');
    END IF;
END //

DROP PROCEDURE IF EXISTS login;
CREATE PROCEDURE login(
    IN p_username VARCHAR(50),
    IN p_password VARCHAR(100)
)
BEGIN
    SELECT * FROM user
    WHERE username = p_username
    AND password = p_password
    AND status = 'ACTIVE';
END //

DROP PROCEDURE IF EXISTS get_user_by_username;
CREATE PROCEDURE get_user_by_username(
    IN p_username VARCHAR(50)
)
BEGIN
    SELECT * FROM user
    WHERE username = p_username;
END //

DROP PROCEDURE IF EXISTS get_all_trips;
CREATE PROCEDURE get_all_trips()
BEGIN
    SELECT * FROM trip
    WHERE status = 'ACTIVE';
END //

DROP PROCEDURE IF EXISTS get_trip_by_id;
CREATE PROCEDURE get_trip_by_id(
    IN p_trip_id INT
)
BEGIN
    SELECT * FROM trip
    WHERE id = p_trip_id
    AND status = 'ACTIVE';
END //

DROP PROCEDURE IF EXISTS search_trips_by_start_end_points;
CREATE PROCEDURE search_trips_by_start_end_points(
    IN p_start_point VARCHAR(100),
    IN p_end_point VARCHAR(100)
)
BEGIN
    SELECT * FROM trip
    WHERE start_point LIKE CONCAT('%', p_start_point, '%')
    AND end_point LIKE CONCAT('%', p_end_point, '%')
    AND status = 'ACTIVE';
END //

DROP PROCEDURE IF EXISTS get_all_buses;
CREATE PROCEDURE get_all_buses()
BEGIN
    SELECT * FROM bus;
END //
DROP PROCEDURE IF EXISTS get_bus_by_id;
CREATE PROCEDURE get_bus_by_id(
    IN p_bus_id INT
)
BEGIN
    SELECT * FROM bus
    WHERE id = p_bus_id;
END //

DROP PROCEDURE IF EXISTS add_bus;
CREATE PROCEDURE add_bus(
    IN p_licensePlate VARCHAR(250),
    IN p_busType ENUM('VIP', 'LUXURY', 'NORMAL'),
    IN p_rowSeat INT,
    IN p_colSeat INT,
    IN p_image VARCHAR(250)
)
BEGIN
    INSERT INTO bus (licensePlate, busType, rowSeat, colSeat, image)
    VALUES (p_licensePlate, p_busType, p_rowSeat, p_colSeat, p_image);
END //

DROP PROCEDURE IF EXISTS update_bus;
CREATE PROCEDURE update_bus(
    IN p_bus_id INT,
    IN p_licensePlate VARCHAR(250),
    IN p_busType ENUM('VIP', 'LUXURY', 'NORMAL'),
    IN p_rowSeat INT,
    IN p_colSeat INT,
    IN p_image VARCHAR(250)
)
BEGIN
    UPDATE bus
    SET licensePlate = p_licensePlate,
        busType = p_busType,
        rowSeat = p_rowSeat,
        colSeat = p_colSeat,
        image = p_image
    WHERE id = p_bus_id;
END //

DROP PROCEDURE IF EXISTS delete_bus;
CREATE PROCEDURE delete_bus(
    IN p_bus_id INT
)
    BEGIN
        DECLARE v_count INT DEFAULT 0;
        SELECT COUNT(*) INTO v_count
        FROM seat
        WHERE busId = p_bus_id;
        IF v_count > 0 THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Không thể xóa xe buýt vì có ghế liên kết';
        ELSE
            DELETE FROM bus
            WHERE id = p_bus_id;
        END IF;
    end //

DROP PROCEDURE IF EXISTS get_seats_by_bus_id;
CREATE PROCEDURE get_seats_by_bus_id(
    IN p_bus_id INT
)
BEGIN
    SELECT * FROM seat
    WHERE busId = p_bus_id;
END //
DROP PROCEDURE IF EXISTS add_seat;
CREATE PROCEDURE add_seat(
    IN p_nameSeat VARCHAR(10),
    IN p_price INT,
    IN p_status BIT,
    IN p_busId INT
)
BEGIN
    INSERT INTO seat (nameSeat, price, status, busId)
    VALUES (p_nameSeat, p_price, p_status, p_busId);
END //

DROP PROCEDURE IF EXISTS update_seat;
CREATE PROCEDURE update_seat(
    IN p_seat_id INT,
    IN p_nameSeat VARCHAR(10),
    IN p_price INT,
    IN p_status BIT,
    IN p_busId INT
)
BEGIN
    UPDATE seat
    SET nameSeat = p_nameSeat,
        price = p_price,
        status = p_status,
        busId = p_busId
    WHERE id = p_seat_id;
END //

DROP PROCEDURE IF EXISTS delete_seat;
CREATE PROCEDURE delete_seat(
    IN p_seat_id INT
)
BEGIN
    DELETE FROM seat
    WHERE id = p_seat_id;
END //

DELIMITER ;

