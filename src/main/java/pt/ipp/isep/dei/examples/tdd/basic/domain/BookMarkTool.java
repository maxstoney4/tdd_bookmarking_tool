package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookMarkTool {

    private List<Bookmark> bookmarks = new ArrayList<>();

    public BookMarkTool() {

    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void bookmarkURL(String url) throws MalformedURLException {
        if(checkDuplicate(url)){
            //getBookmark(url).incrementRating();  only working when this line is not used, dont know where increment is used elsewhere
        } else {
            this.bookmarks.add(new Bookmark(url));
        }
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
    public boolean checkDuplicate(String url) {
        boolean isDuplicate=false;
        for (Bookmark bookmark:bookmarks){
            if (url.equals(bookmark.getURL().toString())){
                isDuplicate=true;
                bookmark.incrementRating();
            }
        }
        return isDuplicate;
    }
    public Bookmark getBookmark(String url) throws MalformedURLException {
        boolean isDuplicate=false;
        Bookmark test = new Bookmark("https://test.com");
        for (Bookmark bookmark:bookmarks){
            if (url.equals(bookmark.getURL().toString())){
                isDuplicate=true;
                test=bookmark;
            }
        }
        if (!isDuplicate){
            throw new IllegalArgumentException("bookmark not existant");
        }
        return test;
    }

    public int getAmoutOfSecureUrls() {
        return (int) bookmarks.stream().filter(Bookmark::isUrlSecure).count();
    }

    public List<Bookmark> findByKeyword(String keywoard) {
        if(keywoard == null){
            return new ArrayList<>();
        }
        return this.bookmarks.stream().filter(x -> x.getKeywords().contains(keywoard)).collect(Collectors.toList());
    }

    public List<Bookmark> findByKeywords(List<String> keywordList) {
        if(keywordList == null || keywordList.size() == 0){
            return new ArrayList<>();
        }
        List<Bookmark> result = new ArrayList<>();
        for(String keyword : keywordList){
            result.addAll(findByKeyword(keyword));
        }
        return result;
    }
    public void sortByRating() throws MalformedURLException {

    }
}
