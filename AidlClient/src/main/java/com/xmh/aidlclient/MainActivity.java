package com.xmh.aidlclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.xmh.aidlserver.model.Ad;
import com.xmh.aidlserver.model.AdManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                AdManager adManager = AdManager.Stub.asInterface(iBinder);
                List<Ad> adList = adManager.getAdList();
                Log.e("xmh", "size:" + adList.size());
                Log.e("xmh", "eg:" + adList.get(0).getName());
                adManager.addAd(new Ad("xmh", 12, true));
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("xmh", "dis");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent();
        intent.setAction("com.xmh.aidl.ad");
        intent.setPackage("com.xmh.aidlserver");
        bindService(intent, conn, BIND_AUTO_CREATE);
    }
}
