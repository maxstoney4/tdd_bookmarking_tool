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
        this.keywords.add(keyword);
    }
}
