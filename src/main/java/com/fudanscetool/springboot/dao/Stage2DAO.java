package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.Stage2;
import org.springframework.stereotype.Repository;

@Repository
public interface Stage2DAO {
    int insertStage2(Stage2 stage2);

    Stage2 searchStage2(String projectID);

    int deleteStage2(String projectID);

    int updateStage2(Stage2 stage2);
}
