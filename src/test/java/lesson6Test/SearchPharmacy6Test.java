package lesson6Test;

import lesson6.MainPage;
import lesson6.OurPharmacyPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchPharmacy6Test extends Abstract6Test{

@Test
    void goToPharmacyPage(){
    MainPage mainPage = new MainPage(getWebDriver());
    mainPage.goToOurPharmacy();

    OurPharmacyPage ourPharmacyPage = new OurPharmacyPage(getWebDriver());
    ourPharmacyPage.inputCity("Коломна");
    ourPharmacyPage.choicePharmacy();

    Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://budzdorov.ru/store/view/50102"));
}
}
