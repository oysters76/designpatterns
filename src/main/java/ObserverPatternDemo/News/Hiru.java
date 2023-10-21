package ObserverPatternDemo.News;

import ObserverPatternDemo.Subscriber;

public class Hiru extends News{

    public Hiru(String channelName, int intervalSize) {
        super(channelName, intervalSize);
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        super.addSubscriber(subscriber);
    }

    @Override
    public void broadcastMessage() {
        for (Subscriber subscriber : subscribers){
            subscriber.sendMessage(this, MessageGenerator.generateMessage(5));
        }
    }
}
