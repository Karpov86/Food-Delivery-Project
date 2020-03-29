CREATE TABLE `users`
(
    `id`           int         NOT NULL AUTO_INCREMENT,
    `phone_number` varchar(20) DEFAULT NULL,
    `name`         varchar(45) DEFAULT NULL,
    `surname`      varchar(45) DEFAULT NULL,
    `address`      varchar(85) DEFAULT NULL,
    `email`        varchar(45) DEFAULT NULL,
    `password`     varchar(45) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `dishes`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(85) NULL,
    `category` VARCHAR(45) NULL,
    `price`    FLOAT       NULL,
    `sale`     TINYINT DEFAULT '0',
    PRIMARY KEY (`id`)
);
CREATE TABLE `orders`
(
    `id`      int      NOT NULL AUTO_INCREMENT,
    `date`    datetime NOT NULL,
    `user_id` int      NOT NULL,
    `dish_id` int      NOT NULL,
    PRIMARY KEY (`id`),
    KEY `user_id` (`user_id`),
    KEY `dish_id` (`dish_id`),
    CONSTRAINT `dish_id` FOREIGN KEY (`dish_id`) REFERENCES `dishes` (`id`),
    CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);