package com.farm.service.impl;

import com.farm.service.DiscussqukuaiService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.farm.utils.PageUtils;
import com.farm.utils.Query;


import com.farm.dao.DiscussqukuaiDao;
import com.farm.entity.DiscussqukuaiEntity;
import com.farm.entity.vo.DiscussqukuaiVO;
import com.farm.entity.view.DiscussqukuaiView;

@Service("discussqukuaiService")
public class DiscussqukuaiServiceImpl extends ServiceImpl<DiscussqukuaiDao, DiscussqukuaiEntity> implements DiscussqukuaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussqukuaiEntity> page = this.selectPage(
                new Query<DiscussqukuaiEntity>(params).getPage(),
                new EntityWrapper<DiscussqukuaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussqukuaiEntity> wrapper) {
		  Page<DiscussqukuaiView> page =new Query<DiscussqukuaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussqukuaiVO> selectListVO(Wrapper<DiscussqukuaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussqukuaiVO selectVO(Wrapper<DiscussqukuaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussqukuaiView> selectListView(Wrapper<DiscussqukuaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussqukuaiView selectView(Wrapper<DiscussqukuaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
