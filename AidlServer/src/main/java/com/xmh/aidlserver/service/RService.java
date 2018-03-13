package com.xmh.aidlserver.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.xmh.aidlserver.model.Ad;
import com.xmh.aidlserver.model.AdManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by void on 2018.03.12 012.
 */

public class RService extends Service {

    private List<Ad> adList = new ArrayList();

    private AdManager.Stub adManager = new AdManager.Stub() {
        @Override
        public List<Ad> getAdList() throws RemoteException {
            return adList;
        }

        @Override
        public void addAd(Ad ad) throws RemoteException {
            adList.add(ad);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        adList.add(new Ad("a", 1, false));
        adList.add(new Ad("b", 2, true));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return adManager;
    }
}
