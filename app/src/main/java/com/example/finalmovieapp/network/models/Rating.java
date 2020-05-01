package com.example.finalmovieapp.network.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.finalmovieapp.BR;
import com.google.gson.annotations.SerializedName;

public class Rating extends BaseObservable {

    @SerializedName("Source")
    private String source;

    @SerializedName("Value")
    private String value;

    public Rating(String source, String value) {
        this.source = source;
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Bindable
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        notifyPropertyChanged(BR.value);
    }

    @Override
    public String toString() {
        return "Rating{" + "Source='" + source + '\'' + ", Value='" + value + '\'' + '}';
    }
}
