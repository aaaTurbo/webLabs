package ru.aaaTurbo.jpa;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class UserEntity {
    @Id
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String password;
    @Getter
    @OneToMany(mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ResultEntity> results;

    public UserEntity(String name) {
        this.name = name;
    }

    public UserEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
