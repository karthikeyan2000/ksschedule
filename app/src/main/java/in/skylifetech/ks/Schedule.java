package in.skylifetech.ks;

public class Schedule {
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

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }
}
