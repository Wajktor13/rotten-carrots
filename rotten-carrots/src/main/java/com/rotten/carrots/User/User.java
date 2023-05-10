package com.rotten.carrots.User;

import com.rotten.carrots.Review.Review;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "users")
public class User {

    @Id
    private String userID;

    private String nickname;

    @DBRef
    private List<Review> reviews = new ArrayList<>();

    public User(String nickname) {
        this.nickname = nickname;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }
}

