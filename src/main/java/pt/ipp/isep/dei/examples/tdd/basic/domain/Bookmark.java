package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.MalformedURLException;
import java.net.URL;

public class Bookmark {

    private URL url;
    private String keyword;

    public Bookmark(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    public URL getURL() {
        return url;
    }
    public String getKeyword(){
        return keyword;
    }
    public void setKeyword(String keyword){
        this.keyword=keyword;
    }
}
