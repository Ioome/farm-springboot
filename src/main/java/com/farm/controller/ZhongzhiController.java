package com.farm.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.farm.entity.ZhongzhiEntity;
import com.farm.entity.view.ZhongzhiView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.farm.service.ZhongzhiService;
import com.farm.utils.PageUtils;
import com.farm.utils.R;
import com.farm.utils.MPUtil;


/**
 * 种植
 * 后端接口
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
@RestController
@RequestMapping("/zhongzhi")
public class ZhongzhiController {
    @Autowired
    private ZhongzhiService zhongzhiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ZhongzhiEntity zhongzhi, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zhongzhi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhongzhiEntity> ew = new EntityWrapper<ZhongzhiEntity>();
		PageUtils page = zhongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongzhi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhongzhiEntity zhongzhi, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zhongzhi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhongzhiEntity> ew = new EntityWrapper<ZhongzhiEntity>();
		PageUtils page = zhongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongzhi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhongzhiEntity zhongzhi){
       	EntityWrapper<ZhongzhiEntity> ew = new EntityWrapper<ZhongzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhongzhi, "zhongzhi")); 
        return R.ok().put("data", zhongzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhongzhiEntity zhongzhi){
        EntityWrapper< ZhongzhiEntity> ew = new EntityWrapper< ZhongzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhongzhi, "zhongzhi")); 
		ZhongzhiView zhongzhiView =  zhongzhiService.selectView(ew);
		return R.ok("查询种植成功").put("data", zhongzhiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        ZhongzhiEntity zhongzhi = zhongzhiService.selectById(id);
        return R.ok().put("data", zhongzhi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        ZhongzhiEntity zhongzhi = zhongzhiService.selectById(id);
        return R.ok().put("data", zhongzhi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhongzhiEntity zhongzhi, HttpServletRequest request){
    	zhongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhongzhi);
        zhongzhiService.insert(zhongzhi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhongzhiEntity zhongzhi, HttpServletRequest request){
    	zhongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhongzhi);
    	zhongzhi.setUserid((Long)request.getSession().getAttribute("userId"));
        zhongzhiService.insert(zhongzhi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZhongzhiEntity zhongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhongzhi);
        zhongzhiService.updateById(zhongzhi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhongzhiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZhongzhiEntity> wrapper = new EntityWrapper<ZhongzhiEntity>();
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

		int count = zhongzhiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
