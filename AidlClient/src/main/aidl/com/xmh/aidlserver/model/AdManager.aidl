// AdManager.aidl
package com.xmh.aidlserver.model;

// Declare any non-default types here with import statements
import com.xmh.aidlserver.model.Ad;

interface AdManager {

    List<Ad> getAdList();
    void addAd(in Ad ad);
}
