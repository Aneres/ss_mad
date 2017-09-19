package cherua.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity  {

    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent GoogleMapsIntent = new Intent(RegisterActivity.this, MapsActivity.class);
                startActivity(GoogleMapsIntent);

                Toast.makeText(getApplicationContext(), "User has been added to our records!",
                       Toast.LENGTH_LONG).show();



            }
        });

    }
}
