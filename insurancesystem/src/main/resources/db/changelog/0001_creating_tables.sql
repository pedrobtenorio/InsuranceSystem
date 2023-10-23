
-- Create the 'drivers' table
CREATE TABLE drivers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    document VARCHAR(255),
    birthdate DATE
);

-- Create the 'customers' table
CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    driver_id INT,
    FOREIGN KEY (driver_id) REFERENCES drivers(id)
);

-- Create the 'insurances' table
CREATE TABLE insurances (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    budget DOUBLE,
    creation_date DATE,
    updated_at DATE,
    car_id INT,
    is_active BOOLEAN,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (car_id) REFERENCES cars(id)
);

-- Create the 'claims' table
CREATE TABLE claims (
    id INT AUTO_INCREMENT PRIMARY KEY,
    car_id INT,
    driver_id INT,
    event_date DATE,
    FOREIGN KEY (car_id) REFERENCES cars(id),
    FOREIGN KEY (driver_id) REFERENCES drivers(id)
);

-- Create the 'car_drivers' table
CREATE TABLE car_drivers (
        id INT AUTO_INCREMENT PRIMARY KEY,
        car_id INT,
        driver_id INT,
        is_main_driver BOOLEAN,
        FOREIGN KEY (car_id) REFERENCES cars(id),
        FOREIGN KEY (driver_id) REFERENCES drivers(id)
);

-- Insert sample data into the 'drivers' table
INSERT INTO drivers (document, birthdate)
VALUES
    ('Driver 1 Document', '1990-05-15'),
    ('Driver 2 Document', '2000-09-20'),
    ('Driver 3 Document', '1999-03-10');

-- Insert sample data into the 'customers' table
INSERT INTO customers (name, driver_id)
VALUES
    ('Customer 1', 1),
    ('Customer 2', 2);

-- Insert sample data into the 'claims' table
INSERT INTO claims (car_id, driver_id, event_date)
VALUES
    (1, 1, '2023-01-15'),
    (2, 2, '2023-02-20');

-- Insert sample data into the 'car_drivers' table
INSERT INTO car_drivers (car_id, driver_id, is_main_driver)
VALUES
    (1, 1, 1),
    (2, 2, 1),
    (3, 3, 1);
