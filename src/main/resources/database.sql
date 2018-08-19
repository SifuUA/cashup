--- Create DB
CREATE DATABASE cashup
  WITH
OWNER = postgres
  ENCODING = 'UTF8'
  CONNECTION LIMIT = -1;

--- Table clients
create table clients (
  client_id  bigint       not null,
  last_name  varchar(255) not null,
  first_name varchar(255) not null,
  birth_date date         not null,
  gender     varchar(255) not null,
  inn        bigint       not null,
  primary key (client_id)
);

--- Table orders
create table orders (
  order_id   bigint           not null,
  client_id  bigint           not null,
  order_date date             not null,
  status     boolean          not null,
  order_sum  double precision not null,
  currency   varchar(255)     not null,
  primary key (order_id),
  foreign key (client_id) references clients (client_id)
);

---Insert data into clients table
insert into clients (client_id, last_name, first_name, birth_date, gender, inn)
values (1, 'Kolbasa', 'Artem', '2001-01-01', 'male', 12312312312);

insert into clients (client_id, last_name, first_name, birth_date, gender, inn)
values (5, 'Petrov', 'Ivan', '2017-10-21', 'male', 431423123);

insert into clients (client_id, last_name, first_name, birth_date, gender, inn)
values (3, 'Semenova', 'Yulia', '1901-11-06', 'female', 929129391);








