package sbpTests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class BaseSteps {
     final SelenideElement logoImg = $x("//img[@id='logo']");
     final SelenideElement logInButton = $x("//button[@id='login-button']");
     final SelenideElement userNameInput = $x("//input[@name='username']");
     final SelenideElement passwordInput = $x("//input[@name='password']");
     final SelenideElement smsInput = $x("//input[@id='otp-code']");
     final SelenideElement codeButton = $x("//button[@id='login-otp-button']");
     static final SelenideElement logoIn = $x("//a[@id='logo']");
    static final String baseUrl = "https://idemo.bspb.ru/";
     final SelenideElement Ava = $x("//a[@id='user-avatar']");
     final SelenideElement ProvZ = $x("//*[@id='header']/div/div[1]");
     final SelenideElement NewAva = $x("//div[@id='avatars']//img[@data-avatar='30.png']");
     final SelenideElement ButSave = $x("//div[@class='form-actions']//button[@id='submit-button']");
     final SelenideElement Error = $x("//div[@class='alert alert-error']");
     final SelenideElement labelAva = $x("//div[@id='avatars-form']/label");
     final SelenideElement cards = $x("//a[@id='cards-overview-index']");
     final SelenideElement getPodt = $x("//*[@id=\"card-details-ownbank-10068\"]/div[2]/div[2]/div/div/div[1]/a/span");
     final SelenideElement block = $x("//*[@id=\"card-details-ownbank-10068\"]/div[2]/div[2]/div/div/div[2]/a/span");
     final SelenideElement blockBut = $x("//*[@id='block-card']");
     final SelenideElement smsCod = $x("//*[@id='otp-input']");
     final SelenideElement butPodt =$x("//*[@id='confirm']");
     final SelenideElement blockProv = $x("//*[@id=\"card-details-ownbank-10068\"]/div[2]/div[2]/div[1]");
     final SelenideElement unBlockBut = $x("//*[@id=\"card-details-ownbank-10068\"]/div[2]/div[2]/div[2]/div/div[1]/a/span");

    @Step("??????????????????????")
    void loginStep() {

        open(baseUrl);
        logoImg.shouldBe(visible);
        userNameInput.shouldBe(visible).val("demo");
        passwordInput.shouldBe(visible).val("demo");
        logInButton.shouldBe(visible).click();
        smsInput.shouldBe(visible).val("0000");
        codeButton.shouldBe(visible).click();
        logoIn.shouldBe(visible);
    }

    @Step("???????????????????? ??????????")
    void cardBlock() {

        cards.shouldBe(visible).click();
        //getPodt.shouldHave(text("??????????????????????????"));
        block.shouldBe(visible).click();
        blockBut.shouldBe(visible).click();
        switchTo().frame($x("//*[@id='confirmation-frame']"));
        smsCod.shouldBe(visible).val("0000");
        butPodt.shouldBe(visible).click();
    }
    @Step("?????????????????????????? ??????????")
    void cardUnBlock() {

        blockProv.shouldHave(text("??????????????????????????"));
        unBlockBut.shouldBe(visible).click();
        switchTo().frame($x("//*[@id='confirmation-frame']"));
        smsCod.shouldBe(visible).val("0000");
        butPodt.shouldBe(visible).click();
        getPodt.shouldHave(text("??????????????????"));

    }


    @Step("????????????????")
    void CheckName() {

        ProvZ.shouldHave(text("????????"));
    }

    @Step("?????????? ????????????????")
    void setNewAva() {

        Ava.shouldBe(visible).click();
        switchTo().frame($x("(//div[@id='contentbar']/iframe)"));
        labelAva.shouldBe(visible);
        labelAva.shouldHave(text("????????????"));
        NewAva.shouldBe(visible).click();
        ButSave.shouldBe(visible).click();
        Error.shouldBe(visible);
    }
    @Step("?????????? ???? ????????????")
    void frameOut(){


        switchTo().defaultContent();
        logoImg.shouldBe(visible).click();
    }
}
