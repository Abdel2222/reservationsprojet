CREATE TABLE show_tag (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `show_id`  int(11) NOT NULL,
    `tag_id`  int(11) NOT NULL,

    PRIMARY KEY (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

    ALTER TABLE `show_tag`
      ADD CONSTRAINT `show_tag_show_id` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;

    ALTER TABLE `show_tag`
      ADD CONSTRAINT `show_tag_tag_id` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `show_tag`
  ADD CONSTRAINT unique_show_tag UNIQUE (`show_id`, `tag_id`);
