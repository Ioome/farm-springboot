package com.farm.dao;

import com.farm.entity.QukuaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.farm.entity.view.QukuaiView;
import com.farm.entity.vo.QukuaiVO;
import org.apache.ibatis.annotations.Param;


/**
 * 区块
 * 
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public interface QukuaiDao extends BaseMapper<QukuaiEntity> {
	
	List<QukuaiVO> selectListVO(@Param("ew") Wrapper<QukuaiEntity> wrapper);
	
	QukuaiVO selectVO(@Param("ew") Wrapper<QukuaiEntity> wrapper);
	
	List<QukuaiView> selectListView(@Param("ew") Wrapper<QukuaiEntity> wrapper);

	List<QukuaiView> selectListView(Pagination page,@Param("ew") Wrapper<QukuaiEntity> wrapper);
	
	QukuaiView selectView(@Param("ew") Wrapper<QukuaiEntity> wrapper);
	
}
