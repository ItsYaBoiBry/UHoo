package hoo.u.magazine.u_hooprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ActivityLifestyle extends AppCompatActivity {

    ImageButton btnMagazine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifestyle);

        ImageButton bck = (ImageButton) findViewById(R.id.btnBack);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnMagazine = findViewById(R.id.catMagazines);
        btnMagazine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLifestyle.this, ActivityMagazine.class);
                startActivity(intent);
            }
        });
    }
}
