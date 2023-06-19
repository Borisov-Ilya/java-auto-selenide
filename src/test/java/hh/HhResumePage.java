package hh;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class HhResumePage {
    private final SelenideElement gender = $x("//span[@data-qa='resume-personal-gender']");
    private final SelenideElement age = $x("//span[@data-qa='resume-personal-age']/span");
    private final SelenideElement city = $x("//span[@data-qa='resume-personal-address']");
    private final SelenideElement liveData = $x("//span[@data-qa='resume-personal-address']/ancestor::p");
    private final SelenideElement tick = $x("//span[@data-qa='resume-personal-phone']/span[1]");

    public static String GENDER = "Пол";
    public static String AGE = "Возраст";
    public static String CITY = "Город";
    public static String CONFIRMED_PHONE = "Подтвержденный номер";
    public static String READY_TO_RELOCATE = "Готовность к переезду";

    public HhResumePage(String url) {
        Selenide.open(url);
    }

    public Map<String, Object> getAttributes() {
        return new HashMap<>() {{
            put(GENDER, getGender());
            put(AGE, getAge());
            put(CITY, getCity());
//            put(CONFIRMED_PHONE, isPhoneConfirmed());
            put(READY_TO_RELOCATE, isReadyToRelocate());
        }};
    }

    public boolean isPhoneConfirmed() {
        return tick.isDisplayed();
    }

    public boolean isReadyToRelocate() {
        return !liveData.getText().split(", ")[1].equals("не готов к переезду");
    }

    public String getCity() {
        return city.getText();
    }

    public int getAge() {
        return Integer.parseInt(age.getText().replaceAll("\\D+", ""));
    }

    public String getGender() {
        return gender.getText().equals("Мужчина") ? "М" : "Ж";
    }
}
