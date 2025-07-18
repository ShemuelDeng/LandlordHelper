package com.shemuel.landlordhelper.mapper;

import com.shemuel.landlordhelper.entity.UserProfile;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户个人信息 Mapper接口
 */
@Mapper
public interface UserProfileMapper extends BaseMapper<UserProfile> {
} 