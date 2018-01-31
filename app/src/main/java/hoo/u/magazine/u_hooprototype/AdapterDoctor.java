package hoo.u.magazine.u_hooprototype;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import android.widget.Filter;

import com.squareup.picasso.Picasso;


import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by bryan on 16/1/2018.
 */

public class AdapterDoctor extends ArrayAdapter<ClassDoctor>{
    private ArrayList<ClassDoctor> doctors;
    private Context context;
    private TextView tvDocName, tvDocPrice, tvDocPosition;
    private CircleImageView docImg;

    public AdapterDoctor(Context context, int resources, ArrayList<ClassDoctor> doctor){
        super(context,resources,doctor);
        doctors = doctor;
        this.context = context;
    }
    public View getView(int position, View converView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_doctor_list, parent, false);
        tvDocName = rowView.findViewById(R.id.docName);
        tvDocPosition = rowView.findViewById(R.id.docPosition);
        tvDocPrice = rowView.findViewById(R.id.docPrice);
        docImg = rowView.findViewById(R.id.docImg);

        tvDocName.setText(doctors.get(position).getDocName());
        tvDocPosition.setText(doctors.get(position).getDocPosition());
        tvDocPrice.setText("SGD " + String.valueOf(doctors.get(position).getDocPrice()) + " per 15 minutes");
        Picasso.with(getContext()).load(doctors.get(position).getDocImage()).into(docImg);

        return rowView;
    }

}
