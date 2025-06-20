
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
 * 入住退房信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/ruzhutuifang")
public class RuzhutuifangController {
    private static final Logger logger = LoggerFactory.getLogger(RuzhutuifangController.class);

    private static final String TABLE_NAME = "ruzhutuifang";

    @Autowired
    private RuzhutuifangService ruzhutuifangService;


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
        PageUtils page = ruzhutuifangService.queryPage(params);

        //字典表数据转换
        List<RuzhutuifangView> list =(List<RuzhutuifangView>)page.getList();
        for(RuzhutuifangView c:list){
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
        RuzhutuifangEntity ruzhutuifang = ruzhutuifangService.selectById(id);
        if(ruzhutuifang !=null){
            //entity转view
            RuzhutuifangView view = new RuzhutuifangView();
            BeanUtils.copyProperties( ruzhutuifang , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(ruzhutuifang.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "zhiyuanzheId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 志愿者
            //级联表
            ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(ruzhutuifang.getZhiyuanzheId());
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
    public R save(@RequestBody RuzhutuifangEntity ruzhutuifang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,ruzhutuifang:{}",this.getClass().getName(),ruzhutuifang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            ruzhutuifang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("志愿者".equals(role))
            ruzhutuifang.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        ruzhutuifang.setRuzhutuifangTypes(1);

        Wrapper<RuzhutuifangEntity> queryWrapper = new EntityWrapper<RuzhutuifangEntity>()
            .eq("yonghu_id", ruzhutuifang.getYonghuId())
            .eq("zhiyuanzhe_id", ruzhutuifang.getZhiyuanzheId())
            .eq("ruzhutuifang_uuid_number", ruzhutuifang.getRuzhutuifangUuidNumber())
            .eq("fangwu_name", ruzhutuifang.getFangwuName())
            .eq("fangwu_address", ruzhutuifang.getFangwuAddress())
            .eq("ruzhutuifang_types", ruzhutuifang.getRuzhutuifangTypes())
            .eq("ruzhu_time", new SimpleDateFormat("yyyy-MM-dd").format(ruzhutuifang.getRuzhuTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RuzhutuifangEntity ruzhutuifangEntity = ruzhutuifangService.selectOne(queryWrapper);
        if(ruzhutuifangEntity==null){
            ruzhutuifang.setInsertTime(new Date());
            ruzhutuifang.setCreateTime(new Date());
            ruzhutuifangService.insert(ruzhutuifang);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody RuzhutuifangEntity ruzhutuifang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,ruzhutuifang:{}",this.getClass().getName(),ruzhutuifang.toString());
        RuzhutuifangEntity oldRuzhutuifangEntity = ruzhutuifangService.selectById(ruzhutuifang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            ruzhutuifang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("志愿者".equals(role))
//            ruzhutuifang.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<RuzhutuifangEntity> queryWrapper = new EntityWrapper<RuzhutuifangEntity>()
            .notIn("id",ruzhutuifang.getId())
            .andNew()
            .eq("yonghu_id", ruzhutuifang.getYonghuId())
            .eq("zhiyuanzhe_id", ruzhutuifang.getZhiyuanzheId())
            .eq("ruzhutuifang_uuid_number", ruzhutuifang.getRuzhutuifangUuidNumber())
            .eq("fangwu_name", ruzhutuifang.getFangwuName())
            .eq("fangwu_address", ruzhutuifang.getFangwuAddress())
            .eq("ruzhutuifang_types", ruzhutuifang.getRuzhutuifangTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RuzhutuifangEntity ruzhutuifangEntity = ruzhutuifangService.selectOne(queryWrapper);
        if(ruzhutuifangEntity==null){
            if(ruzhutuifang.getRuzhutuifangTypes() ==2){
                long l = ruzhutuifang.getTuifangTime().getTime() - ruzhutuifang.getRuzhuTime().getTime();
                long tian = l / (1000 * 60 * 60 * 24);
                ruzhutuifang.setFangwuZonghuafei(tian*ruzhutuifang.getFangwuDanjia());

                YonghuEntity tempYonghu = yonghuService.selectById(ruzhutuifang.getYonghuId());
                if(tempYonghu.getNewMoney()-ruzhutuifang.getFangwuZonghuafei()<0){
                    return R.error("当前支付账户余额不够支付这次住宿花费,请让他充值,要消费金额为"+ruzhutuifang.getFangwuZonghuafei());
                }

                YonghuEntity oldYonghu = yonghuService.selectById(oldRuzhutuifangEntity.getYonghuId());
                oldYonghu.setNewMoney(oldRuzhutuifangEntity.getFangwuZonghuafei()+oldYonghu.getNewMoney());
                yonghuService.updateById(oldYonghu);

                YonghuEntity newYonghu = yonghuService.selectById(ruzhutuifang.getYonghuId());
                newYonghu.setNewMoney(newYonghu.getNewMoney()-ruzhutuifang.getFangwuZonghuafei());
                yonghuService.updateById(newYonghu);

            }
            ruzhutuifangService.updateById(ruzhutuifang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
     * 后端修改
     */
    @RequestMapping("/tuifang")
    public R tuifang(@RequestBody RuzhutuifangEntity ruzhutuifang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,ruzhutuifang:{}",this.getClass().getName(),ruzhutuifang.toString());
        RuzhutuifangEntity ruzhutuifangEntity = ruzhutuifangService.selectById(ruzhutuifang.getId());
        if(ruzhutuifangEntity==null){
            return R.error("查不到入住信息,无法退房");
        }else if(ruzhutuifangEntity.getRuzhutuifangTypes()!=1){
            return R.error("状态不为入住");
        }else if(ruzhutuifangEntity.getRuzhuTime() == null){
            return R.error("入住时间不能为空,请去数据库中核实");
        }else if(ruzhutuifang.getTuifangTime() == null){
            return R.error("退房时间不能为空");
        }else if(ruzhutuifang.getTuifangTime().getTime()<=ruzhutuifangEntity.getRuzhuTime().getTime()){
            return R.error("退房时间不能小于入住时间");
        }else{
            ruzhutuifangEntity.setTuifangTime(ruzhutuifang.getTuifangTime());
            ruzhutuifangEntity.setRuzhutuifangTypes(2);
            long l = ruzhutuifangEntity.getTuifangTime().getTime() - ruzhutuifangEntity.getRuzhuTime().getTime();
            long tian = l / (1000 * 60 * 60 * 24);
            ruzhutuifangEntity.setFangwuZonghuafei(ruzhutuifangEntity.getFangwuDanjia()*tian);
            YonghuEntity yonghuEntity = yonghuService.selectById(ruzhutuifangEntity.getYonghuId());
            if(yonghuEntity.getNewMoney()-ruzhutuifangEntity.getFangwuZonghuafei()<0){
                return R.error("总花费金额为"+ruzhutuifangEntity.getFangwuZonghuafei()+"大于入住用户的账户总额,请让他充值再退房");
            }
            yonghuEntity.setNewMoney(yonghuEntity.getNewMoney()-ruzhutuifangEntity.getFangwuZonghuafei());
            yonghuService.updateById(yonghuEntity);
            ruzhutuifangService.updateById(ruzhutuifangEntity);
            return R.ok();
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<RuzhutuifangEntity> oldRuzhutuifangList =ruzhutuifangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ruzhutuifangService.deleteBatchIds(Arrays.asList(ids));

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
            List<RuzhutuifangEntity> ruzhutuifangList = new ArrayList<>();//上传的东西
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
                            RuzhutuifangEntity ruzhutuifangEntity = new RuzhutuifangEntity();
//                            ruzhutuifangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            ruzhutuifangEntity.setZhiyuanzheId(Integer.valueOf(data.get(0)));   //志愿者 要改的
//                            ruzhutuifangEntity.setRuzhutuifangUuidNumber(data.get(0));                    //入住退房信息编号 要改的
//                            ruzhutuifangEntity.setFangwuName(data.get(0));                    //房屋名称 要改的
//                            ruzhutuifangEntity.setFangwuAddress(data.get(0));                    //房屋位置 要改的
//                            ruzhutuifangEntity.setFangwuDanjia(data.get(0));                    //房屋单价/天 要改的
//                            ruzhutuifangEntity.setRuzhutuifangTypes(Integer.valueOf(data.get(0)));   //入住状态 要改的
//                            ruzhutuifangEntity.setRuzhuTime(sdf.parse(data.get(0)));          //入住时间 要改的
//                            ruzhutuifangEntity.setTuifangTime(sdf.parse(data.get(0)));          //退房时间 要改的
//                            ruzhutuifangEntity.setFangwuZonghuafei(data.get(0));                    //总花费 要改的
//                            ruzhutuifangEntity.setRuzhutuifangContent("");//详情和图片
//                            ruzhutuifangEntity.setInsertTime(date);//时间
//                            ruzhutuifangEntity.setCreateTime(date);//时间
                            ruzhutuifangList.add(ruzhutuifangEntity);


                            //把要查询是否重复的字段放入map中
                                //入住退房信息编号
                                if(seachFields.containsKey("ruzhutuifangUuidNumber")){
                                    List<String> ruzhutuifangUuidNumber = seachFields.get("ruzhutuifangUuidNumber");
                                    ruzhutuifangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> ruzhutuifangUuidNumber = new ArrayList<>();
                                    ruzhutuifangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("ruzhutuifangUuidNumber",ruzhutuifangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //入住退房信息编号
                        List<RuzhutuifangEntity> ruzhutuifangEntities_ruzhutuifangUuidNumber = ruzhutuifangService.selectList(new EntityWrapper<RuzhutuifangEntity>().in("ruzhutuifang_uuid_number", seachFields.get("ruzhutuifangUuidNumber")));
                        if(ruzhutuifangEntities_ruzhutuifangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(RuzhutuifangEntity s:ruzhutuifangEntities_ruzhutuifangUuidNumber){
                                repeatFields.add(s.getRuzhutuifangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [入住退房信息编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        ruzhutuifangService.insertBatch(ruzhutuifangList);
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
        PageUtils page = ruzhutuifangService.queryPage(params);

        //字典表数据转换
        List<RuzhutuifangView> list =(List<RuzhutuifangView>)page.getList();
        for(RuzhutuifangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        RuzhutuifangEntity ruzhutuifang = ruzhutuifangService.selectById(id);
            if(ruzhutuifang !=null){


                //entity转view
                RuzhutuifangView view = new RuzhutuifangView();
                BeanUtils.copyProperties( ruzhutuifang , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(ruzhutuifang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(ruzhutuifang.getZhiyuanzheId());
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
    public R add(@RequestBody RuzhutuifangEntity ruzhutuifang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,ruzhutuifang:{}",this.getClass().getName(),ruzhutuifang.toString());
        Wrapper<RuzhutuifangEntity> queryWrapper = new EntityWrapper<RuzhutuifangEntity>()
            .eq("yonghu_id", ruzhutuifang.getYonghuId())
            .eq("zhiyuanzhe_id", ruzhutuifang.getZhiyuanzheId())
            .eq("ruzhutuifang_uuid_number", ruzhutuifang.getRuzhutuifangUuidNumber())
            .eq("fangwu_name", ruzhutuifang.getFangwuName())
            .eq("fangwu_address", ruzhutuifang.getFangwuAddress())
            .eq("ruzhutuifang_types", ruzhutuifang.getRuzhutuifangTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RuzhutuifangEntity ruzhutuifangEntity = ruzhutuifangService.selectOne(queryWrapper);
        if(ruzhutuifangEntity==null){
            ruzhutuifang.setInsertTime(new Date());
            ruzhutuifang.setCreateTime(new Date());
        ruzhutuifangService.insert(ruzhutuifang);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
