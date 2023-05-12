package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
    public void testAddKeywords() throws MalformedURLException {
        //Arrange

        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);


        String keyword="test";
        List <String> expected = new ArrayList<>();
        expected.add(keyword);

        //Act
        bookmark.addKeyword(keyword);

        //Assert
        Assertions.assertEquals(expected, bookmark.getKeywords());
    }

    @Test
    public void testAddKeywordWithLessThanThreeCharacters() throws MalformedURLException {
        String url = "https://google.com";
        Assertions.assertThrows(IllegalArgumentException.class, () ->{new Bookmark(url).addKeyword("tes");});
    }
    @Test
    public void testAddKeywordWithNullKeyword() throws MalformedURLException {
        String url = "https://google.com";
        Assertions.assertThrows(IllegalArgumentException.class, () ->{new Bookmark(url).addKeyword(null);});
    }

    @Test
    public void testGetKeywords() throws MalformedURLException {
        //Arrange
        String keyword="test";
        List <String> expected = new ArrayList<>();
        expected.add(keyword);

        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);
        bookmark.addKeyword(keyword);

        //Act
        List<String> actual = bookmark.getKeywords();

        //Assert
        Assertions.assertEquals(expected, actual);
    }
}
