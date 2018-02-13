package hoo.u.magazine.u_hooprototype;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
        AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
        adb.setTitle("Disclaimer");
        adb.setMessage("By Clicking on the 'Agree' Button, you consent to providing your Name, Address, Medical History and other personal particulars to the doctors.<include Privacy Policy and Terms and Conditions here> and the rest of the disclaimer");
        adb.setPositiveButton("Agree", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        adb.setNegativeButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        AlertDialog dialog = adb.create();
        dialog.show();

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