package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.dao.ProjectDAO;
import com.fudanscetool.springboot.dao.Stage1DAO;
import com.fudanscetool.springboot.dao.Stage2DAO;
import com.fudanscetool.springboot.dao.Stage3DAO;
import com.fudanscetool.springboot.pojo.Project;
import com.fudanscetool.springboot.pojo.Stage1;
import com.fudanscetool.springboot.pojo.Stage2;
import com.fudanscetool.springboot.pojo.Stage3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectService {
    @Autowired
    private ProjectDAO pdao;

    @Autowired
    private Stage1DAO s1dao;

    @Autowired
    private Stage2DAO s2dao;

    @Autowired
    private Stage3DAO s3dao;

    public boolean createProject(Project project) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return pdao.insertProject(project) != 0;
    }

    public float changeFuncToSize(int funct, String codeLanguage) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        int rate = 0;
        if (codeLanguage.equals("ada")) rate = 71;
        else if (codeLanguage.equals("aishell")) rate = 49;
        else if (codeLanguage.equals("apl")) rate = 32;
        else if (codeLanguage.equals("assenbly")) rate = 320;
        else if (codeLanguage.equals("assemblyMacro")) rate = 213;
        else if (codeLanguage.equals("ansiQuickBasic")) rate = 64;
        else if (codeLanguage.equals("basicCompiled")) rate = 91;
        else if (codeLanguage.equals("basicInterpreted")) rate = 128;
        else if (codeLanguage.equals("c")) rate = 128;
        else if (codeLanguage.equals("cpp")) rate = 29;
        else if (codeLanguage.equals("ansiCobol85")) rate = 91;
        else if (codeLanguage.equals("fortran77")) rate = 105;
        else if (codeLanguage.equals("forth")) rate = 64;
        else if (codeLanguage.equals("jovial")) rate = 105;
        else if (codeLanguage.equals("lisp")) rate = 64;
        else if (codeLanguage.equals("modula2")) rate = 80;
        else if (codeLanguage.equals("pascal")) rate = 91;
        else if (codeLanguage.equals("prolog")) rate = 64;
        else if (codeLanguage.equals("reportGenerator")) rate = 80;
        else if (codeLanguage.equals("spreadsheet")) rate = 6;
        else rate = 100;

        return funct * rate;
    }

    public double changeScaleFactorToRate(String ScaleFactor, String rate) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        if (ScaleFactor.equals("PREC")) {
            if (rate.equals("非常低")) return 6.20;
            else if (rate.equals("低")) return 4.96;
            else if (rate.equals("正常")) return 3.72;
            else if (rate.equals("高")) return 2.48;
            else if (rate.equals("非常高")) return 1.24;
            else if (rate.equals("超高")) return 0.00;
            else return 3.72;
        }
        else if (ScaleFactor.equals("FLEX")) {
            if (rate.equals("非常低")) return 5.07;
            else if (rate.equals("低")) return 4.05;
            else if (rate.equals("正常")) return 3.04;
            else if (rate.equals("高")) return 2.03;
            else if (rate.equals("非常高")) return 1.01;
            else if (rate.equals("超高")) return 0.00;
            else return 3.04;
        }
        else if (ScaleFactor.equals("RESL")) {
            if (rate.equals("非常低")) return 7.07;
            else if (rate.equals("低")) return 5.65;
            else if (rate.equals("正常")) return 4.24;
            else if (rate.equals("高")) return 2.83;
            else if (rate.equals("非常高")) return 1.41;
            else if (rate.equals("超高")) return 0.00;
            else return 4.24;
        }
        else if (ScaleFactor.equals("TEAM")) {
            if (rate.equals("非常低")) return 5.48;
            else if (rate.equals("低")) return 4.38;
            else if (rate.equals("正常")) return 3.29;
            else if (rate.equals("高")) return 2.19;
            else if (rate.equals("非常高")) return 1.10;
            else if (rate.equals("超高")) return 0.00;
            else return 3.29;
        }
        else if (ScaleFactor.equals("PMAT")) {
            if (rate.equals("非常低")) return 7.80;
            else if (rate.equals("低")) return 6.24;
            else if (rate.equals("正常")) return 4.68;
            else if (rate.equals("高")) return 3.12;
            else if (rate.equals("非常高")) return 1.56;
            else if (rate.equals("超高")) return 0.00;
            else return 4.68;
        }
        return 3;
    }

    public double changeEMToRate(String EM, String rate) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        if (EM.equals("RELY")) {
            if (rate.equals("极低")) return 0.75;
            else if (rate.equals("低")) return 0.88;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 1.15;
            else if (rate.equals("极高")) return 1.40;
        }
        else if (EM.equals("DATA")) {
            if (rate.equals("极低")) return 0.93;
            else if (rate.equals("低")) return 0.94;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 1.08;
            else if (rate.equals("极高")) return 1.16;
        }
        else if (EM.equals("CPLX")) {
            if (rate.equals("极低")) return 0.70;
            else if (rate.equals("低")) return 0.85;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 1.15;
            else if (rate.equals("极高")) return 1.30;
        }
        else if (EM.equals("TIME")) {
            if (rate.equals("极低")) return 0.98;
            else if (rate.equals("低")) return 0.99;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 1.11;
            else if (rate.equals("极高")) return 1.30;
        }
        else if (EM.equals("STOR")) {
            if (rate.equals("极低")) return 0.98;
            else if (rate.equals("低")) return 0.99;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 1.06;
            else if (rate.equals("极高")) return 1.21;
        }
        else if (EM.equals("PVOL")) {
            if (rate.equals("极低")) return 0.86;
            else if (rate.equals("低")) return 0.87;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 1.15;
            else if (rate.equals("极高")) return 1.30;
        }
        else if (EM.equals("PEXP")) {
            if (rate.equals("极低")) return 1.86;
            else if (rate.equals("低")) return 1.87;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 1.07;
            else if (rate.equals("极高")) return 1.15;
        }
        else if (EM.equals("ACAP")) {
            if (rate.equals("极低")) return 1.46;
            else if (rate.equals("低")) return 1.19;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 0.86;
            else if (rate.equals("极高")) return 0.71;
        }
        else if (EM.equals("AEXP")) {
            if (rate.equals("极低")) return 1.29;
            else if (rate.equals("低")) return 1.13;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 0.91;
            else if (rate.equals("极高")) return 0.82;
        }
        else if (EM.equals("PCAP")) {
            if (rate.equals("极低")) return 1.42;
            else if (rate.equals("低")) return 1.17;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 0.86;
            else if (rate.equals("极高")) return 0.70;
        }
        else if (EM.equals("DOCU")) {
            if (rate.equals("极低")) return 1.21;
            else if (rate.equals("低")) return 1.1;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 0.90;
            else if (rate.equals("极高")) return 0.89;
        }
        else if (EM.equals("LTEX")) {
            if (rate.equals("极低")) return 1.14;
            else if (rate.equals("低")) return 1.07;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 0.95;
            else if (rate.equals("极高")) return 0.94;
        }
        else if (EM.equals("PCON")) {
            if (rate.equals("极低")) return 1.24;
            else if (rate.equals("低")) return 1.10;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 0.91;
            else if (rate.equals("极高")) return 0.82;
        }
        else if (EM.equals("TOOL")) {
            if (rate.equals("极低")) return 1.23;
            else if (rate.equals("低")) return 1.08;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 1.04;
            else if (rate.equals("极高")) return 1.10;
        }
        else if (EM.equals("SITE")) {
            if (rate.equals("极低")) return 0.90;
            else if (rate.equals("低")) return 0.95;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 1.04;
            else if (rate.equals("极高")) return 1.10;
        }
        else if (EM.equals("SCED")) {
            if (rate.equals("极低")) return 1.23;
            else if (rate.equals("低")) return 1.08;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 1.04;
            else if (rate.equals("极高")) return 1.10;
        }
        else if (EM.equals("PCPX")) {
            if (rate.equals("极低")) return 0.87;
            else if (rate.equals("低")) return 0.93;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 1.10;
            else if (rate.equals("极高")) return 1.45;
        }
        else if (EM.equals("RUSE")) {
            if (rate.equals("极低")) return 0.87;
            else if (rate.equals("低")) return 0.93;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 1.01;
            else if (rate.equals("极高")) return 1.10;
        }
        else if (EM.equals("PDIF")) {
            if (rate.equals("极低")) return 0.90;
            else if (rate.equals("低")) return 0.95;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 1.04;
            else if (rate.equals("极高")) return 1.35;
        }
        else if (EM.equals("PERS")) {
            if (rate.equals("极低")) return 1.23;
            else if (rate.equals("低")) return 1.08;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 0.95;
            else if (rate.equals("极高")) return 0.90;
        }
        else if (EM.equals("PREX")) {
            if (rate.equals("极低")) return 1.23;
            else if (rate.equals("低")) return 1.08;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 0.90;
            else if (rate.equals("极高")) return 0.65;
        }
        else if (EM.equals("FCIL")) {
            if (rate.equals("极低")) return 1.23;
            else if (rate.equals("低")) return 1.08;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 0.95;
            else if (rate.equals("极高")) return 8.89;
        }
        else {
            if (rate.equals("极低")) return 0.98;
            else if (rate.equals("低")) return 0.99;
            else if (rate.equals("标准")) return 1.00;
            else if (rate.equals("高")) return 1.01;
            else if (rate.equals("极高")) return 1.02;
            else return 1.00;
        }
        return 1.00;
    }

    public Project findProject(String projectID) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return pdao.searchProject(projectID);
    }

    public double estimateStage1(Project project, Stage1 stage, String model) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        double weight = 0.91 + 0.01 * (changeScaleFactorToRate("PREC", project.getPREC()) + changeScaleFactorToRate("FLEX", project.getFLEX()) + changeScaleFactorToRate("RESL", project.getRESL()) + changeScaleFactorToRate("TEAM", project.getTEAM()) + changeScaleFactorToRate("PMAT", project.getPMAT()));
        if (model.equals("model1")) {
            return new COCOMOIIModel().estimateStage1(weight, stage);
        }
        else if (model.equals("model2")) {
            return new AnalogyModel().estimateStage1(weight, stage);
        }
        else if (model.equals("model3")) {
            return new MLPModel().estimateStage1(weight, stage);
        }
        else {
            return new COCOMOIIModel().estimateStage1(weight, stage);
        }
    }

    public double estimateStage2(Project project, Stage2 stage, String model) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        double weight = 0.91 + 0.01 * (changeScaleFactorToRate("PREC", project.getPREC()) + changeScaleFactorToRate("FLEX", project.getFLEX()) + changeScaleFactorToRate("RESL", project.getRESL()) + changeScaleFactorToRate("TEAM", project.getTEAM()) + changeScaleFactorToRate("PMAT", project.getPMAT()));
        if (model.equals("model1")) {
            return new COCOMOIIModel().estimateStage2(weight, stage);
        }
        else if (model.equals("model2")) {
            return new AnalogyModel().estimateStage2(weight, stage);
        }
        else if (model.equals("model3")) {
            return new MLPModel().estimateStage2(weight, stage);
        }
        else {
            return new COCOMOIIModel().estimateStage2(weight, stage);
        }
    }

    public double estimateStage3(Project project, Stage3 stage, String model) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        double weight = 0.91 + 0.01 * (changeScaleFactorToRate("PREC", project.getPREC()) + changeScaleFactorToRate("FLEX", project.getFLEX()) + changeScaleFactorToRate("RESL", project.getRESL()) + changeScaleFactorToRate("TEAM", project.getTEAM()) + changeScaleFactorToRate("PMAT", project.getPMAT()));
        if (model.equals("model1")) {
            return new COCOMOIIModel().estimateStage3(weight, stage);
        }
        else if (model.equals("model2")) {
            return new AnalogyModel().estimateStage3(weight, stage);
        }
        else if (model.equals("model3")) {
            return new MLPModel().estimateStage3(weight, stage);
        }
        else {
            return new COCOMOIIModel().estimateStage3(weight, stage);
        }
    }

    public Map<String, Double> countEachLoad(float load) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        Map<String, Double> staffWorkLoad = new HashMap<>();
        staffWorkLoad.put("requirementLoad", load * (0.1 / 3.7));
        staffWorkLoad.put("designLoad", load * (0.3 / 3.7));
        staffWorkLoad.put("codingLoad", load * (0.7 / 3.7));
        staffWorkLoad.put("CMLoad", load * (0.1 / 3.7));
        staffWorkLoad.put("documentingLoad", load * (0.1 / 3.7));
        staffWorkLoad.put("testLoad", load * (2.0 / 3.7));
        staffWorkLoad.put("PMLoad", load * (0.4 / 3.7));
        return staffWorkLoad;
    }

    public Map<String, Double> countEachSalary(Map<String, Double> load) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        Map<String, Double> staffWorkPay = new HashMap<>();
        staffWorkPay.put("requirenmentPay", load.get("requirementLoad") * 7.5);
        staffWorkPay.put("designPay", load.get("designLoad") * 15);
        staffWorkPay.put("codingPay", load.get("codingLoad") * 20);
        staffWorkPay.put("CMPay", load.get("CMLoad") * 10);
        staffWorkPay.put("documentingPay", load.get("documentingLoad") * 11);
        staffWorkPay.put("testPay", load.get("testLoad") * 20);
        staffWorkPay.put("PMPay", load.get("PMLoad") * 15);
        return staffWorkPay;
    }

    public boolean updateRealLoad(String projectID, double realLoad) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return pdao.updateRealLoad(projectID, realLoad) != 0;
    }

    public boolean applyAddProject(String projectID) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return pdao.updateProjectStatus(projectID, "applying") != 0;
    }

    public File outputProject(String projectID) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        Project project = pdao.searchProject(projectID);
        Stage1 stage1 = s1dao.searchStage1(projectID);
        Stage2 stage2 = s2dao.searchStage2(projectID);
        Stage3 stage3 = s3dao.searchStage3(projectID);

        String fileName = projectID + "估算信息.txt";

        File file = new File("D:\\" + fileName);
        try {
            FileWriter fileWrite = new FileWriter(file);
            fileWrite.write("项目ID：" + project.getProjectID());
            fileWrite.write("项目语言：" + project.getCodeLanguage());
            fileWrite.write("项目类型：" + project.getProgramType());
            fileWrite.write("规模因子：" + "PREC: " + project.getPREC() + "\tFLEX: " + project.getFLEX() + "\tRESL: " + project.getRESL() + "\tTEAM: " + project.getTEAM() + "\tPMAT: " + project.getPMAT());
            fileWrite.write("第一阶段");
            fileWrite.write("估算规模（千行代码）：" + stage1.getSize());
            fileWrite.write("估算成本（人月）" + stage1.getEstimateLoad());
            fileWrite.write("第二阶段");
            fileWrite.write("估算规模（千行代码）：" + stage2.getSize());
            fileWrite.write("工作量乘积：");
            fileWrite.write("PCPX: " + stage2.getPCPX() + "\tRUSE: " + stage2.getRUSE() + "\tPDIF: " + stage2.getPDIF() + "\tPERS: " + stage2.getPERS() + "\tPREX: " + stage2.getPREX() + "\tFCIL: " + stage2.getFCIL() + "\tSCED: " + stage2.getSCED());
            fileWrite.write("估算成本（人月）：" + stage2.getEstimateLoad());
            fileWrite.write("第三阶段");
            fileWrite.write("估算规模（千行代码）：" + stage3.getSize());
            fileWrite.write("工作量乘积：");
            fileWrite.write("RELY: " + stage3.getRELY() + "\tDATA: " + stage3.getDATA() + "\tDOCU: " + stage3.getDOCU() + "\tCPLX: " + stage3.getCPLX() + "\tRUSE: " + stage3.getRUSE() + "\tTIME: " + stage3.getTIME() + "\tSTOR: " + stage3.getSTOR() + "\tPVOL: " + stage3.getPVOL() + "\tACAP: " + stage3.getACAP() + "\tAEXP: " + stage3.getAEXP() + "\tPCAP: " + stage3.getPCAP() + "\tPEXP: " + stage3.getPEXP() + "\tLTEX: " + stage3.getLTEX() + "\tPCON: " + stage3.getPCON() + "\tTOOL: " + stage3.getTOOL() + "|tSCED: " + stage3.getSCED() + "\tSITE: " + stage3.getSITE());
            fileWrite.write("估算成本（人月）：" + stage3.getEstimateLoad());
            fileWrite.flush();
            fileWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return file;
        }
    }

    public void downloadFile(String filename, String id, HttpServletResponse resp) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        String orginFilePath = "D:\\" +id + "\\" + filename;
        File file = new File(orginFilePath);
        if (file.exists()) {
            InputStream inStream = null;
            BufferedOutputStream os = null;
            try {
                inStream = new FileInputStream(file);
                // 设置输出的格式，以附件的方式输出，不用用浏览器打开
                byte[] buffer = new byte[1024];
                int byteread;
                try {
                    resp.reset();
                    resp.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
                    resp.setContentType("application/octet-stream");
                    os = new BufferedOutputStream(resp.getOutputStream());
                    while ((byteread = inStream.read(buffer)) != -1) {
                        os.write(buffer, 0, byteread);
                    }
                    inStream.close();
                    os.flush();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inStream != null) {
                        inStream.close();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    if (os != null) {
                        os.close();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } else {
            resp.reset();
            try {
                resp.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("文件不存在", "UTF-8"));
                resp.setContentType("application/octet-stream");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean deleteProject(String projectID) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return (pdao.deleteProject(projectID) + s1dao.deleteStage1(projectID) + s2dao.deleteStage2(projectID) + s3dao.deleteStage3(projectID)) != 0;
    }

    public List<Project> findAllProject() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return pdao.searchAllProject();
    }

    public int countWaitProject(String status) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return pdao.countWaitProjectNumber();
    }
}
