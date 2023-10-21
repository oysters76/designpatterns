package ObserverPatternDemo;

public interface Observer {

    void addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);

    String getName();

}
