package hoo.u.magazine.u_hooprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ActivityViewDoctor extends AppCompatActivity {
    TextView tvName, tvPosition;
    CircleImageView ivImg;
    Button btnCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_doctor);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        ImageButton bck = findViewById(R.id.btnBack);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvName = findViewById(R.id.docName);
        tvPosition = findViewById(R.id.docPosition);
        ivImg = findViewById(R.id.docImg);
        btnCall = findViewById(R.id.btnCall);

        Intent intent = getIntent();
        final ClassDoctor doctor = (ClassDoctor)intent.getSerializableExtra("doc");
        tvName.setText(doctor.getDocName());
        tvPosition.setText(doctor.getDocPosition());
        Picasso.with(getApplicationContext()).load(doctor.getDocImage()).into(ivImg);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityViewDoctor.this, ActivityMedicalCall.class);
                i.putExtra("doctor", doctor);
                startActivity(i);
            }
        });
    }
}
