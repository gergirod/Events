package germangirod.goldcoastevents.ui.fragments;

import android.view.View;
import germangirod.goldcoastevents.Constants;

/**
 * Created by germangirod on 4/15/16.
 */
public class SportEventFragment extends EventFragmentManager {

    public static SportEventFragment newInstance() {
        return new SportEventFragment();
    }

    @Override public void getEventData() {
        super.getEventData();
        eventsData.getEventsByCategory(Constants.SPORT_CATEGORY);
    }

    @Override public void onRowClick(View v, int position) {
        super.onRowClick(v, position);
    }
}
