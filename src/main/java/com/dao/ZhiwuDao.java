package com.dao;

import com.entity.ZhiwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhiwuVO;
import com.entity.view.ZhiwuView;


/**
 * 植物
 * 
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface ZhiwuDao extends BaseMapper<ZhiwuEntity> {
	
	List<ZhiwuVO> selectListVO(@Param("ew") Wrapper<ZhiwuEntity> wrapper);
	
	ZhiwuVO selectVO(@Param("ew") Wrapper<ZhiwuEntity> wrapper);
	
	List<ZhiwuView> selectListView(@Param("ew") Wrapper<ZhiwuEntity> wrapper);

	List<ZhiwuView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiwuEntity> wrapper);
	
	ZhiwuView selectView(@Param("ew") Wrapper<ZhiwuEntity> wrapper);
	
}
