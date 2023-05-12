package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class BookMarkTool {

    private List<Bookmark> bookmarks = new ArrayList<>();

    public BookMarkTool() {

    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void bookmarkURL(String url) throws MalformedURLException {
        this.bookmarks.add(new Bookmark(url));
    }
}
