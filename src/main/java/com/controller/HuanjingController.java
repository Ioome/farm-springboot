package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.HuanjingEntity;
import com.entity.view.HuanjingView;

import com.service.HuanjingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 环境
 * 后端接口
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
@RestController
@RequestMapping("/huanjing")
public class HuanjingController {
    @Autowired
    private HuanjingService huanjingService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuanjingEntity huanjing, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			huanjing.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuanjingEntity> ew = new EntityWrapper<HuanjingEntity>();
		PageUtils page = huanjingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huanjing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuanjingEntity huanjing, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			huanjing.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuanjingEntity> ew = new EntityWrapper<HuanjingEntity>();
		PageUtils page = huanjingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huanjing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuanjingEntity huanjing){
       	EntityWrapper<HuanjingEntity> ew = new EntityWrapper<HuanjingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huanjing, "huanjing")); 
        return R.ok().put("data", huanjingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuanjingEntity huanjing){
        EntityWrapper< HuanjingEntity> ew = new EntityWrapper< HuanjingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huanjing, "huanjing")); 
		HuanjingView huanjingView =  huanjingService.selectView(ew);
		return R.ok("查询环境成功").put("data", huanjingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        HuanjingEntity huanjing = huanjingService.selectById(id);
        return R.ok().put("data", huanjing);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        HuanjingEntity huanjing = huanjingService.selectById(id);
        return R.ok().put("data", huanjing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuanjingEntity huanjing, HttpServletRequest request){
    	huanjing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huanjing);
        huanjingService.insert(huanjing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuanjingEntity huanjing, HttpServletRequest request){
    	huanjing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huanjing);
    	huanjing.setUserid((Long)request.getSession().getAttribute("userId"));
        huanjingService.insert(huanjing);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HuanjingEntity huanjing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huanjing);
        huanjingService.updateById(huanjing);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huanjingService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<HuanjingEntity> wrapper = new EntityWrapper<HuanjingEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = huanjingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
