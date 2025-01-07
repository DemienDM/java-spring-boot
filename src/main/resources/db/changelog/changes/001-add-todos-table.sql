--liquibase formatted sql
--changeset dyermola:add-todos-table

CREATE TABLE java_course.todos (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	title varchar(100) NOT NULL,
	description TEXT NOT NULL,
	due_date DATETIME NOT NULL,
	priority varchar(100) NOT NULL,
	status varchar(100) NOT NULL,
	created_date DATETIME NOT NULL,
	updated_date DATETIME DEFAULT null NULL,
	user_id BIGINT UNSIGNED NOT NULL,
	CONSTRAINT todos_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb3
COLLATE=utf8mb3_general_ci;

--rollback DROP TABLE todos;
