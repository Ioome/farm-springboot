package com.farm.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.farm.utils.PageUtils;
import com.farm.entity.HuanshuiEntity;
import java.util.List;
import java.util.Map;
import com.farm.entity.vo.HuanshuiVO;
import org.apache.ibatis.annotations.Param;
import com.farm.entity.view.HuanshuiView;


/**
 * 换水
 *
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface HuanshuiService extends IService<HuanshuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuanshuiVO> selectListVO(Wrapper<HuanshuiEntity> wrapper);
   	
   	HuanshuiVO selectVO(@Param("ew") Wrapper<HuanshuiEntity> wrapper);
   	
   	List<HuanshuiView> selectListView(Wrapper<HuanshuiEntity> wrapper);
   	
   	HuanshuiView selectView(@Param("ew") Wrapper<HuanshuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuanshuiEntity> wrapper);
   	
}

