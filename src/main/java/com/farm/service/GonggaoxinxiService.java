package com.farm.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.farm.utils.PageUtils;
import com.farm.entity.GonggaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.farm.entity.vo.GonggaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.farm.entity.view.GonggaoxinxiView;


/**
 * 公告信息
 *
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface GonggaoxinxiService extends IService<GonggaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GonggaoxinxiVO> selectListVO(Wrapper<GonggaoxinxiEntity> wrapper);
   	
   	GonggaoxinxiVO selectVO(@Param("ew") Wrapper<GonggaoxinxiEntity> wrapper);
   	
   	List<GonggaoxinxiView> selectListView(Wrapper<GonggaoxinxiEntity> wrapper);
   	
   	GonggaoxinxiView selectView(@Param("ew") Wrapper<GonggaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GonggaoxinxiEntity> wrapper);
   	
}

