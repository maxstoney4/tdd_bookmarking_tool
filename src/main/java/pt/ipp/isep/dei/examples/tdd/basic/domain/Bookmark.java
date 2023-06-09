package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Bookmark {

    private URL url;
    private List<String> keywords = new ArrayList<>();
    private int rating = 1;

    public Bookmark(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    public URL getURL() {
        return url;
    }
    public List <String> getKeywords(){
        return keywords;
    }
    public void addKeyword(String keyword){
        if (keyword!=null){
            if (keyword.length()>3){
                this.keywords.add(keyword);
            } else {
                throw new IllegalArgumentException("keyword too short");
            }
        } else {
            throw new IllegalArgumentException("keyword is null");
        }
    }
    public void incrementRating(){
        rating = rating +1;
    }
    public int getRating(){
        return rating;
    }

    public boolean isUrlSecure() {
        return this.url.toString().startsWith("https");
    }
    public void removeKeyword(String keyword){
        if (keyword!=null){
                if (this.keywords.isEmpty()){
                    throw new IllegalArgumentException("bookmark has no keywords");
                } else {
                    if (this.keywords.contains(keyword)){
                        this.keywords.remove(keyword);
                    }
                    else {
                        throw new IllegalArgumentException("keyword not existent");
                    }
                }
        } else {
            throw new IllegalArgumentException("keyword is null");
        }
    }
}
