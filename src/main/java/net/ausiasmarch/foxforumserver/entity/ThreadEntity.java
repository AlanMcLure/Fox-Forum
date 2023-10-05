package net.ausiasmarch.foxforumserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "thread")
public class ThreadEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Long id_user;

    public ThreadEntity() {
    
    }

    public ThreadEntity(String title, Long id_user) {
        this.title = title;
        this.id_user = id_user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getIdUser() {
        return id_user;
    }

    public void setIdUser(Long id_user) {
        this.id_user = id_user;
    }
}
