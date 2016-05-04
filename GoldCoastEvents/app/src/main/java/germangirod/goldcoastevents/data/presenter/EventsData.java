package germangirod.goldcoastevents.data.presenter;

import germangirod.goldcoastevents.data.api.EventsApi;
import germangirod.goldcoastevents.data.model.EventResponse;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by germangirod on 4/10/16.
 */
public class EventsData {

    private EventsPresenter eventsPresenter;
    private EventsApi eventsApi;

    public EventsData() {
        eventsApi = new EventsApi();
    }

    public void setView(EventsPresenter eventsPresenter) {
        this.eventsPresenter = eventsPresenter;
    }

    public void getEvents() {
        eventsApi.getEvents().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<EventResponse>() {
            @Override public void call(EventResponse eventResponse) {
                eventsPresenter.showEvents(eventResponse);
            }
        }, new Action1<Throwable>() {
            @Override public void call(Throwable throwable) {
                eventsPresenter.showError(throwable);
            }
        });
    }

    public void getEventsByDate(String date) {

        eventsApi.getEventsByDate(date).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<EventResponse>() {
            @Override public void call(EventResponse eventResponse) {
                eventsPresenter.showEvents(eventResponse);
            }
        }, new Action1<Throwable>() {
            @Override public void call(Throwable throwable) {
                eventsPresenter.showError(throwable);
            }
        });
    }

    public void getEventsByCategory(String category) {
        eventsApi.getEventsByCategory(category).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<EventResponse>() {
            @Override public void call(EventResponse eventResponse) {
                eventsPresenter.showEvents(eventResponse);
            }
        }, new Action1<Throwable>() {
            @Override public void call(Throwable throwable) {
                eventsPresenter.showError(throwable);
            }
        });
    }

    public void getEventsByCategoryAndDate(String category, String date) {

        eventsApi.getEventByCategoryAndDate(category, date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<EventResponse>() {
                    @Override public void call(EventResponse eventResponse) {
                        eventsPresenter.showEvents(eventResponse);
                    }
                }, new Action1<Throwable>() {
                    @Override public void call(Throwable throwable) {
                        eventsPresenter.showError(throwable);
                    }
                });
    }
}
