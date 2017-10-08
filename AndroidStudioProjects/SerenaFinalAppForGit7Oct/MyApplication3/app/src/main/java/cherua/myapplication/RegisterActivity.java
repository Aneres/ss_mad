package cherua.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static cherua.myapplication.R.id.editTextPassword;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister;
    private TextView textViewLogin;
    private FirebaseAuth firebaseAuth;
    private EditText editTextFirstName;
    private EditText editTextSurname;
    private EditText editTextEmailAddress;
    private EditText editTextPassword;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressDialog = new ProgressDialog(this);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);
        TextView textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        editTextEmailAddress = (EditText) findViewById(R.id.editTextEmailAddress);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        firebaseAuth = FirebaseAuth.getInstance();


    }



    private void registerUser() {

        //getting email and password from edit texts
        String email = editTextEmailAddress.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();


        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //if the task is successfull
                        if (task.isSuccessful()) {
                            //start the profile activity
                            Log.e("Success", task.getResult().toString());
                            finish();
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        }else{
                            Log.e("Message", task.getException().toString());
                            Toast.makeText(RegisterActivity.this, "Registration Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        Intent LogIntoAccountIntent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(LogIntoAccountIntent);

        Toast.makeText(getApplicationContext(), "You will now be redirected to Log In",
                Toast.LENGTH_LONG).show();


    }

    @Override
    public void onClick(View view) {
        if(view == buttonRegister){
            registerUser();
        }
        if(view == textViewLogin){
            startActivity(new Intent(this, LoginActivity.class));

        }
    }
}