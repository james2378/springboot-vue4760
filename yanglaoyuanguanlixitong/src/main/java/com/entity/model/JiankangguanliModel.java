package com.entity.model;

import com.entity.JiankangguanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 健康信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiankangguanliModel implements Serializable {
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
     * 健康管理编号
     */
    private String jiankangguanliUuidNumber;


    /**
     * 健康管理名称
     */
    private String jiankangguanliName;


    /**
     * 健康状态类型
     */
    private Integer jiankangguanliTypes;


    /**
     * 健康管理备注
     */
    private String jiankangguanliContent;


    /**
     * 测量日期
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
	 * 获取：健康管理编号
	 */
    public String getJiankangguanliUuidNumber() {
        return jiankangguanliUuidNumber;
    }


    /**
	 * 设置：健康管理编号
	 */
    public void setJiankangguanliUuidNumber(String jiankangguanliUuidNumber) {
        this.jiankangguanliUuidNumber = jiankangguanliUuidNumber;
    }
    /**
	 * 获取：健康管理名称
	 */
    public String getJiankangguanliName() {
        return jiankangguanliName;
    }


    /**
	 * 设置：健康管理名称
	 */
    public void setJiankangguanliName(String jiankangguanliName) {
        this.jiankangguanliName = jiankangguanliName;
    }
    /**
	 * 获取：健康状态类型
	 */
    public Integer getJiankangguanliTypes() {
        return jiankangguanliTypes;
    }


    /**
	 * 设置：健康状态类型
	 */
    public void setJiankangguanliTypes(Integer jiankangguanliTypes) {
        this.jiankangguanliTypes = jiankangguanliTypes;
    }
    /**
	 * 获取：健康管理备注
	 */
    public String getJiankangguanliContent() {
        return jiankangguanliContent;
    }


    /**
	 * 设置：健康管理备注
	 */
    public void setJiankangguanliContent(String jiankangguanliContent) {
        this.jiankangguanliContent = jiankangguanliContent;
    }
    /**
	 * 获取：测量日期
	 */
    public Date getZhixingTime() {
        return zhixingTime;
    }


    /**
	 * 设置：测量日期
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
