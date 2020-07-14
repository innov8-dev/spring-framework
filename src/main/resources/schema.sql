create table departments (
    id int auto_increment,
    name varchar(50) not null unique,

    constraint pk_departments
    primary key (id)
);

create table employees (
    id int auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    department_id int not null,

    constraint pk_employees
    primary key (id),

    constraint fk_employee_department
    foreign key (department_id)
    references departments (id)
);