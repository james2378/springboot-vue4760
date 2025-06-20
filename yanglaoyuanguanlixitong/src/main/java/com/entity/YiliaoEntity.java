package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 医疗信息
 *
 * @author 
 * @email
 */
@TableName("yiliao")
public class YiliaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YiliaoEntity() {

	}

	public YiliaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 志愿者
     */
    @ColumnInfo(comment="志愿者",type="int(11)")
    @TableField(value = "zhiyuanzhe_id")

    private Integer zhiyuanzheId;


    /**
     * 医疗管理编号
     */
    @ColumnInfo(comment="医疗管理编号",type="varchar(200)")
    @TableField(value = "yiliao_uuid_number")

    private String yiliaoUuidNumber;


    /**
     * 医疗管理名称
     */
    @ColumnInfo(comment="医疗管理名称",type="varchar(200)")
    @TableField(value = "yiliao_name")

    private String yiliaoName;


    /**
     * 医疗类型
     */
    @ColumnInfo(comment="医疗类型",type="int(11)")
    @TableField(value = "yiliao_types")

    private Integer yiliaoTypes;


    /**
     * 花费金额
     */
    @ColumnInfo(comment="花费金额",type="decimal(10,2)")
    @TableField(value = "yiliao_money")

    private Double yiliaoMoney;


    /**
     * 医疗管理备注
     */
    @ColumnInfo(comment="医疗管理备注",type="text")
    @TableField(value = "yiliao_content")

    private String yiliaoContent;


    /**
     * 操作时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="操作时间",type="timestamp")
    @TableField(value = "caozuo_time")

    private Date caozuoTime;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Yiliao{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", zhiyuanzheId=" + zhiyuanzheId +
            ", yiliaoUuidNumber=" + yiliaoUuidNumber +
            ", yiliaoName=" + yiliaoName +
            ", yiliaoTypes=" + yiliaoTypes +
            ", yiliaoMoney=" + yiliaoMoney +
            ", yiliaoContent=" + yiliaoContent +
            ", caozuoTime=" + DateUtil.convertString(caozuoTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
