package com.zzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzq.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dhx
 * @date 2025/1/16 22:08
 */
@Repository
@Mapper
public interface FeedbackMapper extends BaseMapper<Feedback> {
    @Select("SELECT * FROM feedback")
    public List<Feedback> selectAll();
}
