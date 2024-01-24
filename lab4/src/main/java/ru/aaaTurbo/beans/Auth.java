package ru.aaaTurbo.beans;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.aaaTurbo.jpa.UserEntity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Singleton
public class Auth {

    @PersistenceContext
    EntityManager manager;

    public boolean login(UserEntity user) {
        String pass = user.getPassword();
        user = manager.find(UserEntity.class, user.getName());
        if (user != null) {
            try {
                if (hashPass(pass).equals(user.getPassword())) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public boolean register(UserEntity user) {
        if (manager.find(UserEntity.class, user.getName()) == null) {
            try{
                user.setPassword(hashPass(user.getPassword()));
            } catch (Exception e) {
                return false;
            }
            manager.persist(user);
            return true;
        }
        return false;
    }

    private String hashPass(String pass) throws NoSuchAlgorithmException {

        byte[] bytes = pass.getBytes();

        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] mdDigest = md.digest(bytes);

        return new String(mdDigest);
    }
}
