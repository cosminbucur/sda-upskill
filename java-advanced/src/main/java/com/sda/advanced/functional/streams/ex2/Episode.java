package com.sda.advanced.functional.streams.ex2;

import java.util.List;

public class Episode {

    public String episodeName;
    public int episodeNumber;
    public List<Video> videos;

    public Episode(String episodeName,
                   int episodeNumber,
                   List<Video> videos) {
        this.episodeName = episodeName;
        this.episodeNumber = episodeNumber;
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "episodeName='" + episodeName + '\'' +
                ", episodeNumber=" + episodeNumber +
                ", videos=" + videos +
                '}';
    }
}