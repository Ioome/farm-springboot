package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuanjingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuanjingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuanjingView;


/**
 * 环境
 *
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface HuanjingService extends IService<HuanjingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuanjingVO> selectListVO(Wrapper<HuanjingEntity> wrapper);
   	
   	HuanjingVO selectVO(@Param("ew") Wrapper<HuanjingEntity> wrapper);
   	
   	List<HuanjingView> selectListView(Wrapper<HuanjingEntity> wrapper);
   	
   	HuanjingView selectView(@Param("ew") Wrapper<HuanjingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuanjingEntity> wrapper);
   	
}

