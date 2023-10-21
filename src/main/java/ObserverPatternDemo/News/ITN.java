package ObserverPatternDemo.News;

import ObserverPatternDemo.Subscriber;

public class ITN extends News{

    public ITN(String channelName, int intervalSize) {
        super(channelName, intervalSize);
    }

    @Override
    public void broadcastMessage() {
        for (Subscriber subscriber : subscribers){
            subscriber.sendMessage(this, MessageGenerator.generateMessage(20));
        }
    }
}
