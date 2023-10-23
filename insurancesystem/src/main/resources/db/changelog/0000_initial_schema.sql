-- Create the 'cars' table
CREATE TABLE cars (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR NOT NULL,
    manufacturer VARCHAR NOT NULL,
    fab_year INT NOT NULL,
    fipe_value DOUBLE PRECISION NOT NULL
);

-- Populate the 'cars' table
INSERT INTO cars (model, manufacturer, fab_year, fipe_value) VALUES
    ('Toyota Camry', 'Toyota', 2022, 25000.00),
    ('Honda Civic', 'Honda', 2021, 22000.00),
    ('Ford Mustang', 'Ford', 2020, 35000.00),
    ('Volkswagen Golf', 'Volkswagen', 2022, 26000.00),
    ('Chevrolet Corvette', 'Chevrolet', 2023, 45000.00);
