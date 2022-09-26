DROP TABLE `route_city`;

CREATE TABLE `route_city` (
    `route_id` bigint not null,
    `city_id` bigint not null,
    primary key(`route_id`, `city_id`),
    foreign key(`route_id`) references `route`(`id`),
    foreign key(`city_id`) references `city`(`id`)
);