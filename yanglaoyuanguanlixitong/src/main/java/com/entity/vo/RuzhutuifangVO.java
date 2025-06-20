package com.entity.vo;

import com.entity.RuzhutuifangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 入住退房信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("ruzhutuifang")
public class RuzhutuifangVO implements Serializable {
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
     * 入住退房信息编号
     */

    @TableField(value = "ruzhutuifang_uuid_number")
    private String ruzhutuifangUuidNumber;


    /**
     * 房屋名称
     */

    @TableField(value = "fangwu_name")
    private String fangwuName;


    /**
     * 房屋位置
     */

    @TableField(value = "fangwu_address")
    private String fangwuAddress;


    /**
     * 房屋单价/天
     */

    @TableField(value = "fangwu_danjia")
    private Double fangwuDanjia;


    /**
     * 入住状态
     */

    @TableField(value = "ruzhutuifang_types")
    private Integer ruzhutuifangTypes;


    /**
     * 入住时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "ruzhu_time")
    private Date ruzhuTime;


    /**
     * 退房时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "tuifang_time")
    private Date tuifangTime;


    /**
     * 总花费
     */

    @TableField(value = "fangwu_zonghuafei")
    private Double fangwuZonghuafei;


    /**
     * 入住退房备注
     */

    @TableField(value = "ruzhutuifang_content")
    private String ruzhutuifangContent;


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

}
