package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.Stage3;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface Stage3DAO {
    @Insert("INSERT INTO stage3 VALUES(#{projectID}, #{size}, #{RELY}, #{DATA}, #{DOCU}, #{CPLX}, #{RUSE}, #{ACAP}, #{AEXP}, #{PCAP}, #{PEXP}, #{LTEX}, #{PCON}, #{TIME}, #{STOR}, #{PVOL}, #{TOOL}, #{SCED}, #{SITE}, #{estimateLoad})")
    int insertStage3(Stage3 stage3);

    @Select("SELECT * FROM stage3 WHERE projectID=#{projectID}")
    Stage3 searchStage3(String projectID);

    @Delete("DELETE FROM stage3 WHERE projectID=#{projectID}")
    int deleteStage3(String projectID);

    @Update("UPDATE stage3 SET size=#{size}, RELY=#{RELY}, DATA=#{DATA}, DOCU=#{DOCU}, CPLX=#{CPLX}, RUSE=#{RUSE}, ACAP=#{ACAP}, AEXP=#{AEXP}, PCAP=#{PCAP}, PEXP=#{PEXP}, LTEX=#{LTEX}, PCON=#{PCON}, TIME=#{TIME}, STOR=#{STOR}, PVOL=#{PVOL}, TOOL=#{TOOL}, SCED=#{SCED}, SITE=#{SITE}, estimateLoad=#{estimateLoad} WHERE projectID=#{projectID}")
    int updateStage3(Stage3 stage3);
}
