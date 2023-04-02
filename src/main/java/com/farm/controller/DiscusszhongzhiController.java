package com.farm.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.farm.entity.DiscusszhongzhiEntity;
import com.farm.entity.view.DiscusszhongzhiView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.farm.annotation.IgnoreAuth;

import com.farm.service.DiscusszhongzhiService;
import com.farm.utils.PageUtils;
import com.farm.utils.R;
import com.farm.utils.MPUtil;


/**
 * 种植评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
@RestController
@RequestMapping("/discusszhongzhi")
public class DiscusszhongzhiController {
    @Autowired
    private DiscusszhongzhiService discusszhongzhiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, DiscusszhongzhiEntity discusszhongzhi, HttpServletRequest request){
        EntityWrapper<DiscusszhongzhiEntity> ew = new EntityWrapper<DiscusszhongzhiEntity>();
		PageUtils page = discusszhongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhongzhi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusszhongzhiEntity discusszhongzhi, HttpServletRequest request){
        EntityWrapper<DiscusszhongzhiEntity> ew = new EntityWrapper<DiscusszhongzhiEntity>();
		PageUtils page = discusszhongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhongzhi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusszhongzhiEntity discusszhongzhi){
       	EntityWrapper<DiscusszhongzhiEntity> ew = new EntityWrapper<DiscusszhongzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusszhongzhi, "discusszhongzhi")); 
        return R.ok().put("data", discusszhongzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusszhongzhiEntity discusszhongzhi){
        EntityWrapper< DiscusszhongzhiEntity> ew = new EntityWrapper< DiscusszhongzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusszhongzhi, "discusszhongzhi")); 
		DiscusszhongzhiView discusszhongzhiView =  discusszhongzhiService.selectView(ew);
		return R.ok("查询种植评论表成功").put("data", discusszhongzhiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszhongzhiEntity discusszhongzhi = discusszhongzhiService.selectById(id);
        return R.ok().put("data", discusszhongzhi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszhongzhiEntity discusszhongzhi = discusszhongzhiService.selectById(id);
        return R.ok().put("data", discusszhongzhi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusszhongzhiEntity discusszhongzhi, HttpServletRequest request){
    	discusszhongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhongzhi);
        discusszhongzhiService.insert(discusszhongzhi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusszhongzhiEntity discusszhongzhi, HttpServletRequest request){
    	discusszhongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhongzhi);
        discusszhongzhiService.insert(discusszhongzhi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscusszhongzhiEntity discusszhongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszhongzhi);
        discusszhongzhiService.updateById(discusszhongzhi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszhongzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscusszhongzhiEntity> wrapper = new EntityWrapper<DiscusszhongzhiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusszhongzhiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
