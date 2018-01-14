package hoo.u.magazine.u_hooprototype;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class WhoIsThePatientActivity extends AppCompatActivity {

    Button btnMe, btnSomeoneElse, btnNext;
    Spinner spnMyChild;
    EditText etAddAChildFirstName, etAddAChildLastName, etAddAChildDateOfBirth, etAddAChildNRICorPassport;
    RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_is_the_patient);

        ImageButton bck = (ImageButton) findViewById(R.id.btnBack);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Quicksand-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );


        btnMe = (Button) findViewById(R.id.buttonMe);
        btnSomeoneElse = (Button) findViewById(R.id.buttonSomeoneElse);
        btnNext = (Button) findViewById(R.id.buttonNext);
        spnMyChild = (Spinner) findViewById(R.id.spinnerMyChild);

        btnMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMe.setBackgroundColor(getResources().getColor(R.color.primaryGreen));
                btnSomeoneElse.setBackgroundColor(getResources().getColor(R.color.white));
                spnMyChild.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

        spnMyChild.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spnMyChild.getSelectedItemPosition() == 0) {
                    Toasty("Child 1 selected");

                } else if (spnMyChild.getSelectedItemPosition() == 1) {
                    Toasty("Child 2 selected");
                } else {
                    alertDialogAddAChild();
                }
                btnSomeoneElse.setBackgroundColor(getResources().getColor(R.color.white));
                btnMe.setBackgroundColor(getResources().getColor(R.color.white));
                spnMyChild.setBackgroundColor(getResources().getColor(R.color.primaryGreen));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnSomeoneElse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMe.setBackgroundColor(getResources().getColor(R.color.white));
                spnMyChild.setBackgroundColor(getResources().getColor(R.color.white));
                btnSomeoneElse.setBackgroundColor(getResources().getColor(R.color.primaryGreen));

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), PresentConditionActivity.class));

            }
        });
    }

    //self debugging purposes or future use depending.
    public void Toasty(String message) {
        Toast toast = Toast.makeText(WhoIsThePatientActivity.this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void alertDialogAddAChild() {
        //Inflate the input.xml layout file
        LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewDialog = inflater.inflate(R.layout.alert_dialog_add_a_child, null);

        AlertDialog.Builder myBuilder = new AlertDialog.Builder(WhoIsThePatientActivity.this);

        //Obtain th UI component in the input.xml layout
        etAddAChildFirstName = (EditText) viewDialog.findViewById(R.id.etAddAChildFirstName);
        etAddAChildLastName = (EditText) viewDialog.findViewById(R.id.etAddAChildLastName);
        etAddAChildDateOfBirth = (EditText) viewDialog.findViewById(R.id.etDateOfBirth);
        etAddAChildNRICorPassport = (EditText) viewDialog.findViewById(R.id.etAddAChildNRICorPassport);

        etAddAChildDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To show current date in the datepicker
                Calendar mcurrentDate = Calendar.getInstance();
                int mYear = mcurrentDate.get(java.util.Calendar.YEAR);
                int mMonth = mcurrentDate.get(java.util.Calendar.MONTH);
                final int mDay = mcurrentDate.get(java.util.Calendar.DAY_OF_MONTH);

                //set today as the minimum date

                final DatePickerDialog mDatePicker;
                mDatePicker = new DatePickerDialog(WhoIsThePatientActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                        selectedmonth = selectedmonth + 1;
                        etAddAChildDateOfBirth.setText(selectedyear + "-" + selectedmonth + "-" + selectedday);

                    }
                }, mYear, mMonth, mDay);
                mDatePicker.getDatePicker().setMinDate(System.currentTimeMillis());
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }
        });

        //Set the view of the dialog
        myBuilder.setView(viewDialog);
        myBuilder.setPositiveButton("CONTINUE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(WhoIsThePatientActivity.this, WhoIsThePatientActivity.class));

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
