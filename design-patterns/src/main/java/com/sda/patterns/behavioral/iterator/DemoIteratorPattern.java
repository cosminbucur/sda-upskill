package com.sda.patterns.behavioral.iterator;

import com.sda.patterns.behavioral.iterator.network.LinkedIn;
import com.sda.patterns.behavioral.iterator.network.SocialNetwork;
import com.sda.patterns.behavioral.iterator.profile.Profile;
import com.sda.patterns.behavioral.iterator.spammer.SocialSpammer;

import java.util.ArrayList;
import java.util.List;

public class DemoIteratorPattern {

    public static void main(String[] args) {
        SocialNetwork network = new LinkedIn(createTestProfiles());

        SocialSpammer spammer = new SocialSpammer(network);
        spammer.sendSpamToFriends("ana@gmail.com",
                "Hey! check out this link [link]?");

        spammer.sendSpamToCoworkers("ana@gmail.com",
                "Hey! You are invited to this event [link].");
    }

    public static List<Profile> createTestProfiles() {
        List<Profile> data = new ArrayList<>();
        String ana = "ana@gmail.com";
        String cristi = "cristi@gmail.com";
        String elena = "elena@gmail.com";
        String vali = "vali@gmail.com";
        String alina = "alina@gmail.com";
        String paul = "paul@gmail.com";

        data.add(new Profile(ana, "Ana", "friends:" + cristi, "friends:" + alina, "coworkers:" + vali));
        data.add(new Profile(cristi, "Cristi", "friends:" + ana, "coworkers:" + vali));
        data.add(new Profile(elena, "Elena", "coworkers:" + paul));
        data.add(new Profile(paul, "Paul", "coworkers:" + elena));
        data.add(new Profile(vali, "Vali", "coworkers:" + ana, "coworkers:" + cristi, "friends:" + alina));
        data.add(new Profile(alina, "Alina", "friends:" + ana, "friends:" + vali));
        return data;
    }
}
