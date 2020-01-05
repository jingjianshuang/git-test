package com.itheima.service.impl;

import com.itheima.dao.BaseDictDao;
import com.itheima.domain.BaseDict;
import com.itheima.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("baseDictService")
@Transactional
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    private BaseDictDao baseDictDao;

    public List<BaseDict> selectBaseDictByTypeCode(String typeCode) {
        return baseDictDao.selectBaseDictByTypeCode(typeCode);

    }
}
