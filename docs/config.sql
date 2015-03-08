use `scape`;

TRUNCATE `area_category`;
INSERT INTO `area_category`(`id`, `name`) VALUES (1,'入口景观'),(2,'场地节点'),(3,'园路栈桥'),(4,'水景泳池'),(5,'宅间入户'),(6,'庭院露台'),(7,'架空层'),(8,'景观建筑');

TRUNCATE `category`;
INSERT INTO `category`(`id`, `name`) VALUES (1,'居住景观'),(2,'商业办公'),(3,'城市绿地'),(4,'校园规划'),(5,'休闲度假'),(6,'滨水生态');

TRUNCATE `style`;
INSERT INTO `style`(`id`, `name`) VALUES (1,'欧式'),(2,'东南亚'),(3,'中式'),(4,'地中海'),(5,'现代简约');

TRUNCATE `role`;
INSERT INTO `role` (`id`,`code`,`name`,`description`,`is_active`) VALUES (1,'ROLE_SUPER_ADMIN','超级管理员','超级管理员',1);

TRUNCATE `manager`;
INSERT INTO `manager` (`id`, `email`, `role_id`, `name`,`password`,`salt`,`status`) VALUES (1, 'admin@test.com', 1, 'admin','78794202cea9c66e26e85a395ac7e9e7','yEL0JM',1);

TRUNCATE `resource`;
INSERT INTO  `resource` (`id`, `name`, `url`) VALUES 
('1', 'list user', '/user/list'),
('2', 'edit user', '/user/edit**'),
('3', 'list item', '/item/list'),
('4', 'edit item', '/item/edit**'),
('5', 'add item', '/item/add**');

TRUNCATE `role_resource`;
INSERT INTO `role_resource` (`id`, `role_id`, `resource_id`) VALUES 
('1', '1', '1'),
('2', '1', '2'),
('3', '1', '3'),
('4', '1', '4'),
('5', '1', '5');


