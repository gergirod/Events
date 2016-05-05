package germangirod.goldcoastevents.ui.fragments;

import android.view.View;
import germangirod.goldcoastevents.Constants;

/**
 * Created by germangirod on 4/15/16.
 */
public class SeniorEventFragment extends EventFragmentManager {

    public static SeniorEventFragment newInstance() {
        return new SeniorEventFragment();
    }

    @Override public void getEventData() {
        super.getEventData();
        eventsData.getEventsByCategory(Constants.SENIOR_CATEGORY);
    }

    @Override public void onRowClick(View v, int position) {
        super.onRowClick(v, position);
    }
}
