package gmail.com.varlamvanadia1996;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @Test
    void successTests (){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Nadezhda");
        $("#lastName").setValue("Varlamova");
        $("#userEmail").setValue("varlamvanadia1996@gmail.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("0000000000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__month-select").selectOption("March");
        $(byText("21")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("test.txt");
        $x("//textarea[@id=\"currentAddress\"]").sendKeys("Zelenograd");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();
        $(".modal-content").shouldBe(visible);
        $(".table").shouldHave(text("Nadezhda Varlamova"),
                text("varlamvanadia1996@gmail.com"),
                text("Female"),
                text("0000000000"),
                text("21 March,1996"),
                text("Maths"),
                text("Sports, Reading, Music"),
                text("test.txt"),
                text("Zelenograd"),
                text("Haryana Karnal"));
    }
}
