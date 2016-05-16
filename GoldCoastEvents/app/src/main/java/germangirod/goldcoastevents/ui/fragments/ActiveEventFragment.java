package germangirod.goldcoastevents.ui.fragments;

import android.view.View;
import germangirod.goldcoastevents.util.Constants;

/**
 * Created by germangirod on 4/15/16.
 */
public class ActiveEventFragment extends EventFragmentManager {

    public static ActiveEventFragment newInstance() {
        return new ActiveEventFragment();
    }

    @Override public void getEventData() {
        super.getEventData();
        eventsData.getEventsByCategory(Constants.ACTIVE_CATEGORY);
    }

    @Override public void onRowClick(View v, int position) {
        super.onRowClick(v, position);
    }
}
