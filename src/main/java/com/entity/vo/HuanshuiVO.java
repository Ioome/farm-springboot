package com.entity.vo;

import com.entity.HuanshuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 换水
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public class HuanshuiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 土地名称
	 */
	
	private String tudimingcheng;
		
	/**
	 * 植物名称
	 */
	
	private String zhiwumingcheng;
		
	/**
	 * 植物图片
	 */
	
	private String zhiwutupian;
		
	/**
	 * 种植日期
	 */
	
	private String zhongzhiriqi;
		
	/**
	 * 换水日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date huanshuiriqi;
		
	/**
	 * 当前状态
	 */
	
	private String dangqianzhuangtai;
		
	/**
	 * 下次换水
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date xiacihuanshui;
		
	/**
	 * 其它
	 */
	
	private String qita;
		
	/**
	 * 用户名
	 */
	
	private String yonghuming;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：土地名称
	 */
	 
	public void setTudimingcheng(String tudimingcheng) {
		this.tudimingcheng = tudimingcheng;
	}
	
	/**
	 * 获取：土地名称
	 */
	public String getTudimingcheng() {
		return tudimingcheng;
	}
				
	
	/**
	 * 设置：植物名称
	 */
	 
	public void setZhiwumingcheng(String zhiwumingcheng) {
		this.zhiwumingcheng = zhiwumingcheng;
	}
	
	/**
	 * 获取：植物名称
	 */
	public String getZhiwumingcheng() {
		return zhiwumingcheng;
	}
				
	
	/**
	 * 设置：植物图片
	 */
	 
	public void setZhiwutupian(String zhiwutupian) {
		this.zhiwutupian = zhiwutupian;
	}
	
	/**
	 * 获取：植物图片
	 */
	public String getZhiwutupian() {
		return zhiwutupian;
	}
				
	
	/**
	 * 设置：种植日期
	 */
	 
	public void setZhongzhiriqi(String zhongzhiriqi) {
		this.zhongzhiriqi = zhongzhiriqi;
	}
	
	/**
	 * 获取：种植日期
	 */
	public String getZhongzhiriqi() {
		return zhongzhiriqi;
	}
				
	
	/**
	 * 设置：换水日期
	 */
	 
	public void setHuanshuiriqi(Date huanshuiriqi) {
		this.huanshuiriqi = huanshuiriqi;
	}
	
	/**
	 * 获取：换水日期
	 */
	public Date getHuanshuiriqi() {
		return huanshuiriqi;
	}
				
	
	/**
	 * 设置：当前状态
	 */
	 
	public void setDangqianzhuangtai(String dangqianzhuangtai) {
		this.dangqianzhuangtai = dangqianzhuangtai;
	}
	
	/**
	 * 获取：当前状态
	 */
	public String getDangqianzhuangtai() {
		return dangqianzhuangtai;
	}
				
	
	/**
	 * 设置：下次换水
	 */
	 
	public void setXiacihuanshui(Date xiacihuanshui) {
		this.xiacihuanshui = xiacihuanshui;
	}
	
	/**
	 * 获取：下次换水
	 */
	public Date getXiacihuanshui() {
		return xiacihuanshui;
	}
				
	
	/**
	 * 设置：其它
	 */
	 
	public void setQita(String qita) {
		this.qita = qita;
	}
	
	/**
	 * 获取：其它
	 */
	public String getQita() {
		return qita;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
