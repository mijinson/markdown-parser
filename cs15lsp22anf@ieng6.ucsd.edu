import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
//import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinksTester() throws IOException {
        String content = Files.readString(Path.of("test-file.md"));
        assertEquals(List.of("https://something.com","some-thing.html"),
            MarkdownParse.getLinks(content));
    }

    // THIS IS A TEST THAT FAILS
    @Test
    public void getLinksMyTester() throws IOException {
        String content = Files.readString(Path.of("my-test1.md"));
        assertEquals(List.of(""),
            MarkdownParse.getLinks(content));
    }
}
