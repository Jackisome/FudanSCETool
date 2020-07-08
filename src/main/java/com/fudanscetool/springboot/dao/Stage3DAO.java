package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.Stage3;
import org.springframework.stereotype.Repository;

@Repository
public interface Stage3DAO {
    int insertStage3(Stage3 stage3);

    Stage3 searchStage3(String projectID);

    int deleteStage3(String projectID);

    int updateStage3(Stage3 stage3);
}
