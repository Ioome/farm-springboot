package com.entity.view;

import com.entity.DiscusszhongzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 种植评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
@TableName("discusszhongzhi")
public class DiscusszhongzhiView  extends DiscusszhongzhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusszhongzhiView(){
	}
 
 	public DiscusszhongzhiView(DiscusszhongzhiEntity discusszhongzhiEntity){
 	try {
			BeanUtils.copyProperties(this, discusszhongzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
