package com.example.lesson_4;

public class DetailInfoItem extends BaseInfoItem {
    String info;
    boolean attention;

    public DetailInfoItem(String header, String info, int idImage, boolean attention) {
        super(header, idImage);
        this.info = info;
        this.attention = attention;
    }
}
