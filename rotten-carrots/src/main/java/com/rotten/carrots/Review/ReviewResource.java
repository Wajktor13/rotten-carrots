package com.rotten.carrots.Review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/reviews")
public class ReviewResource {

    private ReviewService reviewService;

    public ReviewResource(ReviewRepository reviewRepository) {
        this.reviewService = new ReviewService(reviewRepository);
    }

    @GetMapping("/all")
    public List<Review> getAll() {
        return this.reviewService.getAllReviews();
    }

    @GetMapping("/{reviewID}")
    public Optional<Review> getReviewByID(@PathVariable("reviewID") String reviewID) {
        return this.reviewService.getReviewByID(reviewID);
    }

    @DeleteMapping("/{reviewID}")
    public ResponseEntity<?> deleteReview(@PathVariable("reviewID") String reviewID) {
        try {
            this.reviewService.deleteReviewByID(reviewID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
