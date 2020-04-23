# CREATE TABLE `product_order`
# (
#     `id`          int(10) unsigned NOT NULL AUTO_INCREMENT,
#     `asset_tag` int(100) unsigned NOT NULL,
#     `asset_type`  varchar(256)     DEFAULT NULL,
#     `is_active`   tinyint(4) DEFAULT '1',
#     `created_on`  datetime   DEFAULT CURRENT_TIMESTAMP,
#     `updated_on`  datetime   DEFAULT CURRENT_TIMESTAMP,
#     --     `customer_id` int(10) unsigned NOT NULL,
# --     `total_cost`  int(10)          NOT NULL,
#
#     PRIMARY KEY (`id`)
# ) ENGINE = InnoDB
#   DEFAULT CHARSET = utf8;
