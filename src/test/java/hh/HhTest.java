package hh;

import core.BaseTest;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HhTest extends BaseTest {
    private final static String URL = "Ссылка на любое резюме hh.ru";

    /**
     * Сравнение через HashMap
     */
    @Test
    public void checkAttributesHashMap() {
        HhResumePage hhResumePage = new HhResumePage(URL);

        Map<String, Object> expectedAttributes = new HashMap<>();
        expectedAttributes.put(HhResumePage.GENDER, "М");
        expectedAttributes.put(HhResumePage.AGE, 28);
        expectedAttributes.put(HhResumePage.CITY, "Анапа");
//        expectedAttributes.put(HhResumePage.CONFIRMED_PHONE, true);
        expectedAttributes.put(HhResumePage.READY_TO_RELOCATE, false);

        Map<String, Object> actualAttributes = hhResumePage.getAttributes();

        Assertions.assertEquals(expectedAttributes, actualAttributes);
    }

    /**
     * Сравнение через Class
     */
    @Test
    public void checkAttributesClass() {
        HhResumePage hhResumePage = new HhResumePage(URL);
        Resume expectedAttributes = new Resume("М", 28, "Анапа", false);
        Resume actualAttributes = new Resume(hhResumePage.getGender(), hhResumePage.getAge(),
                hhResumePage.getCity(),
                hhResumePage.isReadyToRelocate());
//        Сравнение классов
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(expectedAttributes, actualAttributes));

//        Сравнение отдельных переменных в классе
        Assertions.assertEquals(expectedAttributes.getGender(), actualAttributes.getGender());
        Assertions.assertEquals(expectedAttributes.getAge(), actualAttributes.getAge());
        Assertions.assertEquals(expectedAttributes.getCity(), actualAttributes.getCity());
        Assertions.assertEquals(expectedAttributes.isReadyToRelocate(), actualAttributes.isReadyToRelocate());

    }
}
