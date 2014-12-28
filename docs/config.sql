use `scape`;

INSERT INTO `scape`.`area_category`(`id`, `name`, `display`, `gmt_created`, `gmt_modified`) VALUES 
(1,'入口景观', 1, now(), now()),
(2,'场地节点', 1, now(), now()),
(3,'园路栈桥', 1, now(), now()),
(4,'水景泳池', 1, now(), now()),
(5,'宅间入户', 1, now(), now()),
(6,'庭院露台', 1, now(), now()),
(7,'架空层', 1, now(), now()),
(8,'景观建筑', 1, now(), now())
;

INSERT INTO `scape`.`category`(`id`, `name`, `display`, `gmt_created`, `gmt_modified`) VALUES 
(1,'居住景观', 1, now(), now()),
(2,'商业办公', 1, now(), now()),
(3,'城市绿地', 1, now(), now()),
(4,'校园规划', 1, now(), now()),
(5,'休闲度假', 1, now(), now()),
(6,'滨水生态', 1, now(), now());

INSERT INTO `scape`.`style`(`id`, `name`, `display`, `gmt_created`, `gmt_modified`) VALUES 
(1,'欧式', 1, now(), now()),
(2,'东南亚', 1, now(), now()),
(3,'中式', 1, now(), now()),
(4,'地中海', 1, now(), now()),
(5,'现代简约', 1, now(), now())
;