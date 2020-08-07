package ink.zfei.mapper;

import ink.zfei.bean.Device;

public abstract class AbstractDeviceMapper implements  DeviceMapper{


   public abstract Device queryDeviceOnlineStatus(int deviceId);

   public abstract Device queryDeviceOnlineStatus1(int deviceId);
}
