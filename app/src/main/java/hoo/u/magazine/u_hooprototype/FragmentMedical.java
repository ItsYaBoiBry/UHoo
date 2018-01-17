package hoo.u.magazine.u_hooprototype;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class FragmentMedical extends Fragment {
    ImageButton btnConsult, btnHomeCare, btnTherapy, btnAmbulance;

    public FragmentMedical() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_medical, container, false);

        ImageButton bck = (ImageButton) view.findViewById(R.id.btnBack);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        btnConsult = view.findViewById(R.id.btnConsult);
        btnHomeCare = view.findViewById(R.id.btnHomeCare);
        btnTherapy = view.findViewById(R.id.btnTheraphy);
        btnAmbulance = view.findViewById(R.id.btnAmbulance);

        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ActivityMedicalConsult.class));
            }
        });

        return view;
    }
}