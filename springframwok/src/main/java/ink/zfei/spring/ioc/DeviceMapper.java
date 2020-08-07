package ink.zfei.spring.ioc;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface DeviceMapper {


    @Transactional
    int queryStatus(int id);
}
