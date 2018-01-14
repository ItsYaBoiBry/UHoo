package hoo.u.magazine.u_hooprototype;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivityServices extends AppCompatActivity {
    ImageButton foodDelivery, delivery;
    LinearLayout llFoodDelivery, llDelivery;
    ImageView toolbarLogo;
    Button btnFastFood, btnRest, btnSmallDelivery, btnBigDelivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Quicksand-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        //back btn toolbar
        ImageButton bck = (ImageButton) findViewById(R.id.btnBack);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        btnFastFood = (Button) findViewById(R.id.btnFastFood);
        btnRest = (Button) findViewById(R.id.btnAroundMe);
        btnSmallDelivery = (Button) findViewById(R.id.btnPackageDeliveries);
        btnBigDelivery = (Button) findViewById(R.id.btnMovingBulk);

        llFoodDelivery = (LinearLayout) findViewById(R.id.foodDeliveryExpand);
        llFoodDelivery.setVisibility(View.GONE);
        llDelivery = (LinearLayout) findViewById(R.id.deliveryExpand);
        llDelivery.setVisibility(View.GONE);
        foodDelivery = (ImageButton) findViewById(R.id.catFoodDelivery);

        //Food Delivery Category
        foodDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (llFoodDelivery.getVisibility() == View.GONE) {
                    llFoodDelivery.setVisibility(View.VISIBLE);
                } else {
                    llFoodDelivery.setVisibility(View.GONE);
                }

            }
        });
        //Food Delivery Fast food
        btnFastFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityServices.this, ActivityFoodDelivery.class);
                intent.putExtra("key", "1");
                startActivity(intent);
            }
        });

        //Food Delivery Restaurants
        btnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityServices.this, ActivityFoodDelivery.class);
                intent.putExtra("key", "2");
                startActivity(intent);
            }
        });

        //Delivery Category
        delivery = (ImageButton) findViewById(R.id.catDelivery);
        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (llDelivery.getVisibility() == View.GONE) {
                    llDelivery.setVisibility(View.VISIBLE);

                } else {
                    llDelivery.setVisibility(View.GONE);
                }

            }
        });
        //Small Delivery
        btnSmallDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityServices.this, ActivityDelivery.class);
                intent.putExtra("delivery", 0);
                startActivity(intent);
            }
        });
        //Bulky Delivery
        btnBigDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityServices.this, ActivityDelivery.class);
                intent.putExtra("delivery", 1);
                startActivity(intent);
            }
        });


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(ActivityServices.this, MainActivity.class));
                case R.id.navigation_history:
                    return true;
                case R.id.navigation_wallet:
                    return true;
                case R.id.navigation_account:
                    return true;
                case R.id.navigation_help:
                    return true;
            }
            return false;
        }
    };
}
