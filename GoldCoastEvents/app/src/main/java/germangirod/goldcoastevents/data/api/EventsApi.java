package germangirod.goldcoastevents.data.api;

import germangirod.goldcoastevents.data.model.EventResponse;
import rx.Observable;

/**
 * Created by germangirod on 4/8/16.
 */
public class EventsApi implements Events {

    @Override public Observable<EventResponse> getEvents() {
        return RestClient.get().getEvents();
    }

    @Override public Observable<EventResponse> getEventsByCategory(String category) {
        return RestClient.get().getEventsByCategory(category);
    }

    @Override public Observable<EventResponse> getEventByCategoryAndDate(String category, String date) {
        return RestClient.get().getEventsByCategoryAndDate(category, date);
    }

    @Override public Observable<EventResponse> getEventsByDate(String date) {
        return RestClient.get().getEventsByDate(date);
    }
}
