package com.dao;

import com.entity.ShenghuoguanliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShenghuoguanliView;

/**
 * 生活信息 Dao 接口
 *
 * @author 
 */
public interface ShenghuoguanliDao extends BaseMapper<ShenghuoguanliEntity> {

   List<ShenghuoguanliView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
