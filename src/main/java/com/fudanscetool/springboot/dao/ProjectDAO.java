package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.Project;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProjectDAO {
    @Insert("INSERT INTO project VALUES(#{projectID}, #{projectName}, #{createTime}, #{programType}, #{codeLanguage}, #{PREC}, #{FLEX}, #{RESL}, #{TEAM}, #{PMAT}, #{realLoad}, #{projectStatus}, #{projectOwner})")
    int insertProject(Project project);

    @Select("SELECT * FROM project WHERE projectID=#{projectID}")
    Project searchProject(String projectID);

    @Update("UPDATE project SET realLoad={realLoad} WHERE projectID=#{projectID}")
    int updateRealLoad(String projectID, double realLoad);

    @Update("UPDATE project SET projectStatus={status} WHERE projectID=#{projectID}")
    int updateProjectStatus(String projectID, String status);

    @Delete("DELETE FROM project WHERE projectID=#{projectID}")
    int deleteProject(String projectID);

    @Delete("DELETE FROM project WHERE userID=#{userID}")
    int deleteUserProject(String userID);

    @Select("SELECT * FROM project")
    List<Project> searchAllProject();

    @Select("SELECT * FROM project WHERE projectStatus='待审核'")
    List<Project> searchWaitProject();

    @Select("SELECT COUNT (*) FROM project")
    int countProjectNumber(String userID);

    @Select("SELECT COUNT (*) FROM project WHERE projectStatus='待审核'")
    int countWaitProjectNumber();
}
