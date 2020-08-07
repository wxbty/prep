package ink.zfei.mapper;

import ink.zfei.bean.Device;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceMapper {

    Device queryDeviceOnlineStatus(int deviceId);

}
