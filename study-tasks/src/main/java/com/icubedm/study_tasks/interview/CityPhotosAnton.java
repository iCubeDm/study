package com.icubedm.study_tasks.interview;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**

Zalando task

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
Warsaw10.jpg

*/
class CityPhotosAnton {

    public static void main(String[] args) {

        String result = solution(
                "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
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

        System.out.println(result);
    }

    static Pattern PATTERN = Pattern.compile("[\\S]+\\.([a-zA-Z]+),\\s+([\\S]+),\\s+([\\d\\s\\-:]+)");

    private static String solution(String photos) {

        if(photos == null) {
            return "";
        }

        String[] strings = photos.split("\n");

        if(strings.length < 1) {
            return "";
        }

        Map<String, TreeSet<Photo>> cityMap = new HashMap<>();
        List<Photo> list = new ArrayList<>();

        for(int i = 0; i < strings.length; i++) {

            Matcher matcher = PATTERN.matcher(strings[i]);

            if(matcher.find()) {

                Photo photo = new Photo(strings[i], matcher.group(1), matcher.group(2), matcher.group(3));

                cityMap.putIfAbsent(photo.city, new TreeSet<>());

                cityMap.get(photo.city).add(photo);

                list.add(photo);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(Photo ph : list) {

            int size = cityMap.get(ph.city).size();
            int index = cityMap.get(ph.city).headSet(ph).size();

            sb.append(ph.city)
              .append(String.format("%0" + (size/10 + 1) + "d", index + 1))
              .append('.')
              .append(ph.fileFormat)
              .append("\n");
        }

        return sb.toString();
    }

    static class Photo implements Comparable<Photo> {

        static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String originalString;
        String fileFormat;
        String city;
        LocalDateTime date;

        public Photo(String originalString, String fileFormat, String city, String date) {
            this.originalString = originalString;
            this.city = city;
            this.fileFormat = fileFormat;
            this.date = LocalDateTime.parse(date, FORMATTER);
        }

        @Override
        public int compareTo(Photo photo) {
            return date.compareTo(photo.date);
        }
    }
}
