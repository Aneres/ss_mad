package cherua.myapplication;

import android.*;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

/**
 * Created by Cherena on 29/09/2017.
 */

public class CameraActivity extends AppCompatActivity {

        private FloatingActionButton floatingActionButton_camera;

        private static final int CAMERA_REQUEST_CODE = 1;

        private StorageReference storage;
        private ProgressDialog progressDialog;

        private static final int PERMISSIONS_REQUEST_ACCESS_CAMERA = 11;
        private boolean cameraPermissionGranted;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_camera);

            getCameraPermission();

            storage = FirebaseStorage.getInstance().getReference();

            floatingActionButton_camera = (FloatingActionButton) findViewById(R.id.floatingActionButton_camera);
            floatingActionButton_camera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePhotoIntent, CAMERA_REQUEST_CODE);
                }
            });


                    progressDialog = new ProgressDialog(this);

        }

       // private void startCameraTaking(){

      //  }
        private void getCameraPermission() {
    /*
     * Request location permission, so that we can get the location of the
     * device. The result of the permission request is handled by a callback,
     * onRequestPermissionsResult.
     */
            if (ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_GRANTED) {
                cameraPermissionGranted = true;
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.CAMERA},
                        PERMISSIONS_REQUEST_ACCESS_CAMERA);
            }
        }

        /**
         * Handles the result of the request for camera permissions.
         */
        @Override
        public void onRequestPermissionsResult(int requestCode,
                                               @NonNull String permissions[],
                                               @NonNull int[] grantResults) {
            cameraPermissionGranted = false;
            switch (requestCode) {
                case PERMISSIONS_REQUEST_ACCESS_CAMERA: {
                    // If request is cancelled, the result arrays are empty.
                    if (grantResults.length > 0
                            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        cameraPermissionGranted = true;
                    }
                }
            }
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if(requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK){

                progressDialog.setMessage("Image uploading...");
                progressDialog.show();
                Uri uri = data.getData();

                StorageReference filepath = storage.child("Photo").child(uri.getLastPathSegment());

                filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressDialog.dismiss();
                        Toast.makeText(CameraActivity.this, "Upload complete...", Toast.LENGTH_LONG).show();

                    }
                });
            }
        }
    }




