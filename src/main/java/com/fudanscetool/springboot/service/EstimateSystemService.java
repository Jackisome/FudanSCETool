package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.dao.*;
import com.fudanscetool.springboot.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstimateSystemService {
    @Autowired
    private ProjectDAO pdao;

    @Autowired
    private Stage1DAO s1dao;

    @Autowired
    private Stage2DAO s2dao;

    @Autowired
    private Stage3DAO s3dao;

    @Autowired
    private HistoryProjectDAO hdao;

    @Autowired
    private HistoryStage1DAO hs1dao;

    @Autowired
    private HistoryStage2DAO hs2dao;

    @Autowired
    private HistoryStage3DAO hs3dao;

    public List<HistoryProject> findAllHistoryProject() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return hdao.searchAllHistoryProject();
    }

    public List<Project> findAllWaitProject() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return pdao.searchWaitProject();
    }

    public boolean copyToHistoryProjectDatabase(String projectID) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        Project project = pdao.searchProject(projectID);
        Stage1 stage1 = s1dao.searchStage1(projectID);
        Stage2 stage2 = s2dao.searchStage2(projectID);
        Stage3 stage3 = s3dao.searchStage3(projectID);

        HistoryProject hProject = new HistoryProject();
        hProject.setProjectID(project.getProjectID());
        hProject.setCodeLanguage(project.getCodeLanguage());
        hProject.setCreateTime(project.getCreateTime());
        hProject.setProgramType(project.getProgramType());
        hProject.setProjectName(project.getProjectName());
        hProject.setPREC(project.getPREC());
        hProject.setFLEX(project.getFLEX());
        hProject.setPMAT(project.getPMAT());
        hProject.setRESL(project.getRESL());
        hProject.setTEAM(project.getTEAM());

        HistoryStage1 hstage1 = new HistoryStage1();
        hstage1.setProjectID(stage1.getProjectID());
        hstage1.setSize(stage1.getSize());

        HistoryStage2 hstage2 = new HistoryStage2();
        hstage2.setProjectID(stage2.getProjectID());
        hstage2.setFCIL(stage2.getFCIL());
        hstage2.setPCPX(stage2.getPCPX());
        hstage2.setPDIF(stage2.getPDIF());
        hstage2.setPERS(stage2.getPERS());
        hstage2.setRUSE(stage2.getRUSE());
        hstage2.setSCED(stage2.getSCED());
        hstage2.setPREX(stage2.getPREX());
        hstage2.setSize(stage2.getSize());

        HistoryStage3 hstage3 = new HistoryStage3();
        hstage3.setProjectID(stage3.getProjectID());
        hstage3.setACAP(stage3.getACAP());
        hstage3.setAEXP(stage3.getAEXP());
        hstage3.setCPLX(stage3.getCPLX());
        hstage3.setDATA(stage3.getDATA());
        hstage3.setDOCU(stage3.getDOCU());
        hstage3.setLTEX(stage3.getLTEX());
        hstage3.setPCAP(stage3.getPCAP());
        hstage3.setPCON(stage3.getPCON());
        hstage3.setPVOL(stage3.getPVOL());
        hstage3.setRUSE(stage3.getRUSE());
        hstage3.setRELY(stage3.getRELY());
        hstage3.setSCED(stage3.getSCED());
        hstage3.setSITE(stage3.getSITE());
        hstage3.setSTOR(stage3.getSTOR());
        hstage3.setTIME(stage3.getTIME());
        hstage3.setPEXP(stage3.getPEXP());
        hstage3.setTOOL(stage3.getTOOL());
        hstage3.setSize(stage3.getSize());

        return createNewHistoryProject(hProject, hstage1, hstage2, hstage3);
    }

    public double getHistoryProjectWeight(HistoryProject hProject) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        ProjectService ps = new ProjectService();
        return 0.91 + 0.01 * (ps.changeScaleFactorToRate("PREC", hProject.getPREC()) + ps.changeScaleFactorToRate("FLEX", hProject.getFLEX()) + ps.changeScaleFactorToRate("RESL", hProject.getRESL()) + ps.changeScaleFactorToRate("TEAM", hProject.getTEAM()) + ps.changeScaleFactorToRate("PMAT", hProject.getPMAT()));
    }

    public double getHistoryStage2MultipleEM(HistoryStage2 stage) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        ProjectService ps = new ProjectService();
        return ps.changeEMToRate("PCPX", stage.getPCPX()) * ps.changeEMToRate("RUSE", stage.getRUSE()) * ps.changeEMToRate("PDIF", stage.getPDIF()) * ps.changeEMToRate("PERS", stage.getPERS()) * ps.changeEMToRate("PREX", stage.getPREX()) * ps.changeEMToRate("FCIL", stage.getFCIL()) * ps.changeEMToRate("SCED", stage.getSCED());
    }
    public double getHistoryStage3MultipleEM(HistoryStage3 stage) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        ProjectService ps = new ProjectService();
        return ps.changeEMToRate("RELY", stage.getRELY()) * ps.changeEMToRate("DATA", stage.getDATA()) * ps.changeEMToRate("DOCU", stage.getDOCU()) * ps.changeEMToRate("CPLX", stage.getCPLX()) * ps.changeEMToRate("RUSE", stage.getRUSE()) * ps.changeEMToRate("TIME", stage.getTIME()) * ps.changeEMToRate("STOR", stage.getSTOR()) * ps.changeEMToRate("PVOL", stage.getPVOL()) * ps.changeEMToRate("ACAP", stage.getACAP()) * ps.changeEMToRate("AEXP", stage.getAEXP()) * ps.changeEMToRate("PCAP", stage.getPCAP()) * ps.changeEMToRate("PEXP", stage.getPEXP()) * ps.changeEMToRate("LTEX", stage.getLTEX()) * ps.changeEMToRate("PCON", stage.getPCON()) * ps.changeEMToRate("TOOL", stage.getTOOL()) * ps.changeEMToRate("SCED", stage.getSCED()) * ps.changeEMToRate("SITE", stage.getSITE());
    }

    public boolean createNewHistoryProject(HistoryProject hProject, HistoryStage1 hstage1, HistoryStage2 hstage2, HistoryStage3 hstage3) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        if (hs1dao.searchHistoryStage1(hProject.getProjectID()) != null || hs2dao.searchHistoryStage2(hProject.getProjectID()) != null || hs3dao.searchHistoryStage3(hProject.getProjectID()) != null) {
            return false;
        }
        else {
            hdao.insertHistoryProject(hProject);
            hs1dao.insertHistoryStage1(hstage1);
            hs2dao.insertHistoryStage2(hstage2);
            hs3dao.insertHistoryStage3(hstage3);
            return true;
        }
    }

    public boolean trainModel(String model) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        if (model.equals("model1")) {
            new COCOMOIIModel().train();
            return true;
        }
        else if (model.equals("model2")) {
            new AnalogyModel().train();
            return true;
        }
        else if (model.equals("model3")) {
            new MLPModel().train();
            return true;
        }
        else {
            new COCOMOIIModel().train();
            return true;
        }
    }

    public boolean deleteHistoryProject(String hProjectID) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return (hdao.deleteHistoryProject(hProjectID) + hs1dao.deleteHistoryStage1(hProjectID) + hs2dao.deleteHistoryStage2(hProjectID) + hs3dao.deleteHistoryStage3(hProjectID)) != 0;
    }

    public int countHistoryProjectNumber() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return hdao.countHistoryProject();
    }
}
