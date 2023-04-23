
CREATE TABLE IF NOT EXISTS regions (
                         region_id INT (11) UNSIGNED NOT NULL,
                         region_name VARCHAR(25),
                         PRIMARY KEY (region_id)
);

CREATE TABLE IF NOT EXISTS countries (
                           country_id CHAR(2) NOT NULL,
                           country_name VARCHAR(40),
                           region_id INT (11) UNSIGNED NOT NULL,
                           PRIMARY KEY (country_id)
);


CREATE TABLE IF NOT EXISTS locations (
                           location_id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT,
                           street_address VARCHAR(40),
                           postal_code VARCHAR(12),
                           city VARCHAR(30) NOT NULL,
                           state_province VARCHAR(25),
                           country_id CHAR(2) NOT NULL,
                           PRIMARY KEY (location_id)
);

CREATE TABLE IF NOT EXISTS departments (
                             department_id INT (11) UNSIGNED NOT NULL,
                             department_name VARCHAR(30) NOT NULL,
                             manager_id INT (11) UNSIGNED,
                             location_id INT (11) UNSIGNED,
                             PRIMARY KEY (department_id)
);

CREATE TABLE IF NOT EXISTS jobs (
                      job_id VARCHAR(10) NOT NULL,
                      job_title VARCHAR(35) NOT NULL,
                      min_salary DECIMAL(8, 0) UNSIGNED,
                      max_salary DECIMAL(8, 0) UNSIGNED,
                      PRIMARY KEY (job_id)
);

CREATE TABLE IF NOT EXISTS employees (
                           employee_id INT (11) UNSIGNED NOT NULL,
                           first_name VARCHAR(20),
                           last_name VARCHAR(25) NOT NULL,
                           email VARCHAR(25) NOT NULL,
                           phone_number VARCHAR(20),
                           hire_date DATE NOT NULL,
                           job_id VARCHAR(10) NOT NULL,
                           salary DECIMAL(8, 2) NOT NULL,
                           commission_pct DECIMAL(2, 2),
                           manager_id INT (11) UNSIGNED,
                           department_id INT (11) UNSIGNED,
                           PRIMARY KEY (employee_id)
);

CREATE TABLE IF NOT EXISTS job_history (
                             employee_id INT (11) UNSIGNED NOT NULL,
                             start_date DATE NOT NULL,
                             end_date DATE NOT NULL,
                             job_id VARCHAR(10) NOT NULL,
                             department_id INT (11) UNSIGNED NOT NULL
);
ALTER TABLE job_history ADD UNIQUE INDEX (
    employee_id,
    start_date
    );