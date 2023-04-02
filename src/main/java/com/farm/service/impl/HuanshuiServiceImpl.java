package com.farm.service.impl;

import com.farm.service.HuanshuiService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.farm.utils.PageUtils;
import com.farm.utils.Query;


import com.farm.dao.HuanshuiDao;
import com.farm.entity.HuanshuiEntity;
import com.farm.entity.vo.HuanshuiVO;
import com.farm.entity.view.HuanshuiView;

@Service("huanshuiService")
public class HuanshuiServiceImpl extends ServiceImpl<HuanshuiDao, HuanshuiEntity> implements HuanshuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuanshuiEntity> page = this.selectPage(
                new Query<HuanshuiEntity>(params).getPage(),
                new EntityWrapper<HuanshuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuanshuiEntity> wrapper) {
		  Page<HuanshuiView> page =new Query<HuanshuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuanshuiVO> selectListVO(Wrapper<HuanshuiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuanshuiVO selectVO(Wrapper<HuanshuiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuanshuiView> selectListView(Wrapper<HuanshuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuanshuiView selectView(Wrapper<HuanshuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
