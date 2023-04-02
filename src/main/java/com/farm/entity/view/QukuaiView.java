package com.farm.entity.view;

import com.farm.entity.QukuaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 区块
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
@TableName("qukuai")
public class QukuaiView  extends QukuaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QukuaiView(){
	}
 
 	public QukuaiView(QukuaiEntity qukuaiEntity){
 	try {
			BeanUtils.copyProperties(this, qukuaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
