package germangirod.goldcoastevents.data.api;

import germangirod.goldcoastevents.data.model.EventResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by germangirod on 4/8/16.
 */
public interface Api {

    @GET("api/getEvents.php") Observable<EventResponse> getEvents();

    @GET("/getEventsByCategory.php") Observable<EventResponse> getEventsByCategory(@Query("category") String category);

    @GET("/getEventsByCategoryAndDate.php") Observable<EventResponse> getEventsByCategoryAndDate(@Query("category") String category,
            @Query("date") String date);

    @GET("/getEventsByDate.php") Observable<EventResponse> getEventsByDate(@Query("date") String date);
}
