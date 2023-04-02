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


import com.dao.DiscusszhongzhiDao;
import com.entity.DiscusszhongzhiEntity;
import com.service.DiscusszhongzhiService;
import com.entity.vo.DiscusszhongzhiVO;
import com.entity.view.DiscusszhongzhiView;

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
