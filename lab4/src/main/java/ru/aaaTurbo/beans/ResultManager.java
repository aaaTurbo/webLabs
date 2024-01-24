package ru.aaaTurbo.beans;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.aaaTurbo.jpa.ResultEntity;
import ru.aaaTurbo.jpa.UserEntity;

import java.util.HashMap;
import java.util.List;

@Singleton
public class ResultManager {

    private final HashMap<String, List<ResultEntity>> results = new HashMap<>();

    @PersistenceContext
    private EntityManager manager;

    public void save(ResultEntity entity) {
        if (!results.containsKey(entity.getOwner().getName())) {
            UserEntity user = manager.find(UserEntity.class, entity.getOwner().getName());
            if (user != null) {
                entity.setOwner(user);
                results.put(entity.getOwner().getName(), user.getResults());
            }
        }
        manager.persist(entity);
        results.get(entity.getOwner().getName()).add(entity);
    }

    public void clear(String username) {
        if (results.containsKey(username))
            results.get(username).clear();
        UserEntity user = manager.find(UserEntity.class, username);
        if (user != null) {
            user.getResults().clear();
            manager.persist(user);
        }
    }

    public List<ResultBean> getResults(String username) {
        if (results.containsKey(username)) {
            List<ResultEntity> resultEntities = results.get(username);
            return resultEntities.stream().map(ResultEntity::getAsBean).toList();
        }
        return null;
    }
}
