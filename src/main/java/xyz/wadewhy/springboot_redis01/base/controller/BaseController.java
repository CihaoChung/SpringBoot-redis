package xyz.wadewhy.springboot_redis01.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import xyz.wadewhy.springboot_redis01.base.utils.StateParameter;

import java.util.UUID;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springboot_redis01.base.controller
 * @NAME: BaseController
 * @Author: 钟子豪
 * @DATE: 2020/3/26
 * @MONTH_NAME_FULL: 三月
 * @DAY: 26
 * @DAY_NAME_FULL: 星期四
 * @PROJECT_NAME: springboot_redis01
 **/
public abstract class BaseController {
    protected final String success = StateParameter.SUCCESS;
    protected final String  fail = StateParameter.FAULT;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ModelMap getModelMap(String status, Object data, String msg){
        ModelMap modelMap=new ModelMap();
        modelMap.put("status", status);
        modelMap.put("data", data);
        modelMap.put("msg", msg);
        return modelMap;

    }

    public String getUuid(){
        String uuid = UUID.randomUUID().toString(); //获取UUID并转化为String对象
        uuid = uuid.replace("-", "");
        return uuid;
    }
}
