package com.entity.vo;

import com.entity.YiqingfangkongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 疫情防控信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yiqingfangkong")
public class YiqingfangkongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 志愿者
     */

    @TableField(value = "zhiyuanzhe_id")
    private Integer zhiyuanzheId;


    /**
     * 疫情防控编号
     */

    @TableField(value = "yiqingfangkong_uuid_number")
    private String yiqingfangkongUuidNumber;


    /**
     * 疫情防控名称
     */

    @TableField(value = "yiqingfangkong_name")
    private String yiqingfangkongName;


    /**
     * 疫情防控状态类型
     */

    @TableField(value = "yiqingfangkong_types")
    private Integer yiqingfangkongTypes;


    /**
     * 确诊人数
     */

    @TableField(value = "quezhenrenshu")
    private Integer quezhenrenshu;


    /**
     * 密接人数
     */

    @TableField(value = "mijierenshu")
    private Integer mijierenshu;


    /**
     * 疫情防控管理备注
     */

    @TableField(value = "yiqingfangkong_content")
    private String yiqingfangkongContent;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "suoshu_time")
    private Date suoshuTime;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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

}
