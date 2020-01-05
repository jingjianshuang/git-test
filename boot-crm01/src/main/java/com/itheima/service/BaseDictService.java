package com.itheima.service;

import com.itheima.domain.BaseDict;

import java.util.List;

public interface BaseDictService {
    public List<BaseDict> selectBaseDictByTypeCode(String typeCode);

}
