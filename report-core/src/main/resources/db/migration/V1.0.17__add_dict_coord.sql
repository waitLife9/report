-- 新增坐标轴字典
INSERT INTO `aj_report`.`gaea_dict`(`dict_name`,`dict_code`,`remark`) SELECT "XY坐标属性","COORD_PROPERTIES","XY坐标属性" FROM DUAL WHERE NOT EXISTS(SELECT `dict_name`,`dict_code`,`remark` FROM `aj_report`.`gaea_dict` WHERE `dict_name`="XY坐标属性" AND `dict_code`="COORD_PROPERTIES" AND `remark`="XY坐标属性");

INSERT INTO `aj_report`.`gaea_dict_item`(`dict_code`,`item_name`,`item_value`,`locale`) SELECT "COORD_PROPERTIES","数据","series","zh" FROM DUAL WHERE NOT EXISTS(SELECT `dict_code`,`item_name`,`item_value`,`locale` FROM `aj_report`.`gaea_dict_item` WHERE `dict_code`="COORD_PROPERTIES" AND `item_name`="数据" AND `item_value`="series" AND `locale`="zh");
INSERT INTO `aj_report`.`gaea_dict_item`(`dict_code`,`item_name`,`item_value`,`locale`) SELECT "COORD_PROPERTIES","X轴","xAxis","zh" FROM DUAL WHERE NOT EXISTS(SELECT `dict_code`,`item_name`,`item_value`,`locale` FROM `aj_report`.`gaea_dict_item` WHERE `dict_code`="COORD_PROPERTIES" AND `item_name`="X轴" AND `item_value`="xAxis" AND `locale`="zh");
INSERT INTO `aj_report`.`gaea_dict_item`(`dict_code`,`item_name`,`item_value`,`locale`) SELECT "COORD_PROPERTIES","Y轴","yAxis","zh" FROM DUAL WHERE NOT EXISTS(SELECT `dict_code`,`item_name`,`item_value`,`locale` FROM `aj_report`.`gaea_dict_item` WHERE `dict_code`="COORD_PROPERTIES" AND `item_name`="Y轴" AND `item_value`="yAxis" AND `locale`="zh");