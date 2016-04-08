package germangirod.goldcoastevents.data.api;

import germangirod.goldcoastevents.data.model.EventResponse;
import rx.Observable;

/**
 * Created by germangirod on 4/8/16.
 */
public interface Events {

    Observable<EventResponse> getEvents();

    Observable<EventResponse> getEventsByCategory(String category);

    Observable<EventResponse> getEventByCategoryAndDate(String category, String date);

    Observable<EventResponse> getEventsByDate(String date);
}
