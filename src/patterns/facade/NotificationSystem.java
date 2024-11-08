package patterns.facade;

public class NotificationSystem {
    public String notifyUser(String borrower, String message) {
        return "Уведомление для " + borrower + ": " + message;
    }
}
