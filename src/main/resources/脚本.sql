CREATE TABLE `t_order` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` bigint(20) NOT NULL COMMENT '订单号（主键）',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_status` int(11) DEFAULT NULL COMMENT '订单状态',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

CREATE TABLE `t_order0` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` bigint(20) NOT NULL COMMENT '订单号（主键）',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_status` int(11) DEFAULT NULL COMMENT '订单状态',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

CREATE TABLE `t_order1` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` bigint(20) NOT NULL COMMENT '订单号（主键）',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `order_status` int(11) DEFAULT NULL COMMENT '订单状态',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;