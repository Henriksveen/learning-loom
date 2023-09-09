package org.example;

import java.util.List;

public class EventController {

    public String getJsonListEventString() {
        return """
                [
                    {
                        "id": 1,
                        "name": "Event 1",
                        "description": "Event 1 description"
                    },
                    {
                        "id": 2,
                        "name": "Event 2",
                        "description": "Event 2 description"
                    },
                    {
                        "id": 3,
                        "name": "Event 3",
                        "description": "Event 3 description"
                    }
                ]
                """;
    }

    public String getCsvListEventString() {
        return """
                id,name,description
                1,Event 1,Event 1 description
                2,Event 2,Event 2 description
                3,Event 3,Event 3 description
                """;
    }

    public String getXmlListEventString(){
        return """
                <?xml version="1.0" encoding="UTF-8"?>
                <events>
                    <event>
                        <id>1</id>
                        <name>Event 1</name>
                        <description>Event 1 description</description>
                    </event>
                    <event>
                        <id>2</id>
                        <name>Event 2</name>
                        <description>Event 2 description</description>
                    </event>
                    <event>
                        <id>3</id>
                        <name>Event 3</name>
                        <description>Event 3 description</description>
                    </event>
                </events>
                """;
    }

    public List<Event> getEvents() {
        return List.of(
                new Event(1, "Event 1", "Event 1 description"),
                new Event(2, "Event 2", "Event 2 description"),
                new Event(3, "Event 3", "Event 3 description")
        );
    }
}
