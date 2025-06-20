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
 * 生活信息
 *
 * @author 
 * @email
 */
@TableName("shenghuoguanli")
public class ShenghuoguanliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShenghuoguanliEntity() {

	}

	public ShenghuoguanliEntity(T t) {
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
     * 生活管理编号
     */
    @ColumnInfo(comment="生活管理编号",type="varchar(200)")
    @TableField(value = "shenghuoguanli_uuid_number")

    private String shenghuoguanliUuidNumber;


    /**
     * 生活管理名称
     */
    @ColumnInfo(comment="生活管理名称",type="varchar(200)")
    @TableField(value = "shenghuoguanli_name")

    private String shenghuoguanliName;


    /**
     * 生活管理类型
     */
    @ColumnInfo(comment="生活管理类型",type="int(11)")
    @TableField(value = "shenghuoguanli_types")

    private Integer shenghuoguanliTypes;


    /**
     * 花费金额
     */
    @ColumnInfo(comment="花费金额",type="decimal(10,2)")
    @TableField(value = "huafei_money")

    private Double huafeiMoney;


    /**
     * 生活管理详情
     */
    @ColumnInfo(comment="生活管理详情",type="text")
    @TableField(value = "shenghuoguanli_content")

    private String shenghuoguanliContent;


    /**
     * 执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="执行时间",type="timestamp")
    @TableField(value = "zhixing_time")

    private Date zhixingTime;


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
	 * 设置：生活管理编号
	 */
    public String getShenghuoguanliUuidNumber() {
        return shenghuoguanliUuidNumber;
    }
    /**
	 * 获取：生活管理编号
	 */

    public void setShenghuoguanliUuidNumber(String shenghuoguanliUuidNumber) {
        this.shenghuoguanliUuidNumber = shenghuoguanliUuidNumber;
    }
    /**
	 * 设置：生活管理名称
	 */
    public String getShenghuoguanliName() {
        return shenghuoguanliName;
    }
    /**
	 * 获取：生活管理名称
	 */

    public void setShenghuoguanliName(String shenghuoguanliName) {
        this.shenghuoguanliName = shenghuoguanliName;
    }
    /**
	 * 设置：生活管理类型
	 */
    public Integer getShenghuoguanliTypes() {
        return shenghuoguanliTypes;
    }
    /**
	 * 获取：生活管理类型
	 */

    public void setShenghuoguanliTypes(Integer shenghuoguanliTypes) {
        this.shenghuoguanliTypes = shenghuoguanliTypes;
    }
    /**
	 * 设置：花费金额
	 */
    public Double getHuafeiMoney() {
        return huafeiMoney;
    }
    /**
	 * 获取：花费金额
	 */

    public void setHuafeiMoney(Double huafeiMoney) {
        this.huafeiMoney = huafeiMoney;
    }
    /**
	 * 设置：生活管理详情
	 */
    public String getShenghuoguanliContent() {
        return shenghuoguanliContent;
    }
    /**
	 * 获取：生活管理详情
	 */

    public void setShenghuoguanliContent(String shenghuoguanliContent) {
        this.shenghuoguanliContent = shenghuoguanliContent;
    }
    /**
	 * 设置：执行时间
	 */
    public Date getZhixingTime() {
        return zhixingTime;
    }
    /**
	 * 获取：执行时间
	 */

    public void setZhixingTime(Date zhixingTime) {
        this.zhixingTime = zhixingTime;
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
        return "Shenghuoguanli{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", zhiyuanzheId=" + zhiyuanzheId +
            ", shenghuoguanliUuidNumber=" + shenghuoguanliUuidNumber +
            ", shenghuoguanliName=" + shenghuoguanliName +
            ", shenghuoguanliTypes=" + shenghuoguanliTypes +
            ", huafeiMoney=" + huafeiMoney +
            ", shenghuoguanliContent=" + shenghuoguanliContent +
            ", zhixingTime=" + DateUtil.convertString(zhixingTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
