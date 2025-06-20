package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YiqingfangkongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
 * 疫情防控信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yiqingfangkong")
public class YiqingfangkongView extends YiqingfangkongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 疫情防控状态类型的值
		*/
		@ColumnInfo(comment="疫情防控状态类型的字典表值",type="varchar(200)")
		private String yiqingfangkongValue;



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

	public YiqingfangkongView() {

	}

	public YiqingfangkongView(YiqingfangkongEntity yiqingfangkongEntity) {
		try {
			BeanUtils.copyProperties(this, yiqingfangkongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 疫情防控状态类型的值
			*/
			public String getYiqingfangkongValue() {
				return yiqingfangkongValue;
			}
			/**
			* 设置： 疫情防控状态类型的值
			*/
			public void setYiqingfangkongValue(String yiqingfangkongValue) {
				this.yiqingfangkongValue = yiqingfangkongValue;
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
		return "YiqingfangkongView{" +
			", yiqingfangkongValue=" + yiqingfangkongValue +
			", zhiyuanzheName=" + zhiyuanzheName +
			", zhiyuanzhePhone=" + zhiyuanzhePhone +
			", zhiyuanzheIdNumber=" + zhiyuanzheIdNumber +
			", zhiyuanzhePhoto=" + zhiyuanzhePhoto +
			", zhiyuanzheEmail=" + zhiyuanzheEmail +
			"} " + super.toString();
	}
}
