package com.zzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzq.entity.Symptom;
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
public interface SymptomMapper extends BaseMapper<Symptom> {
    @Select("SELECT s.* " +
            "FROM symptom s " +
            "LEFT JOIN diagnosis d ON s.`id` = d.symptom_id " +
            "WHERE d.id IS NULL;")
    List<Symptom> getSymptomWithoutDiagnosis();
}
