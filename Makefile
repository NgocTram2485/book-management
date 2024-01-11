HOST = 127.0.0.1
PORT = 3306
DATABASE = book_management
USER = root
PASSWORD = secret

create-db:
	docker run --rm -d --name database -p 3306:3306 -e MYSQL_ROOT_PASSWORD=secret mysql:8.0.31 || true
.PHONY: create-db

init-db: create-db
	docker exec -it database mysql -u root -psecret -e "CREATE DATABASE book_management;" || true
.PHONY: init-db

migrate-up:
	migrate -source "file://migrations" -database "mysql://$(USER):$(PASSWORD)@tcp($(HOST):$(PORT))/$(DATABASE)" up
.PHONY: migrate-up

init: create-db wait init-db migrate-up
	migrate -source "file://migrations" -database "mysql://$(USER):$(PASSWORD)@tcp($(HOST):$(PORT))/$(DATABASE)" up
.PHONY: init

wait:
	sleep 10
.PHONY: wait