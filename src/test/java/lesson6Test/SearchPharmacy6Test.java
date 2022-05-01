package lesson6Test;

import io.qameta.allure.*;
import lesson6.MainPage;
import lesson6.MyUtils;
import lesson6.OurPharmacyPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
@Story("Поиск аптеки")
public class SearchPharmacy6Test extends Abstract6Test{

@Test
@Description("Выбор аптеки")
@Severity(SeverityLevel.NORMAL)
@Link("https://budzdorov.ru")
@TmsLink("https://github.com/MariaMA0911/WebUI/tree/master/src/test/java/lesson6Test")
    void goToPharmacyPage(){
    MainPage mainPage = new MainPage(getWebDriver());
    mainPage.goToOurPharmacy();

    OurPharmacyPage ourPharmacyPage = new OurPharmacyPage(getWebDriver());
    ourPharmacyPage.inputCity("Коломна");
    ourPharmacyPage.choicePharmacy();
    MyUtils.makeScreenshot(getWebDriver(),
            "SearchPharmacy6Test.goToPharmacyPage" + System.currentTimeMillis() + ".png");
    Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://budzdorov.ru/store/view/50102"));
}
}
