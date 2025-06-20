package com.entity.vo;

import com.entity.YiliaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 医疗信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yiliao")
public class YiliaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 志愿者
     */

    @TableField(value = "zhiyuanzhe_id")
    private Integer zhiyuanzheId;


    /**
     * 医疗管理编号
     */

    @TableField(value = "yiliao_uuid_number")
    private String yiliaoUuidNumber;


    /**
     * 医疗管理名称
     */

    @TableField(value = "yiliao_name")
    private String yiliaoName;


    /**
     * 医疗类型
     */

    @TableField(value = "yiliao_types")
    private Integer yiliaoTypes;


    /**
     * 花费金额
     */

    @TableField(value = "yiliao_money")
    private Double yiliaoMoney;


    /**
     * 医疗管理备注
     */

    @TableField(value = "yiliao_content")
    private String yiliaoContent;


    /**
     * 操作时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "caozuo_time")
    private Date caozuoTime;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：志愿者
	 */
    public Integer getZhiyuanzheId() {
        return zhiyuanzheId;
    }


    /**
	 * 获取：志愿者
	 */

    public void setZhiyuanzheId(Integer zhiyuanzheId) {
        this.zhiyuanzheId = zhiyuanzheId;
    }
    /**
	 * 设置：医疗管理编号
	 */
    public String getYiliaoUuidNumber() {
        return yiliaoUuidNumber;
    }


    /**
	 * 获取：医疗管理编号
	 */

    public void setYiliaoUuidNumber(String yiliaoUuidNumber) {
        this.yiliaoUuidNumber = yiliaoUuidNumber;
    }
    /**
	 * 设置：医疗管理名称
	 */
    public String getYiliaoName() {
        return yiliaoName;
    }


    /**
	 * 获取：医疗管理名称
	 */

    public void setYiliaoName(String yiliaoName) {
        this.yiliaoName = yiliaoName;
    }
    /**
	 * 设置：医疗类型
	 */
    public Integer getYiliaoTypes() {
        return yiliaoTypes;
    }


    /**
	 * 获取：医疗类型
	 */

    public void setYiliaoTypes(Integer yiliaoTypes) {
        this.yiliaoTypes = yiliaoTypes;
    }
    /**
	 * 设置：花费金额
	 */
    public Double getYiliaoMoney() {
        return yiliaoMoney;
    }


    /**
	 * 获取：花费金额
	 */

    public void setYiliaoMoney(Double yiliaoMoney) {
        this.yiliaoMoney = yiliaoMoney;
    }
    /**
	 * 设置：医疗管理备注
	 */
    public String getYiliaoContent() {
        return yiliaoContent;
    }


    /**
	 * 获取：医疗管理备注
	 */

    public void setYiliaoContent(String yiliaoContent) {
        this.yiliaoContent = yiliaoContent;
    }
    /**
	 * 设置：操作时间
	 */
    public Date getCaozuoTime() {
        return caozuoTime;
    }


    /**
	 * 获取：操作时间
	 */

    public void setCaozuoTime(Date caozuoTime) {
        this.caozuoTime = caozuoTime;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
