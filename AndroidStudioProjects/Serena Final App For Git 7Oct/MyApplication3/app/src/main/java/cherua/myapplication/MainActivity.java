package cherua.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.button;
import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {

    private Button btn_logInHome;
    private Button btn_register;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_logInHome = (Button) findViewById(R.id.btn_logInHome);
        btn_logInHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                    Intent LoginPageIntent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(LoginPageIntent);

            }
        });

        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RegisterPageIntent = new Intent (MainActivity.this, RegisterActivity.class);
             startActivity(RegisterPageIntent);
            }
        });

    }

}




