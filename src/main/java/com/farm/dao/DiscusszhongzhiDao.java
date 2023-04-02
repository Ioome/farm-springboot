package com.farm.dao;

import com.farm.entity.DiscusszhongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.farm.entity.view.DiscusszhongzhiView;
import com.farm.entity.vo.DiscusszhongzhiVO;
import org.apache.ibatis.annotations.Param;


/**
 * 种植评论表
 * 
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface DiscusszhongzhiDao extends BaseMapper<DiscusszhongzhiEntity> {
	
	List<DiscusszhongzhiVO> selectListVO(@Param("ew") Wrapper<DiscusszhongzhiEntity> wrapper);
	
	DiscusszhongzhiVO selectVO(@Param("ew") Wrapper<DiscusszhongzhiEntity> wrapper);
	
	List<DiscusszhongzhiView> selectListView(@Param("ew") Wrapper<DiscusszhongzhiEntity> wrapper);

	List<DiscusszhongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhongzhiEntity> wrapper);
	
	DiscusszhongzhiView selectView(@Param("ew") Wrapper<DiscusszhongzhiEntity> wrapper);
	
}
