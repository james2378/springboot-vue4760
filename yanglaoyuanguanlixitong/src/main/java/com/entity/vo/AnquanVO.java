package com.entity.vo;

import com.entity.AnquanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 安全
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("anquan")
public class AnquanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 巡检编号
     */

    @TableField(value = "anquan_uuid_number")
    private String anquanUuidNumber;


    /**
     * 巡检标题
     */

    @TableField(value = "anquan_name")
    private String anquanName;


    /**
     * 巡检类型
     */

    @TableField(value = "anquan_types")
    private Integer anquanTypes;


    /**
     * 巡检详情
     */

    @TableField(value = "anquan_content")
    private String anquanContent;


    /**
     * 执行时间
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

}
