package org.example;

import java.util.function.Function;

public class JsonStringEventMapper implements Function<String, Event> {

    @Override
    public Event apply(String jsonString){
       return new Event(
                1,
                "Event 1",
                "Event 1 description"
       );
    }
}
