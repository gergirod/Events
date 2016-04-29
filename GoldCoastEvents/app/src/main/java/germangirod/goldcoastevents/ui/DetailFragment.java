package germangirod.goldcoastevents.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import germangirod.goldcoastevents.R;

/**
 * Created by germangirod on 4/19/16.
 */
public class DetailFragment extends android.app.Fragment {

    private ImageView imageView;

    public static android.app.Fragment getInstance() {

        android.app.Fragment detailFragment = new DetailFragment();
        /*Bundle arguments = new Bundle();
        arguments.putParcelable("event", Parcels.wrap(weatherResponse));
        locationWeatherForecastFragment.setArguments(arguments);*/

        return detailFragment;
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment, container, false);

        imageView = (ImageView)v.findViewById(R.id.event_detail_image);

        Picasso.with(getActivity()).load("http://www.eatcleanlivehealthy.com/wp-content/uploads/2011/01/become-more-active.jpg").into(imageView);

        return v;
    }
}
