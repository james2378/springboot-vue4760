package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhiyuanzheEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
 * 志愿者
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhiyuanzhe")
public class ZhiyuanzheView extends ZhiyuanzheEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 性别的值
		*/
		@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
		private String sexValue;



	public ZhiyuanzheView() {

	}

	public ZhiyuanzheView(ZhiyuanzheEntity zhiyuanzheEntity) {
		try {
			BeanUtils.copyProperties(this, zhiyuanzheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}


















	@Override
	public String toString() {
		return "ZhiyuanzheView{" +
			", sexValue=" + sexValue +
			"} " + super.toString();
	}
}
