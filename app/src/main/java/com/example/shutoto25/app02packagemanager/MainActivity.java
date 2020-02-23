package com.example.shutoto25.app02packagemanager;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    PackageManager mPackageManager;
    Button mBluetooth;
    Button mCamera;
    Button mGps;
    Button mNfc;
    Button mTouch;
    Button mGyroscope;
    Button mMicrophone;
    String mFeature = null;
    boolean mEnable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBluetooth = findViewById(R.id.btBluetooth);
        mBluetooth.setOnClickListener(buttonClick);
        mCamera = findViewById(R.id.btCamera);
        mCamera.setOnClickListener(buttonClick);
        mGps = findViewById(R.id.btGps);
        mGps.setOnClickListener(buttonClick);
        mNfc = findViewById(R.id.btNfc);
        mNfc.setOnClickListener(buttonClick);
        mTouch = findViewById(R.id.btTouch);
        mTouch.setOnClickListener(buttonClick);
        mGyroscope = findViewById(R.id.btGyroscope);
        mGyroscope.setOnClickListener(buttonClick);
        mMicrophone = findViewById(R.id.btMicrophone);
        mMicrophone.setOnClickListener(buttonClick);

    }

    private View.OnClickListener buttonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.btBluetooth:
                    mFeature = PackageManager.FEATURE_BLUETOOTH;
                    break;

                case R.id.btCamera:
                    mFeature = PackageManager.FEATURE_CAMERA;
                    break;

                case R.id.btGps:
                    mFeature = PackageManager.FEATURE_LOCATION_GPS;
                    break;
                case R.id.btNfc:
                    mFeature = PackageManager.FEATURE_NFC;
                    break;

                case R.id.btTouch:
                    mFeature = PackageManager.FEATURE_TOUCHSCREEN;
                    break;

                case R.id.btGyroscope:
                    mFeature = PackageManager.FEATURE_SENSOR_GYROSCOPE;
                    break;

                case R.id.btMicrophone:
                    mFeature = PackageManager.FEATURE_MICROPHONE;
                    break;
            }

            mPackageManager = getPackageManager();
            mEnable = mPackageManager.hasSystemFeature(mFeature);
            Toast.makeText(getApplicationContext(), mFeature + " is " + mEnable, Toast.LENGTH_SHORT).show();
        }
    };
}
