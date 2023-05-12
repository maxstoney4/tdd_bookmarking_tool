package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Bookmark {

    private URL url;
    private List<String> keywords = new ArrayList<>();

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
}
