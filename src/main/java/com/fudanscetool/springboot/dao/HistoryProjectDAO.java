package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.HistoryProject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Repository
@Mapper
public interface HistoryProjectDAO {
    @Select("SELECT * FROM historyproject")
    List<HistoryProject> searchAllHistoryProject();

    @Insert("INSERT INTO historyproject VALUES(#{projectID}, #{projectName}, #{createTime}, #{programType}, #{codeLanguage}, #{PREC}, #{FLEX}, #{RESL}, #{TEAM}, #{PMAT}, #{realLoad})")
    int insertHistoryProject(HistoryProject hProject);

    @Delete("DELETE FROM historyproject WHERE projectID=#{hProjectID}")
    int deleteHistoryProject(String hProjectID);

    @Select("SELECT COUNT (*) FROM historyproject")
    int countHistoryProject();
}
