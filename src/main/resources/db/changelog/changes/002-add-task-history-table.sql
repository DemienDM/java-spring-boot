--liquibase formatted sql
--changeset dyermola:add-task-history-table

CREATE TABLE java_course.task_history (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	todo BIGINT UNSIGNED NOT NULL,
	oldState TEXT NOT NULL,
	newState TEXT NOT NULL,
	changeDate DATETIME NOT NULL,
	changedBy BIGINT UNSIGNED NOT NULL,
	CONSTRAINT task_history PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb3
COLLATE=utf8mb3_general_ci;

--rollback DROP TABLE task_history;