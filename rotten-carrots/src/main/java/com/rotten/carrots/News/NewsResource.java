package com.rotten.carrots.News;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsResource {

    final private NewsService newsService;

    public NewsResource(NewsRepository newsRepository) {
        this.newsService = new NewsService(newsRepository);
    }

    @GetMapping("/{from_}/{to_}")
    public List<News> getNewsBetweenDates(@PathVariable("from_") String from_, @PathVariable("to_") String to_) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date from = format.parse(from_);
            Date to = format.parse(to_);
            return newsService.getNewsBetweenDates(from, to);
        } catch (ParseException e) {
            return new ArrayList<>();
        }
    }

    @GetMapping("/all")
    public List<News> getAll(){ return this.newsService.getAllNews(); }

    @GetMapping("/{newsID}")
    public News getNewsByID(@PathVariable("newsID") String newsID){
        return newsService.getNewsByID(newsID);
    }
}
