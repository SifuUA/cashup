--- Table clients
create table clients (
  client_id  bigint       not null,
  last_name  varchar(255) not null,
  first_name varchar(255) not null,
  birth_date varchar(255) not null,
  gender     varchar(255) not null,
  inn        bigint       not null,
  primary key (client_id)
);

--- Table orders
create table orders (
  order_id   bigint           not null,
  order_date varchar(255)     not null,
  status     boolean          not null,
  order_sum  double precision not null,
  currency   varchar(255)     not null,
  primary key (order_id)
);
--- Table for mapping
create table client_order (
  client_id bigint not null,
  order_id  bigint not null,

  foreign key (client_id) references clients (client_id),
  foreign key (order_id) references orders (order_id)
);

---Insert data into clients table
insert into clients (client_id, last_name, first_name, birth_date, gender, inn)
values (101, 'Kolbasa', 'Artem', '01.01.2001', 'male', 12312312312);

insert into clients (client_id, last_name, first_name, birth_date, gender, inn)
values (102, 'Petrov', 'Ivan', '21.10.2301', 'male', 431423123);

insert into clients (client_id, last_name, first_name, birth_date, gender, inn)
values (103, 'Semenova', 'Yulia', '13.04.1989', 'female', 929129391);

---Insert data into orders
insert into orders (order_id, order_date, status, order_sum, currency)
values (201, '12.12.2001', true, 123.2, 'dollar');

insert into orders (order_id, order_date, status, order_sum, currency)
values (134, '07.10.2018', true, 233.9, 'euro');

insert into orders (order_id, order_date, status, order_sum, currency)
values (456, '25.01.1945', true, 9999.45, 'grivna');

---Insert data into clients_orders

insert into client_order (client_id, order_id)
values (101, 201);
insert into client_order (client_id, order_id)
values (102, 134);
insert into client_order (client_id, order_id)
values (103, 456);







