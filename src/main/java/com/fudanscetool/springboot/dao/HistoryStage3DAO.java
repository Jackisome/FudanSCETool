package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.HistoryStage3;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HistoryStage3DAO {
    @Insert("INSERT INTO historystage3 VALUES(#{projectID}, #{size}, #{RELY}, #{DATA}, #{DOCU}, #{CPLX}, #{RUSE}, #{ACAP}, #{AEXP}, #{PCAP}, #{PEXP}, #{LTEX}, #{PCON}, #{TIME}, #{STOR}, #{PVOL}, #{TOOL}, #{SCED}, #{SITE})")
    int insertHistoryStage3(HistoryStage3 hStage3);

    @Select("SELECT * FROM historystage3 WHERE projectID=#{hProjectID}")
    HistoryStage3 searchHistoryStage3(String hProjectID);

    @Delete("DELETE FROM historystage3 WHERE projectID=#{hProjectID}")
    int deleteHistoryStage3(String hProjectID);
}
