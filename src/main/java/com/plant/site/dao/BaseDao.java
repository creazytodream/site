package com.plant.site.dao;

import com.plant.site.model.BaseModel;

import java.util.List;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019/1/11 14:51
 * @version:1.0
 **/
public interface BaseDao<T extends BaseModel> {

    List<T> selectAll();

    int delete(String id);

    T select(String id);

    int insert(T record);

    int update(T record);
}
