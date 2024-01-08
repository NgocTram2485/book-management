start transaction;

create table categories
(
    id           int auto_increment primary key,
    name         varchar(64)                         not null,
    created_at   timestamp default CURRENT_TIMESTAMP not null,
    updated_at   timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
);

create table publishers
(
    id           int auto_increment primary key,
    name         varchar(64)                         not null,
    created_at   timestamp default CURRENT_TIMESTAMP not null,
    updated_at   timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
);

create table books
(
    id           int auto_increment primary key,
    name         varchar(64)                         not null,
    category_id  int                                 not null,
    publisher_id int                                 not null,
    status       varchar(32)                         not null,
    avatar       varchar(128)                        not null,
    price        int                                 not null,
    qty          int                                 not null,
    created_at   timestamp default CURRENT_TIMESTAMP not null,
    updated_at   timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
);

create index books_category_id_index on books (category_id);
create index books_publisher_id_index on books (publisher_id);
create index books_status_index on books (status);

create table transactions
(
    id         int auto_increment primary key,
    book_id    int                                 not null,
    action     varchar(32)                         not null,
    qty        int                                 not null,
    created_at timestamp default CURRENT_TIMESTAMP not null
);

create index transactions_book_id_index on transactions (book_id);

commit;
