package com.farm.dao;

import com.farm.entity.HuanjingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.farm.entity.view.HuanjingView;
import com.farm.entity.vo.HuanjingVO;
import org.apache.ibatis.annotations.Param;


/**
 * 环境
 * 
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface HuanjingDao extends BaseMapper<HuanjingEntity> {
	
	List<HuanjingVO> selectListVO(@Param("ew") Wrapper<HuanjingEntity> wrapper);
	
	HuanjingVO selectVO(@Param("ew") Wrapper<HuanjingEntity> wrapper);
	
	List<HuanjingView> selectListView(@Param("ew") Wrapper<HuanjingEntity> wrapper);

	List<HuanjingView> selectListView(Pagination page,@Param("ew") Wrapper<HuanjingEntity> wrapper);
	
	HuanjingView selectView(@Param("ew") Wrapper<HuanjingEntity> wrapper);
	
}
