package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.HistoryStage1;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HistoryStage1DAO {
    @Insert("INSERT INTO historystage1 VALUES(#{projectID}, #{size})")
    int insertHistoryStage1(HistoryStage1 hStage1);

    @Select("SELECT * FROM historystage1 WHERE projectID=#{hProjectID}")
    HistoryStage1 searchHistoryStage1(String hProjectID);

    @Delete("DELETE FROM historystage1 WHERE projectID=#{hProjectID}")
    int deleteHistoryStage1(String hProjectID);
}
