package com.itheima.dao;

import com.itheima.domain.BaseDict;

import java.util.List;

public interface BaseDictDao {

    public List<BaseDict> selectBaseDictByTypeCode(String typeCode);

}
