package ru.netology.javaqa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class DeliveryCardTestPositive {

    public String setDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @BeforeEach
    void SetUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldTestIfOk1() {
        $("[data-test-id=city] input").setValue("Владивосток");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Екатерина Валерьевна");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".notification__content").shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDay));

    }
    @Test
    void shouldTestIfOk2() {
        $("[data-test-id=city] input").setValue("Владивосток");
        String planningDay = setDate(31, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Екатерина Валерьевна");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".notification__content").shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDay));

    }


}
