package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookmarkTest {
    @Test
    public void testCreateBookmark() {
        //arrange

        //act
        Bookmark bookmark = new Bookmark();
        //assert

        Assertions.assertNotNull(bookmark);

    }
    @Test
    public void testCreateBookmark() {
        //arrange

        //act
        Bookmark bookmark = new Bookmark();
        //assert

        Assertions.assertNotNull(bookmark);

    }
}
