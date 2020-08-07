package ink.zfei.spring.ioc;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Device2Mapper {

    int queryStatus2(int id);
}
