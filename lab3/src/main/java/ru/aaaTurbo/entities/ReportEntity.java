package ru.aaaTurbo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="reports")
public class ReportEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String sessionId;
    private String time;
    private String hit;
    private String x;
    private String y;
    private String r;

    public ReportEntity() {
    }

    public ReportEntity(String sessionId, String time, String hit, String x, String y, String r) {
        this.sessionId = sessionId;
        this.time = time;
        this.hit = hit;
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
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

    public boolean ishit() {
        if (hit.equals("true")) {
            return true;
        } else {
            return false;
        }
    }
}
