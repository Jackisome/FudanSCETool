package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.HistoryStage3;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryStage3DAO {
    int insertHistoryStage3(HistoryStage3 hStage3);

    HistoryStage3 searchHistoryStage3(String hProjectID);

    int deleteHistoryStage3(String hProjectID);
}
