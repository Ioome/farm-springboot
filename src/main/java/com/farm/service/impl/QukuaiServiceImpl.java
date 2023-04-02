package com.farm.service.impl;

import com.farm.service.QukuaiService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.farm.utils.PageUtils;
import com.farm.utils.Query;


import com.farm.dao.QukuaiDao;
import com.farm.entity.QukuaiEntity;
import com.farm.entity.vo.QukuaiVO;
import com.farm.entity.view.QukuaiView;

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
