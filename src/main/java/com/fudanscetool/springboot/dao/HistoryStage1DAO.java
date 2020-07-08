package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.HistoryStage1;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryStage1DAO {
    int insertHistoryStage1(HistoryStage1 hStage1);

    HistoryStage1 searchHistoryStage1(String hProjectID);

    int deleteHistoryStage1(String hProjectID);
}
