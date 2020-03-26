package xyz.wadewhy.springboot_redis01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.wadewhy.springboot_redis01.base.controller.BaseController;
import xyz.wadewhy.springboot_redis01.base.utils.RedisConstants;
import xyz.wadewhy.springboot_redis01.base.utils.RedisUtil;
import xyz.wadewhy.springboot_redis01.base.utils.StateParameter;
import xyz.wadewhy.springboot_redis01.pojo.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springboot_redis01.base.controller
 * @NAME: RedisTestController
 * @Author: 钟子豪
 * @DATE: 2020/3/26
 * @MONTH_NAME_FULL: 三月
 * @DAY: 26
 * @DAY_NAME_FULL: 星期四
 * @PROJECT_NAME: springboot_redis01
 **/
@Controller
@RequestMapping("/redis")
public class RedisTestController extends BaseController {
    @Autowired
    RedisUtil redisUtil;
    @RequestMapping(value="/list")
    public String view(HttpServletRequest request, String name){
        logger.info("返回列表页面");
        return "/demoPage/listPage/"+ name;
    }

    /**
     * 测试redis存储&读取
     * @return
     */
    @RequestMapping(value="/test")
    @ResponseBody
    public ModelMap test(){
        try {
            redisUtil.set("redisTemplate","这是一条测试数据", RedisConstants.datebase2);
            String value = redisUtil.get("redisTemplate",RedisConstants.datebase2).toString();
            logger.info("redisValue="+value);
            logger.info("读取redis成功");
            return getModelMap(StateParameter.SUCCESS, value, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }
    @RequestMapping(value="/setUser")
    @ResponseBody
    public ModelMap setUser(){
        try {
            User user = new User();
            user.setName("隔壁老王");
            user.setAge(28);
            user.setId(getUuid());
            redisUtil.set("user",user, RedisConstants.datebase1);
            User res = (User)redisUtil.get("user",RedisConstants.datebase1);
            logger.info("res="+res.toString());
            logger.info("读取redis成功");
            return getModelMap(StateParameter.SUCCESS, res, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }

}
