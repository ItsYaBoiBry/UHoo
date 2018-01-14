package hoo.u.magazine.u_hooprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GeneralSymptomsActivity extends AppCompatActivity {

    Button btnGeneralSymptomsNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_symptoms);

        ImageButton bck = (ImageButton) findViewById(R.id.btnBack);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnGeneralSymptomsNext = (Button)findViewById(R.id.btnGeneralSymptomsNext);

        btnGeneralSymptomsNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),MedicalServicesSharePhotoActivity.class));
            }
        });

    }
}
