DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`
(
    `table_id`      bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `table_name`    varchar(200) NULL DEFAULT '' COMMENT '表名称',
    `table_comment` varchar(500) NULL DEFAULT '' COMMENT '表描述',
    `create_time`   datetime NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime NULL DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`table_id`) USING BTREE,
    UNIQUE INDEX idx_tablename (table_name)
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4  COMMENT = '代码生成业务表' ROW_FORMAT = DYNAMIC;


DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column`
(
    `column_id`      bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `table_id`       bigint NOT NULL COMMENT '归属表编号',
    `column_name`    varchar(200) NULL DEFAULT NULL COMMENT '列名称',
    `column_comment` varchar(500) NULL DEFAULT NULL COMMENT '列描述',
    `column_type`    varchar(100) NULL DEFAULT NULL COMMENT '列类型',
    `java_type`      varchar(500) NULL DEFAULT NULL COMMENT 'JAVA类型',
    `java_field`     varchar(200) NULL DEFAULT NULL COMMENT 'JAVA字段名',
    `is_pk`          char(1) NULL DEFAULT NULL COMMENT '是否主键（1是）',
    `is_required`    char(1) NULL DEFAULT NULL COMMENT '是否必填（1是）',
    `is_insert`      char(1) NULL DEFAULT NULL COMMENT '是否为插入字段（1是）',
    `is_edit`        char(1) NULL DEFAULT NULL COMMENT '是否编辑字段（1是）',
    `is_list`        char(1) NULL DEFAULT NULL COMMENT '是否列表字段（1是）',
    `is_query`       char(1) NULL DEFAULT NULL COMMENT '是否查询字段（1是）',
    `query_type`     varchar(200) NULL DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
    `html_type`      varchar(200) NULL DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
    `sort`           int NULL DEFAULT NULL COMMENT '排序',
    PRIMARY KEY (`column_id`) USING BTREE,
    UNIQUE INDEX idx_table_id_column (table_id, column_name)
) ENGINE = InnoDB AUTO_INCREMENT = 263 CHARACTER SET = utf8mb4  COMMENT = '代码生成业务表字段' ROW_FORMAT = DYNAMIC;