package com.farm.service.impl;

import com.farm.service.DiscusszhongzhiService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.farm.utils.PageUtils;
import com.farm.utils.Query;


import com.farm.dao.DiscusszhongzhiDao;
import com.farm.entity.DiscusszhongzhiEntity;
import com.farm.entity.vo.DiscusszhongzhiVO;
import com.farm.entity.view.DiscusszhongzhiView;

@Service("discusszhongzhiService")
public class DiscusszhongzhiServiceImpl extends ServiceImpl<DiscusszhongzhiDao, DiscusszhongzhiEntity> implements DiscusszhongzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhongzhiEntity> page = this.selectPage(
                new Query<DiscusszhongzhiEntity>(params).getPage(),
                new EntityWrapper<DiscusszhongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhongzhiEntity> wrapper) {
		  Page<DiscusszhongzhiView> page =new Query<DiscusszhongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhongzhiVO> selectListVO(Wrapper<DiscusszhongzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhongzhiVO selectVO(Wrapper<DiscusszhongzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhongzhiView> selectListView(Wrapper<DiscusszhongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhongzhiView selectView(Wrapper<DiscusszhongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
