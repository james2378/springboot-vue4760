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
 * 设备
 *
 * @author 
 * @email
 */
@TableName("shebei")
public class ShebeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShebeiEntity() {

	}

	public ShebeiEntity(T t) {
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
     * 设备名称
     */
    @ColumnInfo(comment="设备名称",type="varchar(200)")
    @TableField(value = "shebei_name")

    private String shebeiName;


    /**
     * 设备照片
     */
    @ColumnInfo(comment="设备照片",type="varchar(200)")
    @TableField(value = "shebei_photo")

    private String shebeiPhoto;


    /**
     * 设备类型
     */
    @ColumnInfo(comment="设备类型",type="int(11)")
    @TableField(value = "shebei_types")

    private Integer shebeiTypes;


    /**
     * 设备数量
     */
    @ColumnInfo(comment="设备数量",type="int(11)")
    @TableField(value = "shebei_number")

    private Integer shebeiNumber;


    /**
     * 设备详细介绍
     */
    @ColumnInfo(comment="设备详细介绍",type="text")
    @TableField(value = "shebei_content")

    private String shebeiContent;


    /**
     * 采购时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="采购时间",type="timestamp")
    @TableField(value = "caigou_time")

    private Date caigouTime;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：设备名称
	 */
    public String getShebeiName() {
        return shebeiName;
    }
    /**
	 * 获取：设备名称
	 */

    public void setShebeiName(String shebeiName) {
        this.shebeiName = shebeiName;
    }
    /**
	 * 设置：设备照片
	 */
    public String getShebeiPhoto() {
        return shebeiPhoto;
    }
    /**
	 * 获取：设备照片
	 */

    public void setShebeiPhoto(String shebeiPhoto) {
        this.shebeiPhoto = shebeiPhoto;
    }
    /**
	 * 设置：设备类型
	 */
    public Integer getShebeiTypes() {
        return shebeiTypes;
    }
    /**
	 * 获取：设备类型
	 */

    public void setShebeiTypes(Integer shebeiTypes) {
        this.shebeiTypes = shebeiTypes;
    }
    /**
	 * 设置：设备数量
	 */
    public Integer getShebeiNumber() {
        return shebeiNumber;
    }
    /**
	 * 获取：设备数量
	 */

    public void setShebeiNumber(Integer shebeiNumber) {
        this.shebeiNumber = shebeiNumber;
    }
    /**
	 * 设置：设备详细介绍
	 */
    public String getShebeiContent() {
        return shebeiContent;
    }
    /**
	 * 获取：设备详细介绍
	 */

    public void setShebeiContent(String shebeiContent) {
        this.shebeiContent = shebeiContent;
    }
    /**
	 * 设置：采购时间
	 */
    public Date getCaigouTime() {
        return caigouTime;
    }
    /**
	 * 获取：采购时间
	 */

    public void setCaigouTime(Date caigouTime) {
        this.caigouTime = caigouTime;
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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shebei{" +
            ", id=" + id +
            ", shebeiName=" + shebeiName +
            ", shebeiPhoto=" + shebeiPhoto +
            ", shebeiTypes=" + shebeiTypes +
            ", shebeiNumber=" + shebeiNumber +
            ", shebeiContent=" + shebeiContent +
            ", caigouTime=" + DateUtil.convertString(caigouTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
