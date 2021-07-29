import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DanTri {
    private static String getContentFrom(String link) throws IOException {
        URL url = new URL(link);
        Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
        scanner.useDelimiter("\\\\Z");
        String content = scanner.next();
        scanner.close();
        content = content.replaceAll("\\R", "");
        return content;
    }
    public static String getEvent(String c){
        String result= "";
        Pattern p1 = Pattern.compile("dt-list dt-list--link\">(.*?)</ul>");
        Matcher m1 = p1.matcher(c);
        while (m1.find()) {
            result = m1.group(1);
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        String content = getContentFrom("https://dantri.com.vn/");
        String c = getEvent(content);
        Pattern p1 = Pattern.compile("htm\">(.*?)</a>");
        Matcher m1 = p1.matcher(c);
        while (m1.find()) {
            System.out.println(m1.group(1).trim());
        }
    }
}
