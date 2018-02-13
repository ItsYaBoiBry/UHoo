package hoo.u.magazine.u_hooprototype;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by bryan on 10/12/2017.
 */

public class custom_adapter_food_delivery extends ArrayAdapter <TestingRestaurants>{
    private ArrayList<TestingRestaurants> arrayList;
    private Context context;
    private ImageView imgRestaurant, uberEatsLogo, chopeLogo;
    private TextView tvRestaurant;

    public custom_adapter_food_delivery(Context context, int resource, ArrayList<TestingRestaurants> arrayList2){
        super(context,resource,arrayList2);
        arrayList = arrayList2;
        this.context = context;
    }
    public View getView(final int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_food_delivery_listview,parent,false);
        tvRestaurant = (TextView) rowView.findViewById(R.id.tvRest);
        imgRestaurant = (ImageView) rowView.findViewById(R.id.ivRest);
        uberEatsLogo = rowView.findViewById(R.id.uber_eats_logo);
        chopeLogo = rowView.findViewById(R.id.chope_logo);
        tvRestaurant.setText(arrayList.get(position).getImgSrc());
        uberEatsLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        chopeLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActivityWebView.class);
                if(arrayList.get(position).getBooking() == null){
                    Toast.makeText(getContext(), "There is no need to book this place.", Toast.LENGTH_SHORT).show();
                }else {
                    intent.putExtra("link", arrayList.get(position).getBooking());
                    getContext().startActivity(intent);
                }
            }
        });

        Picasso.with(getContext()).load(arrayList.get(position).getTvSrc()).into(imgRestaurant);

        return rowView;
    }
}
