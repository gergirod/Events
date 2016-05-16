package germangirod.goldcoastevents.ui.fragments;

import android.view.View;
import germangirod.goldcoastevents.util.Constants;

/**
 * Created by germangirod on 4/15/16.
 */
public class FamilyEventFragment extends EventFragmentManager {

    public static FamilyEventFragment newInstance() {
        return new FamilyEventFragment();
    }

    @Override public void getEventData() {
        super.getEventData();
        eventsData.getEventsByCategory(Constants.ACTIVE_CATEGORY);
    }

    @Override public void onRowClick(View v, int position) {
        super.onRowClick(v, position);
    }
}
