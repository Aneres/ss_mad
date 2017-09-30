package cherua.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by 10369924 on 9/26/2017.
 */

public class Tab3_User_Profile  extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3userprofile, container, false);









        Button button_toCamera = (Button) rootView.findViewById(R.id.button_toCamera);
        button_toCamera.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                Intent toCameraIntent = new Intent(v.getContext(), CameraActivity.class);
                v.getContext().startActivity(toCameraIntent);


            }

        });
        return rootView;


    }
}
