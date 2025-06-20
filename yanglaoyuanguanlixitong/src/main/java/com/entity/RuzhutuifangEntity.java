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
 * 入住退房信息
 *
 * @author 
 * @email
 */
@TableName("ruzhutuifang")
public class RuzhutuifangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public RuzhutuifangEntity() {

	}

	public RuzhutuifangEntity(T t) {
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
     * 入住退房信息编号
     */
    @ColumnInfo(comment="入住退房信息编号",type="varchar(200)")
    @TableField(value = "ruzhutuifang_uuid_number")

    private String ruzhutuifangUuidNumber;


    /**
     * 房屋名称
     */
    @ColumnInfo(comment="房屋名称",type="varchar(200)")
    @TableField(value = "fangwu_name")

    private String fangwuName;


    /**
     * 房屋位置
     */
    @ColumnInfo(comment="房屋位置",type="varchar(200)")
    @TableField(value = "fangwu_address")

    private String fangwuAddress;


    /**
     * 房屋单价/天
     */
    @ColumnInfo(comment="房屋单价/天",type="decimal(10,2)")
    @TableField(value = "fangwu_danjia")

    private Double fangwuDanjia;


    /**
     * 入住状态
     */
    @ColumnInfo(comment="入住状态",type="int(11)")
    @TableField(value = "ruzhutuifang_types")

    private Integer ruzhutuifangTypes;


    /**
     * 入住时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="入住时间",type="date")
    @TableField(value = "ruzhu_time")

    private Date ruzhuTime;


    /**
     * 退房时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="退房时间",type="date")
    @TableField(value = "tuifang_time")

    private Date tuifangTime;


    /**
     * 总花费
     */
    @ColumnInfo(comment="总花费",type="decimal(10,2)")
    @TableField(value = "fangwu_zonghuafei")

    private Double fangwuZonghuafei;


    /**
     * 入住退房备注
     */
    @ColumnInfo(comment="入住退房备注",type="text")
    @TableField(value = "ruzhutuifang_content")

    private String ruzhutuifangContent;


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
	 * 设置：入住退房信息编号
	 */
    public String getRuzhutuifangUuidNumber() {
        return ruzhutuifangUuidNumber;
    }
    /**
	 * 获取：入住退房信息编号
	 */

    public void setRuzhutuifangUuidNumber(String ruzhutuifangUuidNumber) {
        this.ruzhutuifangUuidNumber = ruzhutuifangUuidNumber;
    }
    /**
	 * 设置：房屋名称
	 */
    public String getFangwuName() {
        return fangwuName;
    }
    /**
	 * 获取：房屋名称
	 */

    public void setFangwuName(String fangwuName) {
        this.fangwuName = fangwuName;
    }
    /**
	 * 设置：房屋位置
	 */
    public String getFangwuAddress() {
        return fangwuAddress;
    }
    /**
	 * 获取：房屋位置
	 */

    public void setFangwuAddress(String fangwuAddress) {
        this.fangwuAddress = fangwuAddress;
    }
    /**
	 * 设置：房屋单价/天
	 */
    public Double getFangwuDanjia() {
        return fangwuDanjia;
    }
    /**
	 * 获取：房屋单价/天
	 */

    public void setFangwuDanjia(Double fangwuDanjia) {
        this.fangwuDanjia = fangwuDanjia;
    }
    /**
	 * 设置：入住状态
	 */
    public Integer getRuzhutuifangTypes() {
        return ruzhutuifangTypes;
    }
    /**
	 * 获取：入住状态
	 */

    public void setRuzhutuifangTypes(Integer ruzhutuifangTypes) {
        this.ruzhutuifangTypes = ruzhutuifangTypes;
    }
    /**
	 * 设置：入住时间
	 */
    public Date getRuzhuTime() {
        return ruzhuTime;
    }
    /**
	 * 获取：入住时间
	 */

    public void setRuzhuTime(Date ruzhuTime) {
        this.ruzhuTime = ruzhuTime;
    }
    /**
	 * 设置：退房时间
	 */
    public Date getTuifangTime() {
        return tuifangTime;
    }
    /**
	 * 获取：退房时间
	 */

    public void setTuifangTime(Date tuifangTime) {
        this.tuifangTime = tuifangTime;
    }
    /**
	 * 设置：总花费
	 */
    public Double getFangwuZonghuafei() {
        return fangwuZonghuafei;
    }
    /**
	 * 获取：总花费
	 */

    public void setFangwuZonghuafei(Double fangwuZonghuafei) {
        this.fangwuZonghuafei = fangwuZonghuafei;
    }
    /**
	 * 设置：入住退房备注
	 */
    public String getRuzhutuifangContent() {
        return ruzhutuifangContent;
    }
    /**
	 * 获取：入住退房备注
	 */

    public void setRuzhutuifangContent(String ruzhutuifangContent) {
        this.ruzhutuifangContent = ruzhutuifangContent;
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
        return "Ruzhutuifang{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", zhiyuanzheId=" + zhiyuanzheId +
            ", ruzhutuifangUuidNumber=" + ruzhutuifangUuidNumber +
            ", fangwuName=" + fangwuName +
            ", fangwuAddress=" + fangwuAddress +
            ", fangwuDanjia=" + fangwuDanjia +
            ", ruzhutuifangTypes=" + ruzhutuifangTypes +
            ", ruzhuTime=" + DateUtil.convertString(ruzhuTime,"yyyy-MM-dd") +
            ", tuifangTime=" + DateUtil.convertString(tuifangTime,"yyyy-MM-dd") +
            ", fangwuZonghuafei=" + fangwuZonghuafei +
            ", ruzhutuifangContent=" + ruzhutuifangContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
