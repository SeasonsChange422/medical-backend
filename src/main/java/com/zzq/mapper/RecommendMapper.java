package com.zzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzq.entity.Recommend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author dhx
 * @date 2025/2/12 21:21
 */
@Mapper
public interface RecommendMapper extends BaseMapper<Recommend> {
    @Select("SELECT * FROM recommend")
    List<Recommend> getAll();
}
