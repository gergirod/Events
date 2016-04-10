package germangirod.goldcoastevents.data.presenter;

import germangirod.goldcoastevents.data.model.EventResponse;

/**
 * Created by germangirod on 4/10/16.
 */
public interface EventsPresenter {

    void showEvents(EventResponse eventResponse);

    void showError(Throwable throwable);

}
