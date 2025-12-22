CREATE DATABASE spendwise;
USE spendwise;

CREATE TABLE spends (
	id_spend INT PRIMARY KEY AUTO_INCREMENT,
    date_spend DATE NOT NULL, 
    description_spend TEXT NOT NULL,
    category_spend VARCHAR(30) NOT NULL,
    value_spend DECIMAL(7,2) NOT NULL,
    type_spend VARCHAR(6) NOT NULL,
    CONSTRAINT chk_type CHECK(type_spend IN('INPUT', 'OUTPUT'))
);

CREATE USER 'spendwise-app'@'localhost' IDENTIFIED BY 'senha1234@A';

GRANT INSERT ON spendwise.spends TO 'spendwise-app'@'localhost';

FLUSH PRIVILEGES;
    