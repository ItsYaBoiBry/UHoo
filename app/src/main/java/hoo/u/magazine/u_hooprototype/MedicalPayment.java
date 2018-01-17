package hoo.u.magazine.u_hooprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MedicalPayment extends AppCompatActivity {
    CircleImageView docImg;
    TextView docName, docPrice;
    Button btnBackToListing;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_payment);
        docImg = findViewById(R.id.docImg);
        docName = findViewById(R.id.docName);
        docPrice = findViewById(R.id.docPrice);
        btnBackToListing = findViewById(R.id.btnBackToListing);


        btnBackToListing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicalPayment.this, ActivityMedicalConsult.class);
                startActivity(intent);
                finish();
            }
        });

        Intent intent = getIntent();
        ClassDoctor doctor = (ClassDoctor) intent.getSerializableExtra("doc");
        Picasso.with(getApplicationContext()).load(doctor.getDocImage()).into(docImg);
        docName.setText(doctor.getDocName());
        docPrice.setText("Total Fees:\n Consultation: $"+String.valueOf(doctor.getDocPrice())+"\n\nTotal: $"+String.valueOf(doctor.getDocPrice()));
    }
}
