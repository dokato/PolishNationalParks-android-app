package com.example.android.polishnationalparks;

/**
 * Created by Dominik on 2016-03-12.
 */
public class Park {
    String name;
    String url;
    String picture;

    Park(String name, String url, String picture){
        this.name=name;
        this.url=url;
        this.picture=picture;
    }

    public String get_name(){
        return name;
    }

    public String get_url(){
        return url;
    }

    public String get_picture(){
        return picture;
    }

}
