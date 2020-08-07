package ink.zfei.controller;


import com.alibaba.fastjson.JSONObject;
import ink.zfei.bean.Device;
import ink.zfei.mapper.DeviceMapper;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RequestMapping("/index")
@Controller
public class IndexController     {

    @Resource
    private RedissonClient redissonClient;

//    @Resource
//    private DeviceMapper deviceMapper;

    public int num =10;

    private static String  DEMO_PRIFX = "demo_";

    @ResponseBody
    @RequestMapping(value = "/queryStatus",produces = "text/plain;charset=UTF-8")
    public String queryStatus(Integer deviceId,String name) throws CloneNotSupportedException {

        String tmp = null;

        //先从redis 查，如果不存在，则从数据库查，并塞入redis
//        RMap<Integer, Device> rmap = redissonClient.getMap(DEMO_PRIFX);
//        Device dev = rmap.get(deviceId);
//        if (dev == null)
//        {
//            dev = deviceMapper.queryDeviceOnlineStatus(deviceId);
//            rmap.put(deviceId,dev);
//        }

        String key = DEMO_PRIFX + "id";
        RMap<String, Device> devMaps = redissonClient.getMap(key);
        //查询是否在缓存
        Device dev = devMaps.get(deviceId);
        if (dev == null) {
            //缓存为空，数据库查询，并存入缓存
//            dev = deviceMapper.queryDeviceOnlineStatus(deviceId);
            devMaps.put(String.valueOf(deviceId), dev);
            //设置过期时间
            devMaps.expire(10000, TimeUnit.MILLISECONDS);
        }



        return JSONObject.toJSONString(dev);
    }

}
