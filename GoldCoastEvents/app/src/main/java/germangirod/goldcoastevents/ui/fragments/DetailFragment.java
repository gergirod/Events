package germangirod.goldcoastevents.ui.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import germangirod.goldcoastevents.R;
import germangirod.goldcoastevents.data.model.Event;
import germangirod.goldcoastevents.data.model.Location;
import germangirod.goldcoastevents.util.GeocoderUtil;

/**
 * Created by germangirod on 4/19/16.
 */
public class DetailFragment extends MapBaseFragment {

    private Event event;
    private TextView costTextView, typeTextView, webTextView, eventName, eventDescription , eventDate;
    private android.support.v7.widget.Toolbar toolbar;
    private AppBarLayout appBarLayout;

    public static android.app.Fragment getInstance(Event event) {

        DetailFragment detailFragment = new DetailFragment();
        Bundle arguments = new Bundle();
        arguments.putParcelable("event", event);
        detailFragment.setArguments(arguments);

        return detailFragment;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment, container, false);

        //toolbar = (android.support.v7.widget.Toolbar) v.findViewById(R.id.toolbar);
        costTextView = (TextView) v.findViewById(R.id.costTextView);
        typeTextView = (TextView) v.findViewById(R.id.typeTextView);
        webTextView = (TextView) v.findViewById(R.id.webTextView);
        eventName = (TextView)v.findViewById(R.id.event_name);
        eventDescription = (TextView)v.findViewById(R.id.event_description);
        eventDate = (TextView)v.findViewById(R.id.event_date);
        //appBarLayout = (AppBarLayout)v.findViewById(R.id.appbar);

        //appBarLayout.setExpanded(false);
        getBundleData();
        setMap();

        return v;
    }



    private void getBundleData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            event = arguments.getParcelable("event");
            setDataIntoView();
        }
    }

    private void setDataIntoView() {
        typeTextView.append(" " + event.getType());
        costTextView.append(" " + event.getCost());
        eventName.setText(event.getEventTitle());
        eventDescription.setText(event.getEventDescription());
        eventDate.setText(event.getDetailDate());
        webTextView.setText(Html.fromHtml(event.getWeb()));
        webTextView.setMovementMethod(LinkMovementMethod.getInstance());

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
        GeocoderUtil geocoderUtil = new GeocoderUtil(getActivity());
        Location location= geocoderUtil.getLatitudeAndLongitudeFromString(event.getEventPlace());
        if(location.getLatitude()!=0 && location.getLongitude()!=0){

            LatLng sydney = new LatLng(location.getLatitude(), location.getLongitude());
            this.googleMap.addMarker(new MarkerOptions().position(sydney).title(event.getEventTitle()));
            this.googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 16.0f));
        }

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_detail, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
