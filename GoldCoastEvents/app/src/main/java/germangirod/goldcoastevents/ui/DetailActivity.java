package germangirod.goldcoastevents.ui;

import android.app.Activity;
import android.os.Bundle;
import germangirod.goldcoastevents.R;
import germangirod.goldcoastevents.ui.fragments.DetailFragment;

/**
 * Created by germangirod on 4/17/16.
 */
public class DetailActivity extends Activity {

    private android.app.FragmentTransaction fragmentTransaction;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        setFragment();


    }

    private void setFragment() {
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_content, DetailFragment.getInstance());
        fragmentTransaction.commit();
    }
}
