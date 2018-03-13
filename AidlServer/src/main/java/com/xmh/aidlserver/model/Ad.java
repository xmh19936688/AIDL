package com.xmh.aidlserver.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by void on 2018.03.12 012.
 */

public class Ad implements Parcelable {
    public static final Creator<Ad> CREATOR = new Creator<Ad>() {
        @Override
        public Ad createFromParcel(Parcel in) {
            return new Ad(in);
        }

        @Override
        public Ad[] newArray(int size) {
            return new Ad[size];
        }
    };

    private String name;
    private int id;
    private boolean isOnline;

    public Ad() {
    }

    public Ad(String name, int id, boolean isOnline) {
        this.name = name;
        this.id = id;
        this.isOnline = isOnline;
    }

    protected Ad(Parcel in) {
        name = in.readString();
        id = in.readInt();
        isOnline = in.readByte() != 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(id);
        parcel.writeByte((byte) (isOnline ? 1 : 0));
    }

    public void readFromParcel(Parcel parcel) {
        name = parcel.readString();
        id = parcel.readInt();
        isOnline = parcel.readByte() == 1;
    }
}
