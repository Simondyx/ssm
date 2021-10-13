import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
/*
    用Jsoup解析器解析XML文件
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {

        String path = JsoupDemo1.class.getClassLoader().getResource("Students.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements elements = document.getElementsByTag("name");
        Element element = elements.get(0);
        String name = element.text();

        System.out.println(name);


    }
}
