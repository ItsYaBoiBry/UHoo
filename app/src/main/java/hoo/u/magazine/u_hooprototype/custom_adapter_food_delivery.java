package hoo.u.magazine.u_hooprototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by bryan on 10/12/2017.
 */

public class custom_adapter_food_delivery extends ArrayAdapter <TestingRestaurants>{
    private ArrayList<TestingRestaurants> arrayList;
    private Context context;
    private ImageView imgRestaurant;
    private TextView tvRestaurant;

    public custom_adapter_food_delivery(Context context, int resource, ArrayList<TestingRestaurants> arrayList2){
        super(context,resource,arrayList2);
        arrayList = arrayList2;
        this.context = context;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_food_delivery_listview,parent,false);
        tvRestaurant = (TextView) rowView.findViewById(R.id.tvRest);
        imgRestaurant = (ImageView) rowView.findViewById(R.id.ivRest);
        tvRestaurant.setText(arrayList.get(position).getImgSrc());
        Picasso.with(getContext()).load(arrayList.get(position).getTvSrc()).into(imgRestaurant);

        return rowView;
    }
}
