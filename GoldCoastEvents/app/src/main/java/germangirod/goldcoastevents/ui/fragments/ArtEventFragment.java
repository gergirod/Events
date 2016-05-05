package germangirod.goldcoastevents.ui.fragments;

import android.view.View;
import germangirod.goldcoastevents.Constants;

/**
 * Created by germangirod on 4/15/16.
 */
public class ArtEventFragment extends EventFragmentManager {

    public static ArtEventFragment newInstance() {
        return new ArtEventFragment();
    }

    @Override public void getEventData() {
        super.getEventData();
        eventsData.getEventsByCategory(Constants.ART_CATEGORY);
    }

    @Override public void onRowClick(View v, int position) {
        super.onRowClick(v, position);
    }
}
