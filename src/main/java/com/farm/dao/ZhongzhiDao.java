package com.farm.dao;

import com.farm.entity.ZhongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.farm.entity.view.ZhongzhiView;
import com.farm.entity.vo.ZhongzhiVO;
import org.apache.ibatis.annotations.Param;


/**
 * 种植
 * 
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface ZhongzhiDao extends BaseMapper<ZhongzhiEntity> {
	
	List<ZhongzhiVO> selectListVO(@Param("ew") Wrapper<ZhongzhiEntity> wrapper);
	
	ZhongzhiVO selectVO(@Param("ew") Wrapper<ZhongzhiEntity> wrapper);
	
	List<ZhongzhiView> selectListView(@Param("ew") Wrapper<ZhongzhiEntity> wrapper);

	List<ZhongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhongzhiEntity> wrapper);
	
	ZhongzhiView selectView(@Param("ew") Wrapper<ZhongzhiEntity> wrapper);
	
}
