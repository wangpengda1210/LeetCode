import java.util.*;

public class WebCrawler {
     interface HtmlParser {
         List<String> getUrls(String url);
     }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostName = startUrl.split("/")[2];

        Queue<String> htmls = new LinkedList<>();
        HashSet<String> seen = new HashSet<>();
        htmls.add(startUrl);
        seen.add(startUrl);
        List<String> ans = new ArrayList<>();

        while (!htmls.isEmpty()) {
            String next = htmls.poll();
            ans.add(next);

            for (String child : htmlParser.getUrls(next)) {
                if (!seen.contains(child) && child.split("/")[2].equals(hostName)) {
                    htmls.add(child);
                    seen.add(child);
                }
            }
        }

        return ans;
    }
}
