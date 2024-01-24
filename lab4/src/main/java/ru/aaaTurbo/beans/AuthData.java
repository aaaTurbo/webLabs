package ru.aaaTurbo.beans;

import jakarta.ejb.Stateless;
import lombok.Getter;
import lombok.Setter;

@Stateless
public class AuthData {
    @Getter
    @Setter
    private boolean status = false;

    @Getter
    @Setter
    private String message = "";

}
