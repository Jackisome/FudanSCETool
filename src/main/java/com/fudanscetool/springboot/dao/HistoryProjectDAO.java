package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.HistoryProject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryProjectDAO {
    List<HistoryProject> searchAllHistoryProject();

    int insertHistoryProject(HistoryProject hProject);

    int deleteHistoryProject(String hProjectID);

    int countHistoryProject();
}
