package de.applicity.guestbook;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // Eine Entität, die in der Datenbank gespeichert wird verfügt stets über die Entity-Annotation aus dem javax.persistence-Package
public class GuestBookEntry {

    @Id //Primärschlüssel
    @GeneratedValue(strategy = GenerationType.AUTO) //über die Generierungsstrategie erhält die Komponente ihren Wert, AUTO = es wird der für die Datenbank best geeignete Ansatz gewählt
    private Long id;

    private String title;

    private String comment;

    private String commenter;

    @JsonFormat(pattern = "dd.MM.yyyy, MM:mm:ss")
    private Date date = new Date();

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
