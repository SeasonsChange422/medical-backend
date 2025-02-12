package com.zzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzq.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dhx
 * @date 2025/1/16 22:06
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM user")
    List<User> selectAll();
}
