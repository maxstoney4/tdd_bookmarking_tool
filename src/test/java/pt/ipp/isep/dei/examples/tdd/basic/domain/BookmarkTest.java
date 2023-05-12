package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookmarkTest {
    @Test
    public void testCreateBookmark() {
        Bookmark bookmark = new Bookmark();
        Assertions.assertNotNull(bookmark);
    }
}
