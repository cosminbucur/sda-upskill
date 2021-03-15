package com.sda.patterns.behavioral.iterator.network;

import com.sda.patterns.behavioral.iterator.iterator.ProfileIterator;

public interface SocialNetwork {

    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
