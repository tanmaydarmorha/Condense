package com.more.condenseapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class QueryActivity extends AppCompatActivity {

    TextInputLayout nameTextInput;
    TextInputLayout emailTextInput;
    TextInputLayout phoneTextInput;
    TextInputLayout descriptionTextInput;

    TextInputEditText nameEditText;
    TextInputEditText emailEditText;
    TextInputEditText phoneEditText;
    TextInputEditText descriptionEditText;

    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        nameTextInput = findViewById(R.id.query_name_text_input);
        emailTextInput = findViewById(R.id.query_email_text_input);
        phoneTextInput = findViewById(R.id.query_phone_text_input);
        descriptionTextInput = findViewById(R.id.query_description_text_input);

        nameEditText = findViewById(R.id.query_name_edit_text);
        emailEditText = findViewById(R.id.query_email_edit_text);
        phoneEditText = findViewById(R.id.query_phone_edit_text);
        descriptionEditText = findViewById(R.id.query_description_edit_text);

        MaterialButton queryButton = findViewById(R.id.query_button);

        mRef = FirebaseDatabase.getInstance().getReference().child("Queries");

        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hide keyboard
                RelativeLayout mainLayout = findViewById(R.id.activity_query_page);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);

                if (isValid()) {
                    Query query = new Query(nameEditText.getText().toString(), emailEditText.getText().toString(),
                            phoneEditText.getText().toString(), descriptionEditText.getText().toString());

                    mRef.push().setValue(query);
                    Toast.makeText(QueryActivity.this,"Query Submitted Successfully",Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Log.e(QueryActivity.class.getSimpleName(), "Form Not Valid");
                }
            }
        });

    }

    private boolean isValid() {

        boolean valid = true;
        // checking input name
        if (nameEditText.getText().toString().isEmpty()) {
            nameTextInput.setError("Field cannot be empty");
        }

        for (int i = 0; i < nameEditText.getText().toString().length(); i++) {
            if (!((nameEditText.getText().toString().charAt(i) > 64 && nameEditText.getText().toString().charAt(i) < 91) ||
                    (nameEditText.getText().toString().charAt(i) > 96 && nameEditText.getText().toString().charAt(i) < 123) ||
                    (nameEditText.getText().toString().charAt(i) == ' '))) {
                nameTextInput.setError("Name should not contain any special characters or numbers");
                valid = false;
            }
        }

        // check input email
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (!emailEditText.getText().toString().matches(regex)) {
            emailTextInput.setError("Invalid Email");
            valid = false;
        }

        // check input phone number
        if (phoneEditText.getText().toString().length() != 10) {
            phoneTextInput.setError("Phone number must contain 10 digits");
            valid = false;
        }

        for (int i = 0; i < phoneEditText.getText().toString().length(); i++) {
            if (!(phoneEditText.getText().toString().charAt(i) > 47 && phoneEditText.getText().toString().charAt(i) < 58)) {
                phoneTextInput.setError("Invalid Phone Number");
                valid = false;
            }
        }

        // check input description
        if (descriptionEditText.getText().toString().isEmpty()) {
            descriptionTextInput.setError("Field Cannot be Empty");
            valid = false;
        }

        return valid;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
