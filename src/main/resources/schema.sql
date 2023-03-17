--- Igor Mierzejewski ---
---https://github.com/xseser---


--products -> promotions, complaints, returns
CREATE TABLE online_shop.products
(
    id                integer not null generated always as identity,
    name              text    not null,
    category          text    not null,
    price             numeric(10,2) not null,
    weight            integer not null,
    expiration_date   date    not null default (current_date + interval '1 year'),
    manufacturer_name text,
    product_count     integer not null default 1,

    CONSTRAINT pk__products__id primary key (id)
);


CREATE TABLE online_shop.promotions
(
    id         integer not null generated always as identity,
    start_date date    not null default current_date,
    end_date   date    not null default (current_date + interval '1 month'),
    product_id integer not null,
    percent    integer not null,

    CONSTRAINT pk__promotions__id primary key (id),
    CONSTRAINT fk__promotions__products__id foreign key (product_id) references online_shop.products (id)
);


--employee is not used everywhere.
CREATE TABLE online_shop.employees
(
    id                 integer not null generated always as identity,
    name               text    not null,
    last_name          text    not null,
    birth_date         date    not null,
    account_number     integer,
    date_of_employment date    not null,
    hourly_rate        integer,

    CONSTRAINT pk__employees__id primary key (id)
);

CREATE TABLE online_shop.complaints
(
    id             integer not null generated always as identity,
    complaint_date date    not null default current_date,
    status         integer not null default 0,

    CONSTRAINT pk__complaints__id primary key (id),
    constraint fk__complaints__complaints_types__status foreign key (status) references online_shop.complaints_types (id)
);

CREATE TABLE online_shop.complaints_types
(
    id          integer generated always as identity,
    status_name text not null,

    CONSTRAINT pk__complaints_types__id primary key (id)
);

create table online_shop.returns
(
    id          integer not null generated always as identity,
    return_date date    not null default current_date,
    status      integer not null default 0,

    constraint pk__returns__id primary key (id),
    constraint fk__returns__returns_types__status foreign key (status) references online_shop.returns_types (id)
);

create table online_shop.returns_types
(
    id          integer generated always as identity,
    status_name text not null,

    CONSTRAINT pk__returns_types__id primary key (id)
);
--products upper


--representation of users:
create table online_shop.clients
(
    id          integer generated always as identity,
    user_name   text    not null,
    password    text    not null,
    client_type integer not null default 0,
    delivery_id integer,

    constraint pk__clients__id primary key (id),
    constraint uq__clients__user_name unique (user_name),
    constraint fk__clients__client_types__client_type foreign key (client_type) references online_shop.client_types (id),
    constraint fk__clients__deliveries__delivery_id foreign key (delivery_id) references online_shop.deliveries (id)
);



create table online_shop.deliveries
( --pinned to client. Many to many relation.
    id      integer generated always as identity,
    address text not null,
    city    text not null,

    constraint pk__deliveries__id primary key (id),
    constraint uq__deliveries__address unique (address)
);

create table online_shop.client_types
( --pinned to client. one client type to one client.
    id   integer generated always as identity,
    role text not null,

    constraint pk__client_types__id primary key (id)
);

create table online_shop.cards
( --card is pinned to client. many cards to one client.
    id        integer generated always as identity,
    balance   integer not null default 0,
    client_id integer not null,

    constraint pk__cards__id primary key (id),
    constraint fk__cards__clients__client_id foreign key (client_id) references online_shop.clients (id)
);

create table online_shop.score_cards
( --score_card is pinned to client. One score card to one client.
    id           integer generated always as identity,
    point        integer not null default 0,
    client_id    integer not null,
    phone_number integer not null,

    constraint pk__score_cards__id primary key (id),
    constraint fk__score_cards__clients__client_id foreign key (client_id) references online_shop.clients (id)
);

create table online_shop.payments
( --TODO
    id            integer generated always as identity,
    card_id       integer not null,
    cart_id       integer not null,
    score_card_id integer,

    constraint pk__payments__id primary key (id),
    constraint fk__payments__cards__card_id foreign key (card_id) references online_shop.cards (id),
    constraint fk__payments__carts__cart_id foreign key (cart_id) references online_shop.carts (user_id),
    constraint fk__payments__score_cards__score_card_id foreign key (score_card_id) references online_shop.score_cards (id)
);

create table online_shop.carts
( --should be pinned to client. Relation one to one
    user_id        integer generated always as identity,
    product_id     integer not null,
    product_counts integer not null default 1,
    cost           integer not null default 0,
    delivery_id    integer not null,
    order_status   integer not null default 0,

    constraint pk__carts__id primary key (user_id),
    constraint fk__carts__clients_id foreign key (user_id) references online_shop.clients (id),
    constraint fk__carts__deliveries__delivery_id foreign key (delivery_id) references online_shop.deliveries (id),
    constraint fk__carts__status_orders__order_status foreign key (order_status) references online_shop.status_orders (id)
);

create table online_shop.status_orders
(
    id          integer generated always as identity,
    status      text not null,
    description text,

    constraint pk__status_orders__id primary key (id)
);

create table online_shop.receipts
(
    id         integer generated always as identity,
    cart_id    integer not null,
    payment_id integer not null,

    constraint pk__receipts__id primary key (id),
    constraint fk__receipts__carts__cart_id foreign key (cart_id) references online_shop.carts (user_id),
    constraint fk__receipts__payments__payment_id foreign key (payment_id) references online_shop.payments (id)
);


select * from online_shop.products where category = 'sweets' and name = 'cookie'