package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class LoginPage(private val driver: WebDriver): BasePage(driver) {

    @FindBy(id = "com.fredrikbogg.android_chat_app:id/loginButton")
    private lateinit var loginButton: WebElement

    @FindBy(id = "com.fredrikbogg.android_chat_app:id/editTextEmail")
    private lateinit var emailTextField: WebElement

    @FindBy(id = "com.fredrikbogg.android_chat_app:id/editTextPassword")
    private lateinit var passwordTextField: WebElement

    @FindBy(id = "com.fredrikbogg.android_chat_app:id/snackbar_text")
    private lateinit var errorMsgPopup: WebElement

    public fun selectLoginBtn(){
        loginButton.click()
    }

    public fun submitLoginCredentials(email: String, password: String) {
        emailTextField.sendKeys(email)
        passwordTextField.sendKeys(password)
        loginButton.click()
    }

    public fun getErrorMsg(): String? {
        return errorMsgPopup.text
    }

    public fun loginViaValidCredentials() {
        emailTextField.sendKeys("invalidemail@gmail.com")
        passwordTextField.sendKeys("12345678")
        loginButton.click()
    }


}