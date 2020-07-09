package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.dao.HistoryProjectDAO;
import com.fudanscetool.springboot.dao.HistoryStage1DAO;
import com.fudanscetool.springboot.dao.HistoryStage2DAO;
import com.fudanscetool.springboot.dao.HistoryStage3DAO;
import com.fudanscetool.springboot.pojo.*;
import org.elasticsearch.common.util.ESSloppyMath;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AnalogyModel implements EstimateModel {

    static boolean isTrain = false;
    EstimateSystemService es = new EstimateSystemService();
    ProjectService ps = new ProjectService();
    @Autowired
    private HistoryProjectDAO hdao;

    @Autowired
    private HistoryStage1DAO h1dao;

    @Autowired
    private HistoryStage2DAO h2dao;

    @Autowired
    private HistoryStage3DAO h3dao;

    @Override
    public void train() {
        return ;
    }

    @Override
    public double estimateStage1(double weight, Stage1 stage) {
        List<HistoryProject> allHistoryProject = hdao.searchAllHistoryProject();
        double[] distance = new double[allHistoryProject.size()];
        double maxsize = 0;
        double minsize = 100000000;
        double maxweight = 0;
        double minweight = 100000000;
        EstimateSystemService es = new EstimateSystemService();
        for (int i = 0; i < allHistoryProject.size(); i++) {
            HistoryProject hp = allHistoryProject.get(i);
            HistoryStage1 hs =  h1dao.searchHistoryStage1(hp.getProjectID());
            if (hs.getSize() > maxsize)
                maxsize = hs.getSize();
            if (hs.getSize() < minsize)
                minsize = hs.getSize();
            if (es.getHistoryProjectWeight(hp) > maxweight)
                maxweight = es.getHistoryProjectWeight(hp);
            if (es.getHistoryProjectWeight(hp) < minweight)
                minweight = es.getHistoryProjectWeight(hp);
        }
        for (int i = 0; i < allHistoryProject.size(); i++) {
            HistoryProject hp = allHistoryProject.get(i);
            HistoryStage1 hs =  h1dao.searchHistoryStage1(hp.getProjectID());
            double sizedis = Math.pow(Math.abs(stage.getSize() - hs.getSize()) / (maxsize - minsize), 2);
            double weightsize = Math.pow(Math.abs((weight - es.getHistoryProjectWeight(hp)) / maxweight - minweight), 2);
            distance[i] = Math.sqrt((sizedis + weightsize) / 2);
        }
        double mindis = 1000000000;
        double load = 0;
        for (int i = 0; i < allHistoryProject.size(); i++) {
            if (distance[i] < mindis) {
                mindis = distance[i];
                load = allHistoryProject.get(i).getRealLoad();
            }
        }
        return load;
    }

    @Override
    public double estimateStage2(double weight, Stage2 stage) {
        List<HistoryProject> allHistoryProject = hdao.searchAllHistoryProject();
        double[] distance = new double[allHistoryProject.size()];
        double maxsize = 0;
        double minsize = 100000000;
        double maxweight = 0;
        double minweight = 100000000;
        EstimateSystemService es = new EstimateSystemService();
        for (int i = 0; i < allHistoryProject.size(); i++) {
            HistoryProject hp = allHistoryProject.get(i);
            HistoryStage2 hs =  h2dao.searchHistoryStage2(hp.getProjectID());
            if (hs.getSize() > maxsize)
                maxsize = hs.getSize();
            if (hs.getSize() < minsize)
                minsize = hs.getSize();
            if (es.getHistoryProjectWeight(hp) > maxweight)
                maxweight = es.getHistoryProjectWeight(hp);
            if (es.getHistoryProjectWeight(hp) < minweight)
                minweight = es.getHistoryProjectWeight(hp);
        }
        for (int i = 0; i < allHistoryProject.size(); i++) {
            HistoryProject hp = allHistoryProject.get(i);
            HistoryStage2 hs =  h2dao.searchHistoryStage2(hp.getProjectID());
            double sizedis = Math.pow(Math.abs(stage.getSize() - hs.getSize()) / (maxsize - minsize), 2);
            double weightsize = Math.pow(Math.abs((weight - es.getHistoryProjectWeight(hp)) / maxweight - minweight), 2);
            double[] em2 = new double[7];
            em2[0] = Math.pow(Math.abs(ps.changeEMToRate("PCPX", stage.getPCPX()) - ps.changeEMToRate("PCPX", hs.getPCPX())) / (1.45 - 0.87), 2);
            em2[1] = Math.pow(Math.abs(ps.changeEMToRate("RUSE", stage.getRUSE()) - ps.changeEMToRate("RUSE", hs.getRUSE())) / (1.10 - 0.87), 2);
            em2[2] = Math.pow(Math.abs(ps.changeEMToRate("PDIF", stage.getPDIF()) - ps.changeEMToRate("PDIF", hs.getPDIF())) / (1.35 - 0.90), 2);
            em2[3] = Math.pow(Math.abs(ps.changeEMToRate("PERS", stage.getPERS()) - ps.changeEMToRate("PERS", hs.getPERS())) / (1.23 - 0.90), 2);
            em2[4] = Math.pow(Math.abs(ps.changeEMToRate("PREX", stage.getPREX()) - ps.changeEMToRate("PREX", hs.getPREX())) / (1.23 - 0.65), 2);
            em2[5] = Math.pow(Math.abs(ps.changeEMToRate("FCIL", stage.getFCIL()) - ps.changeEMToRate("FCIL", hs.getFCIL())) / (1.23 - 0.89), 2);
            em2[6] = Math.pow(Math.abs(ps.changeEMToRate("SCED", stage.getSCED()) - ps.changeEMToRate("SCED", hs.getSCED())) / (1.23 - 1.00), 2);
            distance[i] = Math.sqrt((sizedis + weightsize + em2[0] + em2[1] + em2[2] + em2[3] + em2[4] + em2[5] + em2[6]) / 9);
        }
        double mindis = 1000000000;
        double load = 0;
        for (int i = 0; i < allHistoryProject.size(); i++) {
            if (distance[i] < mindis) {
                mindis = distance[i];
                load = allHistoryProject.get(i).getRealLoad();
            }
        }
        return load;
    }

    @Override
    public double estimateStage3(double weight, Stage3 stage) {
        List<HistoryProject> allHistoryProject = hdao.searchAllHistoryProject();
        double[] distance = new double[allHistoryProject.size()];
        double maxsize = 0;
        double minsize = 100000000;
        double maxweight = 0;
        double minweight = 100000000;
        EstimateSystemService es = new EstimateSystemService();
        for (int i = 0; i < allHistoryProject.size(); i++) {
            HistoryProject hp = allHistoryProject.get(i);
            HistoryStage3 hs =  h3dao.searchHistoryStage3(hp.getProjectID());
            if (hs.getSize() > maxsize)
                maxsize = hs.getSize();
            if (hs.getSize() < minsize)
                minsize = hs.getSize();
            if (es.getHistoryProjectWeight(hp) > maxweight)
                maxweight = es.getHistoryProjectWeight(hp);
            if (es.getHistoryProjectWeight(hp) < minweight)
                minweight = es.getHistoryProjectWeight(hp);
        }
        for (int i = 0; i < allHistoryProject.size(); i++) {
            HistoryProject hp = allHistoryProject.get(i);
            HistoryStage3 hs =  h3dao.searchHistoryStage3(hp.getProjectID());
            double sizedis = Math.pow(Math.abs(stage.getSize() - hs.getSize()) / (maxsize - minsize), 2);
            double weightsize = Math.pow(Math.abs((weight - es.getHistoryProjectWeight(hp)) / maxweight - minweight), 2);
            double[] em3 = new double[17];
            em3[0] = Math.pow(Math.abs(ps.changeEMToRate("RELY", stage.getRELY()) - ps.changeEMToRate("RELY", hs.getRELY())) / (1.40 - 0.75), 2);
            em3[1] = Math.pow(Math.abs(ps.changeEMToRate("DATA", stage.getDATA()) - ps.changeEMToRate("DATA", hs.getDATA())) / (1.16 - 0.93), 2);
            em3[2] = Math.pow(Math.abs(ps.changeEMToRate("DOCU", stage.getDOCU()) - ps.changeEMToRate("DOCU", hs.getDOCU())) / (1.21 - 0.89), 2);
            em3[3] = Math.pow(Math.abs(ps.changeEMToRate("CPLX", stage.getCPLX()) - ps.changeEMToRate("CPLX", hs.getCPLX())) / (1.30 - 0.70), 2);
            em3[4] = Math.pow(Math.abs(ps.changeEMToRate("RUSE", stage.getRUSE()) - ps.changeEMToRate("RUSE", hs.getRUSE())) / (1.10 - 0.87), 2);
            em3[5] = Math.pow(Math.abs(ps.changeEMToRate("TIME", stage.getTIME()) - ps.changeEMToRate("TIME", hs.getTIME())) / (1.30 - 0.98), 2);
            em3[6] = Math.pow(Math.abs(ps.changeEMToRate("STOR", stage.getSTOR()) - ps.changeEMToRate("STOR", hs.getSTOR())) / (1.21 - 0.98), 2);
            em3[7] = Math.pow(Math.abs(ps.changeEMToRate("PVOL", stage.getPVOL()) - ps.changeEMToRate("PVOL", hs.getPVOL())) / (1.30 - 0.86), 2);
            em3[8] = Math.pow(Math.abs(ps.changeEMToRate("ACAP", stage.getACAP()) - ps.changeEMToRate("ACAP", hs.getACAP())) / (1.46 - 0.71), 2);
            em3[9] = Math.pow(Math.abs(ps.changeEMToRate("AEXP", stage.getAEXP()) - ps.changeEMToRate("AEXP", hs.getAEXP())) / (1.29 - 0.82), 2);
            em3[10] = Math.pow(Math.abs(ps.changeEMToRate("PCAP", stage.getPCAP()) - ps.changeEMToRate("PCAP", hs.getPCAP())) / (1.42 - 0.70), 2);
            em3[11] = Math.pow(Math.abs(ps.changeEMToRate("PEXP", stage.getPEXP()) - ps.changeEMToRate("PEXP", hs.getPEXP())) / (1.86 - 1.00), 2);
            em3[12] = Math.pow(Math.abs(ps.changeEMToRate("LTEX", stage.getLTEX()) - ps.changeEMToRate("LTEX", hs.getLTEX())) / (1.14 - 0.94), 2);
            em3[13] = Math.pow(Math.abs(ps.changeEMToRate("PCON", stage.getPCON()) - ps.changeEMToRate("PCON", hs.getPCON())) / (1.24 - 0.82), 2);
            em3[14] = Math.pow(Math.abs(ps.changeEMToRate("TOOL", stage.getTOOL()) - ps.changeEMToRate("TOOL", hs.getTOOL())) / (1.23 - 1.00), 2);
            em3[15] = Math.pow(Math.abs(ps.changeEMToRate("SCED", stage.getSCED()) - ps.changeEMToRate("SCED", hs.getSCED())) / (1.23 - 1.00), 2);
            em3[16] = Math.pow(Math.abs(ps.changeEMToRate("SITE", stage.getSITE()) - ps.changeEMToRate("SITE", hs.getSITE())) / (1.10 - 0.90), 2);
            distance[i] = Math.sqrt((sizedis + weightsize + em3[0] + em3[1] + em3[2] + em3[3] + em3[4] + em3[5] + em3[6] + em3[7] + em3[8] + em3[9] + em3[10] + em3[11] + em3[12] + em3[13] + em3[14] + em3[15] + em3[16]) / 9);
        }
        double mindis = 1000000000;
        double load = 0;
        for (int i = 0; i < allHistoryProject.size(); i++) {
            if (distance[i] < mindis) {
                mindis = distance[i];
                load = allHistoryProject.get(i).getRealLoad();
            }
        }
        return load;
    }
}
