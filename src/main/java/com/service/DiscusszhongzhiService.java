package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszhongzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszhongzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszhongzhiView;


/**
 * 种植评论表
 *
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface DiscusszhongzhiService extends IService<DiscusszhongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhongzhiVO> selectListVO(Wrapper<DiscusszhongzhiEntity> wrapper);
   	
   	DiscusszhongzhiVO selectVO(@Param("ew") Wrapper<DiscusszhongzhiEntity> wrapper);
   	
   	List<DiscusszhongzhiView> selectListView(Wrapper<DiscusszhongzhiEntity> wrapper);
   	
   	DiscusszhongzhiView selectView(@Param("ew") Wrapper<DiscusszhongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhongzhiEntity> wrapper);
   	
}

