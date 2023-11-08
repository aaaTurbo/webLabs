package ru.aaaTurbo.beans;

import ru.aaaTurbo.dao.ReportDAO;
import ru.aaaTurbo.entities.ReportEntity;

import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Date;

public class AppBean {
    private String x = "";
    private String y = "";
    private String r = "";
    private String valInf = "";
    private String dots = "";
    private ArrayList<ReportEntity> reports;
    private ReportDAO reportDAO = new ReportDAO();
    private String sessionId;


    public AppBean() {
        sessionId = FacesContext.getCurrentInstance().getExternalContext().getSessionId(true);
        reports = reportDAO.getReports(sessionId);
    }

    public void save() {
        valInf = "";
        validate();
        if (valInf.equals("")) {
            ReportEntity toSave = new ReportEntity(sessionId, new Date().toString(), String.valueOf(check(x, y, r)), x, y, r);
            reports.add(toSave);
            if (check(x, y, r)) {
                dots += "<circle cx=\"" + (((Double.parseDouble(x) * 100) / Double.parseDouble(r)) + 150)
                        + "\" cy=\"" + (-1 * ((Double.parseDouble(y) * 100) / Double.parseDouble(r)) + 150) + "\" r=\"2\" fill=\"#00ff00\"/>";
            } else {
                dots += "<circle cx=\"" + (((Double.parseDouble(x) * 100) / Double.parseDouble(r)) + 150)
                        + "\" cy=\"" + (-1 * ((Double.parseDouble(y) * 100) / Double.parseDouble(r)) + 150) + "\" r=\"2\" fill=\"red\"/>";
            }
//            reportDAO.save(toSave);
        }
        x = "";
        y = "";
        r = "";
    }

    public void reset() {
        x = "";
        y = "";
        r = "";
    }

    public boolean check(String x, String y, String r) {
        if (!(x.equals("") && y.equals("") && r.equals(""))) {
            double xD = Double.parseDouble(x);
            double yD = Double.parseDouble(y);
            double rD = Double.parseDouble(r);
            if (xD == 0.0 && yD == 0.0) {
                return true;
            }
            if (xD > -rD && xD <= 0.0 && yD >= 0.0 && yD < rD / 2.0) {
                return true;
            }
            if (xD < rD && xD >= 0.0 && yD <= 0.0 && yD > -rD / 2.0 && rD / 2.0 > xD / 2.0 - yD) {
                return true;
            }
            if (xD <= 0.0 && xD > -rD && yD > -rD && yD <= 0.0 && rD * rD > xD * xD + yD * yD) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void validate() {
        if (x.equals("") || y.equals("") || r.equals("")) {
            valInf = "X, Y and R can't be empty";
        } else {
            double xD = Double.parseDouble(x);
            double yD = Double.parseDouble(y);
            double rD = Double.parseDouble(r);
            if (xD != -2 && xD != -1.5 && xD != -1 && xD != -0.5 && xD != 0 && xD != 0.5 && xD != 1 && xD != 1.5 && xD != 2) {
                valInf += "X must be of {-2, -1.5, -1, -0.5, 0, 0.5, 1, 1.5, 2}\n";
            }
            if (!(-5 < yD && yD < 5)) {
                valInf += "Y must be from -5 to 5 (not including)\n";
            }
            if (!(0.1 < rD && rD < 3 && r.matches("[012].[0-9]"))) {
                valInf += "R must be from 0.1 to 3 (not including) and step must be 0.1\n";
            }
        }
    }

    public ArrayList<ReportEntity> getReports() {
        ArrayList<ReportEntity> res = new ArrayList<>();
        for (int i = reports.size() - 1; i >= 0; i--) {
            res.add(reports.get(i));
        }
        return res;
    }

    public void setReports(ArrayList<ReportEntity> reports) {
        this.reports = reports;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getValInf() {
        return valInf;
    }

    public void setValInf(String valInf) {
        this.valInf = valInf;
    }

    public String getDots() {
        return dots;
    }

    public void setDots(String dots) {
        this.dots = dots;
    }
}
