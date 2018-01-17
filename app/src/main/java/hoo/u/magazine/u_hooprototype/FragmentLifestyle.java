package hoo.u.magazine.u_hooprototype;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLifestyle extends Fragment {
    ImageButton btnMagazine;

    public FragmentLifestyle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_lifestyle, container, false);

        ImageButton bck = (ImageButton) view.findViewById(R.id.btnBack);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        btnMagazine = view.findViewById(R.id.catMagazines);
        btnMagazine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityMagazine.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
