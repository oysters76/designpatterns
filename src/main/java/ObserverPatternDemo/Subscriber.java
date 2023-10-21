package ObserverPatternDemo;

public interface Subscriber {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void sendMessage(Observer observer, String message);

}
