package wiki;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class WikiTest extends BaseTest {
    private final static String URL = "https://ru.wikipedia.org/wiki/Java";

    @Test
    public void openAllHrefs() {
        Selenide.open(URL);
        ElementsCollection hrefs = $$x("//div[@id='toc']//a[@href]");
        List<String> links = new ArrayList<>();
        // 1 способ перебора ссылок
//        for(int i = 0; i < hrefs.size(); i++) {
//            links.add(hrefs.get(i).getAttribute("href"));
//        }
//        // 2 способ перебора ссылок
//        for(SelenideElement element : hrefs) {
//            links.add(element.getAttribute("href"));
//        }
        // 3 способ перебора ссылок
        hrefs.forEach(x -> links.add(x.getAttribute("href")));
//
//        // Перебор и открытие полученных ссылок
//        links.forEach(Selenide::open);
//        // Перебор и открытие полученных ссылок + assert
//        for (int i = 0; i < links.size(); i++) {
//            String listUrl = links.get(i);
//            Selenide.open(listUrl);
//            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
//            Assertions.assertEquals(currentUrl, listUrl);
//        }
//
//        // Открытие рандомной ссылки и удаление этой ссылки из списка
//        while (links.size() > 0) {
//            int randomNumber = new Random().nextInt(links.size());
//            Selenide.open(links.get(randomNumber));
//            links.remove(WebDriverRunner.getWebDriver().getCurrentUrl());
//        }

        List<Integer> linksLength = hrefs.stream().map(x -> x.getAttribute("href").length()).collect(Collectors.toList());
        int i = 0;
    }
}
