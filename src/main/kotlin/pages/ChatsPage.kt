package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import kotlin.concurrent.thread


class ChatsPage(private val driver: WebDriver): BasePage(driver) {

    @FindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private lateinit var pageTitle: WebElement

    @FindBy(id = "com.fredrikbogg.android_chat_app:id/displayNameText")
    private lateinit var recipientUser: WebElement

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Settings\"]/android.widget.ImageView")
    private lateinit var settings: WebElement

    public fun verifyUserIsOnChatPage(): Boolean {
        return pageTitle.text=="Chats" && recipientUser.text=="TestUser"
    }

    public fun selectSettings(){
        settings.click()
    }

}