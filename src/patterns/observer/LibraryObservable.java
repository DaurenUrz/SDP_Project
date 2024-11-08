package patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class LibraryObservable {
    private final List<Observer> subscribers = new ArrayList<>();

    public void addSubscriber(Observer observer) {
        subscribers.add(observer);
    }

    public void addNewBook(String book) {
        for (Observer subscriber : subscribers) {
            subscriber.update("Новая книга доступна: " + book);
        }
    }
}
