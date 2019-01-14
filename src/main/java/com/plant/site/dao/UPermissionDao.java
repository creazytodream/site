package com.plant.site.dao;

import com.plant.site.model.UPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UPermissionDao {
    int insert(UPermission record);

    int insertSelective(UPermission record);
    List<UPermission> findPermissionByUid(@Param("uId") Long id);
}