package com.zjl.mouse.db.dao;

import com.zjl.mouse.db.model.VakaUser;
import com.zjl.mouse.db.model.VakaUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VakaUserDAO {
    long countByExample(VakaUserExample example);

    int deleteByExample(VakaUserExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(VakaUser record);

    int insertSelective(VakaUser record);

    List<VakaUser> selectByExample(VakaUserExample example);

    VakaUser selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") VakaUser record, @Param("example") VakaUserExample example);

    int updateByExample(@Param("record") VakaUser record, @Param("example") VakaUserExample example);

    int updateByPrimaryKeySelective(VakaUser record);

    int updateByPrimaryKey(VakaUser record);
}