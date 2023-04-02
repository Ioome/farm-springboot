package com.farm.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.farm.entity.HuanshuiEntity;
import com.farm.entity.view.HuanshuiView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.farm.service.HuanshuiService;
import com.farm.utils.PageUtils;
import com.farm.utils.R;
import com.farm.utils.MPUtil;


/**
 * 换水
 * 后端接口
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
@RestController
@RequestMapping("/huanshui")
public class HuanshuiController {
    @Autowired
    private HuanshuiService huanshuiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HuanshuiEntity huanshui, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			huanshui.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuanshuiEntity> ew = new EntityWrapper<HuanshuiEntity>();
		PageUtils page = huanshuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huanshui), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuanshuiEntity huanshui, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			huanshui.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuanshuiEntity> ew = new EntityWrapper<HuanshuiEntity>();
		PageUtils page = huanshuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huanshui), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuanshuiEntity huanshui){
       	EntityWrapper<HuanshuiEntity> ew = new EntityWrapper<HuanshuiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huanshui, "huanshui")); 
        return R.ok().put("data", huanshuiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuanshuiEntity huanshui){
        EntityWrapper< HuanshuiEntity> ew = new EntityWrapper< HuanshuiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huanshui, "huanshui")); 
		HuanshuiView huanshuiView =  huanshuiService.selectView(ew);
		return R.ok("查询换水成功").put("data", huanshuiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        HuanshuiEntity huanshui = huanshuiService.selectById(id);
        return R.ok().put("data", huanshui);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        HuanshuiEntity huanshui = huanshuiService.selectById(id);
        return R.ok().put("data", huanshui);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuanshuiEntity huanshui, HttpServletRequest request){
    	huanshui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huanshui);
        huanshuiService.insert(huanshui);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuanshuiEntity huanshui, HttpServletRequest request){
    	huanshui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huanshui);
    	huanshui.setUserid((Long)request.getSession().getAttribute("userId"));
        huanshuiService.insert(huanshui);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HuanshuiEntity huanshui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huanshui);
        huanshuiService.updateById(huanshui);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huanshuiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<HuanshuiEntity> wrapper = new EntityWrapper<HuanshuiEntity>();
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

		int count = huanshuiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
