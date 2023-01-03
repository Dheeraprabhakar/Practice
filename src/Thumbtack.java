// For some job categories on Thumbtack, customers are able to book a job
// with a pro without having to negotiate a booking time. To power this
// feature, Thumbtack needs to be able to query a pro’s calendar to determine
// if they have any preexisting events that would conflict with the new booking.

// Design and implement a class to power the new pro calendar. Specifically,
// your calendar class must support the following four functions:

// 1. Adding an event -- the pro should be able to create overlapping events
// 2. Retrieving all of the details for a specific event
// 3. Deleting an event
// 4. Computing isSlotFree, which will take a start and an end time and return
//    true if and only if there are no preexisting events that overlap the requested
//    time.

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Event{
    long eventId;
    String eventName;
    long timeslotStart;
    long timeslotEnd;

    Event(long timeslotStart, long timeslotEnd, String eventName, int eventId){
        this.eventId = eventId;
        this.timeslotStart = timeslotStart;
        this.timeslotEnd = timeslotEnd;
        this.eventName = eventName;
    }

}
class CalendarApp{
    static int eventId=0;
    Map<Integer, Event> events = new HashMap<>();
    public void addEvent(long timeslotStart, long timeslotEnd, String eventName){
        int eid = eventId++;
        Event e = new Event(timeslotStart, timeslotEnd, eventName, eid);
        events.put(eid, e);
    }
    public boolean deleteEvent(int eventId){
        if(events.containsKey(eventId)){
            events.remove(eventId);
            return true;
        }
        return false;
    }
    public Event getDetails(int eventId){
        if(events.containsKey(eventId)){
            return events.get(eventId);
        }
        return null;
    }
    public boolean isSlotFree(long timeslotS, long timeslotE){
        Collection<Event> evs  = events.values();
        boolean isSlotFree = true;
        for(Event e:evs){
            if(!(timeslotS<e.timeslotStart && timeslotE < e.timeslotStart) || !(timeslotE>e.timeslotEnd && timeslotS>e.timeslotEnd)){
                isSlotFree = false;
                return isSlotFree;
            }
        }
        return isSlotFree;
    }
}

public class Thumbtack {

    static int addNumbers(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        long startTime=8;
        long endTime=9;
        CalendarApp capp = new CalendarApp();
        capp.addEvent(startTime, endTime, "event1");
        capp.addEvent(12, 14, "event2");
        capp.addEvent(14, 15, "event2");

        capp.deleteEvent(1);

        Event e = capp.getDetails(2);
        System.out.print(e.timeslotStart);

        System.out.print(capp.isSlotFree(10, 13));

    }
}
