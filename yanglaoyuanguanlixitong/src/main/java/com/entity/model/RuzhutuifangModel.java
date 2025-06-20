package com.entity.model;

import com.entity.RuzhutuifangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 入住退房信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class RuzhutuifangModel implements Serializable {
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
     * 入住退房信息编号
     */
    private String ruzhutuifangUuidNumber;


    /**
     * 房屋名称
     */
    private String fangwuName;


    /**
     * 房屋位置
     */
    private String fangwuAddress;


    /**
     * 房屋单价/天
     */
    private Double fangwuDanjia;


    /**
     * 入住状态
     */
    private Integer ruzhutuifangTypes;


    /**
     * 入住时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date ruzhuTime;


    /**
     * 退房时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date tuifangTime;


    /**
     * 总花费
     */
    private Double fangwuZonghuafei;


    /**
     * 入住退房备注
     */
    private String ruzhutuifangContent;


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
	 * 获取：入住退房信息编号
	 */
    public String getRuzhutuifangUuidNumber() {
        return ruzhutuifangUuidNumber;
    }


    /**
	 * 设置：入住退房信息编号
	 */
    public void setRuzhutuifangUuidNumber(String ruzhutuifangUuidNumber) {
        this.ruzhutuifangUuidNumber = ruzhutuifangUuidNumber;
    }
    /**
	 * 获取：房屋名称
	 */
    public String getFangwuName() {
        return fangwuName;
    }


    /**
	 * 设置：房屋名称
	 */
    public void setFangwuName(String fangwuName) {
        this.fangwuName = fangwuName;
    }
    /**
	 * 获取：房屋位置
	 */
    public String getFangwuAddress() {
        return fangwuAddress;
    }


    /**
	 * 设置：房屋位置
	 */
    public void setFangwuAddress(String fangwuAddress) {
        this.fangwuAddress = fangwuAddress;
    }
    /**
	 * 获取：房屋单价/天
	 */
    public Double getFangwuDanjia() {
        return fangwuDanjia;
    }


    /**
	 * 设置：房屋单价/天
	 */
    public void setFangwuDanjia(Double fangwuDanjia) {
        this.fangwuDanjia = fangwuDanjia;
    }
    /**
	 * 获取：入住状态
	 */
    public Integer getRuzhutuifangTypes() {
        return ruzhutuifangTypes;
    }


    /**
	 * 设置：入住状态
	 */
    public void setRuzhutuifangTypes(Integer ruzhutuifangTypes) {
        this.ruzhutuifangTypes = ruzhutuifangTypes;
    }
    /**
	 * 获取：入住时间
	 */
    public Date getRuzhuTime() {
        return ruzhuTime;
    }


    /**
	 * 设置：入住时间
	 */
    public void setRuzhuTime(Date ruzhuTime) {
        this.ruzhuTime = ruzhuTime;
    }
    /**
	 * 获取：退房时间
	 */
    public Date getTuifangTime() {
        return tuifangTime;
    }


    /**
	 * 设置：退房时间
	 */
    public void setTuifangTime(Date tuifangTime) {
        this.tuifangTime = tuifangTime;
    }
    /**
	 * 获取：总花费
	 */
    public Double getFangwuZonghuafei() {
        return fangwuZonghuafei;
    }


    /**
	 * 设置：总花费
	 */
    public void setFangwuZonghuafei(Double fangwuZonghuafei) {
        this.fangwuZonghuafei = fangwuZonghuafei;
    }
    /**
	 * 获取：入住退房备注
	 */
    public String getRuzhutuifangContent() {
        return ruzhutuifangContent;
    }


    /**
	 * 设置：入住退房备注
	 */
    public void setRuzhutuifangContent(String ruzhutuifangContent) {
        this.ruzhutuifangContent = ruzhutuifangContent;
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
