package com.farm.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.farm.entity.QukuaiEntity;
import com.farm.entity.view.QukuaiView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.farm.annotation.IgnoreAuth;

import com.farm.service.QukuaiService;
import com.farm.utils.PageUtils;
import com.farm.utils.R;
import com.farm.utils.MPUtil;


/**
 * 区块
 * 后端接口
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
@RestController
@RequestMapping("/qukuai")
public class QukuaiController {
    @Autowired
    private QukuaiService qukuaiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, QukuaiEntity qukuai, HttpServletRequest request){
        EntityWrapper<QukuaiEntity> ew = new EntityWrapper<QukuaiEntity>();
		PageUtils page = qukuaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qukuai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QukuaiEntity qukuai, HttpServletRequest request){
        EntityWrapper<QukuaiEntity> ew = new EntityWrapper<QukuaiEntity>();
		PageUtils page = qukuaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qukuai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QukuaiEntity qukuai){
       	EntityWrapper<QukuaiEntity> ew = new EntityWrapper<QukuaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qukuai, "qukuai")); 
        return R.ok().put("data", qukuaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QukuaiEntity qukuai){
        EntityWrapper< QukuaiEntity> ew = new EntityWrapper< QukuaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qukuai, "qukuai")); 
		QukuaiView qukuaiView =  qukuaiService.selectView(ew);
		return R.ok("查询区块成功").put("data", qukuaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        QukuaiEntity qukuai = qukuaiService.selectById(id);
		qukuai.setClicknum(qukuai.getClicknum()+1);
		qukuai.setClicktime(new Date());
		qukuaiService.updateById(qukuai);
        return R.ok().put("data", qukuai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        QukuaiEntity qukuai = qukuaiService.selectById(id);
		qukuai.setClicknum(qukuai.getClicknum()+1);
		qukuai.setClicktime(new Date());
		qukuaiService.updateById(qukuai);
        return R.ok().put("data", qukuai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QukuaiEntity qukuai, HttpServletRequest request){
    	qukuai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qukuai);
        qukuaiService.insert(qukuai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QukuaiEntity qukuai, HttpServletRequest request){
    	qukuai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qukuai);
        qukuaiService.insert(qukuai);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QukuaiEntity qukuai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qukuai);
        qukuaiService.updateById(qukuai);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qukuaiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<QukuaiEntity> wrapper = new EntityWrapper<QukuaiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = qukuaiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,QukuaiEntity qukuai, HttpServletRequest request,String pre){
        EntityWrapper<QukuaiEntity> ew = new EntityWrapper<QukuaiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = qukuaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qukuai), params), params));
        return R.ok().put("data", page);
    }


}
