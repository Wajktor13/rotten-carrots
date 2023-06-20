package com.rotten.carrots.News;

import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsResource {

    private NewsService newsService;

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

    @GetMapping("/byYear")
    public List<News> getNewsFromOneYear(@RequestParam("year") String year) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String from_ = year+ "-01-01";
        String to_ = year + "-12-31";
        try {
            Date from = format.parse(from_);
            Date to = format.parse(to_);
            return newsService.getNewsBetweenDates(from, to);
        } catch (ParseException e) {
            return new ArrayList<>();
        }
    }

    @GetMapping("/byYearAndMonth")
    public List<News> getNewsFromOneYearAndMonth(@RequestParam("year") String year,
                                                 @RequestParam("month") String month) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String from_ = year +"-"+ month + "-01";
        String to_ = switch (month) {
            case "1", "3", "5", "7", "8", "10", "12" -> year +"-"+ month + "-31";
            case "4", "6", "9", "11" -> year +"-"+ month + "-30";
            case "2" -> year +"-"+ month + "-28";
            default -> "";
        };
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

    @PostMapping("/add")
    public News addNewNews(@RequestBody News news){
        return newsService.publishNews(news);
    }
    @GetMapping("/newestNews")
    public List<News> getNewestNews(){
        return newsService.getNewestNews();
    }
    @GetMapping("newestNews/{limit}")
    public List<News> getNewestByParam(@PathVariable("limit") int howMuch){
        return newsService.getLatestNews(howMuch);
    }
    @GetMapping("/newsByAuthor")
    public List<News> getByAuthor(@RequestParam("author") String author) {
        return newsService.getByAuthor(author);
    }

    @GetMapping("/newsByAuthorFirstLetters")
    public List<News> getByAuthorFirstLetters(@RequestParam("letters") String letters){
        return newsService.getByAuthorFirstLetters(letters);
    }

    @GetMapping("/{author}/{from_}/{to_}")
    public List<News> getByAuthorAndBetweenDates(@PathVariable("author") String author,
                                                 @PathVariable("from_") String from_,
                                                 @PathVariable("to_") String to_){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date from = format.parse(from_);
            Date to = format.parse(to_);
            return newsService.getByAuthorAndBetweenDates(author, from, to);
        } catch (ParseException e) {
            return new ArrayList<>();
        }
    }

    @GetMapping("/newsByTitle")
    public List<News>getByTitle(@RequestParam("title") String title){
        return newsService.getByTitle(title);
    }

    @GetMapping("/sortByAuthor")
    public List<News>getSortedByAuthor() {
        return newsService.getSortedByAuthor();
    }

    @GetMapping("/sortByAuthorDesc")
    public List<News>getSortedByAuthorDesc() {
        return newsService.getSortedByAuthorDesc();
    }

    @GetMapping("/newsByAuthorAndContent")
    public List<News>getByAuthorAndContent(@RequestParam("content") String content,
                                           @RequestParam("author") String author){
        return newsService.getByAuthorAndContent(content, author);
    }
    @GetMapping("/newsByContent")
    public List<News>getByContentFragment(@RequestParam("content") String content){
        return newsService.getByContentFragment(content);
    }

}
