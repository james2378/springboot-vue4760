
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
 * 医疗信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yiliao")
public class YiliaoController {
    private static final Logger logger = LoggerFactory.getLogger(YiliaoController.class);

    private static final String TABLE_NAME = "yiliao";

    @Autowired
    private YiliaoService yiliaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
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
        PageUtils page = yiliaoService.queryPage(params);

        //字典表数据转换
        List<YiliaoView> list =(List<YiliaoView>)page.getList();
        for(YiliaoView c:list){
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
        YiliaoEntity yiliao = yiliaoService.selectById(id);
        if(yiliao !=null){
            //entity转view
            YiliaoView view = new YiliaoView();
            BeanUtils.copyProperties( yiliao , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(yiliao.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "zhiyuanzheId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 志愿者
            //级联表
            ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(yiliao.getZhiyuanzheId());
            if(zhiyuanzhe != null){
            BeanUtils.copyProperties( zhiyuanzhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "zhiyuanzheId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
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
    public R save(@RequestBody YiliaoEntity yiliao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yiliao:{}",this.getClass().getName(),yiliao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            yiliao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("志愿者".equals(role))
            yiliao.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YiliaoEntity> queryWrapper = new EntityWrapper<YiliaoEntity>()
            .eq("yonghu_id", yiliao.getYonghuId())
            .eq("zhiyuanzhe_id", yiliao.getZhiyuanzheId())
            .eq("yiliao_uuid_number", yiliao.getYiliaoUuidNumber())
            .eq("yiliao_name", yiliao.getYiliaoName())
            .eq("yiliao_types", yiliao.getYiliaoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YiliaoEntity yiliaoEntity = yiliaoService.selectOne(queryWrapper);
        if(yiliaoEntity==null){
            yiliao.setInsertTime(new Date());
            yiliao.setCreateTime(new Date());
            YonghuEntity yonghuEntity = yonghuService.selectById(yiliao.getYonghuId());
            double blance = yonghuEntity.getNewMoney() - yiliao.getYiliaoMoney();
            if(blance<0)
                return R.error("当前用户的账户不足以支付此次生活花费,请联系用户充值");
            yonghuEntity.setNewMoney(blance);
            yonghuService.updateById(yonghuEntity);
            yiliaoService.insert(yiliao);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YiliaoEntity yiliao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yiliao:{}",this.getClass().getName(),yiliao.toString());
        YiliaoEntity oldYiliaoEntity = yiliaoService.selectById(yiliao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            yiliao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("志愿者".equals(role))
//            yiliao.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<YiliaoEntity> queryWrapper = new EntityWrapper<YiliaoEntity>()
            .notIn("id",yiliao.getId())
            .andNew()
            .eq("yonghu_id", yiliao.getYonghuId())
            .eq("zhiyuanzhe_id", yiliao.getZhiyuanzheId())
            .eq("yiliao_uuid_number", yiliao.getYiliaoUuidNumber())
            .eq("yiliao_name", yiliao.getYiliaoName())
            .eq("yiliao_types", yiliao.getYiliaoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YiliaoEntity yiliaoEntity = yiliaoService.selectOne(queryWrapper);
        if(yiliaoEntity==null){
            yiliaoService.updateById(yiliao);//根据id更新
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
        List<YiliaoEntity> oldYiliaoList =yiliaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yiliaoService.deleteBatchIds(Arrays.asList(ids));

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
            List<YiliaoEntity> yiliaoList = new ArrayList<>();//上传的东西
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
                            YiliaoEntity yiliaoEntity = new YiliaoEntity();
//                            yiliaoEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            yiliaoEntity.setZhiyuanzheId(Integer.valueOf(data.get(0)));   //志愿者 要改的
//                            yiliaoEntity.setYiliaoUuidNumber(data.get(0));                    //医疗管理编号 要改的
//                            yiliaoEntity.setYiliaoName(data.get(0));                    //医疗管理名称 要改的
//                            yiliaoEntity.setYiliaoTypes(Integer.valueOf(data.get(0)));   //医疗类型 要改的
//                            yiliaoEntity.setYiliaoMoney(data.get(0));                    //花费金额 要改的
//                            yiliaoEntity.setYiliaoContent("");//详情和图片
//                            yiliaoEntity.setCaozuoTime(sdf.parse(data.get(0)));          //操作时间 要改的
//                            yiliaoEntity.setInsertTime(date);//时间
//                            yiliaoEntity.setCreateTime(date);//时间
                            yiliaoList.add(yiliaoEntity);


                            //把要查询是否重复的字段放入map中
                                //医疗管理编号
                                if(seachFields.containsKey("yiliaoUuidNumber")){
                                    List<String> yiliaoUuidNumber = seachFields.get("yiliaoUuidNumber");
                                    yiliaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yiliaoUuidNumber = new ArrayList<>();
                                    yiliaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yiliaoUuidNumber",yiliaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //医疗管理编号
                        List<YiliaoEntity> yiliaoEntities_yiliaoUuidNumber = yiliaoService.selectList(new EntityWrapper<YiliaoEntity>().in("yiliao_uuid_number", seachFields.get("yiliaoUuidNumber")));
                        if(yiliaoEntities_yiliaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YiliaoEntity s:yiliaoEntities_yiliaoUuidNumber){
                                repeatFields.add(s.getYiliaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [医疗管理编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yiliaoService.insertBatch(yiliaoList);
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
        PageUtils page = yiliaoService.queryPage(params);

        //字典表数据转换
        List<YiliaoView> list =(List<YiliaoView>)page.getList();
        for(YiliaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YiliaoEntity yiliao = yiliaoService.selectById(id);
            if(yiliao !=null){


                //entity转view
                YiliaoView view = new YiliaoView();
                BeanUtils.copyProperties( yiliao , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(yiliao.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(yiliao.getZhiyuanzheId());
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
    public R add(@RequestBody YiliaoEntity yiliao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yiliao:{}",this.getClass().getName(),yiliao.toString());
        Wrapper<YiliaoEntity> queryWrapper = new EntityWrapper<YiliaoEntity>()
            .eq("yonghu_id", yiliao.getYonghuId())
            .eq("zhiyuanzhe_id", yiliao.getZhiyuanzheId())
            .eq("yiliao_uuid_number", yiliao.getYiliaoUuidNumber())
            .eq("yiliao_name", yiliao.getYiliaoName())
            .eq("yiliao_types", yiliao.getYiliaoTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YiliaoEntity yiliaoEntity = yiliaoService.selectOne(queryWrapper);
        if(yiliaoEntity==null){
            yiliao.setInsertTime(new Date());
            yiliao.setCreateTime(new Date());
        yiliaoService.insert(yiliao);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
