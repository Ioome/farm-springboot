package com.farm.service.impl;

import com.farm.service.HuanjingService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.farm.utils.PageUtils;
import com.farm.utils.Query;


import com.farm.dao.HuanjingDao;
import com.farm.entity.HuanjingEntity;
import com.farm.entity.vo.HuanjingVO;
import com.farm.entity.view.HuanjingView;

@Service("huanjingService")
public class HuanjingServiceImpl extends ServiceImpl<HuanjingDao, HuanjingEntity> implements HuanjingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuanjingEntity> page = this.selectPage(
                new Query<HuanjingEntity>(params).getPage(),
                new EntityWrapper<HuanjingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuanjingEntity> wrapper) {
		  Page<HuanjingView> page =new Query<HuanjingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuanjingVO> selectListVO(Wrapper<HuanjingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuanjingVO selectVO(Wrapper<HuanjingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuanjingView> selectListView(Wrapper<HuanjingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuanjingView selectView(Wrapper<HuanjingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
