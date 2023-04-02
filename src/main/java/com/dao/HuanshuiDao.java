package com.dao;

import com.entity.HuanshuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuanshuiVO;
import com.entity.view.HuanshuiView;


/**
 * 换水
 * 
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface HuanshuiDao extends BaseMapper<HuanshuiEntity> {
	
	List<HuanshuiVO> selectListVO(@Param("ew") Wrapper<HuanshuiEntity> wrapper);
	
	HuanshuiVO selectVO(@Param("ew") Wrapper<HuanshuiEntity> wrapper);
	
	List<HuanshuiView> selectListView(@Param("ew") Wrapper<HuanshuiEntity> wrapper);

	List<HuanshuiView> selectListView(Pagination page,@Param("ew") Wrapper<HuanshuiEntity> wrapper);
	
	HuanshuiView selectView(@Param("ew") Wrapper<HuanshuiEntity> wrapper);
	
}
