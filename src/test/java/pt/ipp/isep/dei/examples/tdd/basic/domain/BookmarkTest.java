package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BookmarkTest {
    @Test
    public void testCreateBookmark() throws MalformedURLException {
        String url = "https://google.com";
        URL expected = new URL(url);

        Bookmark bookmark = new Bookmark(url);

        Assertions.assertNotNull(bookmark);
        Assertions.assertEquals(expected, bookmark.getURL());
    }

    @Test
    public void testCreateBookmarkThrowsMalformedUrlException() throws MalformedURLException {
        String url = "123";
        Assertions.assertThrows(MalformedURLException.class, () -> {
            new Bookmark(url);
        });
    }

    @Test
    public void testGetURL() throws MalformedURLException {
        //Arrange
        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);
        URL expected = new URL(url);

        //Act
        URL actual = bookmark.getURL();

        //Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testAddKeyword() throws MalformedURLException {
        //Arrange
        String keyword="test";
        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);
        String expected = "test";

        //Act
        bookmark.setKeyword(keyword);

        //Assert
        Assertions.assertEquals(expected, bookmark.getKeyword());
    }
    @Test
    public void testGetKeyword() throws MalformedURLException {
        //Arrange
        String keyword="test";
        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);
        String expected = "test";
        bookmark.setKeyword(keyword);

        //Act
        String actual = bookmark.getKeyword();

        //Assert
        Assertions.assertEquals(expected, actual);
    }
}
