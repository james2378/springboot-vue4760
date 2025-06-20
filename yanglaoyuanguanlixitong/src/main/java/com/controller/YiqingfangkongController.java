
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 疫情防控信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yiqingfangkong")
public class YiqingfangkongController {
    private static final Logger logger = LoggerFactory.getLogger(YiqingfangkongController.class);

    private static final String TABLE_NAME = "yiqingfangkong";

    @Autowired
    private YiqingfangkongService yiqingfangkongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ZhiyuanzheService zhiyuanzheService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("志愿者".equals(role))
            params.put("zhiyuanzheId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = yiqingfangkongService.queryPage(params);

        //字典表数据转换
        List<YiqingfangkongView> list =(List<YiqingfangkongView>)page.getList();
        for(YiqingfangkongView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YiqingfangkongEntity yiqingfangkong = yiqingfangkongService.selectById(id);
        if(yiqingfangkong !=null){
            //entity转view
            YiqingfangkongView view = new YiqingfangkongView();
            BeanUtils.copyProperties( yiqingfangkong , view );//把实体数据重构到view中
            //级联表 志愿者
            //级联表
            ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(yiqingfangkong.getZhiyuanzheId());
            if(zhiyuanzhe != null){
            BeanUtils.copyProperties( zhiyuanzhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhiyuanzheId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZhiyuanzheId(zhiyuanzhe.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YiqingfangkongEntity yiqingfangkong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yiqingfangkong:{}",this.getClass().getName(),yiqingfangkong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("志愿者".equals(role))
            yiqingfangkong.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YiqingfangkongEntity> queryWrapper = new EntityWrapper<YiqingfangkongEntity>()
            .eq("zhiyuanzhe_id", yiqingfangkong.getZhiyuanzheId())
            .eq("yiqingfangkong_uuid_number", yiqingfangkong.getYiqingfangkongUuidNumber())
            .eq("yiqingfangkong_name", yiqingfangkong.getYiqingfangkongName())
            .eq("yiqingfangkong_types", yiqingfangkong.getYiqingfangkongTypes())
            .eq("quezhenrenshu", yiqingfangkong.getQuezhenrenshu())
            .eq("mijierenshu", yiqingfangkong.getMijierenshu())
            .eq("suoshu_time", new SimpleDateFormat("yyyy-MM-dd").format(yiqingfangkong.getSuoshuTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YiqingfangkongEntity yiqingfangkongEntity = yiqingfangkongService.selectOne(queryWrapper);
        if(yiqingfangkongEntity==null){
            yiqingfangkong.setInsertTime(new Date());
            yiqingfangkong.setCreateTime(new Date());
            yiqingfangkongService.insert(yiqingfangkong);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YiqingfangkongEntity yiqingfangkong, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yiqingfangkong:{}",this.getClass().getName(),yiqingfangkong.toString());
        YiqingfangkongEntity oldYiqingfangkongEntity = yiqingfangkongService.selectById(yiqingfangkong.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("志愿者".equals(role))
//            yiqingfangkong.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<YiqingfangkongEntity> queryWrapper = new EntityWrapper<YiqingfangkongEntity>()
            .notIn("id",yiqingfangkong.getId())
            .andNew()
            .eq("zhiyuanzhe_id", yiqingfangkong.getZhiyuanzheId())
            .eq("yiqingfangkong_uuid_number", yiqingfangkong.getYiqingfangkongUuidNumber())
            .eq("yiqingfangkong_name", yiqingfangkong.getYiqingfangkongName())
            .eq("yiqingfangkong_types", yiqingfangkong.getYiqingfangkongTypes())
            .eq("quezhenrenshu", yiqingfangkong.getQuezhenrenshu())
            .eq("mijierenshu", yiqingfangkong.getMijierenshu())
            .eq("suoshu_time", new SimpleDateFormat("yyyy-MM-dd").format(yiqingfangkong.getSuoshuTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YiqingfangkongEntity yiqingfangkongEntity = yiqingfangkongService.selectOne(queryWrapper);
        if(yiqingfangkongEntity==null){
            yiqingfangkongService.updateById(yiqingfangkong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YiqingfangkongEntity> oldYiqingfangkongList =yiqingfangkongService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yiqingfangkongService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<YiqingfangkongEntity> yiqingfangkongList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YiqingfangkongEntity yiqingfangkongEntity = new YiqingfangkongEntity();
//                            yiqingfangkongEntity.setZhiyuanzheId(Integer.valueOf(data.get(0)));   //志愿者 要改的
//                            yiqingfangkongEntity.setYiqingfangkongUuidNumber(data.get(0));                    //疫情防控编号 要改的
//                            yiqingfangkongEntity.setYiqingfangkongName(data.get(0));                    //疫情防控名称 要改的
//                            yiqingfangkongEntity.setYiqingfangkongTypes(Integer.valueOf(data.get(0)));   //疫情防控状态类型 要改的
//                            yiqingfangkongEntity.setQuezhenrenshu(Integer.valueOf(data.get(0)));   //确诊人数 要改的
//                            yiqingfangkongEntity.setMijierenshu(Integer.valueOf(data.get(0)));   //密接人数 要改的
//                            yiqingfangkongEntity.setYiqingfangkongContent("");//详情和图片
//                            yiqingfangkongEntity.setSuoshuTime(sdf.parse(data.get(0)));          //所属日期 要改的
//                            yiqingfangkongEntity.setInsertTime(date);//时间
//                            yiqingfangkongEntity.setCreateTime(date);//时间
                            yiqingfangkongList.add(yiqingfangkongEntity);


                            //把要查询是否重复的字段放入map中
                                //疫情防控编号
                                if(seachFields.containsKey("yiqingfangkongUuidNumber")){
                                    List<String> yiqingfangkongUuidNumber = seachFields.get("yiqingfangkongUuidNumber");
                                    yiqingfangkongUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yiqingfangkongUuidNumber = new ArrayList<>();
                                    yiqingfangkongUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yiqingfangkongUuidNumber",yiqingfangkongUuidNumber);
                                }
                        }

                        //查询是否重复
                         //疫情防控编号
                        List<YiqingfangkongEntity> yiqingfangkongEntities_yiqingfangkongUuidNumber = yiqingfangkongService.selectList(new EntityWrapper<YiqingfangkongEntity>().in("yiqingfangkong_uuid_number", seachFields.get("yiqingfangkongUuidNumber")));
                        if(yiqingfangkongEntities_yiqingfangkongUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YiqingfangkongEntity s:yiqingfangkongEntities_yiqingfangkongUuidNumber){
                                repeatFields.add(s.getYiqingfangkongUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [疫情防控编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yiqingfangkongService.insertBatch(yiqingfangkongList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = yiqingfangkongService.queryPage(params);

        //字典表数据转换
        List<YiqingfangkongView> list =(List<YiqingfangkongView>)page.getList();
        for(YiqingfangkongView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YiqingfangkongEntity yiqingfangkong = yiqingfangkongService.selectById(id);
            if(yiqingfangkong !=null){


                //entity转view
                YiqingfangkongView view = new YiqingfangkongView();
                BeanUtils.copyProperties( yiqingfangkong , view );//把实体数据重构到view中

                //级联表
                    ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(yiqingfangkong.getZhiyuanzheId());
                if(zhiyuanzhe != null){
                    BeanUtils.copyProperties( zhiyuanzhe , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhiyuanzheId(zhiyuanzhe.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody YiqingfangkongEntity yiqingfangkong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yiqingfangkong:{}",this.getClass().getName(),yiqingfangkong.toString());
        Wrapper<YiqingfangkongEntity> queryWrapper = new EntityWrapper<YiqingfangkongEntity>()
            .eq("zhiyuanzhe_id", yiqingfangkong.getZhiyuanzheId())
            .eq("yiqingfangkong_uuid_number", yiqingfangkong.getYiqingfangkongUuidNumber())
            .eq("yiqingfangkong_name", yiqingfangkong.getYiqingfangkongName())
            .eq("yiqingfangkong_types", yiqingfangkong.getYiqingfangkongTypes())
            .eq("quezhenrenshu", yiqingfangkong.getQuezhenrenshu())
            .eq("mijierenshu", yiqingfangkong.getMijierenshu())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YiqingfangkongEntity yiqingfangkongEntity = yiqingfangkongService.selectOne(queryWrapper);
        if(yiqingfangkongEntity==null){
            yiqingfangkong.setInsertTime(new Date());
            yiqingfangkong.setCreateTime(new Date());
        yiqingfangkongService.insert(yiqingfangkong);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
