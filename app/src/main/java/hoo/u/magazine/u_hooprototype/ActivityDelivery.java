package hoo.u.magazine.u_hooprototype;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class ActivityDelivery extends AppCompatActivity {
    TextView title;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        title = (TextView) findViewById(R.id.tvTitle);

        //back btn toolbar
        ImageButton bck = (ImageButton) findViewById(R.id.btnBack);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        int deliveryType = intent.getIntExtra("delivery", 0);
        if (deliveryType == 0) {
            title.setText("Small Packages");
        } else if (deliveryType == 1) {
            title.setText("Bigger and Bulkier");
        }

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
    }

}
