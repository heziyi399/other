package com.hzyexample.other.service.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hzyexample.other.entity.AttrGroupEntity;
import com.hzyexample.other.util.PageUtils;
import com.hzyexample.other.vo.AttrGroupWithAttrsVo;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-01 21:08:49
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long catelogId);


    List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId);

}

