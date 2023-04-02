package com.farm.entity.vo;

import java.io.Serializable;
 

/**
 * 植物
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public class ZhiwuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 分类
	 */
	
	private String fenlei;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 生长周期
	 */
	
	private String shengzhangzhouqi;
		
	/**
	 * 营养价值
	 */
	
	private String yingyangjiazhi;
		
	/**
	 * 施肥品种
	 */
	
	private String shifeipinzhong;
		
	/**
	 * 光照周期
	 */
	
	private String guangzhaozhouqi;
		
	/**
	 * 土壤要求
	 */
	
	private String turangyaoqiu;
		
	/**
	 * 温度建议
	 */
	
	private String wendujianyi;
		
	/**
	 * 湿度建议
	 */
	
	private String shidujianyi;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
				
	
	/**
	 * 设置：分类
	 */
	 
	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	
	/**
	 * 获取：分类
	 */
	public String getFenlei() {
		return fenlei;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：生长周期
	 */
	 
	public void setShengzhangzhouqi(String shengzhangzhouqi) {
		this.shengzhangzhouqi = shengzhangzhouqi;
	}
	
	/**
	 * 获取：生长周期
	 */
	public String getShengzhangzhouqi() {
		return shengzhangzhouqi;
	}
				
	
	/**
	 * 设置：营养价值
	 */
	 
	public void setYingyangjiazhi(String yingyangjiazhi) {
		this.yingyangjiazhi = yingyangjiazhi;
	}
	
	/**
	 * 获取：营养价值
	 */
	public String getYingyangjiazhi() {
		return yingyangjiazhi;
	}
				
	
	/**
	 * 设置：施肥品种
	 */
	 
	public void setShifeipinzhong(String shifeipinzhong) {
		this.shifeipinzhong = shifeipinzhong;
	}
	
	/**
	 * 获取：施肥品种
	 */
	public String getShifeipinzhong() {
		return shifeipinzhong;
	}
				
	
	/**
	 * 设置：光照周期
	 */
	 
	public void setGuangzhaozhouqi(String guangzhaozhouqi) {
		this.guangzhaozhouqi = guangzhaozhouqi;
	}
	
	/**
	 * 获取：光照周期
	 */
	public String getGuangzhaozhouqi() {
		return guangzhaozhouqi;
	}
				
	
	/**
	 * 设置：土壤要求
	 */
	 
	public void setTurangyaoqiu(String turangyaoqiu) {
		this.turangyaoqiu = turangyaoqiu;
	}
	
	/**
	 * 获取：土壤要求
	 */
	public String getTurangyaoqiu() {
		return turangyaoqiu;
	}
				
	
	/**
	 * 设置：温度建议
	 */
	 
	public void setWendujianyi(String wendujianyi) {
		this.wendujianyi = wendujianyi;
	}
	
	/**
	 * 获取：温度建议
	 */
	public String getWendujianyi() {
		return wendujianyi;
	}
				
	
	/**
	 * 设置：湿度建议
	 */
	 
	public void setShidujianyi(String shidujianyi) {
		this.shidujianyi = shidujianyi;
	}
	
	/**
	 * 获取：湿度建议
	 */
	public String getShidujianyi() {
		return shidujianyi;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
			
}
