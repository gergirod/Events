package germangirod.goldcoastevents.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;
import germangirod.goldcoastevents.data.model.Location;
import java.io.IOException;
import java.util.List;

/**
 * Created by germangirod on 5/15/16.
 */
public class GeocoderUtil {

    private Context context;
    private Location location;

    public GeocoderUtil(Context context) {
        this.context = context;
        location = new Location();
    }

    public Location getLatitudeAndLongitudeFromString(String place) {
        final Geocoder geocoder = new Geocoder(context);

        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocationName(place+", Gold Coast, Queensland, Australia",1);
            if (addresses != null && !addresses.isEmpty()) {
                Address address = addresses.get(0);

                if (address.getCountryCode() != null && address.getCountryCode().equals("AU")) {

                    location.latitude = address.getLatitude();
                    location.longitude = address.getLongitude();
                }
            }
        } catch (IOException e) {
            Log.e("error ","error "+e);
        }

        return location;
    }
}



