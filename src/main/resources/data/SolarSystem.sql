CREATE SCHEMA IF NOT EXISTS solar_system;
USE solar_system;


CREATE TABLE IF NOT EXISTS city
(
    id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(25) NOT NULL
);
CREATE TABLE  IF NOT EXISTS ip_address (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ip_address varchar(15) NOT NULL
);

CREATE TABLE  IF NOT EXISTS solar_system (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    feed_in_tariff double(8,2) NOT NULL,
    energy_sold int NOT NULL,
    city_id   INT         NULL,
    street    VARCHAR(30) NULL,
    apartment VARCHAR(10) NULL,
    CONSTRAINT fk_solar_system_city1
        FOREIGN KEY (city_id)
            REFERENCES city (id)
);
CREATE TABLE IF NOT EXISTS solar_panel
(
    id           INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ip_address_id int NOT NULL,
    model    VARCHAR(45) NOT NULL,
    type VARCHAR(35) NOT NULL,
	solar_system_id INT  NOT NULL,
    current_angle float NOT NULL,
      CONSTRAINT fk_solar_panel_solar_system1
        FOREIGN KEY (solar_system_id)
            REFERENCES solar_system (id)
);

CREATE TABLE IF NOT EXISTS solar_battery
(
    id           INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    model    VARCHAR(45) NOT NULL,
    ip_address_id int NOT NULL,
    capacity double(5,2) NOT NULL,
    operating_temperature int NOT NULL DEFAULT 20 COMMENT '°C',
	solar_system_id INT  NOT NULL,
      CONSTRAINT fk_solar_battery_solar_system1
        FOREIGN KEY (solar_system_id)
            REFERENCES solar_system (id)
);


CREATE TABLE IF NOT EXISTS client
(
    id        INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    surname   VARCHAR(25) NOT NULL,
    name      VARCHAR(25) NOT NULL,
    email     VARCHAR(45) NULL,
    city_id   INT         NULL,
    street    VARCHAR(30) NULL,
    apartment VARCHAR(10) NULL,
    CONSTRAINT fk_client_city1
        FOREIGN KEY (city_id)
            REFERENCES city (id)
);

CREATE TABLE IF NOT EXISTS client_solar_system
(
    client_id INT NOT NULL,
    solar_system_id   INT NOT NULL,
    PRIMARY KEY (client_id, solar_system_id),
    CONSTRAINT clientsolar_system_ibfk_1
        FOREIGN KEY (client_id)
            REFERENCES client (id),
    CONSTRAINT clientsolar_system_ibfk_2
        FOREIGN KEY (solar_system_id)
            REFERENCES solar_system (id)
);

