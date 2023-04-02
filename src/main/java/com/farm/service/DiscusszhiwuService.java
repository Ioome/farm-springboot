package com.farm.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.farm.utils.PageUtils;
import com.farm.entity.DiscusszhiwuEntity;
import java.util.List;
import java.util.Map;
import com.farm.entity.vo.DiscusszhiwuVO;
import org.apache.ibatis.annotations.Param;
import com.farm.entity.view.DiscusszhiwuView;


/**
 * 植物评论表
 *
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface DiscusszhiwuService extends IService<DiscusszhiwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhiwuVO> selectListVO(Wrapper<DiscusszhiwuEntity> wrapper);
   	
   	DiscusszhiwuVO selectVO(@Param("ew") Wrapper<DiscusszhiwuEntity> wrapper);
   	
   	List<DiscusszhiwuView> selectListView(Wrapper<DiscusszhiwuEntity> wrapper);
   	
   	DiscusszhiwuView selectView(@Param("ew") Wrapper<DiscusszhiwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhiwuEntity> wrapper);
   	
}

