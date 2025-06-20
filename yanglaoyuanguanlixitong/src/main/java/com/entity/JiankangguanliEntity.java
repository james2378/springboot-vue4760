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
 * 健康信息
 *
 * @author 
 * @email
 */
@TableName("jiankangguanli")
public class JiankangguanliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiankangguanliEntity() {

	}

	public JiankangguanliEntity(T t) {
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
     * 健康管理编号
     */
    @ColumnInfo(comment="健康管理编号",type="varchar(200)")
    @TableField(value = "jiankangguanli_uuid_number")

    private String jiankangguanliUuidNumber;


    /**
     * 健康管理名称
     */
    @ColumnInfo(comment="健康管理名称",type="varchar(200)")
    @TableField(value = "jiankangguanli_name")

    private String jiankangguanliName;


    /**
     * 健康状态类型
     */
    @ColumnInfo(comment="健康状态类型",type="int(11)")
    @TableField(value = "jiankangguanli_types")

    private Integer jiankangguanliTypes;


    /**
     * 健康管理备注
     */
    @ColumnInfo(comment="健康管理备注",type="text")
    @TableField(value = "jiankangguanli_content")

    private String jiankangguanliContent;


    /**
     * 测量日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="测量日期",type="date")
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
	 * 设置：健康管理编号
	 */
    public String getJiankangguanliUuidNumber() {
        return jiankangguanliUuidNumber;
    }
    /**
	 * 获取：健康管理编号
	 */

    public void setJiankangguanliUuidNumber(String jiankangguanliUuidNumber) {
        this.jiankangguanliUuidNumber = jiankangguanliUuidNumber;
    }
    /**
	 * 设置：健康管理名称
	 */
    public String getJiankangguanliName() {
        return jiankangguanliName;
    }
    /**
	 * 获取：健康管理名称
	 */

    public void setJiankangguanliName(String jiankangguanliName) {
        this.jiankangguanliName = jiankangguanliName;
    }
    /**
	 * 设置：健康状态类型
	 */
    public Integer getJiankangguanliTypes() {
        return jiankangguanliTypes;
    }
    /**
	 * 获取：健康状态类型
	 */

    public void setJiankangguanliTypes(Integer jiankangguanliTypes) {
        this.jiankangguanliTypes = jiankangguanliTypes;
    }
    /**
	 * 设置：健康管理备注
	 */
    public String getJiankangguanliContent() {
        return jiankangguanliContent;
    }
    /**
	 * 获取：健康管理备注
	 */

    public void setJiankangguanliContent(String jiankangguanliContent) {
        this.jiankangguanliContent = jiankangguanliContent;
    }
    /**
	 * 设置：测量日期
	 */
    public Date getZhixingTime() {
        return zhixingTime;
    }
    /**
	 * 获取：测量日期
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
        return "Jiankangguanli{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", zhiyuanzheId=" + zhiyuanzheId +
            ", jiankangguanliUuidNumber=" + jiankangguanliUuidNumber +
            ", jiankangguanliName=" + jiankangguanliName +
            ", jiankangguanliTypes=" + jiankangguanliTypes +
            ", jiankangguanliContent=" + jiankangguanliContent +
            ", zhixingTime=" + DateUtil.convertString(zhixingTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
