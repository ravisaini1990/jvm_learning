package design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternPractice {

    public static void main(String[] args) {
        IYoutubeLiveObservable youtubeLiveObservable= new YoutubeLiveObservable();

        ISubscriberObserver subscriberObserver =  new Subscriber1(youtubeLiveObservable);
        ISubscriberObserver subscriberObserver2 =  new Subscriber2(youtubeLiveObservable);
        ISubscriberObserver subscriberObserver3 =  new Subscriber3(youtubeLiveObservable);
        ISubscriberObserver subscriberObserver1 =  new Subscriber1(youtubeLiveObservable);

        youtubeLiveObservable.JoinLive(subscriberObserver);
        youtubeLiveObservable.JoinLive(subscriberObserver2);
        youtubeLiveObservable.JoinLive(subscriberObserver1);
        youtubeLiveObservable.JoinLive(subscriberObserver3);
        youtubeLiveObservable.notifySubscribers();

        youtubeLiveObservable.UnJoinLive(subscriberObserver3);
        youtubeLiveObservable.notifySubscribers();
        youtubeLiveObservable.UnJoinLive(subscriberObserver);
        youtubeLiveObservable.notifySubscribers();
        youtubeLiveObservable.UnJoinLive(subscriberObserver1);
        youtubeLiveObservable.notifySubscribers();

        //since list is empty , it won't print
        youtubeLiveObservable.UnJoinLive(subscriberObserver2);
        youtubeLiveObservable.notifySubscribers();
    }

}

interface IYoutubeLiveObservable {

    void JoinLive(ISubscriberObserver subscriberObserver);

    void UnJoinLive(ISubscriberObserver subscriberObserver);

    void notifySubscribers();

    int totalMembers();
}

class  YoutubeLiveObservable implements  IYoutubeLiveObservable {

    List<ISubscriberObserver> subscriberObserverList;
    YoutubeLiveObservable() {
        this.subscriberObserverList = new ArrayList<>();
    }

    @Override
    public void JoinLive(ISubscriberObserver subscriberObserver) {
        subscriberObserverList.add(subscriberObserver);
    }

    @Override
    public void UnJoinLive(ISubscriberObserver subscriberObserver) {
        subscriberObserverList.remove(subscriberObserver);
    }

    @Override
    public void notifySubscribers() {
        while (!subscriberObserverList.isEmpty()) {
            subscriberObserverList.forEach(ISubscriberObserver::notifySubscriber);
            System.out.println("Notify Subscribers : " + subscriberObserverList.size());
            try {
                Thread.sleep(2000);
                break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public int totalMembers() {
        return subscriberObserverList.size();
    }
}


interface ISubscriberObserver {
    void notifySubscriber();
}

class Subscriber1 implements ISubscriberObserver {
    final IYoutubeLiveObservable iYoutubeLiveObservable;

    Subscriber1(IYoutubeLiveObservable iYoutubeLiveObservable) {
        this.iYoutubeLiveObservable = iYoutubeLiveObservable;
    }


    @Override
    public void notifySubscriber() {
        System.out.println("Notify Subscriber1 :: Total Subscribers " + iYoutubeLiveObservable.totalMembers());
    }
}

class Subscriber2 implements ISubscriberObserver {
    final IYoutubeLiveObservable iYoutubeLiveObservable;

    Subscriber2(IYoutubeLiveObservable iYoutubeLiveObservable) {
        this.iYoutubeLiveObservable = iYoutubeLiveObservable;
    }


    @Override
    public void notifySubscriber() {
        iYoutubeLiveObservable.totalMembers();
       // System.out.println("Notify Subscriber2 :: Total Subscribers " + iYoutubeLiveObservable.totalMembers());
    }
}

class Subscriber3 implements ISubscriberObserver {
    final IYoutubeLiveObservable iYoutubeLiveObservable;

    Subscriber3(IYoutubeLiveObservable iYoutubeLiveObservable) {
        this.iYoutubeLiveObservable = iYoutubeLiveObservable;
    }


    @Override
    public void notifySubscriber() {
       // System.out.println("Notify Subscriber3 :: Total Subscribers " + iYoutubeLiveObservable.totalMembers());
        iYoutubeLiveObservable.totalMembers();
    }
}
