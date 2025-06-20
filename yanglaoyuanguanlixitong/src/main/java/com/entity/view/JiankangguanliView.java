package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiankangguanliEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
 * 健康信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiankangguanli")
public class JiankangguanliView extends JiankangguanliEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 健康状态类型的值
		*/
		@ColumnInfo(comment="健康状态类型的字典表值",type="varchar(200)")
		private String jiankangguanliValue;



		//级联表 yonghu
			/**
			* 用户姓名
			*/

			@ColumnInfo(comment="用户姓名",type="varchar(200)")
			private String yonghuName;
			/**
			* 用户手机号
			*/

			@ColumnInfo(comment="用户手机号",type="varchar(200)")
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/

			@ColumnInfo(comment="用户身份证号",type="varchar(200)")
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/

			@ColumnInfo(comment="用户头像",type="varchar(200)")
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/

			@ColumnInfo(comment="电子邮箱",type="varchar(200)")
			private String yonghuEmail;
			/**
			* 余额
			*/
			@ColumnInfo(comment="余额",type="decimal(10,2)")
			private Double newMoney;

		//级联表 zhiyuanzhe
			/**
			* 志愿者姓名
			*/

			@ColumnInfo(comment="志愿者姓名",type="varchar(200)")
			private String zhiyuanzheName;
			/**
			* 志愿者手机号
			*/

			@ColumnInfo(comment="志愿者手机号",type="varchar(200)")
			private String zhiyuanzhePhone;
			/**
			* 志愿者身份证号
			*/

			@ColumnInfo(comment="志愿者身份证号",type="varchar(200)")
			private String zhiyuanzheIdNumber;
			/**
			* 志愿者头像
			*/

			@ColumnInfo(comment="志愿者头像",type="varchar(200)")
			private String zhiyuanzhePhoto;
			/**
			* 电子邮箱
			*/

			@ColumnInfo(comment="电子邮箱",type="varchar(200)")
			private String zhiyuanzheEmail;

	public JiankangguanliView() {

	}

	public JiankangguanliView(JiankangguanliEntity jiankangguanliEntity) {
		try {
			BeanUtils.copyProperties(this, jiankangguanliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 健康状态类型的值
			*/
			public String getJiankangguanliValue() {
				return jiankangguanliValue;
			}
			/**
			* 设置： 健康状态类型的值
			*/
			public void setJiankangguanliValue(String jiankangguanliValue) {
				this.jiankangguanliValue = jiankangguanliValue;
			}





































				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}




				//级联表的get和set zhiyuanzhe

					/**
					* 获取： 志愿者姓名
					*/
					public String getZhiyuanzheName() {
						return zhiyuanzheName;
					}
					/**
					* 设置： 志愿者姓名
					*/
					public void setZhiyuanzheName(String zhiyuanzheName) {
						this.zhiyuanzheName = zhiyuanzheName;
					}

					/**
					* 获取： 志愿者手机号
					*/
					public String getZhiyuanzhePhone() {
						return zhiyuanzhePhone;
					}
					/**
					* 设置： 志愿者手机号
					*/
					public void setZhiyuanzhePhone(String zhiyuanzhePhone) {
						this.zhiyuanzhePhone = zhiyuanzhePhone;
					}

					/**
					* 获取： 志愿者身份证号
					*/
					public String getZhiyuanzheIdNumber() {
						return zhiyuanzheIdNumber;
					}
					/**
					* 设置： 志愿者身份证号
					*/
					public void setZhiyuanzheIdNumber(String zhiyuanzheIdNumber) {
						this.zhiyuanzheIdNumber = zhiyuanzheIdNumber;
					}

					/**
					* 获取： 志愿者头像
					*/
					public String getZhiyuanzhePhoto() {
						return zhiyuanzhePhoto;
					}
					/**
					* 设置： 志愿者头像
					*/
					public void setZhiyuanzhePhoto(String zhiyuanzhePhoto) {
						this.zhiyuanzhePhoto = zhiyuanzhePhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getZhiyuanzheEmail() {
						return zhiyuanzheEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setZhiyuanzheEmail(String zhiyuanzheEmail) {
						this.zhiyuanzheEmail = zhiyuanzheEmail;
					}





	@Override
	public String toString() {
		return "JiankangguanliView{" +
			", jiankangguanliValue=" + jiankangguanliValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", zhiyuanzheName=" + zhiyuanzheName +
			", zhiyuanzhePhone=" + zhiyuanzhePhone +
			", zhiyuanzheIdNumber=" + zhiyuanzheIdNumber +
			", zhiyuanzhePhoto=" + zhiyuanzhePhoto +
			", zhiyuanzheEmail=" + zhiyuanzheEmail +
			"} " + super.toString();
	}
}
