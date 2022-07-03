package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory

open class BasePage(private val driver: WebDriver) {

    init {
        // Initialize all lateinit @FindBy elements
        initElements()
    }

    /**
     * Use in constructor to initialize @FindBy elements.
     * Optionally, timeout can be passed to override default.
     */
    private fun initElements(timeoutInSeconds: Int = 5) {
        PageFactory.initElements(AjaxElementLocatorFactory(driver, timeoutInSeconds), this)
    }


}