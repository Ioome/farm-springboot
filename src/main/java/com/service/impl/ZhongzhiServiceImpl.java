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


import com.dao.ZhongzhiDao;
import com.entity.ZhongzhiEntity;
import com.service.ZhongzhiService;
import com.entity.vo.ZhongzhiVO;
import com.entity.view.ZhongzhiView;

@Service("zhongzhiService")
public class ZhongzhiServiceImpl extends ServiceImpl<ZhongzhiDao, ZhongzhiEntity> implements ZhongzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhongzhiEntity> page = this.selectPage(
                new Query<ZhongzhiEntity>(params).getPage(),
                new EntityWrapper<ZhongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhongzhiEntity> wrapper) {
		  Page<ZhongzhiView> page =new Query<ZhongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhongzhiVO> selectListVO(Wrapper<ZhongzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhongzhiVO selectVO(Wrapper<ZhongzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhongzhiView> selectListView(Wrapper<ZhongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhongzhiView selectView(Wrapper<ZhongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
