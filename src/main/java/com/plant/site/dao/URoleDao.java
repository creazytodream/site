package com.plant.site.dao;

import com.plant.site.model.URole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface URoleDao {
    int insert(URole record);

    int insertSelective(URole record);

    List<URole> findRoleByUid(@Param("id") Long userId);
}