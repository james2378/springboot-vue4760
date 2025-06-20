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
 * 安全
 *
 * @author 
 * @email
 */
@TableName("anquan")
public class AnquanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public AnquanEntity() {

	}

	public AnquanEntity(T t) {
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
     * 巡检编号
     */
    @ColumnInfo(comment="巡检编号",type="varchar(200)")
    @TableField(value = "anquan_uuid_number")

    private String anquanUuidNumber;


    /**
     * 巡检标题
     */
    @ColumnInfo(comment="巡检标题",type="varchar(200)")
    @TableField(value = "anquan_name")

    private String anquanName;


    /**
     * 巡检类型
     */
    @ColumnInfo(comment="巡检类型",type="int(11)")
    @TableField(value = "anquan_types")

    private Integer anquanTypes;


    /**
     * 巡检详情
     */
    @ColumnInfo(comment="巡检详情",type="text")
    @TableField(value = "anquan_content")

    private String anquanContent;


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
	 * 设置：巡检编号
	 */
    public String getAnquanUuidNumber() {
        return anquanUuidNumber;
    }
    /**
	 * 获取：巡检编号
	 */

    public void setAnquanUuidNumber(String anquanUuidNumber) {
        this.anquanUuidNumber = anquanUuidNumber;
    }
    /**
	 * 设置：巡检标题
	 */
    public String getAnquanName() {
        return anquanName;
    }
    /**
	 * 获取：巡检标题
	 */

    public void setAnquanName(String anquanName) {
        this.anquanName = anquanName;
    }
    /**
	 * 设置：巡检类型
	 */
    public Integer getAnquanTypes() {
        return anquanTypes;
    }
    /**
	 * 获取：巡检类型
	 */

    public void setAnquanTypes(Integer anquanTypes) {
        this.anquanTypes = anquanTypes;
    }
    /**
	 * 设置：巡检详情
	 */
    public String getAnquanContent() {
        return anquanContent;
    }
    /**
	 * 获取：巡检详情
	 */

    public void setAnquanContent(String anquanContent) {
        this.anquanContent = anquanContent;
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
        return "Anquan{" +
            ", id=" + id +
            ", anquanUuidNumber=" + anquanUuidNumber +
            ", anquanName=" + anquanName +
            ", anquanTypes=" + anquanTypes +
            ", anquanContent=" + anquanContent +
            ", zhixingTime=" + DateUtil.convertString(zhixingTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
