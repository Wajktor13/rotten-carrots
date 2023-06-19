package com.rotten.carrots.News;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public News publishNews(News news){
        news.setPublicationDate(LocalDateTime.now());
        return this.newsRepository.save(news);
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

    public List<News> getNewestNews() {
        return newsRepository.findTop10ByOrderByPublicationDateDesc();
    }

    public List<News> getLatestNews(int limit) {
        return newsRepository.findLatestNews(limit);
    }

    public List<News> getByAuthor(String author) {
        return newsRepository.findByAuthor(author);
    }

    public List<News> getByAuthorFirstLetters(String letters) {
        return newsRepository.findByAuthorStartingWith(letters);
    }

    public List<News> getByAuthorAndBetweenDates(String author, Date startDate, Date endDate){
        return newsRepository.findNewsByAuthorAndDate(author, startDate, endDate);
    }

    public List<News> getByTitle(String title){
        return newsRepository.findNewsByTitle(title);
    }

    public List<News> getSortedByAuthor() {
        return newsRepository.findNewsByOrderByAuthor();
    }

    public List<News> getSortedByAuthorDesc() {
        return newsRepository.findNewsByOrderByAuthorDesc();
    }
    public List<News>  getByContentFragment(String content)
    {return newsRepository.getByContentFragment(content);}

    public List<News> getByAuthorAndContent(String content, String author)
        {return newsRepository.findByAuthorAndContent(content, author);}

}
