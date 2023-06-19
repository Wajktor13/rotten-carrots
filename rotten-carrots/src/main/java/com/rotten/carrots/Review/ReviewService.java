package com.rotten.carrots.Review;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReviewService {

    ReviewRepository reviewRepository;

    public ReviewService() {
    }

    public ReviewService(ReviewRepository newsRepository) {
        this.reviewRepository = newsRepository;
    }

    public List<Review> getAllReviews(){
        return this.reviewRepository.findAll();
    }

    public Optional<Review> getReviewByID(String reviewID) {

        return this.reviewRepository.findById(reviewID);
    }

    public List<Review> getGameReviews(String gameID){
        return this.reviewRepository.findByGameID(gameID);
    }

    public void deleteReviewByID(String reviewID){
        this.reviewRepository.deleteById(reviewID);
    }

    public List<Review> getByCarrotRate() {
        return reviewRepository.findByOrderByCarrotRateDesc();
    }

    public List<Review> getTopByCarrotRate() {
        return reviewRepository.findTop15ByOrderByCarrotRateDesc();
    }

    public List<Review> getReviewsByAuthor(String author){
        return reviewRepository.findByAuthor(author);
    }
    public List<Review> getReviewsByContent(String content) {
        return reviewRepository.getReviewsByContent(content);
    }

    public List<Review> findByOrderPublicationDateDesc() {
        return reviewRepository.findByOrderByPublicationDateDesc();
    }
}
