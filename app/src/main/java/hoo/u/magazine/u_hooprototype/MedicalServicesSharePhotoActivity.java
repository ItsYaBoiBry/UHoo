package hoo.u.magazine.u_hooprototype;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MedicalServicesSharePhotoActivity extends AppCompatActivity {

        Button btnTakeAPhoto, btnChooseFile,btnTakeAPhoto1, btnChooseFile1, btnSharePhotoNext;
        EditText etDescription, etDescription1;
    public static final int REQUEST_CODE = 100;
    public static final int PERMISSION_REQUEST = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_services_share_photo);

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

        btnTakeAPhoto = (Button)findViewById(R.id.btnTakeAPhoto);
        btnChooseFile = (Button)findViewById(R.id.btnChooseFile);
        btnTakeAPhoto1 = (Button)findViewById(R.id.btnTakeAPhoto1);
        btnChooseFile1 = (Button)findViewById(R.id.btnChooseFile1);
        etDescription = (EditText)findViewById(R.id.editTextDescription);
        etDescription1 = (EditText)findViewById(R.id.editTextDescription1);

        btnTakeAPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(MedicalServicesSharePhotoActivity.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(MedicalServicesSharePhotoActivity.this, android.Manifest.permission.CAMERA)){
                        ActivityCompat.requestPermissions(MedicalServicesSharePhotoActivity.this, new String[]{android.Manifest.permission.CAMERA}, PERMISSION_REQUEST);
                    }
                }else{
                    openCamera();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_CODE);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
