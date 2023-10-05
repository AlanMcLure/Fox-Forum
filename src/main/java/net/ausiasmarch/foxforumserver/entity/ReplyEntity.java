package net.ausiasmarch.foxforumserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reply")
public class ReplyEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;
    private Long id_user;
    private Long id_thread;

    public ReplyEntity() {
    
    }

    public ReplyEntity(String title, String body, Long id_user, Long id_thread) {
        this.title = title;
        this.body = body;
        this.id_user = id_user;
        this.id_thread = id_thread;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getIdUser() {
        return id_user;
    }

    public void setIdUser(Long id_user) {
        this.id_user = id_user;
    }

    public Long getIdThread() {
        return id_thread;
    }

    public void setIdThread(Long id_thread) {
        this.id_thread = id_thread;
    }
}
