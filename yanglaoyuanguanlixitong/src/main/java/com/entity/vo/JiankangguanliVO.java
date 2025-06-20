package com.entity.vo;

import com.entity.JiankangguanliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 健康信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiankangguanli")
public class JiankangguanliVO implements Serializable {
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
     * 健康管理编号
     */

    @TableField(value = "jiankangguanli_uuid_number")
    private String jiankangguanliUuidNumber;


    /**
     * 健康管理名称
     */

    @TableField(value = "jiankangguanli_name")
    private String jiankangguanliName;


    /**
     * 健康状态类型
     */

    @TableField(value = "jiankangguanli_types")
    private Integer jiankangguanliTypes;


    /**
     * 健康管理备注
     */

    @TableField(value = "jiankangguanli_content")
    private String jiankangguanliContent;


    /**
     * 测量日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zhixing_time")
    private Date zhixingTime;


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

}
