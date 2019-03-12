package in.skylifetech.ks;

public class Schedule {
    int clusterIcon;
    String eventName, eventVenue, eventTime;

    Schedule(String name, String venue, String time, int icon) {
        eventName = name;
        eventVenue = venue;
        eventTime = time;
        clusterIcon = icon;
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

    public int getClusterIcon() {
        return clusterIcon;
    }
}
