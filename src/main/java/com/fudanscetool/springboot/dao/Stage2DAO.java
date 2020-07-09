package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.Stage2;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface Stage2DAO {
    @Insert("INSERT INTO stage2 VALUES(#{projectID}, #{size}, #{PCPX}, #{RUSE}, #{PDIF}, #{PERS}, #{PREX}, #{FCIL}, #{SCED}, #{estimateLoad})")
    int insertStage2(Stage2 stage2);

    @Select("SELECT * FROM stage2 WHERE projectID=#{projectID")
    Stage2 searchStage2(String projectID);

    @Delete("DELETE FROM stage2 WHERE projectID=#{projectID}")
    int deleteStage2(String projectID);

    @Update("UPDATE stage2 SET size={size}, PCPX=#{PCPX}, RUSE=#{RUSE}, PDIF=#{PDIF}, PERS=#{PERS}, PREX=#{PREX}, FCIL=#{FCIL}, SCED=#{SCED}, estimateLoad=#{estimateLoad} WHERE projectID=#{projectID}")
    int updateStage2(Stage2 stage2);
}
