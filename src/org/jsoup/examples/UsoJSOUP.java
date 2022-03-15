package org.jsoup.examples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class UsoJSOUP {
    public static void main(String[] args) {
        Document doc = null;
                try {
                    doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/9828ef4989632378cb01f05c18a0ca3a47781f777d705291ec60422ef13d871c").get();
                }catch (IOException e) {
                    e.printStackTrace();
                }
        System.out.println(doc.title());
        Elements newsHeadlines = doc.select("#TemperatureValue");
        for (Element headline : newsHeadlines) {
            log("%s\n\t%s", headline.attr("#Card--cardHeading--5_qfE"), headline.absUrl("href"));
        }
    }
}