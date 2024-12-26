--liquibase formatted sql
--changeset dyermola:add-task-history-table

CREATE TABLE java_course.task_history (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	todo BIGINT UNSIGNED NOT NULL,
	old_state TEXT NOT NULL,
	new_state TEXT NOT NULL,
	change_date DATETIME NOT NULL,
	changed_by varchar(100) NOT NULL,
	CONSTRAINT task_history PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb3
COLLATE=utf8mb3_general_ci;

--rollback DROP TABLE task_history;
