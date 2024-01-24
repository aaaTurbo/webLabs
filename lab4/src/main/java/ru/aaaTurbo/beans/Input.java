package ru.aaaTurbo.beans;

import jakarta.ejb.Stateless;
import lombok.Getter;
import lombok.Setter;

@Stateless
public class Input {
    @Getter
    @Setter
    private double x;
    @Getter
    @Setter
    private double y;
    @Getter
    @Setter
    private double r;
    @Getter
    @Setter
    private String username;

}
