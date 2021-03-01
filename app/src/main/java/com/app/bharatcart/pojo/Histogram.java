
package com.app.bharatcart.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Histogram implements Parcelable {

    @SerializedName("1")
    @Expose
    private Integer _1;
    @SerializedName("2")
    @Expose
    private Integer _2;
    @SerializedName("3")
    @Expose
    private Integer _3;
    @SerializedName("4")
    @Expose
    private Integer _4;
    @SerializedName("5")
    @Expose
    private Integer _5;

    public Integer get1() {
        return _1;
    }

    public void set1(Integer _1) {
        this._1 = _1;
    }

    public Integer get2() {
        return _2;
    }

    public void set2(Integer _2) {
        this._2 = _2;
    }

    public Integer get3() {
        return _3;
    }

    public void set3(Integer _3) {
        this._3 = _3;
    }

    public Integer get4() {
        return _4;
    }

    public void set4(Integer _4) {
        this._4 = _4;
    }

    public Integer get5() {
        return _5;
    }

    public void set5(Integer _5) {
        this._5 = _5;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this._1);
        dest.writeValue(this._2);
        dest.writeValue(this._3);
        dest.writeValue(this._4);
        dest.writeValue(this._5);
    }

    public Histogram() {
    }

    protected Histogram(Parcel in) {
        this._1 = (Integer) in.readValue(Integer.class.getClassLoader());
        this._2 = (Integer) in.readValue(Integer.class.getClassLoader());
        this._3 = (Integer) in.readValue(Integer.class.getClassLoader());
        this._4 = (Integer) in.readValue(Integer.class.getClassLoader());
        this._5 = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Histogram> CREATOR = new Parcelable.Creator<Histogram>() {
        @Override
        public Histogram createFromParcel(Parcel source) {
            return new Histogram(source);
        }

        @Override
        public Histogram[] newArray(int size) {
            return new Histogram[size];
        }
    };
}
