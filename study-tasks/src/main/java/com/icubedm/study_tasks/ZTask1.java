package com.icubedm.study_tasks;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
photo.jpg, Warsaw, 2013-09-05 14:08:15
john.png, London, 2015-06-20 15:13:22
myFriends.png, Warsaw, 2013-09-05 14:07:13
Eiffel.jpg, Paris, 2015-07-23 08:03:02
pisatower.jpg, Paris, 2015-07-22 23:59:59
BOB.jpg, London, 2015-08-05 00:02:03
notredame.png, Paris, 2015-09-01 12:00:00
me.jpg, Warsaw, 2013-09-06 15:40:22
a.png, Warsaw, 2016-02-13 13:33:50
b.jpg, Warsaw, 2016-01-02 15:12:22
c.jpg, Warsaw, 2016-01-02 14:34:30
d.jpg, Warsaw, 2016-01-02 15:15:01
e.png, Warsaw, 2016-01-02 09:49:09
f.png, Warsaw, 2016-01-02 10:55:32
g.jpg, Warsaw, 2016-02-29 22:13:11
*
Warsaw02.jpg
London1.png
Warsaw01.png
Paris2.jpg
Paris1.jpg
London2.jpg
Paris3.png
Warsaw03.jpg
Warsaw09.png
Warsaw07.jpg
Warsaw06.jpg
Warsaw08.jpg
Warsaw04.png
Warsaw05.png
Warsaw10.jpg*/
class ZTask1 {

    public static void main(String[] args) {
        String[] array = {
                "photo.jpg, Warsaw, 2013-09-05 14:08:15",
                "john.png, London, 2015-06-20 15:13:22",
                "myFriends.png, Warsaw, 2013-09-05 14:07:13",
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02",
                "pisatower.jpg, Paris, 2015-07-22 23:59:59",
                "BOB.jpg, London, 2015-08-05 00:02:03",
                "notredame.png, Paris, 2015-09-01 12:00:00",
                "me.jpg, Warsaw, 2013-09-06 15:40:22",
                "a.png, Warsaw, 2016-02-13 13:33:50",
                "b.jpg, Warsaw, 2016-01-02 15:12:22",
                "c.jpg, Warsaw, 2016-01-02 14:34:30",
                "d.jpg, Warsaw, 2016-01-02 15:15:01",
                "e.png, Warsaw, 2016-01-02 09:49:09",
                "f.png, Warsaw, 2016-01-02 10:55:32",
                "g.jpg, Warsaw, 2016-02-29 22:13:11",
        };

        String sol = new ZTask1().solution("photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11");

        System.out.println(sol);

    }

    static class Picture {
        String city;
        String extension;
        String dateTime;
        String originalString;
        String resultString;

        public Picture(String city, String extension, String dateTime, String originalString) {
            this.city = city;
            this.extension = extension;
            this.dateTime = dateTime;
            this.originalString = originalString;
        }

        public LocalDateTime date() {
            return LocalDateTime.parse(dateTime.replace(" ", "T"), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
    }

    private Picture findMatches(String s) {

        String regexp = "\\w+\\.(jpg|png|jpeg),\\s(\\w+),\\s(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2})";
        Matcher matcher = Pattern.compile(regexp).matcher(s);

        if (!matcher.find()) {
            throw new RuntimeException("Pattern not matches");
        }

        String city = matcher.group(2);
        String extension = matcher.group(1);
        String dateTime = matcher.group(3);

        return new Picture(city, extension, dateTime, s);
    }

    public String solution(String S) {

        if(S == null || S.isEmpty())
            return S;

        // write your code in Java SE 8
        String[] arr = S.split("\\n");

        List<Picture> pictures = new ArrayList<>();

        // STEP 1. Data preparation using custom Picture class
        for (String s : arr) {
            pictures.add(findMatches(s));
        }

        HashMap<String, List<Picture>> map = new HashMap<>();
        // Form the City-name based map
        for (Picture picture : pictures) {
            map.putIfAbsent(picture.city, new ArrayList<>());
            map.get(picture.city).add(picture);
        }

        // sort all lists by creation date
        for (List<Picture> pictureList : map.values()) {
            pictureList.sort((p1, p2) -> p1.date().isBefore(p2.date()) ? -1 : 1);
        }

        // STEP 2. Prepare the output

        for (List<Picture> pictureList : map.values()) {
            for (int i = 0; i < pictureList.size(); i++) {
                Picture picture = pictureList.get(i);

                // In order to define how many leading zeroes are needed, use number of elements in array
                int digits = String.valueOf(pictureList.size()).length();
                String formattedNumber = String.format("%0" + digits + "d", i + 1);

                // "Glue" the result string and put it to the bucket
                picture.resultString = picture.city + formattedNumber + "." + picture.extension;
            }
        }

        List<String> resultArray = Arrays.asList(arr);

        map.forEach((city, picturesList) -> {
            for (Picture picture : picturesList) {
                int index = resultArray.indexOf(picture.originalString);
                resultArray.set(index, picture.resultString);
            }
        });

        return String.join("\r\n", resultArray);
    }
}