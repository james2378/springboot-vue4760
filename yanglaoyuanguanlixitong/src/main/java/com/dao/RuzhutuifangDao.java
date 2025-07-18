package com.dao;

import com.entity.RuzhutuifangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.RuzhutuifangView;

/**
 * 入住退房信息 Dao 接口
 *
 * @author 
 */
public interface RuzhutuifangDao extends BaseMapper<RuzhutuifangEntity> {

   List<RuzhutuifangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
