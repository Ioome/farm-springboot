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


import com.dao.HuanshuiDao;
import com.entity.HuanshuiEntity;
import com.service.HuanshuiService;
import com.entity.vo.HuanshuiVO;
import com.entity.view.HuanshuiView;

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
