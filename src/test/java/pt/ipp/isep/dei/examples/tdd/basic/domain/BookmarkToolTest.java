package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void testIncreaseDuplicate() throws MalformedURLException {
        //Arrange
        BookMarkTool bookMarkTool = new BookMarkTool();

        String url = "https://google.com";

        bookMarkTool.bookmarkURL(url);  //add bookmark with url

        int expected = 2;

        //Act
        bookMarkTool.bookmarkURL(url);  //checkDuplicate gets called -->increase


        //Assert
        Assertions.assertEquals(expected, bookMarkTool.getBookmark(url).getRating());

    }
    @Test
    public void testIncreaseDuplicateWithAdditionalUrlsCaseOne() throws MalformedURLException {
        //Arrange
        BookMarkTool bookMarkTool = new BookMarkTool();

        String url = "https://google.com";
        String urlTwo = "https://youtube.com";

        bookMarkTool.bookmarkURL(url);  //add bookmark with url

        int expected = 1;

        //Act
        bookMarkTool.bookmarkURL(urlTwo);  //add bookmark with url
        bookMarkTool.bookmarkURL(urlTwo);  //checkDuplicate gets called -->increase
        bookMarkTool.bookmarkURL(urlTwo);  //checkDuplicate gets called -->increase


        //Assert
        Assertions.assertEquals(expected, bookMarkTool.getBookmark(url).getRating());

    }
    @Test
    public void testIncreaseDuplicateWithAdditionalUrlsCaseTwo() throws MalformedURLException {
        //Arrange
        BookMarkTool bookMarkTool = new BookMarkTool();

        String url = "https://google.com";
        String urlTwo = "https://youtube.com";

        bookMarkTool.bookmarkURL(url);  //add bookmark with url

        int expected = 3;

        //Act
        bookMarkTool.bookmarkURL(urlTwo);  //add bookmark with url
        bookMarkTool.bookmarkURL(urlTwo);  //checkDuplicate gets called -->increase
        bookMarkTool.bookmarkURL(urlTwo);  //checkDuplicate gets called -->increase


        //Assert
        Assertions.assertEquals(expected, bookMarkTool.getBookmark(urlTwo).getRating());

    }

    @Test
    public void testGetBookmark() throws MalformedURLException {
        //Arrange
        BookMarkTool bookMarkTool = new BookMarkTool();

        String url = "https://google.com";

        bookMarkTool.bookmarkURL(url);  //add bookmark with url

        Bookmark expected = new Bookmark(url);

        //Act
        Bookmark actual = bookMarkTool.getBookmark(url);

        //Assert
        Assertions.assertEquals(expected.getRating(), actual.getRating());
        Assertions.assertEquals(expected.getURL().toString(), actual.getURL().toString());

    }
    @Test
    public void testGetBookmarkWithNonExistingURL() throws MalformedURLException {
        String url = "https://google.com";
        BookMarkTool bookMarkTool = new BookMarkTool();
        bookMarkTool.bookmarkURL(url);  //add bookmark with url

        String testUrl="https://test.com";

        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            bookMarkTool.getBookmark(testUrl);});
    }

    @Test
    public void testGetAmountOfSecureUrls() throws MalformedURLException {
        //Arrange
        BookMarkTool bookMarkTool = new BookMarkTool();
        bookMarkTool.bookmarkURL("https://secure.com");
        bookMarkTool.bookmarkURL("https://secure2.com");
        bookMarkTool.bookmarkURL("http://not-secure.com");

        //Act and Assert
        Assertions.assertEquals(2, bookMarkTool.getAmoutOfSecureUrls());
    }

    @Test
    public void testGetAmountOfSecureUrlsWithNoBookmarks(){
        //Arrange
        BookMarkTool bookMarkTool = new BookMarkTool();

        //Act and Assert
        Assertions.assertEquals(0, bookMarkTool.getAmoutOfSecureUrls());
    }

    @Test
    public void testFindByKeywordNullInput(){
        //Arrange
        BookMarkTool bookMarkTool = new BookMarkTool();

        //Act and Assert
        Assertions.assertTrue(bookMarkTool.findByKeyword(null).isEmpty());
    }

    @Test
    public void testFindByKeywordNoBookmarks(){
        //Arrange
        String keywoard = "keyword";
        BookMarkTool bookMarkTool = new BookMarkTool();

        //Act and Assert
        Assertions.assertTrue(bookMarkTool.findByKeyword(keywoard).isEmpty());
    }

    @Test
    public void testFindByKeywordSingleResult() throws MalformedURLException {
        //Arrange
        String bookmarkUrl = "https://url1.com";
        String keywoard = "relevantKeyword";
        BookMarkTool bookMarkTool = new BookMarkTool();
        bookMarkTool.bookmarkURL(bookmarkUrl);
        bookMarkTool.bookmarkURL("https://url2.com");
        bookMarkTool.bookmarkURL("https://url3.com");

        bookMarkTool.setKeyword(bookmarkUrl, keywoard);
        bookMarkTool.setKeyword("https://url2.com", "irrelevantKeyword");
        bookMarkTool.setKeyword("https://url3.com", "irrelevantKeyword2");

        //Act
        List<Bookmark> result = bookMarkTool.findByKeyword(keywoard);

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(bookmarkUrl, result.get(0).getURL().toString());
    }

    @Test
    public void testFindByKeywordMultipleResults() throws MalformedURLException {
        //Arrange
        List<String> expectedResultUrls = new ArrayList<>();
        String bookmarkUrl1 = "https://url1.com";
        String bookmarkUrl2 = "https://url2.com";
        expectedResultUrls.add(bookmarkUrl1);
        expectedResultUrls.add(bookmarkUrl2);

        String keywoard = "relevantKeyword";

        BookMarkTool bookMarkTool = new BookMarkTool();
        bookMarkTool.bookmarkURL(bookmarkUrl1);
        bookMarkTool.bookmarkURL(bookmarkUrl2);
        bookMarkTool.bookmarkURL("https://url3.com");

        bookMarkTool.setKeyword(bookmarkUrl1, keywoard);
        bookMarkTool.setKeyword(bookmarkUrl2, keywoard);
        bookMarkTool.setKeyword(bookmarkUrl2, "irrelevantKeyword");
        bookMarkTool.setKeyword("https://url3.com", "irrelevantKeyword2");

        //Act
        List<Bookmark> result = bookMarkTool.findByKeyword(keywoard);

        Assertions.assertEquals(2, result.size());
        List<String> resultUrls = result.stream().map(x->x.getURL().toString()).collect(Collectors.toList());
        Assertions.assertEquals(expectedResultUrls, resultUrls);
    }

    @Test
    public void testFindByKeywordsNullInput(){
        //Arrange
        BookMarkTool bookMarkTool = new BookMarkTool();

        //Act and Assert
        Assertions.assertTrue(bookMarkTool.findByKeywords(null).isEmpty());
    }

    @Test
    public void testFindByKeywordsNoBookmarks(){
        //Arrange
        List<String> keywordList = new ArrayList<>();
        String keywoard = "keyword";
        keywordList.add(keywoard);
        BookMarkTool bookMarkTool = new BookMarkTool();

        //Act and Assert
        Assertions.assertTrue(bookMarkTool.findByKeywords(keywordList).isEmpty());
    }

    @Test
    public void testFindByKeywordsNoKeyWords(){
        //Arrange
        List<String> keywordList = new ArrayList<>();
        BookMarkTool bookMarkTool = new BookMarkTool();

        //Act and Assert
        Assertions.assertTrue(bookMarkTool.findByKeywords(keywordList).isEmpty());
    }

    @Test
    public void testFindByKeywordsSingleResult() throws MalformedURLException {
        //Arrange
        List<String> keywordList = new ArrayList<>();
        String keywoard = "relevantKeyword";
        keywordList.add(keywoard);

        String bookmarkUrl = "https://url1.com";
        BookMarkTool bookMarkTool = new BookMarkTool();
        bookMarkTool.bookmarkURL(bookmarkUrl);
        bookMarkTool.bookmarkURL("https://url2.com");
        bookMarkTool.bookmarkURL("https://url3.com");

        bookMarkTool.setKeyword(bookmarkUrl, keywoard);
        bookMarkTool.setKeyword("https://url2.com", "irrelevantKeyword");
        bookMarkTool.setKeyword("https://url3.com", "irrelevantKeyword2");

        //Act
        List<Bookmark> result = bookMarkTool.findByKeywords(keywordList);

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(bookmarkUrl, result.get(0).getURL().toString());
    }

    @Test
    public void testFindByKeywordsMultipleResults() throws MalformedURLException {
        //Arrange
        List<String> keywordList = new ArrayList<>();
        String keywoard1 = "relevantKeyword";
        String keywoard2 = "relevantKeyword2";
        keywordList.add(keywoard1);
        keywordList.add(keywoard2);

        List<String> expectedResultUrls = new ArrayList<>();
        String bookmarkUrl1 = "https://url1.com";
        String bookmarkUrl2 = "https://url2.com";
        String bookmarkUrl3 = "https://url3.com";
        expectedResultUrls.add(bookmarkUrl1);
        expectedResultUrls.add(bookmarkUrl2);
        expectedResultUrls.add(bookmarkUrl3);

        BookMarkTool bookMarkTool = new BookMarkTool();
        bookMarkTool.bookmarkURL(bookmarkUrl1);
        bookMarkTool.bookmarkURL(bookmarkUrl2);
        bookMarkTool.bookmarkURL(bookmarkUrl3);

        bookMarkTool.setKeyword(bookmarkUrl1, keywoard1);
        bookMarkTool.setKeyword(bookmarkUrl2, keywoard1);
        bookMarkTool.setKeyword(bookmarkUrl2, "irrelevantKeyword");
        bookMarkTool.setKeyword(bookmarkUrl3, keywoard2);

        //Act
        List<Bookmark> result = bookMarkTool.findByKeywords(keywordList);

        Assertions.assertEquals(3, result.size());
        List<String> resultUrls = result.stream().map(x->x.getURL().toString()).collect(Collectors.toList());
        Assertions.assertEquals(expectedResultUrls, resultUrls);
    }
}