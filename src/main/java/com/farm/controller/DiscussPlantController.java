package com.farm.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.farm.entity.DiscusszhiwuEntity;
import com.farm.entity.view.DiscusszhiwuView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.farm.annotation.IgnoreAuth;

import com.farm.service.DiscusszhiwuService;
import com.farm.utils.PageUtils;
import com.farm.utils.R;
import com.farm.utils.MPUtil;


/**
 * 植物评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
@RestController
@RequestMapping("/api/v1/discusszhiwu")
public class DiscussPlantController {
    @Autowired
    private DiscusszhiwuService discusszhiwuService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, DiscusszhiwuEntity discusszhiwu, HttpServletRequest request){
        EntityWrapper<DiscusszhiwuEntity> ew = new EntityWrapper<DiscusszhiwuEntity>();
		PageUtils page = discusszhiwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhiwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusszhiwuEntity discusszhiwu, HttpServletRequest request){
        EntityWrapper<DiscusszhiwuEntity> ew = new EntityWrapper<DiscusszhiwuEntity>();
		PageUtils page = discusszhiwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhiwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusszhiwuEntity discusszhiwu){
       	EntityWrapper<DiscusszhiwuEntity> ew = new EntityWrapper<DiscusszhiwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusszhiwu, "discusszhiwu")); 
        return R.ok().put("data", discusszhiwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusszhiwuEntity discusszhiwu){
        EntityWrapper< DiscusszhiwuEntity> ew = new EntityWrapper< DiscusszhiwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusszhiwu, "discusszhiwu")); 
		DiscusszhiwuView discusszhiwuView =  discusszhiwuService.selectView(ew);
		return R.ok("查询植物评论表成功").put("data", discusszhiwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszhiwuEntity discusszhiwu = discusszhiwuService.selectById(id);
        return R.ok().put("data", discusszhiwu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszhiwuEntity discusszhiwu = discusszhiwuService.selectById(id);
        return R.ok().put("data", discusszhiwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusszhiwuEntity discusszhiwu, HttpServletRequest request){
    	discusszhiwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhiwu);
        discusszhiwuService.insert(discusszhiwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusszhiwuEntity discusszhiwu, HttpServletRequest request){
    	discusszhiwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhiwu);
        discusszhiwuService.insert(discusszhiwu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscusszhiwuEntity discusszhiwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszhiwu);
        discusszhiwuService.updateById(discusszhiwu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszhiwuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscusszhiwuEntity> wrapper = new EntityWrapper<DiscusszhiwuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusszhiwuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
