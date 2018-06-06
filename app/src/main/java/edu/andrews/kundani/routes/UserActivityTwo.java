package edu.andrews.kundani.routes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserActivityTwo extends AppCompatActivity {

    // Declaring Button object.
    Button SubmitButton, ShowButton;

    // Declaring EditText object.
    EditText NameEditText, PhoneNumberEditText, LocationEditText;

    // Declaring String variable ( In which we are storing firebase server URL ).
    public static final String Firebase_Server_URL = "https://se-project-7028a.firebaseio.com/";

    // Declaring String variables to store name & phone number get from EditText.
    String NameHolder, NumberHolder, LocationHolder;

    // // Declaring TextView object.
    TextView ShowDataTextView ;

    // Declaring Firebase object.
    Firebase firebase;

    DatabaseReference databaseInfo;

    FirebaseHelper fh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_two);
        // Adding MainActivity context into Firebase context.
        Firebase.setAndroidContext(UserActivityTwo.this);

        databaseInfo = FirebaseDatabase.getInstance().getReference("Info");

        // Passing firebase Server URL into firebase object.
        firebase = new Firebase(Firebase_Server_URL);

        // Adding ID'S .
        SubmitButton = (Button)findViewById(R.id.submit);

        ShowButton = (Button)findViewById(R.id.show);

        ShowDataTextView = (TextView)findViewById(R.id.showData);

        NameEditText = (EditText)findViewById(R.id.name);

        PhoneNumberEditText = (EditText)findViewById(R.id.phone_number);

        LocationEditText = (EditText) findViewById(R.id.Location);

        // Adding Click listener to Submit button.
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = databaseInfo.push().getKey();

                // Declaring student class object.
                Information information = new Information();

                // Calling function to Get data from EditText and store into string variables.
                GetDataFromEditText();

                information.setPersonId(id);

                // Adding student name into information class object.
                information.setName(NameHolder);

                // Adding student number into information class object.
                information.setPhoneNumber(NumberHolder);

                //add address/location
                information.setLocation(LocationHolder);

                // Passing student phone number and name into firebase object to add into database.
                firebase.child("Information").setValue(information);

                //alternate saving method
                //fh.save(information, id);

                // Showing toast message after data inserted.
                Toast.makeText(UserActivityTwo.this,"Data Inserted Successfully", Toast.LENGTH_LONG).show();

            }
        });

        // Adding click listener to Show data button.
        ShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Adding addValueEventListener method on firebase object.
                firebase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot SubSnapshot : dataSnapshot.getChildren()) {

                            Information information = SubSnapshot.getValue(Information.class);

                            // Adding name and phone number of student into string that is coming from server.
                            String ShowDataString = "Name : "+information.getName()+
                                    "\nPhone Number : "+information.getPhoneNumber()+
                                    "\nLocation: "+information.getLocation()+
                                    "\n\n";

                            // Apply complete string variable into TextView.
                            ShowDataTextView.setText(ShowDataString);
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        System.out.println("Data Access Failed" + firebaseError.getMessage());
                    }
                });

            }
        });
    }

    public void GetDataFromEditText(){

        NameHolder = NameEditText.getText().toString().trim();

        NumberHolder = PhoneNumberEditText.getText().toString().trim();

        LocationHolder = LocationEditText.getText().toString().trim();

    }

}
