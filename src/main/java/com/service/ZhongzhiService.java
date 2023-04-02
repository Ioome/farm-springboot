package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhongzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhongzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhongzhiView;


/**
 * 种植
 *
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface ZhongzhiService extends IService<ZhongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhongzhiVO> selectListVO(Wrapper<ZhongzhiEntity> wrapper);
   	
   	ZhongzhiVO selectVO(@Param("ew") Wrapper<ZhongzhiEntity> wrapper);
   	
   	List<ZhongzhiView> selectListView(Wrapper<ZhongzhiEntity> wrapper);
   	
   	ZhongzhiView selectView(@Param("ew") Wrapper<ZhongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhongzhiEntity> wrapper);
   	
}

