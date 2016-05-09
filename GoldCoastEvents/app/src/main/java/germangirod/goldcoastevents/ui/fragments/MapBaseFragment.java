package germangirod.goldcoastevents.ui.fragments;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by germangirod on 5/9/16.
 */
public class MapBaseFragment extends android.app.Fragment implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener {
    public GoogleMap googleMap;

    @Override public void onMapLongClick(LatLng latLng) {

    }

    @Override public void onMapReady(GoogleMap googleMap) {


    }
}
