

package Others;

import java.time.LocalDateTime;

public class Notification {
    private String text;
    private LocalDateTime dateTime;

    public Notification(String text) {
        this.text = text;
        this.dateTime = LocalDateTime.now();
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
