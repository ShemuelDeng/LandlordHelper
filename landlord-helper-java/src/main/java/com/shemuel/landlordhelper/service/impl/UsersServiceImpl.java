package com.shemuel.landlordhelper.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.shemuel.landlordhelper.mapper.UsersMapper;
import com.shemuel.landlordhelper.entity.Users;
import com.shemuel.landlordhelper.service.UsersService;
import com.shemuel.landlordhelper.utils.PageUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;

/**
 *  服务实现类
 */
@Service
@RequiredArgsConstructor
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    /**
     * 查询分页列表
     */
    @Override
    public IPage<Users> selectPage(Users users) {
        LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
        // 构建查询条件
        wrapper.eq(users.getId() != null, Users::getId, users.getId());
        wrapper.eq(users.getOpenid() != null, Users::getOpenid, users.getOpenid());
        wrapper.eq(users.getNickname() != null, Users::getNickname, users.getNickname());
        wrapper.eq(users.getAvatarUrl() != null, Users::getAvatarUrl, users.getAvatarUrl());
        wrapper.eq(users.getCreatedAt() != null, Users::getCreatedAt, users.getCreatedAt());
        wrapper.eq(users.getUpdatedAt() != null, Users::getUpdatedAt, users.getUpdatedAt());
        return page(PageUtil.getPage(), wrapper);
    }

    /**
     * 查询列表
     */
    @Override
    public List<Users> selectList(Users users) {
        LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
        // 构建查询条件
        wrapper.eq(users.getId() != null, Users::getId, users.getId());
        wrapper.eq(users.getOpenid() != null, Users::getOpenid, users.getOpenid());
        wrapper.eq(users.getNickname() != null, Users::getNickname, users.getNickname());
        wrapper.eq(users.getAvatarUrl() != null, Users::getAvatarUrl, users.getAvatarUrl());
        wrapper.eq(users.getCreatedAt() != null, Users::getCreatedAt, users.getCreatedAt());
        wrapper.eq(users.getUpdatedAt() != null, Users::getUpdatedAt, users.getUpdatedAt());
        return list(wrapper);
    }

    /**
     * 新增
     */
    @Override
    public boolean insert(Users users) {
        return save(users);
    }

    /**
     * 修改
     */
    @Override
    public boolean update(Users users) {
        return updateById(users);
    }

    /**
     * 批量删除
     */
    @Override
    public boolean deleteByIds(List<Long> ids) {
        return removeByIds(ids);
    }
}
