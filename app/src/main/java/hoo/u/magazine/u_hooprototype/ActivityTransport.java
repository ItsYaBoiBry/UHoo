package hoo.u.magazine.u_hooprototype;

import android.content.Context;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivityTransport extends AppCompatActivity {

    private GoogleMap map;
    Button train, car, bus;
    RelativeLayout rl, travelDetailsCar, travelDetailsTrain, getTravelDetailsBus;
    LinearLayout llGrab, llUber, llComfort;
    EditText etYourLocation, etYourDestination;
    LatLng latLng;
    ImageView toolbarLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Quicksand-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        Typeface bold = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");

        etYourLocation = (EditText) findViewById(R.id.etYourLocation);
        etYourDestination = (EditText) findViewById(R.id.etYourDestination);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                LatLng poi_CausewayPoint = new LatLng(1.436065, 103.786263);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_CausewayPoint, 15));
            }

        });
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
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}