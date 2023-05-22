

package Others.Notification;

import java.time.LocalDateTime;

public class Notification {

    private static int nr_notificari=0;

    public int getId() {
        return id;
    }

    private int id;
    private String text;
    private LocalDateTime dateTime;



    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    private int id_user;

    public Notification(String text,int id_user) {
        ++nr_notificari;
        this.id=nr_notificari;
        this.text = text;
        this.dateTime = LocalDateTime.now();
        this.id_user=id_user;
    }

    public Notification(int id,String text,LocalDateTime dateTime,int id_user) {
        this.id=id;
        this.text = text;
        this.dateTime = dateTime;
        this.id_user=id_user;
    }


    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
