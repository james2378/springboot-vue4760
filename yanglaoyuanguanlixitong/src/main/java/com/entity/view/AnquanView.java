package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.AnquanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
 * 安全
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("anquan")
public class AnquanView extends AnquanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 巡检类型的值
		*/
		@ColumnInfo(comment="巡检类型的字典表值",type="varchar(200)")
		private String anquanValue;



	public AnquanView() {

	}

	public AnquanView(AnquanEntity anquanEntity) {
		try {
			BeanUtils.copyProperties(this, anquanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 巡检类型的值
			*/
			public String getAnquanValue() {
				return anquanValue;
			}
			/**
			* 设置： 巡检类型的值
			*/
			public void setAnquanValue(String anquanValue) {
				this.anquanValue = anquanValue;
			}


















	@Override
	public String toString() {
		return "AnquanView{" +
			", anquanValue=" + anquanValue +
			"} " + super.toString();
	}
}
