package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.HistoryStage2;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HistoryStage2DAO {
    @Insert("INSERT INTO historystage2 VALUES(#{projectID}, #{size}, #{PCPX}, #{RUSE}, #{PDIF}, #{PERS}, #{PREX}, #{FCIL}, #{SCED})")
    int insertHistoryStage2(HistoryStage2 hStage2);

    @Select("SELECT * FROM historystage2 WHERE projectID=#{hProjectID}")
    HistoryStage2 searchHistoryStage2(String hProjectID);

    @Delete("DELETE FROM historystage2 WHERE projectID=#{hProjectID}")
    int deleteHistoryStage2(String hProjectID);
}
