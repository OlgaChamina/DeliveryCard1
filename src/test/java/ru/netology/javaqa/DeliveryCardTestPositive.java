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

    @Test // текущая дата + 3 дня
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
    @Test // текущая дата + 32 дня
    void shouldTestIfOk2() {
        $("[data-test-id=city] input").setValue("Владивосток");
        String planningDay = setDate(32, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Анна Мария");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".notification__content").shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDay));

    }
    @Test // Поле ввода города - на кириллице через дефис
    void shouldTestIfOk3() {
        $("[data-test-id=city] input").setValue("Ростов-на-дону");
        String planningDay = setDate(32, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Анна Мария");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".notification__content").shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDay));

    }
    @Test // Поле ввода города - на кириллице заглавными буквами
    void shouldTestIfOk4() {
        $("[data-test-id=city] input").setValue("МОСКВА");
        String planningDay = setDate(32, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Анна Мария");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".notification__content").shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDay));

    }
    @Test // Поле ввода имени - на кириллице через дефис
    void shouldTestIfOk5() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(32, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Анна-Мария");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".notification__content").shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDay));

    }
    @Test // Поле ввода имени - на кириллице заглавными буквами
    void shouldTestIfOk6() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(32, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("МАРИЯ ПЕТРОВА");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".notification__content").shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDay));

    }
    @Test // Поле ввода имени - на кириллице через 10 пробелов между именем и фамилией
    void shouldTestIfOk7() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(32, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Анна          Мария");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".notification__content").shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDay));

    }


}
