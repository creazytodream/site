package com.plant.site.dao;

import com.plant.site.model.URolePermission;
import org.springframework.stereotype.Repository;

@Repository
public interface URolePermissionDao {
    int insert(URolePermission record);

    int insertSelective(URolePermission record);
}