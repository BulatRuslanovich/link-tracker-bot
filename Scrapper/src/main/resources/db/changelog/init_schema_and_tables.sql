CREATE SCHEMA IF NOT EXISTS link_tracker;

CREATE TABLE IF NOT EXISTS link_tracker.t_link
(
    id           BIGINT GENERATED ALWAYS AS IDENTITY,
    resource   TEXT      NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (resource)
);

CREATE TABLE IF NOT EXISTS link_tracker.t_chat
(
    id BIGINT UNIQUE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS link_tracker.t_chat_link
(
    link_id BIGINT REFERENCES link_tracker.t_link (id) ON DELETE CASCADE,
    chat_id BIGINT REFERENCES link_tracker.t_chat (id) ON DELETE CASCADE,
    PRIMARY KEY (link_id, chat_id)
);