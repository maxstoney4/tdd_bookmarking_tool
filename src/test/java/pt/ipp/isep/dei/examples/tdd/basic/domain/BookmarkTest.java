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
    public void testAddKeywordsWithKeyWordAlreadyExisting() throws MalformedURLException {
        //Arrange

        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);


        String keywordOne="test";
        String keywordTwo="test2";
        List <String> expected = new ArrayList<>();
        expected.add(keywordOne);
        expected.add(keywordTwo);

        //Act
        bookmark.addKeyword(keywordOne);
        bookmark.addKeyword(keywordTwo);

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
    @Test
    public void testGetKeywordsWithTwoKeywords() throws MalformedURLException {
        //Arrange
        String keywordOne="test";
        String keywordTwo="test2";
        List <String> expected = new ArrayList<>();
        expected.add(keywordOne);
        expected.add(keywordTwo);

        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);
        bookmark.addKeyword(keywordOne);
        bookmark.addKeyword(keywordTwo);

        //Act
        List<String> actual = bookmark.getKeywords();

        //Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testIncrementRating() throws MalformedURLException {
        //Arrange

        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);
        int expected = 2;

        //Act
        bookmark.incrementRating();

        //Assert
        Assertions.assertEquals(expected, bookmark.getRating());
    }
    @Test
    public void testGetRating() throws MalformedURLException {
        //Arrange
        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);
        int expected = 1;

        //Act
        int actual = bookmark.getRating();

        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIsUrlSecureWithSecureUrl() throws MalformedURLException {
        //Arrange
        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);

        //Act and Assert
        Assertions.assertTrue(bookmark.isUrlSecure());
    }

    @Test
    public void testIsUrlSecureWithUnsecureUrl() throws MalformedURLException {
        //Arrange
        String url = "http://google.com";
        Bookmark bookmark = new Bookmark(url);

        //Act and Assert
        Assertions.assertFalse(bookmark.isUrlSecure());
    }
    @Test
    public void testremoveKeywordWithOneExistingKeyword() throws MalformedURLException {
        //Arrange
        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);

        String keywordOne="test";

        List <String> expected = new ArrayList<>();

        //Act
        bookmark.addKeyword(keywordOne);
        bookmark.removeKeyword(keywordOne);

        //Assert
        Assertions.assertEquals(expected, bookmark.getKeywords());
    }
    @Test
    public void testremoveKeywordWithSeveralExistingKeywordsAndRemoveFirst() throws MalformedURLException {
        //Arrange
        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);

        String keywordOne="test";
        String keywordTwo="testTwo";
        String keywordThree="testThree";
        String keywordFour="Four";

        List <String> expected = new ArrayList<>();

        //expected.add(keywordOne);
        expected.add(keywordTwo);
        expected.add(keywordThree);
        expected.add(keywordFour);

        bookmark.addKeyword(keywordOne);
        bookmark.addKeyword(keywordTwo);
        bookmark.addKeyword(keywordThree);
        bookmark.addKeyword(keywordFour);
        //Act

        bookmark.removeKeyword(keywordOne);

        //Assert
        Assertions.assertEquals(expected, bookmark.getKeywords());
    }
    @Test
    public void testremoveKeywordWithSeveralExistingKeywordsAndRemoveLast() throws MalformedURLException {
        //Arrange
        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);

        String keywordOne="test";
        String keywordTwo="testTwo";
        String keywordThree="testThree";
        String keywordFour="Four";

        List <String> expected = new ArrayList<>();

        expected.add(keywordOne);
        expected.add(keywordTwo);
        expected.add(keywordThree);
        //expected.add(keywordFour);

        bookmark.addKeyword(keywordOne);
        bookmark.addKeyword(keywordTwo);
        bookmark.addKeyword(keywordThree);
        bookmark.addKeyword(keywordFour);
        //Act

        bookmark.removeKeyword(keywordFour);

        //Assert
        Assertions.assertEquals(expected, bookmark.getKeywords());
    }
    @Test
    public void testremoveKeywordWithNonExistingKeyword() throws MalformedURLException {
        //Arrange
        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);

        String keywordOne="test";
        String keywordTwo="testTwo";

        bookmark.addKeyword(keywordOne);
        bookmark.addKeyword(keywordTwo);

        //Assert&Act
        Assertions.assertThrows(IllegalArgumentException.class, () ->{bookmark.removeKeyword("non-existing keyword");});
    }
    @Test
    public void testremoveKeywordFromEmptyKeywordlist() throws MalformedURLException {
        //Arrange
        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);

        //Assert&Act
        Assertions.assertThrows(IllegalArgumentException.class, () ->{bookmark.removeKeyword("empty_keyword_list_keyword");});
    }
    @Test
    public void testremoveNullKeyword() throws MalformedURLException {
        //Arrange
        String url = "https://google.com";
        Bookmark bookmark = new Bookmark(url);

        String keywordOne="test";
        String keywordTwo="testTwo";

        bookmark.addKeyword(keywordOne);
        bookmark.addKeyword(keywordTwo);

        String nullKeyword=null;

        //Assert&Act
        Assertions.assertThrows(IllegalArgumentException.class, () ->{bookmark.removeKeyword(nullKeyword);});
    }
}
