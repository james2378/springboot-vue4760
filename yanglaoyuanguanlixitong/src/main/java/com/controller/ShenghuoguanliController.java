
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
 * 生活信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shenghuoguanli")
public class ShenghuoguanliController {
    private static final Logger logger = LoggerFactory.getLogger(ShenghuoguanliController.class);

    private static final String TABLE_NAME = "shenghuoguanli";

    @Autowired
    private ShenghuoguanliService shenghuoguanliService;


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
        PageUtils page = shenghuoguanliService.queryPage(params);

        //字典表数据转换
        List<ShenghuoguanliView> list =(List<ShenghuoguanliView>)page.getList();
        for(ShenghuoguanliView c:list){
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
        ShenghuoguanliEntity shenghuoguanli = shenghuoguanliService.selectById(id);
        if(shenghuoguanli !=null){
            //entity转view
            ShenghuoguanliView view = new ShenghuoguanliView();
            BeanUtils.copyProperties( shenghuoguanli , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shenghuoguanli.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "zhiyuanzheId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 志愿者
            //级联表
            ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(shenghuoguanli.getZhiyuanzheId());
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
    public R save(@RequestBody ShenghuoguanliEntity shenghuoguanli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shenghuoguanli:{}",this.getClass().getName(),shenghuoguanli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shenghuoguanli.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("志愿者".equals(role))
            shenghuoguanli.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShenghuoguanliEntity> queryWrapper = new EntityWrapper<ShenghuoguanliEntity>()
            .eq("yonghu_id", shenghuoguanli.getYonghuId())
            .eq("zhiyuanzhe_id", shenghuoguanli.getZhiyuanzheId())
            .eq("shenghuoguanli_uuid_number", shenghuoguanli.getShenghuoguanliUuidNumber())
            .eq("shenghuoguanli_name", shenghuoguanli.getShenghuoguanliName())
            .eq("shenghuoguanli_types", shenghuoguanli.getShenghuoguanliTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShenghuoguanliEntity shenghuoguanliEntity = shenghuoguanliService.selectOne(queryWrapper);
        if(shenghuoguanliEntity==null){
            shenghuoguanli.setInsertTime(new Date());
            shenghuoguanli.setCreateTime(new Date());
            YonghuEntity yonghuEntity = yonghuService.selectById(shenghuoguanli.getYonghuId());
            double blance = yonghuEntity.getNewMoney() - shenghuoguanli.getHuafeiMoney();
            if(blance<0)
                return R.error("当前用户的账户不足以支付此次生活花费,请联系用户充值");
            yonghuEntity.setNewMoney(blance);
            yonghuService.updateById(yonghuEntity);
            shenghuoguanliService.insert(shenghuoguanli);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShenghuoguanliEntity shenghuoguanli, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shenghuoguanli:{}",this.getClass().getName(),shenghuoguanli.toString());
        ShenghuoguanliEntity oldShenghuoguanliEntity = shenghuoguanliService.selectById(shenghuoguanli.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shenghuoguanli.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("志愿者".equals(role))
//            shenghuoguanli.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShenghuoguanliEntity> queryWrapper = new EntityWrapper<ShenghuoguanliEntity>()
            .notIn("id",shenghuoguanli.getId())
            .andNew()
            .eq("yonghu_id", shenghuoguanli.getYonghuId())
            .eq("zhiyuanzhe_id", shenghuoguanli.getZhiyuanzheId())
            .eq("shenghuoguanli_uuid_number", shenghuoguanli.getShenghuoguanliUuidNumber())
            .eq("shenghuoguanli_name", shenghuoguanli.getShenghuoguanliName())
            .eq("shenghuoguanli_types", shenghuoguanli.getShenghuoguanliTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShenghuoguanliEntity shenghuoguanliEntity = shenghuoguanliService.selectOne(queryWrapper);
        if(shenghuoguanliEntity==null){
            shenghuoguanliService.updateById(shenghuoguanli);//根据id更新
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
        List<ShenghuoguanliEntity> oldShenghuoguanliList =shenghuoguanliService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shenghuoguanliService.deleteBatchIds(Arrays.asList(ids));

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
            List<ShenghuoguanliEntity> shenghuoguanliList = new ArrayList<>();//上传的东西
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
                            ShenghuoguanliEntity shenghuoguanliEntity = new ShenghuoguanliEntity();
//                            shenghuoguanliEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shenghuoguanliEntity.setZhiyuanzheId(Integer.valueOf(data.get(0)));   //志愿者 要改的
//                            shenghuoguanliEntity.setShenghuoguanliUuidNumber(data.get(0));                    //生活管理编号 要改的
//                            shenghuoguanliEntity.setShenghuoguanliName(data.get(0));                    //生活管理名称 要改的
//                            shenghuoguanliEntity.setShenghuoguanliTypes(Integer.valueOf(data.get(0)));   //生活管理类型 要改的
//                            shenghuoguanliEntity.setHuafeiMoney(data.get(0));                    //花费金额 要改的
//                            shenghuoguanliEntity.setShenghuoguanliContent("");//详情和图片
//                            shenghuoguanliEntity.setZhixingTime(sdf.parse(data.get(0)));          //执行时间 要改的
//                            shenghuoguanliEntity.setInsertTime(date);//时间
//                            shenghuoguanliEntity.setCreateTime(date);//时间
                            shenghuoguanliList.add(shenghuoguanliEntity);


                            //把要查询是否重复的字段放入map中
                                //生活管理编号
                                if(seachFields.containsKey("shenghuoguanliUuidNumber")){
                                    List<String> shenghuoguanliUuidNumber = seachFields.get("shenghuoguanliUuidNumber");
                                    shenghuoguanliUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shenghuoguanliUuidNumber = new ArrayList<>();
                                    shenghuoguanliUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shenghuoguanliUuidNumber",shenghuoguanliUuidNumber);
                                }
                        }

                        //查询是否重复
                         //生活管理编号
                        List<ShenghuoguanliEntity> shenghuoguanliEntities_shenghuoguanliUuidNumber = shenghuoguanliService.selectList(new EntityWrapper<ShenghuoguanliEntity>().in("shenghuoguanli_uuid_number", seachFields.get("shenghuoguanliUuidNumber")));
                        if(shenghuoguanliEntities_shenghuoguanliUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShenghuoguanliEntity s:shenghuoguanliEntities_shenghuoguanliUuidNumber){
                                repeatFields.add(s.getShenghuoguanliUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [生活管理编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shenghuoguanliService.insertBatch(shenghuoguanliList);
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
        PageUtils page = shenghuoguanliService.queryPage(params);

        //字典表数据转换
        List<ShenghuoguanliView> list =(List<ShenghuoguanliView>)page.getList();
        for(ShenghuoguanliView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShenghuoguanliEntity shenghuoguanli = shenghuoguanliService.selectById(id);
            if(shenghuoguanli !=null){


                //entity转view
                ShenghuoguanliView view = new ShenghuoguanliView();
                BeanUtils.copyProperties( shenghuoguanli , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shenghuoguanli.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(shenghuoguanli.getZhiyuanzheId());
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
    public R add(@RequestBody ShenghuoguanliEntity shenghuoguanli, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shenghuoguanli:{}",this.getClass().getName(),shenghuoguanli.toString());
        Wrapper<ShenghuoguanliEntity> queryWrapper = new EntityWrapper<ShenghuoguanliEntity>()
            .eq("yonghu_id", shenghuoguanli.getYonghuId())
            .eq("zhiyuanzhe_id", shenghuoguanli.getZhiyuanzheId())
            .eq("shenghuoguanli_uuid_number", shenghuoguanli.getShenghuoguanliUuidNumber())
            .eq("shenghuoguanli_name", shenghuoguanli.getShenghuoguanliName())
            .eq("shenghuoguanli_types", shenghuoguanli.getShenghuoguanliTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShenghuoguanliEntity shenghuoguanliEntity = shenghuoguanliService.selectOne(queryWrapper);
        if(shenghuoguanliEntity==null){
            shenghuoguanli.setInsertTime(new Date());
            shenghuoguanli.setCreateTime(new Date());
        shenghuoguanliService.insert(shenghuoguanli);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
