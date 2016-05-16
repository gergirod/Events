package germangirod.goldcoastevents.ui.fragments;

import android.view.View;
import germangirod.goldcoastevents.util.Constants;

/**
 * Created by germangirod on 4/15/16.
 */
public class FoodEventFragment extends EventFragmentManager {

    public static FoodEventFragment newInstance() {
        return new FoodEventFragment();
    }

    @Override public void getEventData() {
        super.getEventData();
        eventsData.getEventsByCategory(Constants.FOOD_CATEGORY);
    }

    @Override public void onRowClick(View v, int position) {
        super.onRowClick(v, position);
    }
}
