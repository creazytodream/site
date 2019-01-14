package com.plant.site.dao;

import com.plant.site.model.UUserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UUserRoleDao {
    int insert(UUserRole record);

    int insertSelective(UUserRole record);
}