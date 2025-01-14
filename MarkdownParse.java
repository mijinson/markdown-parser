//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<String>();

        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {

            //checks for image reference: if it is an image then its not added to toReturn
            if (markdown.indexOf("!", currentIndex) == markdown.indexOf("[", currentIndex)-1) {
                currentIndex+=2;
                break;
            }

            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;

            //if space between [] and () skip the space so code can properly extract link
            if (openParen != closeBracket + 1) {
                currentIndex++;
            }

            if (markdown.substring(openParen + 1, closeParen).isBlank()) {
                break;
            }
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
    //for lab report
}