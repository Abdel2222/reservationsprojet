CREATE TABLE show_tag (
    'show_id' BIGINT,
    'tag_id' BIGINT,
    PRIMARY KEY (show_id, tag_id),
    FOREIGN KEY (show_id) REFERENCES shows(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES tags(id) ON DELETE RESTRICT ON UPDATE CASCADE
);