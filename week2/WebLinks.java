package stringsfirstassignment;

import edu.duke.*;

public class WebLinks {
    public void search() {
        URLResource file = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        Iterable<String> files = file.words();

        for (String item : files) {
            String itemLower = item.toLowerCase();
            int pos = itemLower.indexOf("youtube.com");
            if (pos != -1) {
                int beg = item.lastIndexOf("\"",pos);
                int end = item.indexOf("\"", pos+1);
                System.out.println(item.substring(beg+1,end));

            }
        }
    }
}
