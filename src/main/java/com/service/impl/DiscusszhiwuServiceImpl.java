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


import com.dao.DiscusszhiwuDao;
import com.entity.DiscusszhiwuEntity;
import com.service.DiscusszhiwuService;
import com.entity.vo.DiscusszhiwuVO;
import com.entity.view.DiscusszhiwuView;

@Service("discusszhiwuService")
public class DiscusszhiwuServiceImpl extends ServiceImpl<DiscusszhiwuDao, DiscusszhiwuEntity> implements DiscusszhiwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhiwuEntity> page = this.selectPage(
                new Query<DiscusszhiwuEntity>(params).getPage(),
                new EntityWrapper<DiscusszhiwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhiwuEntity> wrapper) {
		  Page<DiscusszhiwuView> page =new Query<DiscusszhiwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhiwuVO> selectListVO(Wrapper<DiscusszhiwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhiwuVO selectVO(Wrapper<DiscusszhiwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhiwuView> selectListView(Wrapper<DiscusszhiwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhiwuView selectView(Wrapper<DiscusszhiwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
