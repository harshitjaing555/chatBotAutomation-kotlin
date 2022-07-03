package tests

import projectCapabilities.ProjectCaps
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import org.junit.After
import org.junit.Before

import org.openqa.selenium.remote.DesiredCapabilities
import pages.ChatsPage
import pages.LoginPage
import pages.SettingsPage
import pages.UsersTab
import java.net.URL
import java.util.concurrent.TimeUnit

open class BaseTest {

    lateinit var loginPage: LoginPage
    lateinit var chatsPage: ChatsPage
    lateinit var settingsPage: SettingsPage
    lateinit var usersTab: UsersTab

    private lateinit var driver: AndroidDriver<AndroidElement>
    protected open var caps: DesiredCapabilities? = ProjectCaps.AndroidBaseCapabilities()
    private val webDriverURL: URL = URL("http://127.0.0.1:4723/wd/hub")

    // This happens before each test
    @Before
    fun setup() {
        driver = AndroidDriver<AndroidElement>(webDriverURL, caps)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = LoginPage(driver)
        chatsPage = ChatsPage(driver)
        settingsPage = SettingsPage(driver)
        usersTab = UsersTab(driver)
    }

    // This happens after each test
    @After
    fun teardown() {
        // Close after each test
        driver.closeApp()
    }

}