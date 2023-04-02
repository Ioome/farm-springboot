package com.farm.entity.vo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 区块
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
public class QukuaiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 土地名称
	 */
	
	private String tudimingcheng;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 规模
	 */
	
	private String guimo;
		
	/**
	 * 面积
	 */
	
	private Integer mianji;
		
	/**
	 * 状态
	 */
	
	private String zhuangtai;
		
	/**
	 * 适合作物
	 */
	
	private String shihezuowu;
		
	/**
	 * 详情
	 */
	
	private String xiangqing;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
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
	 * 设置：规模
	 */
	 
	public void setGuimo(String guimo) {
		this.guimo = guimo;
	}
	
	/**
	 * 获取：规模
	 */
	public String getGuimo() {
		return guimo;
	}
				
	
	/**
	 * 设置：面积
	 */
	 
	public void setMianji(Integer mianji) {
		this.mianji = mianji;
	}
	
	/**
	 * 获取：面积
	 */
	public Integer getMianji() {
		return mianji;
	}
				
	
	/**
	 * 设置：状态
	 */
	 
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
	}
				
	
	/**
	 * 设置：适合作物
	 */
	 
	public void setShihezuowu(String shihezuowu) {
		this.shihezuowu = shihezuowu;
	}
	
	/**
	 * 获取：适合作物
	 */
	public String getShihezuowu() {
		return shihezuowu;
	}
				
	
	/**
	 * 设置：详情
	 */
	 
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	
	/**
	 * 获取：详情
	 */
	public String getXiangqing() {
		return xiangqing;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}
