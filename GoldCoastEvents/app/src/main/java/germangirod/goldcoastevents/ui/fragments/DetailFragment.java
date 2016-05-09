package germangirod.goldcoastevents.ui.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;
import germangirod.goldcoastevents.R;

/**
 * Created by germangirod on 4/19/16.
 */
public class DetailFragment extends MapBaseFragment {

    private ImageView imageView;

    public static android.app.Fragment getInstance() {

        DetailFragment detailFragment = new DetailFragment();
        /*Bundle arguments = new Bundle();
        arguments.putParcelable("event", Parcels.wrap(weatherResponse));
        locationWeatherForecastFragment.setArguments(arguments);*/

        return detailFragment;
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment, container, false);

        imageView = (ImageView)v.findViewById(R.id.event_detail_image);

        Picasso.with(getActivity()).load("http://www.eatcleanlivehealthy.com/wp-content/uploads/2011/01/become-more-active.jpg").into(imageView);

        setMap();

        return v;
    }

    private void setMap() {

        FragmentManager fragmentManager = getChildFragmentManager();
        MapFragment mapFragment = new MapFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.map, mapFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit();
        mapFragment.getMapAsync(this);
    }

    @Override public void onMapReady(GoogleMap googleMap) {
        super.onMapReady(googleMap);
        this.googleMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        this.googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
