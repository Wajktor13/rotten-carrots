package com.rotten.carrots.News;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class NewsService {

    NewsRepository newsRepository;

    public NewsService() {
    }

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public void publishNews(News news){
        this.newsRepository.save(news);
    }

    public List<News> getNewsBetweenDates(Date from, Date to){
        return newsRepository.findBetweenDates(from, to);
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News getNewsByID(String id){
        Optional<News> news = newsRepository.findById(id);
        return news.orElse(null);
    }
}
