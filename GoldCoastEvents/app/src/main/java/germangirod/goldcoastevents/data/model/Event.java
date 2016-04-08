package germangirod.goldcoastevents.data.model;

import java.util.Date;

/**
 * Created by germangirod on 4/8/16.
 */
public class Event {

    public String eventName;
    public String eventDescription;
    public String eventLink;
    public String eventImageUrl;
    public String eventDetailImageUrl;
    public String eventDate;
    public String eventPlace;
    public String detailDate;
    public String cost;
    public String type;
    public String contact;
    public String organization;
    public String phone;
    public String email;
    public String web;
    public String eventCategory;
    public Date startDate;
    public Date $endDate;

    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventLink() {
        return eventLink;
    }

    public String getEventImageUrl() {
        return eventImageUrl;
    }

    public String getEventDetailImageUrl() {
        return eventDetailImageUrl;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public String getDetailDate() {
        return detailDate;
    }

    public String getType() {
        return type;
    }

    public String getContact() {
        return contact;
    }

    public String getOrganization() {
        return organization;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getWeb() {
        return web;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date get$endDate() {
        return $endDate;
    }

    public String getCost() {
        return cost;
    }
}
