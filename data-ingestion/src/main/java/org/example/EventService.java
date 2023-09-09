package org.example;

public class EventService {
    public void pushEventToQueue(Event event) {
        System.out.println("Pushing event to queue: " + event);
    }
}
