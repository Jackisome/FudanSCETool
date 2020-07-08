package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.Stage1;
import org.springframework.stereotype.Repository;

@Repository
public interface Stage1DAO {
    int insertStage1(Stage1 stage1);

    Stage1 searchStage1(String projectID);

    int deleteStage1(String projectID);

    int updateStage1(Stage1 stage1);
}
