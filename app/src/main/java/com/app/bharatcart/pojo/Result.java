
package com.app.bharatcart.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Parcelable {

    @SerializedName("result")
    @Expose
    private List<Result_> result = null;
    @SerializedName("success")
    @Expose
    private Boolean success;

    public List<Result_> getResult() {
        return result;
    }

    public void setResult(List<Result_> result) {
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.result);
        dest.writeValue(this.success);
    }

    public Result() {
    }

    protected Result(Parcel in) {
        this.result = new ArrayList<Result_>();
        in.readList(this.result, Result_.class.getClassLoader());
        this.success = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel source) {
            return new Result(source);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
}
