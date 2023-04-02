package com.farm.dao;

import com.farm.entity.GonggaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.farm.entity.view.GonggaoxinxiView;
import com.farm.entity.vo.GonggaoxinxiVO;
import org.apache.ibatis.annotations.Param;


/**
 * 公告信息
 * 
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface GonggaoxinxiDao extends BaseMapper<GonggaoxinxiEntity> {
	
	List<GonggaoxinxiVO> selectListVO(@Param("ew") Wrapper<GonggaoxinxiEntity> wrapper);
	
	GonggaoxinxiVO selectVO(@Param("ew") Wrapper<GonggaoxinxiEntity> wrapper);
	
	List<GonggaoxinxiView> selectListView(@Param("ew") Wrapper<GonggaoxinxiEntity> wrapper);

	List<GonggaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<GonggaoxinxiEntity> wrapper);
	
	GonggaoxinxiView selectView(@Param("ew") Wrapper<GonggaoxinxiEntity> wrapper);
	
}
