package ru.aaaTurbo.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ru.aaaTurbo.beans.ResultBean;

@Entity
@Table(name = "results")
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    @Setter
    private Long id;
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
    @ManyToOne
    @JoinColumn
    @Getter
    @Setter
    private UserEntity owner;

    public ResultBean getAsBean() {
        return new ResultBean(x, y, r, result);
    }

}
