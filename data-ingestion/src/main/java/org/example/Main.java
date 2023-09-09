package org.example;

public class Main {
    public static void main(String[] args) {
        EventController userEndpoint = new EventController();
        EventService eventService = new EventService();
        JsonStringEventMapper jsonStringEventMapper = new JsonStringEventMapper();

        userEndpoint.getJsonListEventString()
                .lines()
                .map(jsonStringEventMapper)
                .forEach(eventService::pushEventToQueue);
    }
}
