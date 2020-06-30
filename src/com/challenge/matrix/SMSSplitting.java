package com.challenge.matrix;

import java.util.*;

public class SMSSplitting {


    public static List<String> segments(String message) {
        int maxSegmentLength = 160;
        int length = message.length();
        List<String> segments = new ArrayList<>();
        if (length <= 160) {
            segments.add(message);
        } else {
            int noOfSegments = (int) Math.ceil((double) length / 160);//length / 160;

            int pointer = 0;
            for (int i = 1; i <= noOfSegments; i++) {
                String seg = "";
                if (pointer + maxSegmentLength <= length) {
                    seg = message.substring(pointer, pointer + maxSegmentLength-1);
                } else {
                    seg = message.substring(pointer, length);
                }

                String suffix = " (" + i + "/" + noOfSegments + ")";
                segments.add(seg + suffix);
                pointer += maxSegmentLength+1;
            }
        }
        return segments;
    }

    public static void main(String[] args) {
        String s = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis partu sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore ver rup. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa.";

        List<String> segs = segments(s);

        System.out.println("Ceiling value of  = " + Math.abs(1.1));


    }
}
