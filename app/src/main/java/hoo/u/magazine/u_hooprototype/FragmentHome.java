package hoo.u.magazine.u_hooprototype;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {
    ImageButton btnTransport, btnMedical, btnServices, btnLifestyle;


    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_home, container, false);

        Typeface bold = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Montserrat-SemiBold.ttf");

        btnLifestyle = (ImageButton) view.findViewById(R.id.catLifestyle);
        btnMedical = (ImageButton) view.findViewById(R.id.catMedical);
        btnServices = (ImageButton) view.findViewById(R.id.catServices);
        btnTransport = (ImageButton) view.findViewById(R.id.catTransport);


        btnTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext(),ActivityTransport.class));
            }
        });

        btnServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new FragmentServices();
                replaceFragment(fragment);
                // do something here
            }
        });

        btnMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new FragmentMedical();
                replaceFragment(fragment);
                // do something here
            }
        });

        btnLifestyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new FragmentLifestyle();
                replaceFragment(fragment);
                // do something here
            }
        });

        return view;
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrameLayout, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
