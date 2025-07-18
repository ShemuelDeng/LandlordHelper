package com.shemuel.landlordhelper.service;

import com.shemuel.landlordhelper.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 *  服务接口
 */
public interface UsersService extends IService<Users> {
    /**
     * 查询分页列表
     */
    IPage<Users> selectPage(Users users);

    /**
     * 查询列表
     */
    List<Users> selectList(Users users);

    /**
     * 新增
     */
    boolean insert(Users users);

    /**
     * 修改
     */
    boolean update(Users users);

    /**
     * 批量删除
     */
    boolean deleteByIds(List<Long> ids);
}
