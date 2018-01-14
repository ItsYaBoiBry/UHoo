package hoo.u.magazine.u_hooprototype;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MedicalActivity extends AppCompatActivity {

    ImageButton ibMedicalServiceVideoCall,ibMedicalServicesHouseCall,ibMedicalWellnessVideoCall,ibPaediatricCare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        ImageButton bck = (ImageButton) findViewById(R.id.btnBack);

        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ibMedicalServiceVideoCall = (ImageButton)findViewById(R.id.ibMedicalServiceVideoCall);
        ibMedicalServicesHouseCall = (ImageButton)findViewById(R.id.ibMedicalServicesHouseCall);
        ibMedicalWellnessVideoCall = (ImageButton)findViewById(R.id.ibMedicalWellnessVideoCall);
        ibPaediatricCare = (ImageButton)findViewById(R.id.ibPaediatricCare);

        ibMedicalServiceVideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicalActivity.this,VideoConnectActivity.class));
            }
        });
        ibMedicalServicesHouseCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alert("House Call Service Coming Soon");
            }
        });
        ibMedicalWellnessVideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alert("Medical Wellness Video Call Service Coming Soon");
            }
        });
        ibPaediatricCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alert("Paediatric Care Video Call Service Coming Soon.");
            }
        });

    }

    //self debugging purposes or future use depending.
    public void Toasty(String message) {
        Toast toast = Toast.makeText(MedicalActivity.this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void Alert(String alertMessage){
        AlertDialog.Builder builder = new AlertDialog.Builder(MedicalActivity.this);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setMessage(alertMessage);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
//        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int whichButton) {
//            }
//        });
        builder.show();
    }
}
