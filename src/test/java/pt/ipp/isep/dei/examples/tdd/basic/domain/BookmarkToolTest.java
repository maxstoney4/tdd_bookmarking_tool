package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
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

        Assertions.assertThrows(MalformedURLException.class, () -> {
            bookMarkTool.bookmarkURL(url);
        });
    }

}



