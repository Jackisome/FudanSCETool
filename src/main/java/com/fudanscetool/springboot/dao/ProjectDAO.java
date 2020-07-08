package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDAO {
    int insertProject(Project project);

    Project searchProject(String projectID);

    int updateRealLoad(String projectID, float realLoad);

    int updateProjectStatus(String projectID, String status);

    int deleteProject(String projectID);

    int deleteUserProject(String userID);

    List<Project> searchAllProject();

    List<Project> searchWaitProject();

    int countProjectNumber(String userID);

    int countWaitProjetNumber();
}
