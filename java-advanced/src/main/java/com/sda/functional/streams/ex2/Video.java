package com.sda.functional.streams.ex2;

public class Video {

    public String title;
    public String url;
    public VideoType videoType;

    public Video(String title, String url, VideoType videoType) {
        this.title = title;
        this.url = url;
        this.videoType = videoType;
    }

    @Override
    public String toString() {
        return "Video{" + "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", videoType=" + videoType +
                '}';
    }
}
