package hoo.u.magazine.u_hooprototype;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class VideoConnectActivity extends AppCompatActivity {

    ImageButton ibSeeADoctorNow,ibSeeMyFavouriteDoctor,ibScheduleAnAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_connect);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Quicksand-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        ImageButton bck = (ImageButton) findViewById(R.id.btnBack);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ibSeeADoctorNow = (ImageButton)findViewById(R.id.ibSeeADoctorNow);
        ibSeeMyFavouriteDoctor = (ImageButton)findViewById(R.id.ibSeeMyFavouriteDoctor);
        ibScheduleAnAppointment = (ImageButton)findViewById(R.id.ibScheduleAnAppointment);

        ibSeeADoctorNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert();
            }
        });

        ibSeeMyFavouriteDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ibScheduleAnAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void alert(){
        //Inflate the input.xml layout file
        LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewDialog = inflater.inflate(R.layout.alert_dialog,null);

        AlertDialog.Builder myBuilder = new AlertDialog.Builder(VideoConnectActivity.this
        );

        //Set the view of the dialog
        myBuilder.setView(viewDialog);
        myBuilder.setPositiveButton("CONTINUE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(VideoConnectActivity.this,WhoIsThePatientActivity.class));

            }
        });
        myBuilder.setNeutralButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog myDialog = myBuilder.create();
        myDialog.show();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
