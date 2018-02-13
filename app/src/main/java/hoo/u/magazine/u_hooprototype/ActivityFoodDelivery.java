package hoo.u.magazine.u_hooprototype;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.ListUpdateCallback;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivityFoodDelivery extends AppCompatActivity {
    ListView listView;
    ArrayList<TestingRestaurants> restaurants;
    ArrayList<TestingRestaurants> selectedResaurants;
    ArrayAdapter aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_delivery);
        ImageButton bck = (ImageButton) findViewById(R.id.btnBack);

        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        Intent getKey = getIntent();
        String key = getKey.getStringExtra("key");
        listView = (ListView) findViewById(R.id.lvFood);
        restaurants = new ArrayList<TestingRestaurants>();
        selectedResaurants = new ArrayList<TestingRestaurants>();
        aa =  new custom_adapter_food_delivery(this, R.layout.custom_food_delivery_listview,selectedResaurants);
        listView.setAdapter(aa);
        restaurants.add(new TestingRestaurants(1,"MacDonald's","https://data.whicdn.com/images/12405129/large.jpg"));
        restaurants.add(new TestingRestaurants(1,"KFC","https://farm1.staticflickr.com/722/21507528168_befd796920_c.jpg"));
        restaurants.add(new TestingRestaurants(2,"Club Street Social","http://d2jzxcrnybzkkt.cloudfront.net/uploads/2017/09/CSS_Seared_Scallops_jpg_1505863967.jpg?date=201802121000","http://www.chope.co/singapore-restaurants/restaurant/club-street-social"));
        restaurants.add(new TestingRestaurants(2,"Ninja Cut","http://d2jzxcrnybzkkt.cloudfront.net/uploads/2017/07/Ninja_Cut_1_Beefy_Patty_Macaro_1500954652.jpg?date=201802121000","http://www.chope.co/singapore-restaurants/restaurant/ninja-cut"));
        aa.notifyDataSetChanged();
        for( int i = 0; i < restaurants.size(); i++){
            if(restaurants.get(i).getId() == Integer.parseInt(key)){
                selectedResaurants.add(restaurants.get(i));
            }
            else{
                Log.e("restaurant error","Not restaurant category");
            }
        }
        aa.notifyDataSetChanged();


    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
