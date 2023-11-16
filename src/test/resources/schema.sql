
  CREATE TABLE IF NOT EXISTS employee (

  employee_id BIGINT NOT NULL PRIMARY KEY,
  email VARCHAR(100) NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL

  );

  CREATE TABLE IF NOT EXISTS project (

  project_id BIGINT NOT NULL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  stage VARCHAR(100) NOT NULL,
  description VARCHAR(500) NOT NULL

  );


  CREATE TABLE IF NOT EXISTS project_employee (

  project_id BIGINT REFERENCES project,
  employee_id BIGINT REFERENCES employee

  );