package in.skylifetech.ks;

public class Schedule {     //Modal class for ScheduleAdapter.
    String eventName, eventVenue, eventTime;

    Schedule(String name, String venue, String time) {
        eventName = name;
        eventVenue = venue;
        eventTime = time;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventVenue() {
        return eventVenue;
    }
}
