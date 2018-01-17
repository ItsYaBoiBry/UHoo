package hoo.u.magazine.u_hooprototype;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentServices extends Fragment {

    ImageButton foodDelivery, delivery;
    LinearLayout llFoodDelivery, llDelivery;
    Button btnFastFood, btnRest, btnSmallDelivery, btnBigDelivery;


    public FragmentServices() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_services, container, false);

        btnFastFood = (Button) view.findViewById(R.id.btnFastFood);
        btnRest = (Button) view.findViewById(R.id.btnAroundMe);
        btnSmallDelivery = (Button) view.findViewById(R.id.btnPackageDeliveries);
        btnBigDelivery = (Button) view.findViewById(R.id.btnMovingBulk);

        llFoodDelivery = (LinearLayout) view.findViewById(R.id.foodDeliveryExpand);
        llFoodDelivery.setVisibility(View.GONE);
        llDelivery = (LinearLayout) view.findViewById(R.id.deliveryExpand);
        llDelivery.setVisibility(View.GONE);
        foodDelivery = (ImageButton) view.findViewById(R.id.catFoodDelivery);

        //back btn toolbar
        ImageButton bck = (ImageButton) view.findViewById(R.id.btnBack);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

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
                Intent intent = new Intent(getContext(), ActivityFoodDelivery.class);
                intent.putExtra("key", "1");
                startActivity(intent);
            }
        });

        //Food Delivery Restaurants
        btnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityFoodDelivery.class);
                intent.putExtra("key", "2");
                startActivity(intent);
            }
        });

        //Delivery Category
        delivery = (ImageButton) view.findViewById(R.id.catDelivery);
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
                Intent intent = new Intent(getContext(), ActivityDelivery.class);
                intent.putExtra("delivery", 0);
                startActivity(intent);
            }
        });
        //Bulky Delivery
        btnBigDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityDelivery.class);
                intent.putExtra("delivery", 1);
                startActivity(intent);
            }
        });


        return view;
    }

}
