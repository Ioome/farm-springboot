package com.dao;

import com.entity.DiscusszhiwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhiwuVO;
import com.entity.view.DiscusszhiwuView;


/**
 * 植物评论表
 * 
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface DiscusszhiwuDao extends BaseMapper<DiscusszhiwuEntity> {
	
	List<DiscusszhiwuVO> selectListVO(@Param("ew") Wrapper<DiscusszhiwuEntity> wrapper);
	
	DiscusszhiwuVO selectVO(@Param("ew") Wrapper<DiscusszhiwuEntity> wrapper);
	
	List<DiscusszhiwuView> selectListView(@Param("ew") Wrapper<DiscusszhiwuEntity> wrapper);

	List<DiscusszhiwuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhiwuEntity> wrapper);
	
	DiscusszhiwuView selectView(@Param("ew") Wrapper<DiscusszhiwuEntity> wrapper);
	
}
