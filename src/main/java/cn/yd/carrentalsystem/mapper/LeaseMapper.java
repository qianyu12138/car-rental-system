package cn.yd.carrentalsystem.mapper;

import cn.yd.carrentalsystem.po.Lease;
import cn.yd.carrentalsystem.po.LeaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeaseMapper {
    int countByExample(LeaseExample example);

    int deleteByExample(LeaseExample example);

    int deleteByPrimaryKey(Integer lid);

    int insert(Lease record);

    int insertSelective(Lease record);

    List<Lease> selectByExample(LeaseExample example);

    Lease selectByPrimaryKey(Integer lid);

    int updateByExampleSelective(@Param("record") Lease record, @Param("example") LeaseExample example);

    int updateByExample(@Param("record") Lease record, @Param("example") LeaseExample example);

    int updateByPrimaryKeySelective(Lease record);

    int updateByPrimaryKey(Lease record);
}