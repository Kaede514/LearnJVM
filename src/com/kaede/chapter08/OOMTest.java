package com.kaede.chapter08;

import java.util.ArrayList;
import java.util.Random;

public class OOMTest {
    public static void main(String[] args) {
        ArrayList<Picture> list = new ArrayList<>();
        while(true) {
            try {
                //±ÜÃâ¶ÑÒç³ö¹ý¿ì
                Thread.sleep(10);
            } catch(Exception e) {
                e.printStackTrace();
            }

            list.add(new Picture(new Random().nextInt(1024 * 1024)));
        }
    }
}

class Picture {
    @SuppressWarnings("all")
    private byte[] pixels;

    public Picture(int length) {
        this.pixels = new byte[length];
    }
}
