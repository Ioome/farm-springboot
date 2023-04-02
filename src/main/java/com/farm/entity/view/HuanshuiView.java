package com.farm.entity.view;

import com.farm.entity.HuanshuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 换水
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
@TableName("huanshui")
public class HuanshuiView  extends HuanshuiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuanshuiView(){
	}
 
 	public HuanshuiView(HuanshuiEntity huanshuiEntity){
 	try {
			BeanUtils.copyProperties(this, huanshuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
