package com.shemuel.landlordhelper.mapper;


import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.shemuel.landlordhelper.entity.GenTable;
import com.shemuel.landlordhelper.entity.GenTableColumn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GenTableMapper {
    
    List<GenTable> selectGenTableList(GenTable genTable);

    int deleteGenTableByIds(Long[] tableIds);
    
    List<GenTableColumn> selectDbTableColumns(String tableName);
    
    void insertGenTable(GenTable genTable);
    
    GenTable selectGenTableById(Long tableId);
    
    List<GenTableColumn> selectGenTableColumns(Long tableId);
    
    void insertGenTableColumn(GenTableColumn column);

    @InterceptorIgnore(tenantLine = "true")
    List<GenTable> selectDbTableList(GenTable genTable);
    
    int insertGenTableBatch(@Param("columns") List<GenTableColumn> columns);
    
    int selectDbTableCount(GenTable genTable);
    
    GenTable selectGenTableByName(String tableName);
    
    void deleteGenTableColumns(List<Long> columnIds);
    
    void updateGenTableColumns(List<GenTableColumn> columns);
    
    void updateGenTable(GenTable table);

    void deleteGenTableColumnsByTableIds(Long[] tableIds);
}