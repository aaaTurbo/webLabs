package ru.aaaTurbo.beans;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateful;
import ru.aaaTurbo.jpa.ResultEntity;
import ru.aaaTurbo.jpa.UserEntity;

@Stateful
public class HitChecker {

    @EJB
    private ResultManager manager;

    public boolean check(Input input) {
        ResultEntity result = new ResultEntity();
        result.setX(input.getX());
        result.setY(input.getY());
        result.setR(input.getR());
        boolean hit = research(result.getX(), result.getY(), result.getR());
        result.setResult(hit);
        result.setOwner(new UserEntity(input.getUsername()));
        manager.save(result);
        return hit;
    }

    private boolean research(double x, double y, double r) {
        boolean result  = false;
        if (r >= 0) {
            if (0 <= y && y <= r && -r/2 <= x && x <= 0) result = true;
            if (x * x + y * y <= r/2 * r/2 && x >= 0 && y <= 0) result = true;
            if (-r < x + y && -r <= x && x <= 0 && -r <= y && y <= 0) result = true;
        } else {
            if (0 >= y && y >= r && -r/2 >= x && x >= 0) result = true;
            if (x * x + y * y <= r/2 * r/2 && x <= 0 && y >= 0) result = true;
            if (-r > x + y && -r >= x && x >= 0 && -r >= y && y >= 0) result = true;
        }
        return result;
    }

}
