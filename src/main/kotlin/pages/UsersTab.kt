package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindAll
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.FindBys

class UsersTab(private val driver: WebDriver): BasePage(driver) {

    @FindBy(xpath = "//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
    private lateinit var testUsers: List<WebElement>

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
    private lateinit var secondTestUser: WebElement

    @FindBy(id = "com.fredrikbogg.android_chat_app:id/requestSentButton")
    private lateinit var requestSentBtn: WebElement

    public fun verifyTotalTestUserAreTwo(): Boolean {
        // Added this findElements due to an open issue i.e. List element annotation unsupported for kotlin: https://github.com/appium/java-client/issues/1257
        return driver.findElements(By.xpath("//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")).size==2
    }

    public fun selectSecondTestUser(){
        secondTestUser.click()
    }

    public fun verifyRequestSentBtnIsDisabled(): Boolean{
        return requestSentBtn.isDisplayed
    }
}