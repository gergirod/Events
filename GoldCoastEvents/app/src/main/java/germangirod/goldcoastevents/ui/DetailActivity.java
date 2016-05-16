package germangirod.goldcoastevents.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import germangirod.goldcoastevents.R;
import germangirod.goldcoastevents.data.model.Event;
import germangirod.goldcoastevents.ui.fragments.DetailFragment;

/**
 * Created by germangirod on 5/10/16.
 */
public class DetailActivity extends AppCompatActivity {

    private android.app.FragmentTransaction fragmentTransaction;
    private Event event;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        getExtras();
        setFragment();
    }

    private void getExtras() {

        Bundle bundle = getIntent().getExtras();
        event = bundle.getParcelable("event");
    }

    private void setFragment() {
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_content, DetailFragment.getInstance(event));
        fragmentTransaction.commit();
    }
}



