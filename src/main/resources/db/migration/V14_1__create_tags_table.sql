CREATE TABLE tags (
   `id` INT AUTO_INCREMENT PRIMARY KEY,
    `tag` VARCHAR(30) UNIQUE
);
ALTER TABLE `tags`
  MODIFY `tag` VARCHAR(30) NOT NULL UNIQUE;
