package hoo.u.magazine.u_hooprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MedicalPayment extends AppCompatActivity {
    CircleImageView docImg;
    TextView docName, docPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_payment);
        docImg = findViewById(R.id.docImg);
        docName = findViewById(R.id.docName);
        docPrice = findViewById(R.id.docPrice);

        Intent intent = getIntent();
        ClassDoctor doctor = (ClassDoctor) intent.getSerializableExtra("doc");
        Picasso.with(getApplicationContext()).load(doctor.getDocImage()).into(docImg);
        docName.setText(doctor.getDocName());
        docPrice.setText("Total Fees:\n Consultation: $"+String.valueOf(doctor.getDocPrice())+"\n\nTotal: $"+String.valueOf(doctor.getDocPrice()));
    }
}
