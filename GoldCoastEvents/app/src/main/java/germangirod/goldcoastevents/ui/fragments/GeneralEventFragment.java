package germangirod.goldcoastevents.ui.fragments;

import android.view.View;
import germangirod.goldcoastevents.util.Constants;

/**
 * Created by germangirod on 4/15/16.
 */
public class GeneralEventFragment extends EventFragmentManager {

    public static GeneralEventFragment newInstance() {
        return new GeneralEventFragment();
    }

    @Override public void getEventData() {
        super.getEventData();
        eventsData.getEventsByCategory(Constants.GENERAL_CATEGORY);
    }

    @Override public void onRowClick(View v, int position) {
        super.onRowClick(v, position);
    }
}
