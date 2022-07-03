package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import javax.swing.JFormattedTextField

class SettingsPage(private val driver: WebDriver): BasePage(driver) {



    @FindBy(id = "com.fredrikbogg.android_chat_app:id/statusText")
    private lateinit var status: WebElement

    @FindBy(id = "com.fredrikbogg.android_chat_app:id/changeImageButton")
    private lateinit var changeImage: WebElement

    @FindBy(id = "com.fredrikbogg.android_chat_app:id/changeStatusButton")
    private lateinit var changeStatus: WebElement

    @FindBy(id = "com.fredrikbogg.android_chat_app:id/logoutButton")
    private lateinit var logoutButton: WebElement

    @FindBy(id = "com.fredrikbogg.android_chat_app:id/alertTitle")
    private lateinit var changeStatusAlertTitle: WebElement

    @FindBy(className = "android.widget.EditText")
    private lateinit var changeStatusTextfield: WebElement

    @FindBy(id = "android:id/button2")
    private lateinit var cancelBtn: WebElement

    @FindBy(id = "android:id/button1")
    private lateinit var okBtn: WebElement

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Users\"]/android.widget.ImageView")
    private lateinit var usersTab: WebElement

    public fun verifyButtonsAreEnabled(): Boolean {
        return changeStatus.isEnabled && changeImage.isEnabled && logoutButton.isEnabled
    }

    public fun selectChangeStatus(){
        changeStatus.click()
    }

    public fun verifyStatusAlertFields(): Boolean{
        return changeStatusAlertTitle.text=="Status:" && changeStatusTextfield.isDisplayed
                && cancelBtn.isDisplayed && okBtn.isDisplayed
    }

    public fun changeStatus(text: String): Boolean {
        changeStatusTextfield.sendKeys(text)
        okBtn.click()
        return verifyStatusIsChanged(text)
    }

    fun verifyStatusIsChanged(text: String): Boolean {
        return status.text=="test2"
    }

    public fun selectUsersTab(){
        usersTab.click()
    }

}