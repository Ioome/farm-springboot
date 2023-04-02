package com.farm.dao;

import com.farm.entity.DiscussqukuaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.farm.entity.view.DiscussqukuaiView;
import com.farm.entity.vo.DiscussqukuaiVO;
import org.apache.ibatis.annotations.Param;


/**
 * 区块评论表
 * 
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface DiscussqukuaiDao extends BaseMapper<DiscussqukuaiEntity> {
	
	List<DiscussqukuaiVO> selectListVO(@Param("ew") Wrapper<DiscussqukuaiEntity> wrapper);
	
	DiscussqukuaiVO selectVO(@Param("ew") Wrapper<DiscussqukuaiEntity> wrapper);
	
	List<DiscussqukuaiView> selectListView(@Param("ew") Wrapper<DiscussqukuaiEntity> wrapper);

	List<DiscussqukuaiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussqukuaiEntity> wrapper);
	
	DiscussqukuaiView selectView(@Param("ew") Wrapper<DiscussqukuaiEntity> wrapper);
	
}
