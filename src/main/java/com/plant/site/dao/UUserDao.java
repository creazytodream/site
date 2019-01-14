package com.plant.site.dao;

import com.plant.site.model.UUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UUserDao {
    int insert(UUser record);

    UUser selectAllByName(@Param("nickname") String userName);

    int insertSelective(UUser record);
}