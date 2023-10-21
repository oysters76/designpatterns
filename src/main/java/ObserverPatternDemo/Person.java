package ObserverPatternDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Person implements Subscriber{
    private String fname;
    private String lname;

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getName(){
        return fname + " " + lname;
    }

    @Override
    public void subscribe(Observer observer) {
        observer.addSubscriber(this);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observer.removeSubscriber(this);
    }

    private String formatDate(Date date)  {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy hh:mm:ss");
        return dateFormat.format(date);
    }

    @Override
    public void sendMessage(Observer observer, String message) {
        System.out.println(this.getName() + " : " + observer.getName() + " : " + formatDate(new Date()) + " : " + message);
    }
}
