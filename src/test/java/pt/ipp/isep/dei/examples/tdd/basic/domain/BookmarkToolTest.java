package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class BookmarkToolTest {

    @Test
    public void testCreateBookmarkTool() {
        BookMarkTool bookmarkTool = new BookMarkTool();
        Assertions.assertNotNull(bookmarkTool);
    }

    @Test
    public void testGetBookmarks() {
        //Arrange
        String url = "https://google.com";
        BookMarkTool bookMarkTool = new BookMarkTool();

        //Act
        List<Bookmark> bookmarks = bookMarkTool.getBookmarks();

        //Assert
        Assertions.assertNotNull(bookmarks);
    }

    @Test
    public void testAddBookmark() throws MalformedURLException {
        //Arrange
        String url = "https://google.com";
        BookMarkTool bookMarkTool = new BookMarkTool();

        //Act
        bookMarkTool.bookmarkURL(url);


        //Assert
        Assertions.assertEquals(1, bookMarkTool.getBookmarks().size());
    }

    @Test
    public void testCreateBookmarkThrowsMalformedUrlException() throws MalformedURLException {
        //Arrange
        String url = "123";
        BookMarkTool bookMarkTool = new BookMarkTool();

        //Act and Assert
        Assertions.assertThrows(MalformedURLException.class, () -> {
            bookMarkTool.bookmarkURL(url);
        });
    }

    @Test
    public void testAddKeyword() throws MalformedURLException {
        //Arrange
        String url = "https://google.com";
        String keyword = "keyword";
        List<String> expectedKeywords = new ArrayList<>();
        expectedKeywords.add(keyword);

        BookMarkTool bookMarkTool = new BookMarkTool();
        bookMarkTool.bookmarkURL(url);

        Bookmark expectedBookmark = new Bookmark("https://google.com");
        expectedBookmark.addKeyword("keyword");

        //Act
        bookMarkTool.setKeyword(url, keyword);

        //Assert
        Assertions.assertEquals(1, bookMarkTool.getBookmarks().size());
        Assertions.assertEquals(expectedKeywords, bookMarkTool.getBookmarks().get(0).getKeywords());
    }

    @Test
    public void testAddKeywordForNonExistentBookmark() throws MalformedURLException {
        //Arrange
        BookMarkTool bookMarkTool = new BookMarkTool();

        String url = "123";
        String keyword = "keyword";

        //Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bookMarkTool.setKeyword(url, keyword);
        });
    }

    @Test
    public void testAddKeywordWithNullUrl() throws MalformedURLException {
        //Arrange
        BookMarkTool bookMarkTool = new BookMarkTool();

        String url = null;
        String keyword = "keyword";

        //Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bookMarkTool.setKeyword(url, keyword);
        });
    }

    @Test
    public void testAddKeywordWithNullKeyword() throws MalformedURLException {
        //Arrange
        BookMarkTool bookMarkTool = new BookMarkTool();

        String url = "123";
        String keyword = null;

        //Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bookMarkTool.setKeyword(url, keyword);
        });
    }
    @Test
    public void testCheckDuplicate() throws MalformedURLException {
        //Arrange
        BookMarkTool bookMarkTool = new BookMarkTool();

        String url = "https://google.com";

        bookMarkTool.bookmarkURL(url);  //add bookmark with url
        Boolean expected = true;

        //Act
        Boolean actual = bookMarkTool.checkDuplicate(url);

        //Assert
        Assertions.assertEquals(expected, actual);

    }
}



