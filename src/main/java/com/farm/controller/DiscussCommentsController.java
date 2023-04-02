package com.farm.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.farm.entity.DiscussqukuaiEntity;
import com.farm.entity.view.DiscussqukuaiView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.farm.annotation.IgnoreAuth;

import com.farm.service.DiscussqukuaiService;
import com.farm.utils.PageUtils;
import com.farm.utils.R;
import com.farm.utils.MPUtil;


/**
 * 区块评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
@RestController
@RequestMapping("/discussqukuai")
public class DiscussCommentsController {
    @Autowired
    private DiscussqukuaiService discussqukuaiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, DiscussqukuaiEntity discussqukuai, HttpServletRequest request){
        EntityWrapper<DiscussqukuaiEntity> ew = new EntityWrapper<DiscussqukuaiEntity>();
		PageUtils page = discussqukuaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussqukuai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussqukuaiEntity discussqukuai, HttpServletRequest request){
        EntityWrapper<DiscussqukuaiEntity> ew = new EntityWrapper<DiscussqukuaiEntity>();
		PageUtils page = discussqukuaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussqukuai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussqukuaiEntity discussqukuai){
       	EntityWrapper<DiscussqukuaiEntity> ew = new EntityWrapper<DiscussqukuaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussqukuai, "discussqukuai")); 
        return R.ok().put("data", discussqukuaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussqukuaiEntity discussqukuai){
        EntityWrapper< DiscussqukuaiEntity> ew = new EntityWrapper< DiscussqukuaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussqukuai, "discussqukuai")); 
		DiscussqukuaiView discussqukuaiView =  discussqukuaiService.selectView(ew);
		return R.ok("查询区块评论表成功").put("data", discussqukuaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussqukuaiEntity discussqukuai = discussqukuaiService.selectById(id);
        return R.ok().put("data", discussqukuai);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussqukuaiEntity discussqukuai = discussqukuaiService.selectById(id);
        return R.ok().put("data", discussqukuai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussqukuaiEntity discussqukuai, HttpServletRequest request){
    	discussqukuai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussqukuai);
        discussqukuaiService.insert(discussqukuai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussqukuaiEntity discussqukuai, HttpServletRequest request){
    	discussqukuai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussqukuai);
        discussqukuaiService.insert(discussqukuai);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussqukuaiEntity discussqukuai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussqukuai);
        discussqukuaiService.updateById(discussqukuai);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussqukuaiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscussqukuaiEntity> wrapper = new EntityWrapper<DiscussqukuaiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussqukuaiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
