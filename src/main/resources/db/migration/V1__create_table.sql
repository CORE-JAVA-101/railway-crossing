CREATE TABLE railway_crossings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE KEY,
    address VARCHAR(255) NOT NULL,
    landmark VARCHAR(255),
    train_schedule DATETIME,
    platform_in_charge VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL
);
