package cherua.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    //private FloatingActionButton to_tabs_btn = (FloatingActionButton) findViewById(R.id.to_tabs_btn);
   // to_tabs_btn.setOnClickListener (new View.OnClickListener())

    //trying to implement the fab on google maps

   // private FloatingActionbutton to_tabs_btn;
   // to_tabs_btn  = (FloatingActionButton) findViewById(R.id.to_tabs_btn);
//    fab.setOnclickListener(new View.OnClickListener(){

   // public void sButton(View v) {
      //  Toast.makeText(this, "CLICK!", Toast.LENGTH_SHORT).show();
   // }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //just implemented this before leaving the room
//         FloatingActionButton to_tabs_btn = (FloatingActionButton) findViewById(R.id.to_tabs_btn);
//         to_tabs_btn.setOnClickListener (new View.OnClickListener() {
//             @Override
//             public void onClick(View view) {
//
//             }
//         })
//
//    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng dublin = new LatLng(53.346308,-6.2604618);
        mMap.addMarker(new MarkerOptions().position(dublin).title("The Big Schmoke"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dublin));
    }
}
