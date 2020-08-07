package demo;

import ink.zfei.spring.Device;

public class BeanAquire {

    private Device  device;

    public void print()
    {
        device  = (Device) SpringBeanUtil.applicationContext.getBean("deviceA");
        System.out.println(device);
    }

}
