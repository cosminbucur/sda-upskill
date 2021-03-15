package com.sda.json;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public class DemoJsonSchema {

    // TIP: use plugins > jsonschma2pojo:generate to generate classes
    public static void main(String[] args) {
        Clock clock = new Clock(Clock.Status.ACTIVE, true);
        List<Event> events = Arrays.asList(
                new Event("Romania", new Time(10, 30)),
                new Event("Germany", new Time(5, 15)));
        ChildObject childObject = new ChildObject(clock, events);
        ComplexSchema complexSchema = new ComplexSchema(
                123,
                ZonedDateTime.of(2019, 12, 21, 6, 26, 51, 933015, ZoneId.of("UTC")),
                "invitation",
                childObject);
        System.out.println(complexSchema);
    }
}
