package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.QukuaiDao;
import com.entity.QukuaiEntity;
import com.service.QukuaiService;
import com.entity.vo.QukuaiVO;
import com.entity.view.QukuaiView;

@Service("qukuaiService")
public class QukuaiServiceImpl extends ServiceImpl<QukuaiDao, QukuaiEntity> implements QukuaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QukuaiEntity> page = this.selectPage(
                new Query<QukuaiEntity>(params).getPage(),
                new EntityWrapper<QukuaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QukuaiEntity> wrapper) {
		  Page<QukuaiView> page =new Query<QukuaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QukuaiVO> selectListVO(Wrapper<QukuaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QukuaiVO selectVO(Wrapper<QukuaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QukuaiView> selectListView(Wrapper<QukuaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QukuaiView selectView(Wrapper<QukuaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
