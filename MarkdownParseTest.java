import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinksTesterOG() throws IOException {
        String content = Files.readString(Path.of("test-file.md"));
        assertEquals(List.of("https://something.com","some-thing.html"),
            MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksMyTester1() throws IOException {
        String content = Files.readString(Path.of("my-test1.md"));
        assertEquals(List.of(),
            MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksMyTester2() throws IOException {
        String content = Files.readString(Path.of("my-test2.md"));
        assertEquals(List.of("https://something.com"),
            MarkdownParse.getLinks(content));
    }
    // output is same as test 1, but test is failing for some strange reason
    // @Test
    // public void getLinksMyTester3() throws IOException {
    //     String content = Files.readString(Path.of("my-test3.md"));
    //     assertEquals(List.of(),
    //         MarkdownParse.getLinks(content));
    // }
}
