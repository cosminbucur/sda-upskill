package com.sda.advanced.functional.streams.ex2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DemoEx2 {

    public static void main(String[] args) {
        List<Season> seasons = createSeasons();

        // level 1 - seasons
        List<String> seasonNames = getSeasonNames(seasons);
        List<Integer> seasonNumbers = getSeasonNumbers(seasons);

        // level 2 - episodes
        List<String> episodeNames = getEpisodeNames(seasons);

        // level 3 - videos
        List<String> videoNames = getVideoNames(seasons);
        List<Video> videoClipsFromEvenEpisodesFromOddSeasons =
                getVideoClipsFromEvenEpisodesFromOddSeasons(seasons);
    }

    private static List<Season> createSeasons() {
        /*
        Season 1
            Episode 1
                Video 1
                Video 2
            Episode 2
                Video 3
                Video 4
        Season 2
            Episode 3
                Video 5
                Video 6
         */

        Video video1 = new Video("GOT1", "got1.com", VideoType.CLIP);
        Video video2 = new Video("GOT2", "got2.com", VideoType.EPISODE);
        Video video3 = new Video("GOT3", "got3.com", VideoType.PREVIEW);
        Video video4 = new Video("GOT4", "got4.com", VideoType.PREVIEW);
        Video video5 = new Video("GOT5", "got5.com", VideoType.CLIP);
        Video video6 = new Video("GOT6", "got6.com", VideoType.EPISODE);

        Episode episode1 = new Episode("got1", 1,
                Arrays.asList(video1, video2));
        Episode episode2 = new Episode("got2", 2,
                Arrays.asList(video3, video4));
        Episode episode3 = new Episode("got3", 1,
                Arrays.asList(video5, video6));

        Season season1 = new Season("season 1", 1,
                Arrays.asList(episode1, episode2));
        Season season2 = new Season("season 2", 2,
                Collections.singletonList(episode3));

        List<Season> seasons = Arrays.asList(season1, season2);
        return seasons;
    }

    // level 1 - seasons

    private static List<String> getSeasonNames(List<Season> seasons) {
        return seasons.stream()
                .map(season -> season.seasonName)
                .collect(Collectors.toList());
    }

    private static List<Integer> getSeasonNumbers(List<Season> seasons) {
        return seasons.stream()
                .map(season -> season.seasonNumber)
                .collect(Collectors.toList());
    }

    // level 2 - episodes

    private static List<String> getEpisodeNames(List<Season> seasons) {
        return seasons.stream()
                .flatMap(season -> season.episodes.stream())
                .map(episode -> episode.episodeName)
                .collect(Collectors.toList());
    }

    // level 3 - videos

    private static List<String> getVideoNames(List<Season> seasons) {
        return seasons.stream()
                .flatMap(season -> season.episodes.stream())
                .flatMap(episode -> episode.videos.stream())
                .map(video -> video.title)
                .collect(Collectors.toList());
    }

    private static List<Video> getVideoClipsFromEvenEpisodesFromOddSeasons(List<Season> seasons) {
        return seasons.stream()
                .filter(season -> season.seasonNumber % 2 == 0)
                .flatMap(season -> season.episodes.stream())
                .filter(episode -> episode.episodeNumber % 2 != 0)
                .flatMap(episode -> episode.videos.stream())
                .filter(video -> video.videoType == VideoType.CLIP)
                .collect(Collectors.toList());
    }

}
