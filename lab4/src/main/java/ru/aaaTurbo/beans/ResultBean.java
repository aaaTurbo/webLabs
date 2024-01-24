package ru.aaaTurbo.beans;

import jakarta.ejb.Stateless;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Stateless
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean {
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
    private boolean result;
}
