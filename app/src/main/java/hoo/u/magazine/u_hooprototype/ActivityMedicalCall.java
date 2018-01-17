package hoo.u.magazine.u_hooprototype;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityMedicalCall extends AppCompatActivity {
    FloatingActionButton endCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_call);

        Intent i = getIntent();
        final ClassDoctor doctor = (ClassDoctor) i.getSerializableExtra("doctor");
        endCall = (FloatingActionButton) findViewById(R.id.endCall);
        endCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMedicalCall.this, MedicalPayment.class);
                intent.putExtra("doc",doctor);
                startActivity(intent);
            }
        });
    }
}