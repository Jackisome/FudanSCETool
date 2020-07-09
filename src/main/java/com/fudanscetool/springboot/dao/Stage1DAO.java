package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.Stage1;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface Stage1DAO {
    @Insert("INSERT INTO stage1 VALUES(#{projectID}, #{size}, #{estimateLoad})")
    int insertStage1(Stage1 stage1);

    @Select("SELECT * FROM stage1 WHERE projectID=#{projectID}")
    Stage1 searchStage1(String projectID);

    @Delete("DELETE FROM stage1 WHERE projectID=#{projectID}")
    int deleteStage1(String projectID);

    @Update("UPDATE stage1 SET size=#{size},estimateLoad=#{estimateLoad} WHERE projectID=#{projectID}")
    int updateStage1(Stage1 stage1);
}
