package com.dao;

import com.entity.ZhongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhongzhiVO;
import com.entity.view.ZhongzhiView;


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
