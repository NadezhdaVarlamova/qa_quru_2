package gmail.com.varlamvanadia1996;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @Test
    void successTests (){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Nadezhda");
        $("#lastName").setValue("Varlamova");
        $("#userEmail").setValue("varlamvanadia1996@gmail.com");
        $x("//label[text()=\"Female\"]").click();
        $("#userNumber").setValue("0000000000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__month-select").selectOption("March");
        $x("//div[text()=\"21\"]").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $x("//label[text()=\"Sports\"]").click();
        $x("//label[text()=\"Reading\"]").click();
        $x("//label[text()=\"Music\"]").click();
        File file = new File("resources/test.txt");
        String absolutePath = file.getAbsolutePath();
        $("#uploadPicture").sendKeys(absolutePath);
        $x("//textarea[@id=\"currentAddress\"]").sendKeys("Zelenograd");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();
        $(".modal-content").shouldBe(visible);
        $x("//td[text()=\"Student Name\"]/following-sibling::td").shouldHave(text("Nadezhda Varlamova"));
        $x("//td[text()=\"Student Email\"]/following-sibling::td").shouldHave(text("varlamvanadia1996@gmail.com"));
        $x("//td[text()=\"Gender\"]/following-sibling::td").shouldHave(text("Female"));
        $x("//td[text()=\"Mobile\"]/following-sibling::td").shouldHave(text("0000000000"));
        $x("//td[text()=\"Date of Birth\"]/following-sibling::td").shouldHave(text("21 March,1996"));
        $x("//td[text()=\"Subjects\"]/following-sibling::td").shouldHave(text("Maths"));
        $x("//td[text()=\"Hobbies\"]/following-sibling::td").shouldHave(text("Sports, Reading, Music"));
        $x("//td[text()=\"Picture\"]/following-sibling::td").shouldHave(text("test.txt"));
        $x("//td[text()=\"Address\"]/following-sibling::td").shouldHave(text("Zelenograd"));
        $x("//td[text()=\"State and City\"]/following-sibling::td").shouldHave(text("Haryana Karnal"));
    }
}
