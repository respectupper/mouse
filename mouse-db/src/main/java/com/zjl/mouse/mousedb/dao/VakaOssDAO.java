package com.zjl.mouse.mousedb.dao;

import com.zjl.mouse.mousedb.model.VakaOss;
import com.zjl.mouse.mousedb.model.VakaOssExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VakaOssDAO {
    long countByExample(VakaOssExample example);

    int deleteByExample(VakaOssExample example);

    int deleteByPrimaryKey(Long fId);

    int insert(VakaOss record);

    int insertSelective(VakaOss record);

    List<VakaOss> selectByExample(VakaOssExample example);

    VakaOss selectByPrimaryKey(Long fId);

    int updateByExampleSelective(@Param("record") VakaOss record, @Param("example") VakaOssExample example);

    int updateByExample(@Param("record") VakaOss record, @Param("example") VakaOssExample example);

    int updateByPrimaryKeySelective(VakaOss record);

    int updateByPrimaryKey(VakaOss record);
}