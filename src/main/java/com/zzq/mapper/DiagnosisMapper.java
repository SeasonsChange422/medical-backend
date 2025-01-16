package com.zzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzq.entity.Diagnosis;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author dhx
 * @date 2025/1/16 22:07
 */
@Repository
@Mapper
public interface DiagnosisMapper extends BaseMapper<Diagnosis> {
}
