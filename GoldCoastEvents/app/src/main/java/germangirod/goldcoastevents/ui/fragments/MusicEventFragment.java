package germangirod.goldcoastevents.ui.fragments;

import android.view.View;
import germangirod.goldcoastevents.util.Constants;

/**
 * Created by germangirod on 4/15/16.
 */
public class MusicEventFragment extends EventFragmentManager  {

    public static MusicEventFragment newInstance() {
        return new MusicEventFragment();
    }

    @Override public void getEventData() {
        super.getEventData();
        eventsData.getEventsByCategory(Constants.MUSIC_CATEGORY);
    }

    @Override public void onRowClick(View v, int position) {
        super.onRowClick(v, position);
    }
}
