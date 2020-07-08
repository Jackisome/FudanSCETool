package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.HistoryStage2;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryStage2DAO {
    int insertHistoryStage2(HistoryStage2 hStage2);

    HistoryStage2 searchHistoryStage2(String hProjectID);

    int deleteHistoryStage2(String hProjectID);
}
