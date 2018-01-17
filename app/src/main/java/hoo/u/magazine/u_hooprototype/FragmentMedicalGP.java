package hoo.u.magazine.u_hooprototype;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMedicalGP extends Fragment {
    ListView lvGP;
    ArrayList<ClassDoctor> doctors;
    ArrayAdapter aa;

    public FragmentMedicalGP() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_medical_g, container, false);

        lvGP = view.findViewById(R.id.lvGP);
        doctors = new ArrayList<ClassDoctor>();
        doctors.add(new ClassDoctor(0,"Joanne Ek","General Practitioner (GP Doctor)","https://i.pinimg.com/originals/5a/fc/e6/5afce6b018c13fee5ef6d52bf581e545.jpg",10));
        doctors.add(new ClassDoctor(1,"Bryan Low","General Practitioner (GP Doctor)","https://i.pinimg.com/originals/95/ed/28/95ed2896339bcbb0fe160a4d3580ad17.jpg",9));
        aa = new AdapterDoctor(getContext(), R.layout.custom_doctor_list, doctors);
        lvGP.setAdapter(aa);

        lvGP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassDoctor doctor = doctors.get(position);
                Intent intent = new Intent(getContext(), ActivityViewDoctor.class);
                intent.putExtra("doc",doctor);
                startActivity(intent);
            }
        });
        return view;
    }

}
