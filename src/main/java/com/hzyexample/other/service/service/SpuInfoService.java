package com.hzyexample.other.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzyexample.other.entity.SpuInfoEntity;
import com.hzyexample.other.util.PageUtils;

import java.util.Map;

/**
 * spu信息
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-01 21:08:49
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);


    void saveBaseSpuInfo(SpuInfoEntity infoEntity);


    PageUtils queryPageByCondition(Map<String, Object> params);


}

