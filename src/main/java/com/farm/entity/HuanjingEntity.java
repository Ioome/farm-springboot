package com.farm.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 环境
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2020-12-20 09:48:46
 */
@TableName("huanjing")
public class HuanjingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HuanjingEntity() {
		
	}
	
	public HuanjingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 编号
	 */
					
	private String bianhao;
	
	/**
	 * 土地名称
	 */
					
	private String tudimingcheng;
	
	/**
	 * 植物名称
	 */
					
	private String zhiwumingcheng;
	
	/**
	 * 分类
	 */
					
	private String fenlei;
	
	/**
	 * 植物图片
	 */
					
	private String zhiwutupian;
	
	/**
	 * 种植日期
	 */
					
	private String zhongzhiriqi;
	
	/**
	 * 当前状态
	 */
					
	private String dangqianzhuangtai;
	
	/**
	 * 环境温度
	 */
					
	private String huanjingwendu;
	
	/**
	 * 温度建议
	 */
					
	private String wendujianyi;
	
	/**
	 * 温度管理
	 */
					
	private String wenduguanli;
	
	/**
	 * 空气湿度
	 */
					
	private String kongqishidu;
	
	/**
	 * 湿度建议
	 */
					
	private String shidujianyi;
	
	/**
	 * 土壤管理
	 */
					
	private String turangguanli;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：编号
	 */
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	/**
	 * 获取：编号
	 */
	public String getBianhao() {
		return bianhao;
	}
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
	 * 设置：环境温度
	 */
	public void setHuanjingwendu(String huanjingwendu) {
		this.huanjingwendu = huanjingwendu;
	}
	/**
	 * 获取：环境温度
	 */
	public String getHuanjingwendu() {
		return huanjingwendu;
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
	 * 设置：温度管理
	 */
	public void setWenduguanli(String wenduguanli) {
		this.wenduguanli = wenduguanli;
	}
	/**
	 * 获取：温度管理
	 */
	public String getWenduguanli() {
		return wenduguanli;
	}
	/**
	 * 设置：空气湿度
	 */
	public void setKongqishidu(String kongqishidu) {
		this.kongqishidu = kongqishidu;
	}
	/**
	 * 获取：空气湿度
	 */
	public String getKongqishidu() {
		return kongqishidu;
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
	 * 设置：土壤管理
	 */
	public void setTurangguanli(String turangguanli) {
		this.turangguanli = turangguanli;
	}
	/**
	 * 获取：土壤管理
	 */
	public String getTurangguanli() {
		return turangguanli;
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
