package com.dao;

import com.entity.YiqingfangkongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YiqingfangkongView;

/**
 * 疫情防控信息 Dao 接口
 *
 * @author 
 */
public interface YiqingfangkongDao extends BaseMapper<YiqingfangkongEntity> {

   List<YiqingfangkongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
