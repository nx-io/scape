use `scape`;

TRUNCATE `area_category`;
INSERT INTO `area_category`(`id`, `name`) VALUES (1,'入口景观'),(2,'场地节点'),(3,'园路栈桥'),(4,'水景泳池'),(5,'宅间入户'),(6,'庭院露台'),(7,'架空层'),(8,'景观建筑');

TRUNCATE `category`;
INSERT INTO `category`(`id`, `name`) VALUES (1,'居住景观'),(2,'商业办公'),(3,'城市绿地'),(4,'校园规划'),(5,'休闲度假'),(6,'滨水生态');

TRUNCATE `style`;
INSERT INTO `style`(`id`, `name`) VALUES (1,'欧式'),(2,'东南亚'),(3,'中式'),(4,'地中海'),(5,'现代简约');