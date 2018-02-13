package hoo.u.magazine.u_hooprototype;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ActivityTransport extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap map;
    Button train, car, bus;
    RelativeLayout rl, travelDetailsCar, travelDetailsTrain, getTravelDetailsBus;
    LinearLayout llGrab, llUber, llComfort;
    EditText etYourLocation, etYourDestination;
    LatLng latLng;
    SupportMapFragment mapFragment;
    private GoogleApiClient mGoogleApiClient;
    private static final int PERMISSION_ACCESS_COARSE_LOCATION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        Typeface bold = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-SemiBold.ttf");

        etYourLocation = (EditText) findViewById(R.id.etYourLocation);
        etYourDestination = (EditText) findViewById(R.id.etYourDestination);

        FragmentManager fm = getSupportFragmentManager();
        mapFragment = (SupportMapFragment) fm.findFragmentById(R.id.map);

        TextView tvLabelto = (TextView) findViewById(R.id.tvLabelTo);
        tvLabelto.setTypeface(bold);
        llUber = (LinearLayout) findViewById(R.id.btnUber);
        llComfort = (LinearLayout) findViewById(R.id.btnComfort);
        llGrab = (LinearLayout) findViewById(R.id.btnGrab);
        rl = (RelativeLayout) findViewById(R.id.relativeLayout);

        travelDetailsTrain = (RelativeLayout) findViewById(R.id.rlTravelDetailsTrain);
        travelDetailsTrain.setVisibility(View.INVISIBLE);
        travelDetailsCar = (RelativeLayout) findViewById(R.id.rlTravelDetailsCar);
        travelDetailsCar.setVisibility(View.INVISIBLE);
        getTravelDetailsBus = (RelativeLayout) findViewById(R.id.rlTravelDetailsBus);
        getTravelDetailsBus.setVisibility(View.INVISIBLE);
        train = (Button) findViewById(R.id.train);

        bus = (Button) findViewById(R.id.bus);

        car = (Button) findViewById(R.id.car);
        train.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                getTravelDetailsBus.setVisibility(View.INVISIBLE);
                travelDetailsCar.setVisibility(View.INVISIBLE);
                if (travelDetailsTrain.getVisibility() == View.INVISIBLE) {
                    travelDetailsTrain.setVisibility(View.VISIBLE);

                } else {
                    travelDetailsTrain.setVisibility(View.INVISIBLE);

                }
            }
        });
        car.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                getTravelDetailsBus.setVisibility(View.INVISIBLE);
                if (travelDetailsCar.getVisibility() == View.INVISIBLE) {
                    travelDetailsCar.setVisibility(View.VISIBLE);
                } else {
                    travelDetailsCar.setVisibility(View.INVISIBLE);
                }
                travelDetailsTrain.setVisibility(View.INVISIBLE);
                llGrab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar snackbar = Snackbar.make(rl, "Grab has been selected", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }
                });
                llComfort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar snackbar = Snackbar.make(rl, "Taxi has been selected", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }
                });
                llUber.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar snackbar = Snackbar.make(rl, "Uber has been selected", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }
                });
            }
        });
        bus.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (getTravelDetailsBus.getVisibility() == View.INVISIBLE) {
                    getTravelDetailsBus.setVisibility(View.VISIBLE);
                } else {
                    getTravelDetailsBus.setVisibility(View.INVISIBLE);
                }
                travelDetailsCar.setVisibility(View.INVISIBLE);
                travelDetailsTrain.setVisibility(View.INVISIBLE);
            }
        });

        ImageButton bck = (ImageButton) findViewById(R.id.btnBack);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    public String GetAddressFromLocation(Context context, LatLng latLng) {
        Geocoder coder = new Geocoder(this);
        List<Address> address;

        String retrievedAddress = null;
        try {
            address = coder.getFromLocation(latLng.latitude, latLng.longitude, 1);
            retrievedAddress = address.get(0).getAddressLine(0).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retrievedAddress;
    }

    public LatLng GetLocationFromAddress(Context context, String strAddress) {
        Geocoder coder = new Geocoder(this);
        List<Address> address;
        LatLng currentLocation = null;
        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            currentLocation = new LatLng((double) (location.getLatitude()),
                    (double) (location.getLongitude()));
            Log.e("current Locale", String.valueOf(currentLocation));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentLocation;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        int permissionCheck_Coarse = ContextCompat.checkSelfPermission(
                ActivityTransport.this, android.Manifest.permission.ACCESS_COARSE_LOCATION);
        int permissionCheck_Fine = ContextCompat.checkSelfPermission(
                ActivityTransport.this, android.Manifest.permission.ACCESS_FINE_LOCATION);

        final Location mLocation;
        if (permissionCheck_Coarse == PermissionChecker.PERMISSION_GRANTED
                || permissionCheck_Fine == PermissionChecker.PERMISSION_GRANTED) {
            mLocation = LocationServices.FusedLocationApi.getLastLocation(
                    mGoogleApiClient);

            LocationRequest mLocationRequest = LocationRequest.create();
            mLocationRequest.setPriority(LocationRequest
                    .PRIORITY_HIGH_ACCURACY);
            mLocationRequest.setInterval(5000);
            mLocationRequest.setSmallestDisplacement(100);

            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,
                    mLocationRequest, this);
        } else {
            mLocation = null;
            Toast.makeText(ActivityTransport.this,
                    "Permission not granted to retrieve location info",
                    Toast.LENGTH_SHORT).show();
        }

        if (mLocation != null) {
            Toast.makeText(this, "Lat : " + mLocation.getLatitude() +
                            " Lng : " + mLocation.getLongitude(),
                    Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(this, "Location not Detected",
                    Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    @Override
    public void onLocationChanged(Location location) {
        final Location myLocation = location;
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                LatLng current_location = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(current_location, 18));
                final String address = GetAddressFromLocation(ActivityTransport.this, current_location);

                BitmapDescriptor mapIcon = BitmapDescriptorFactory.fromResource(R.drawable.mapmarker);
                map.addMarker(new MarkerOptions().icon(mapIcon).position(current_location).title("You Are At " + address));
                etYourLocation.setText(address);
            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_ACCESS_COARSE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // All good!

                } else {
                    Toast.makeText(this, "Need your location!", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

}