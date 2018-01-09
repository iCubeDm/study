package com.icubedm.study_tasks.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesZalando {

    public static void main(String[] args) {

//        System.out.println(solution("my.song.mp3 11b\n" +
//                "greatSong.flac 1000b\n" +
//                "not3.txt 5b\n" +
//                "video.mp4 200b\n" +
//                "game.exe 100b\n" +
//                "mov!e.mkv 10000b"));
//
//        System.out.println();

        System.out.println(solution("my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b"));
    }

    static Pattern PATTERN = Pattern.compile("[\\w]+\\.([a-z\\d]+)\\s(\\d+)b");

    public static String solution(String files) {

        if(files == null || files.length() == 0) {
            return "music 0b\n" +
            "images 0b\n" +
            "movies 0b\n" +
            "other 0b";
        }

        String[] strings = files.split("\n");

        if(strings.length < 1) {
            return "music 0b\n" +
                    "images 0b\n" +
                    "movies 0b\n" +
                    "other 0b";
        }

        Map<String, Long> filesMap = new HashMap<>();

        filesMap.put("music", 0L);
        filesMap.put("image", 0L);
        filesMap.put("movie", 0L);
        filesMap.put("other", 0L);


        for(String file: strings) {

            Matcher matcher = PATTERN.matcher(file);

            if(matcher.find()) {

                long value = Long.valueOf(matcher.group(2));

                switch (matcher.group(1)) {
                    case "mp3" :
                    case "aac" :
                    case "flac" : {
                        filesMap.compute("music", (k, v) -> v + value);
                        break;
                    }
                    case "jpg" :
                    case "bpm" :
                    case "gif" : {
                        filesMap.compute("image", (k, v) -> v + value);
                        break;
                    }
                    case "mp4" :
                    case "avi" :
                    case "mkv" : {
                        filesMap.compute("movie", (k, v) -> v + value);
                        break;
                    }
                    default:
                        filesMap.compute("other", (k, v) -> v + value);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb
          .append("music ").append(filesMap.get("music")).append("b\n")
          .append("images ").append(filesMap.get("image")).append("b\n")
          .append("movies ").append(filesMap.get("movie")).append("b\n")
          .append("other ").append(filesMap.get("other")).append("b");

        return sb.toString();
    }
}
