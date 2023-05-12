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

    public void setKeyword(String url, String keyword) {
        if (url == null || keyword == null) {
            throw new IllegalArgumentException();
        }
        Bookmark bookmark = this.bookmarks.stream()
                .filter(x -> x.getURL().toString().equals(url)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No bookmark for this URL"));
        bookmark.addKeyword(keyword);
    }
}
