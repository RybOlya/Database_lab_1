-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-12 19:29:18.024

-- tables
-- Table: IP_address
CREATE TABLE IP_address (
    IP_address varchar(15) NOT NULL,
    CONSTRAINT IP_address_pk PRIMARY KEY (IP_address)
);

-- Table: address
CREATE TABLE address (
    id int NOT NULL AUTO_INCREMENT,
    city varchar(35) NOT NULL,
    region varchar(35) NOT NULL,
    street varchar(50) NOT NULL,
    building_number int NOT NULL,
    CONSTRAINT address_pk PRIMARY KEY (id)
);

-- Table: battery
CREATE TABLE battery (
    id int NOT NULL AUTO_INCREMENT,
    capacity double(5,2) NOT NULL,
    operating_temperature int NOT NULL DEFAULT 20 COMMENT '°C',
    IP_address varchar(15) NOT NULL,
    efficiency_id int NOT NULL,
    CONSTRAINT battery_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city (
    name varchar(35) NOT NULL,
    region varchar(35) NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (name,region)
);

-- Table: client
CREATE TABLE client (
    id int NOT NULL AUTO_INCREMENT,
    surname varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
    address_id int NOT NULL,
    contact_info_id int NOT NULL,
    password varchar(100) NOT NULL,
    is_a_company bool NULL,
    CONSTRAINT client_pk PRIMARY KEY (id)
);

-- Table: client_solar
CREATE TABLE client_solar (
    id int NOT NULL AUTO_INCREMENT,
    solar_system_id int NOT NULL,
    client_id int NOT NULL,
    CONSTRAINT client_solar_pk PRIMARY KEY (id)
);

-- Table: contact_info
CREATE TABLE contact_info (
    id int NOT NULL AUTO_INCREMENT,
    phone char(12) NOT NULL,
    email varchar(35) NOT NULL,
    CONSTRAINT contact_info_pk PRIMARY KEY (id)
);

-- Table: devices
CREATE TABLE devices (
    id int NOT NULL AUTO_INCREMENT,
    solar_panel_id int NULL,
    battery_id int NULL,
    CONSTRAINT devices_pk PRIMARY KEY (id)
);

-- Table: efficiency
CREATE TABLE efficiency (
    id int NOT NULL AUTO_INCREMENT,
    device_id int NOT NULL,
    `current_time` time NOT NULL,
    consumption int NOT NULL,
    production int NOT NULL,
    CONSTRAINT efficiency_pk PRIMARY KEY (id)
);

-- Table: installation
CREATE TABLE installation (
    id int NOT NULL AUTO_INCREMENT,
    cost int NOT NULL,
    installer_company_id int NOT NULL,
    client_solar_id int NOT NULL,
    CONSTRAINT installation_pk PRIMARY KEY (id)
);

-- Table: installer_company
CREATE TABLE installer_company (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(35) NOT NULL,
    address_id int NOT NULL,
    contact_info_id int NOT NULL,
    area_coverage int NOT NULL,
    CONSTRAINT installer_company_pk PRIMARY KEY (id)
);

-- Table: region
CREATE TABLE region (
    name varchar(35) NOT NULL,
    CONSTRAINT region_pk PRIMARY KEY (name)
);

-- Table: solar_panel
CREATE TABLE solar_panel (
    id int NOT NULL AUTO_INCREMENT,
    type varchar(35) NOT NULL,
    current_angle float NULL,
    efficiency_id int NOT NULL,
    IP_address varchar(15) NOT NULL,
    CONSTRAINT solar_panel_pk PRIMARY KEY (id)
);

-- Table: solar_system
CREATE TABLE solar_system (
    id int NOT NULL AUTO_INCREMENT,
    status varchar(35) NOT NULL,
    is_connected bool NOT NULL,
    feed_in_tariff double(8,2) NOT NULL,
    energy_sold int NOT NULL,
    low_rate_tariff double(8,2) NOT NULL,
    offset_of_control int NOT NULL COMMENT 'This value determines the tolerance of the
control. With a control offset of e.g. 50W, about
50W are not consumed by the system itself, but
fed into the grid. This means that electricity does
not have to be drawn immediately if the amount
of electricity produced fluctuates slightly.',
    kWp int NULL COMMENT 'Kilowatt peak output',
    house_fuse int NULL COMMENT 'Value per phase in Amperes (e.g. 25 A or 40A)',
    devices_id int NOT NULL,
    location int NOT NULL,
    CONSTRAINT solar_system_pk PRIMARY KEY (id)
);

-- Table: time_slots_with_low_rate_tariff
CREATE TABLE time_slots_with_low_rate_tariff (
    low_rate_tariff double(8,2) NOT NULL AUTO_INCREMENT,
    monday_friday_from time NOT NULL,
    monday_friday_to time NOT NULL,
    saturday_from time NOT NULL,
    saturday_to time NOT NULL,
    sunday_from time NOT NULL,
    sunday_to time NOT NULL,
    CONSTRAINT time_slots_with_low_rate_tariff_pk PRIMARY KEY (low_rate_tariff)
);

-- foreign keys
-- Reference: address_city (table: address)
ALTER TABLE address ADD CONSTRAINT address_city FOREIGN KEY address_city (city,region)
    REFERENCES city (name,region);

-- Reference: battery_IP_address (table: battery)
ALTER TABLE battery ADD CONSTRAINT battery_IP_address FOREIGN KEY battery_IP_address (IP_address)
    REFERENCES IP_address (IP_address);

-- Reference: battery_efficiency (table: battery)
ALTER TABLE battery ADD CONSTRAINT battery_efficiency FOREIGN KEY battery_efficiency (efficiency_id)
    REFERENCES efficiency (id);

-- Reference: city_region (table: city)
ALTER TABLE city ADD CONSTRAINT city_region FOREIGN KEY city_region (region)
    REFERENCES region (name);

-- Reference: client_address (table: client)
ALTER TABLE client ADD CONSTRAINT client_address FOREIGN KEY client_address (address_id)
    REFERENCES address (id);

-- Reference: client_contact_info (table: client)
ALTER TABLE client ADD CONSTRAINT client_contact_info FOREIGN KEY client_contact_info (contact_info_id)
    REFERENCES contact_info (id);

-- Reference: client_solar_client (table: client_solar)
ALTER TABLE client_solar ADD CONSTRAINT client_solar_client FOREIGN KEY client_solar_client (client_id)
    REFERENCES client (id);

-- Reference: client_solar_solar_system (table: client_solar)
ALTER TABLE client_solar ADD CONSTRAINT client_solar_solar_system FOREIGN KEY client_solar_solar_system (solar_system_id)
    REFERENCES solar_system (id);

-- Reference: devices_battery (table: devices)
ALTER TABLE devices ADD CONSTRAINT devices_battery FOREIGN KEY devices_battery (battery_id)
    REFERENCES battery (id);

-- Reference: devices_solar_panel (table: devices)
ALTER TABLE devices ADD CONSTRAINT devices_solar_panel FOREIGN KEY devices_solar_panel (solar_panel_id)
    REFERENCES solar_panel (id);

-- Reference: installation_client_solar (table: installation)
ALTER TABLE installation ADD CONSTRAINT installation_client_solar FOREIGN KEY installation_client_solar (client_solar_id)
    REFERENCES client_solar (id);

-- Reference: installation_installer_company (table: installation)
ALTER TABLE installation ADD CONSTRAINT installation_installer_company FOREIGN KEY installation_installer_company (installer_company_id)
    REFERENCES installer_company (id);

-- Reference: installer_company_address (table: installer_company)
ALTER TABLE installer_company ADD CONSTRAINT installer_company_address FOREIGN KEY installer_company_address (address_id)
    REFERENCES address (id);

-- Reference: installer_company_contact_info (table: installer_company)
ALTER TABLE installer_company ADD CONSTRAINT installer_company_contact_info FOREIGN KEY installer_company_contact_info (contact_info_id)
    REFERENCES contact_info (id);

-- Reference: solar_panel_IP_address (table: solar_panel)
ALTER TABLE solar_panel ADD CONSTRAINT solar_panel_IP_address FOREIGN KEY solar_panel_IP_address (IP_address)
    REFERENCES IP_address (IP_address);

-- Reference: solar_panel_efficiency (table: solar_panel)
ALTER TABLE solar_panel ADD CONSTRAINT solar_panel_efficiency FOREIGN KEY solar_panel_efficiency (efficiency_id)
    REFERENCES efficiency (id);

-- Reference: solar_system_address (table: solar_system)
ALTER TABLE solar_system ADD CONSTRAINT solar_system_address FOREIGN KEY solar_system_address (location)
    REFERENCES address (id);

-- Reference: solar_system_devices (table: solar_system)
ALTER TABLE solar_system ADD CONSTRAINT solar_system_devices FOREIGN KEY solar_system_devices (devices_id)
    REFERENCES devices (id);

-- Reference: solar_system_time_slots_with_low_rate_tariff (table: solar_system)
ALTER TABLE solar_system ADD CONSTRAINT solar_system_time_slots_with_low_rate_tariff FOREIGN KEY solar_system_time_slots_with_low_rate_tariff (low_rate_tariff)
    REFERENCES time_slots_with_low_rate_tariff (low_rate_tariff);

-- End of file.

