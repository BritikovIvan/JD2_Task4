CREATE TABLE `role` (
    `id` bigint not null auto_increment,
    `role` varchar(45) not null unique,
    primary key(`id`)
);

CREATE TABLE `user` (
    `id` bigint not null auto_increment,
    `name` varchar(45),
    `surname` varchar(45),
    `role_id` bigint not null,
    primary key(`id`),
    foreign key(`role_id`) references `role`(`id`)
);

CREATE TABLE `login` (
    `id` bigint not null auto_increment,
    `login` varchar(45) not null unique,
    `password` varchar(45) not null,
    `user_id` bigint not null unique,
    primary key(`id`),
    foreign key(`user_id`) references `user`(`id`)
);

CREATE TABLE `aircompany` (
    `id` BIGINT not NULL auto_increment,
    `name` varchar(45) not null unique,
    primary key(`id`)
);

CREATE TABLE `airplane` (
    `id` BIGINT not NULL auto_increment,
    `name` varchar(45) not null,
    `aircompany_id` bigint not null,
    primary key(`id`),
    foreign key(`aircompany_id`) references `aircompany`(`id`)
);

CREATE TABLE `route` (
    `id` BIGINT not NULL auto_increment,
    `arrival` datetime not null,
    `departure` datetime not null,
    primary key(`id`)
);

CREATE TABLE `ticket` (
    `id` BIGINT not NULL auto_increment,
    `route_id` bigint not null,
    `user_id` bigint not null,
    `passport` varchar(45) unique,
    primary key(`id`),
    foreign key(`route_id`) references `route`(`id`),
    foreign key(`user_id`) references `user`(`id`)
);

CREATE TABLE `country` (
    `id` BIGINT not NULL auto_increment,
    `name` varchar(45) not null,
    primary key(`id`)
);

CREATE TABLE `city` (
    `id` BIGINT not NULL auto_increment,
    `name` varchar(90) not null,
    `country_id` bigint not null,
    primary key(`id`),
    foreign key(`country_id`) references `country`(`id`)
);

CREATE TABLE `route_city` (
    `id` BIGINT not NULL auto_increment,
    `route_id` bigint not null,
    `city_id` bigint not null,
    primary key(`id`),
    foreign key(`route_id`) references `route`(`id`),
    foreign key(`city_id`) references `city`(`id`)
);