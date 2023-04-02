package com.dao;

import com.entity.QukuaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QukuaiVO;
import com.entity.view.QukuaiView;


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
