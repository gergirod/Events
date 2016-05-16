package germangirod.goldcoastevents.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/**
 * Created by germangirod on 4/8/16.
 */
public class Event implements Parcelable {

    public String eventTitle;
    public String eventDescription;
    public String eventLink;
    public String eventImageUrl;
    public String eventBigImageUrl;
    public String eventDate;
    public String eventDetailPlace;
    public String eventDetailDate;
    public String eventCost;
    public String eventType;
    public String eventContact;
    public String eventOrganization;
    public String eventPhone;
    public String eventEmail;
    public String eventWeb;
    public String eventCategory;
    public Date startDate;
    public Date endDate;

    public String getEventTitle() {
        return replaceRareCharsets(eventTitle);
    }

    public String getEventDescription() {
        return replaceRareCharsets(eventDescription);
    }

    public String getEventLink() {
        return eventLink;
    }

    public String getEventImageUrl() {
        return eventImageUrl;
    }

    public String getEventDetailImageUrl() {
        return eventBigImageUrl;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventPlace() {
        return eventDetailPlace;
    }

    public String getDetailDate() {
        return fixDetailDate();
    }

    public String getType() {
        return eventType;
    }

    public String getContact() {
        return eventContact;
    }

    public String getOrganization() {
        return eventOrganization;
    }

    public String getPhone() {
        return eventPhone;
    }

    public String getEmail() {
        return eventEmail;
    }

    public String getWeb() {
        return createLinkFromText();
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getCost() {
        return eventCost;
    }

    private String createLinkFromText(){

        return "<a href=\""+eventLink+"\">Link To Event</a> ";

    }

    private String fixDetailDate(){

        String newDate="";

        int from;
        int to;

        from = eventDetailDate.indexOf("From");
        to = eventDetailDate.indexOf("To");

        newDate = eventDetailDate.substring(from, to-1);

        newDate = newDate +"\n"+eventDetailDate.substring(to, eventDetailDate.length());

        return newDate;


    }

    private String replaceRareCharsets(String s) {
        if (s.indexOf("&#38;") != -1) {

            return s.replace("&#38;", "and");
        }
        if(s.indexOf("&amp")!=-1){

            return s.replace("&amp", "and");
        }

        return s;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(replaceRareCharsets(eventTitle));
        dest.writeString(replaceRareCharsets(eventDescription));
        dest.writeString(eventLink);
        dest.writeString(eventImageUrl);
        dest.writeString(eventBigImageUrl);
        dest.writeString(eventDate);
        dest.writeString(eventDetailPlace);
        dest.writeString(eventDetailDate);
        dest.writeString(eventCost);
        dest.writeString(eventType);
        dest.writeString(eventContact);
        dest.writeString(eventOrganization);
        dest.writeString(eventPhone);
        dest.writeString(eventEmail);
        dest.writeString(eventWeb);
        //dest.writeString(eventCategory);
        //dest.writeSerializable(startDate);
        //dest.writeSerializable(endDate);


    }

    private Event(Parcel in) {
        eventTitle = in.readString();
        eventDescription = in.readString();
        eventLink = in.readString();
        eventImageUrl = in.readString();
        eventBigImageUrl = in.readString();
        eventDate = in.readString();
        eventDetailPlace = in.readString();
        eventDetailDate = in.readString();
        eventCost = in.readString();
        eventType = in.readString();
        eventContact = in.readString();
        eventOrganization = in.readString();
        eventPhone = in.readString();
        eventEmail = in.readString();
        eventWeb = in.readString();
        //eventCategory = in.readString();
//        startDate = (java.util.Date) in.readSerializable();
//        endDate = (java.util.Date) in.readSerializable();*/
    }

    public static final Parcelable.Creator<Event> CREATOR
            = new Parcelable.Creator<Event>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
}
