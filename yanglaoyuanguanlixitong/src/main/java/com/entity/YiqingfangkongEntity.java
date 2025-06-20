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
 * 疫情防控信息
 *
 * @author 
 * @email
 */
@TableName("yiqingfangkong")
public class YiqingfangkongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YiqingfangkongEntity() {

	}

	public YiqingfangkongEntity(T t) {
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
     * 志愿者
     */
    @ColumnInfo(comment="志愿者",type="int(11)")
    @TableField(value = "zhiyuanzhe_id")

    private Integer zhiyuanzheId;


    /**
     * 疫情防控编号
     */
    @ColumnInfo(comment="疫情防控编号",type="varchar(200)")
    @TableField(value = "yiqingfangkong_uuid_number")

    private String yiqingfangkongUuidNumber;


    /**
     * 疫情防控名称
     */
    @ColumnInfo(comment="疫情防控名称",type="varchar(200)")
    @TableField(value = "yiqingfangkong_name")

    private String yiqingfangkongName;


    /**
     * 疫情防控状态类型
     */
    @ColumnInfo(comment="疫情防控状态类型",type="int(11)")
    @TableField(value = "yiqingfangkong_types")

    private Integer yiqingfangkongTypes;


    /**
     * 确诊人数
     */
    @ColumnInfo(comment="确诊人数",type="int(11)")
    @TableField(value = "quezhenrenshu")

    private Integer quezhenrenshu;


    /**
     * 密接人数
     */
    @ColumnInfo(comment="密接人数",type="int(11)")
    @TableField(value = "mijierenshu")

    private Integer mijierenshu;


    /**
     * 疫情防控管理备注
     */
    @ColumnInfo(comment="疫情防控管理备注",type="text")
    @TableField(value = "yiqingfangkong_content")

    private String yiqingfangkongContent;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="所属日期",type="date")
    @TableField(value = "suoshu_time")

    private Date suoshuTime;


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
	 * 设置：疫情防控编号
	 */
    public String getYiqingfangkongUuidNumber() {
        return yiqingfangkongUuidNumber;
    }
    /**
	 * 获取：疫情防控编号
	 */

    public void setYiqingfangkongUuidNumber(String yiqingfangkongUuidNumber) {
        this.yiqingfangkongUuidNumber = yiqingfangkongUuidNumber;
    }
    /**
	 * 设置：疫情防控名称
	 */
    public String getYiqingfangkongName() {
        return yiqingfangkongName;
    }
    /**
	 * 获取：疫情防控名称
	 */

    public void setYiqingfangkongName(String yiqingfangkongName) {
        this.yiqingfangkongName = yiqingfangkongName;
    }
    /**
	 * 设置：疫情防控状态类型
	 */
    public Integer getYiqingfangkongTypes() {
        return yiqingfangkongTypes;
    }
    /**
	 * 获取：疫情防控状态类型
	 */

    public void setYiqingfangkongTypes(Integer yiqingfangkongTypes) {
        this.yiqingfangkongTypes = yiqingfangkongTypes;
    }
    /**
	 * 设置：确诊人数
	 */
    public Integer getQuezhenrenshu() {
        return quezhenrenshu;
    }
    /**
	 * 获取：确诊人数
	 */

    public void setQuezhenrenshu(Integer quezhenrenshu) {
        this.quezhenrenshu = quezhenrenshu;
    }
    /**
	 * 设置：密接人数
	 */
    public Integer getMijierenshu() {
        return mijierenshu;
    }
    /**
	 * 获取：密接人数
	 */

    public void setMijierenshu(Integer mijierenshu) {
        this.mijierenshu = mijierenshu;
    }
    /**
	 * 设置：疫情防控管理备注
	 */
    public String getYiqingfangkongContent() {
        return yiqingfangkongContent;
    }
    /**
	 * 获取：疫情防控管理备注
	 */

    public void setYiqingfangkongContent(String yiqingfangkongContent) {
        this.yiqingfangkongContent = yiqingfangkongContent;
    }
    /**
	 * 设置：所属日期
	 */
    public Date getSuoshuTime() {
        return suoshuTime;
    }
    /**
	 * 获取：所属日期
	 */

    public void setSuoshuTime(Date suoshuTime) {
        this.suoshuTime = suoshuTime;
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
        return "Yiqingfangkong{" +
            ", id=" + id +
            ", zhiyuanzheId=" + zhiyuanzheId +
            ", yiqingfangkongUuidNumber=" + yiqingfangkongUuidNumber +
            ", yiqingfangkongName=" + yiqingfangkongName +
            ", yiqingfangkongTypes=" + yiqingfangkongTypes +
            ", quezhenrenshu=" + quezhenrenshu +
            ", mijierenshu=" + mijierenshu +
            ", yiqingfangkongContent=" + yiqingfangkongContent +
            ", suoshuTime=" + DateUtil.convertString(suoshuTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
