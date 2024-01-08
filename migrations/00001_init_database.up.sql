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
    author       varchar(64)                         not null,
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

create table accounts
(
    id           int auto_increment primary key,
    username     varchar(64)                         not null,
    password     varchar(128)                        not null,
    created_at   timestamp default CURRENT_TIMESTAMP not null,
    updated_at   timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
);

INSERT INTO book_management.accounts (id, username, password, created_at, updated_at) VALUES (1, 'admin', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '2024-01-08 07:58:39', '2024-01-08 08:09:37');

create table transactions
(
    id         int auto_increment primary key,
    book_id    int                                 not null,
    action     varchar(32)                         not null,
    qty        int                                 not null,
    created_at timestamp default CURRENT_TIMESTAMP not null
);

create index transactions_book_id_index on transactions (book_id);

INSERT INTO book_management.categories (id, name, created_at, updated_at) VALUES (1, 'Tiểu thuyết', '2024-01-05 16:31:14', '2024-01-05 16:31:14');
INSERT INTO book_management.categories (id, name, created_at, updated_at) VALUES (2, 'Truyện tranh', '2024-01-06 15:25:17', '2024-01-06 15:25:17');
INSERT INTO book_management.categories (id, name, created_at, updated_at) VALUES (3, 'Trinh thám', '2024-01-08 06:55:38', '2024-01-08 06:55:38');
INSERT INTO book_management.categories (id, name, created_at, updated_at) VALUES (4, 'Tâm lý, tình cảm', '2024-01-08 06:58:32', '2024-01-08 06:58:32');
INSERT INTO book_management.categories (id, name, created_at, updated_at) VALUES (5, 'Lịch sử', '2024-01-08 06:58:32', '2024-01-08 06:58:32');
INSERT INTO book_management.categories (id, name, created_at, updated_at) VALUES (6, 'Văn học viễn tưởng', '2024-01-08 06:58:32', '2024-01-08 06:58:32');
INSERT INTO book_management.categories (id, name, created_at, updated_at) VALUES (7, 'Khoa học công nghệ', '2024-01-08 06:58:32', '2024-01-08 06:58:32');

INSERT INTO book_management.publishers (id, name, created_at, updated_at) VALUES (1, 'Nhà xuất bản Trẻ', '2024-01-05 16:31:27', '2024-01-08 06:56:50');
INSERT INTO book_management.publishers (id, name, created_at, updated_at) VALUES (2, 'Nhà xuất bản Kim Đồng', '2024-01-06 15:25:32', '2024-01-06 15:25:32');
INSERT INTO book_management.publishers (id, name, created_at, updated_at) VALUES (3, 'Nhà xuất bản Tổng hợp thành phố Hồ Chí Minh', '2024-01-08 06:56:50', '2024-01-08 06:56:50');
INSERT INTO book_management.publishers (id, name, created_at, updated_at) VALUES (4, 'Nhà xuất bản Hội Nhà văn', '2024-01-08 06:56:50', '2024-01-08 06:56:50');
INSERT INTO book_management.publishers (id, name, created_at, updated_at) VALUES (5, 'Nhà xuất bản Lao Động', '2024-01-08 06:56:50', '2024-01-08 06:56:50');

INSERT INTO book_management.books (id, name, author, category_id, publisher_id, status, avatar, price, qty, created_at, updated_at) VALUES (1, 'Nhà Giả Kim', 'Paulo Coelho', 1, 1, 'active', '', 69000, 100, '2024-01-05 16:32:26', '2024-01-08 06:28:12');
INSERT INTO book_management.books (id, name, author, category_id, publisher_id, status, avatar, price, qty, created_at, updated_at) VALUES (2, 'Doraemon', 'Fujiko F. Fujio', 2, 5, 'active', '', 20000, 1000, '2024-01-06 15:25:59', '2024-01-08 07:06:51');
INSERT INTO book_management.books (id, name, author, category_id, publisher_id, status, avatar, price, qty, created_at, updated_at) VALUES (3, 'Truyện cổ tích', 'Nhà xuất bản trẻ', 2, 2, 'active', '', 99000, 100, '2024-01-08 07:06:23', '2024-01-08 07:06:40');

commit;
