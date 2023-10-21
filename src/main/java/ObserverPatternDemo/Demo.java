package ObserverPatternDemo;

import ObserverPatternDemo.News.Hiru;
import ObserverPatternDemo.News.ITN;
import ObserverPatternDemo.News.News;
import ObserverPatternDemo.News.NewsBroadcaster;

public class Demo {
    public static void main(String[] args) {
//        News news = new News("Generic News Channel");
//        Person personA = new Person("Gary", "Smith");
//        Person personB = new Person("Jane", "Smith");
//
//        personA.subscribe(news);
//        personB.subscribe(news);
//
//        NewsBroadcaster broadcaster = new NewsBroadcaster(news, 1);
//        Thread broadCasterThread = new Thread(broadcaster);
//        broadCasterThread.start();

        Hiru hiru = new Hiru("Hiru News", 5);
        ITN itn = new ITN("ITN News", 10);
        Person personA = new Person("Gary", "Smith");
        Person personB = new Person("James", "Smith");
        Person personC = new Person("Mary", "Smith");
        Person personD = new Person("Jane", "Smith");



        hiru.addSubscriber(personA);
        itn.addSubscriber(personC);

        hiru.addSubscriber(personB);
        itn.addSubscriber(personD);

        NewsBroadcaster hiruBroadcaster = new NewsBroadcaster(hiru);
        Thread hiruBroadcasterThread = new Thread(hiruBroadcaster);
        hiruBroadcasterThread.start();

        NewsBroadcaster itnBroadCaster = new NewsBroadcaster(itn);
        Thread itnBroadcasterThread = new Thread(itnBroadCaster);
        itnBroadcasterThread.start();

    }
}
