package com.biaoche.server.dao.dao;

import com.biaoche.server.pojo.entity.OperUsers;
import com.biaoche.server.pojo.entity.OperUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperUsersMapper {
    long countByExample(OperUsersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperUsers record);

    int insertSelective(OperUsers record);

    List<OperUsers> selectByExample(OperUsersExample example);

    OperUsers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperUsers record, @Param("example") OperUsersExample example);

    int updateByExample(@Param("record") OperUsers record, @Param("example") OperUsersExample example);

    int updateByPrimaryKeySelective(OperUsers record);

    int updateByPrimaryKey(OperUsers record);
}