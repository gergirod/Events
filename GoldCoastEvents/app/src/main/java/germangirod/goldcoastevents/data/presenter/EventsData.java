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

    public void setView(EventsPresenter eventsPresenter){
        this.eventsPresenter = eventsPresenter;
    }

    public void getEvents(){
        EventsApi eventsApi = new EventsApi();
        eventsApi.getEvents()
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
