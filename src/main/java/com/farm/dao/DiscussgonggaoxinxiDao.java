package com.farm.dao;

import com.farm.entity.DiscussgonggaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.farm.entity.view.DiscussgonggaoxinxiView;
import com.farm.entity.vo.DiscussgonggaoxinxiVO;
import org.apache.ibatis.annotations.Param;


/**
 * 公告信息评论表
 * 
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface DiscussgonggaoxinxiDao extends BaseMapper<DiscussgonggaoxinxiEntity> {
	
	List<DiscussgonggaoxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussgonggaoxinxiEntity> wrapper);
	
	DiscussgonggaoxinxiVO selectVO(@Param("ew") Wrapper<DiscussgonggaoxinxiEntity> wrapper);
	
	List<DiscussgonggaoxinxiView> selectListView(@Param("ew") Wrapper<DiscussgonggaoxinxiEntity> wrapper);

	List<DiscussgonggaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgonggaoxinxiEntity> wrapper);
	
	DiscussgonggaoxinxiView selectView(@Param("ew") Wrapper<DiscussgonggaoxinxiEntity> wrapper);
	
}
