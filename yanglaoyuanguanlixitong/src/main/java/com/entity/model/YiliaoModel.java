package com.entity.model;

import com.entity.YiliaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 医疗信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YiliaoModel implements Serializable {
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
     * 医疗管理编号
     */
    private String yiliaoUuidNumber;


    /**
     * 医疗管理名称
     */
    private String yiliaoName;


    /**
     * 医疗类型
     */
    private Integer yiliaoTypes;


    /**
     * 花费金额
     */
    private Double yiliaoMoney;


    /**
     * 医疗管理备注
     */
    private String yiliaoContent;


    /**
     * 操作时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date caozuoTime;


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
	 * 获取：医疗管理编号
	 */
    public String getYiliaoUuidNumber() {
        return yiliaoUuidNumber;
    }


    /**
	 * 设置：医疗管理编号
	 */
    public void setYiliaoUuidNumber(String yiliaoUuidNumber) {
        this.yiliaoUuidNumber = yiliaoUuidNumber;
    }
    /**
	 * 获取：医疗管理名称
	 */
    public String getYiliaoName() {
        return yiliaoName;
    }


    /**
	 * 设置：医疗管理名称
	 */
    public void setYiliaoName(String yiliaoName) {
        this.yiliaoName = yiliaoName;
    }
    /**
	 * 获取：医疗类型
	 */
    public Integer getYiliaoTypes() {
        return yiliaoTypes;
    }


    /**
	 * 设置：医疗类型
	 */
    public void setYiliaoTypes(Integer yiliaoTypes) {
        this.yiliaoTypes = yiliaoTypes;
    }
    /**
	 * 获取：花费金额
	 */
    public Double getYiliaoMoney() {
        return yiliaoMoney;
    }


    /**
	 * 设置：花费金额
	 */
    public void setYiliaoMoney(Double yiliaoMoney) {
        this.yiliaoMoney = yiliaoMoney;
    }
    /**
	 * 获取：医疗管理备注
	 */
    public String getYiliaoContent() {
        return yiliaoContent;
    }


    /**
	 * 设置：医疗管理备注
	 */
    public void setYiliaoContent(String yiliaoContent) {
        this.yiliaoContent = yiliaoContent;
    }
    /**
	 * 获取：操作时间
	 */
    public Date getCaozuoTime() {
        return caozuoTime;
    }


    /**
	 * 设置：操作时间
	 */
    public void setCaozuoTime(Date caozuoTime) {
        this.caozuoTime = caozuoTime;
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
