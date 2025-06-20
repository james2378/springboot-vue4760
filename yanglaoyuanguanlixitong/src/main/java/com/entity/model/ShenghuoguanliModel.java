package com.entity.model;

import com.entity.ShenghuoguanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 生活信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShenghuoguanliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 志愿者
     */
    private Integer zhiyuanzheId;


    /**
     * 生活管理编号
     */
    private String shenghuoguanliUuidNumber;


    /**
     * 生活管理名称
     */
    private String shenghuoguanliName;


    /**
     * 生活管理类型
     */
    private Integer shenghuoguanliTypes;


    /**
     * 花费金额
     */
    private Double huafeiMoney;


    /**
     * 生活管理详情
     */
    private String shenghuoguanliContent;


    /**
     * 执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zhixingTime;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：志愿者
	 */
    public Integer getZhiyuanzheId() {
        return zhiyuanzheId;
    }


    /**
	 * 设置：志愿者
	 */
    public void setZhiyuanzheId(Integer zhiyuanzheId) {
        this.zhiyuanzheId = zhiyuanzheId;
    }
    /**
	 * 获取：生活管理编号
	 */
    public String getShenghuoguanliUuidNumber() {
        return shenghuoguanliUuidNumber;
    }


    /**
	 * 设置：生活管理编号
	 */
    public void setShenghuoguanliUuidNumber(String shenghuoguanliUuidNumber) {
        this.shenghuoguanliUuidNumber = shenghuoguanliUuidNumber;
    }
    /**
	 * 获取：生活管理名称
	 */
    public String getShenghuoguanliName() {
        return shenghuoguanliName;
    }


    /**
	 * 设置：生活管理名称
	 */
    public void setShenghuoguanliName(String shenghuoguanliName) {
        this.shenghuoguanliName = shenghuoguanliName;
    }
    /**
	 * 获取：生活管理类型
	 */
    public Integer getShenghuoguanliTypes() {
        return shenghuoguanliTypes;
    }


    /**
	 * 设置：生活管理类型
	 */
    public void setShenghuoguanliTypes(Integer shenghuoguanliTypes) {
        this.shenghuoguanliTypes = shenghuoguanliTypes;
    }
    /**
	 * 获取：花费金额
	 */
    public Double getHuafeiMoney() {
        return huafeiMoney;
    }


    /**
	 * 设置：花费金额
	 */
    public void setHuafeiMoney(Double huafeiMoney) {
        this.huafeiMoney = huafeiMoney;
    }
    /**
	 * 获取：生活管理详情
	 */
    public String getShenghuoguanliContent() {
        return shenghuoguanliContent;
    }


    /**
	 * 设置：生活管理详情
	 */
    public void setShenghuoguanliContent(String shenghuoguanliContent) {
        this.shenghuoguanliContent = shenghuoguanliContent;
    }
    /**
	 * 获取：执行时间
	 */
    public Date getZhixingTime() {
        return zhixingTime;
    }


    /**
	 * 设置：执行时间
	 */
    public void setZhixingTime(Date zhixingTime) {
        this.zhixingTime = zhixingTime;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
