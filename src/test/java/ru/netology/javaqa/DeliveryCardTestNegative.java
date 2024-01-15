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

class DeliveryCardTestNegative {
    public String setDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @BeforeEach
    void SetUp() {
        open("http://localhost:9999");
    }

    @Test
        // поле ввода города на латинице
    void shouldTestIfNotOk1() {
        $("[data-test-id=city] input").setValue("Voronezh");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Екатерина Валерьевна");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=city].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Доставка в выбранный город недоступна"));

    }

    @Test
        // поле ввода города на кириллице с цифрами
    void shouldTestIfNotOk2() {
        $("[data-test-id=city] input").setValue("Ростов10");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Екатерина Валерьевна");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=city].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Доставка в выбранный город недоступна"));

    }

    @Test
        // поле ввода города на кириллице с символом !
    void shouldTestIfNotOk3() {
        $("[data-test-id=city] input").setValue("Ростов!");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Екатерина Валерьевна");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=city].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Доставка в выбранный город недоступна"));

    }

    @Test
        // поле ввода города 10 пробелов
    void shouldTestIfNotOk4() {
        $("[data-test-id=city] input").setValue("          ");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Екатерина Валерьевна");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=city].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Поле обязательно для заполнения"));

    }

    @Test
        // поле ввода города пустое
    void shouldTestIfNotOk5() {
        $("[data-test-id=city] input").setValue("          ");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Екатерина Валерьевна");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=city].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Поле обязательно для заполнения"));

    }

    @Test
        // поле ввода имени на латинице
    void shouldTestIfNotOk6() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Irina");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=name].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы," +
                        " пробелы и дефисы."));

    }

    @Test
        // поле ввода имени на кириллица с цифрами
    void shouldTestIfNotOk7() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Василий2016");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=name].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы," +
                        " пробелы и дефисы."));

    }

    @Test
        // поле ввода имени на кириллица с спец. символами
    void shouldTestIfNotOk8() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Василий***");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=name].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы," +
                        " пробелы и дефисы."));

    }

    @Test
        // поле ввода имени на кириллица с апостроф
    void shouldTestIfNotOk9() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("О`Коннор");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=name].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы," +
                        " пробелы и дефисы."));

    }

    @Test
        // поле ввода имени на кириллица с Ё
    void shouldTestIfNotOk10() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Пётр Алёхин");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=name].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы," +
                        " пробелы и дефисы."));

    }

    @Test
        // поле ввода имени 10 пробелов
    void shouldTestIfNotOk11() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("              ");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=name].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Поле обязательно для заполнения"));

    }

    @Test
        // поле ввода имени пустое
    void shouldTestIfNotOk12() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("");
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=name].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Поле обязательно для заполнения"));

    }

    @Test
        // поле ввода телефона без знака +
    void shouldTestIfNotOk13() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Валентина Ивановна");
        $("[data-test-id=phone] input").setValue("89600000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=phone].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }
    @Test
        // поле ввода телефона в формате +7(960)0000000 со скобками
    void shouldTestIfNotOk14() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Валентина Ивановна");
        $("[data-test-id=phone] input").setValue("+7(960)0000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=phone].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }
    @Test
        // поле ввода телефона в формате +7 960 000 00 00 с пробелами
    void shouldTestIfNotOk15() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Валентина Ивановна");
        $("[data-test-id=phone] input").setValue("+7 960 000 00 00");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=phone].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }
    @Test
        // поле ввода телефона с буквами
    void shouldTestIfNotOk16() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Валентина Ивановна");
        $("[data-test-id=phone] input").setValue("+796056788нн");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=phone].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }
    @Test
        // поле ввода телефона на один символ больше - 12 цифр
    void shouldTestIfNotOk17() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Валентина Ивановна");
        $("[data-test-id=phone] input").setValue("+796012110480");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=phone].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }
    @Test
        // поле ввода телефона на один символ меньше - 10 цифр
    void shouldTestIfNotOk18() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Валентина Ивановна");
        $("[data-test-id=phone] input").setValue("+7960121104");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=phone].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }
    @Test
        // поле ввода телефона пустое
    void shouldTestIfNotOk19() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Валентина Ивановна");
        $("[data-test-id=phone] input").setValue("");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=phone].input_invalid .input__sub")
                .shouldHave(Condition.exactText("Поле обязательно для заполнения"));

    }
    @Test
        // поле ввода телефона пустое
    void shouldTestIfNotOk20() {
        $("[data-test-id=city] input").setValue("Мурманск");
        String planningDay = setDate(3, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDay);
        $("[data-test-id=name] input").setValue("Валентина Ивановна");
        $("[data-test-id=phone] input").setValue("+79092142300");
        $(".button").click();
        $("[data-test-id=agreement].input_invalid")
                .shouldHave(Condition.exactText
                        ("Я соглашаюсь с условиями обработки и использования моих персональных данных"));

    }
}
