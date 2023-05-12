package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookmarkToolTest {

    @Test
    public void testCreateBookmarkTool() {
        BookMarkTool bookmarkTool = new BookMarkTool();
        Assertions.assertNotNull(bookmarkTool);
    }


}



