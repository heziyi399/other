package com.hzyexample.other.service.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.hzyexample.other.entity.SpuInfoDescEntity;
import com.hzyexample.other.util.PageUtils;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-01 21:08:49
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfoDesc(SpuInfoDescEntity descEntity);


}

