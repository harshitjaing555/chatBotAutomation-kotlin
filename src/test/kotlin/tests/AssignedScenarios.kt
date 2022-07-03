package tests

import org.junit.Assert
import org.junit.Test

class AssignedScenarios: BaseTest() {
    //override var caps: DesiredCapabilities? = ProjectCaps.AndroidBaseCapabilities()

    // Scenario 1
    @Test
    fun loginViaInvalidCredentialsTest(){
        loginPage.selectLoginBtn()
        loginPage.submitLoginCredentials("invalidemail@gmail.com","12345678")
        Assert.assertEquals("There is no user record corresponding to this identifier. The user may have been deleted.",
                loginPage.getErrorMsg())
    }

    @Test
    fun testCase_2_3_4(){
        loginPage.selectLoginBtn()
        loginViaValidCredentials()
        changeStatusSuccessfully()
        verifyUsersTabScreen()
    }

    // Scenario 2
    private fun loginViaValidCredentials(){
        loginPage.submitLoginCredentials("karolina.sitnik@hl.co.uk","testtest")
        Assert.assertTrue(chatsPage.verifyUserIsOnChatPage())
    }

    // Scenario 3
    private fun changeStatusSuccessfully(){
        chatsPage.selectSettings()
        Assert.assertTrue(settingsPage.verifyButtonsAreEnabled())
        settingsPage.selectChangeStatus()
        settingsPage.verifyStatusAlertFields()
        Assert.assertTrue(settingsPage.changeStatus("test2"))
    }

    // Scenario 4
    private fun verifyUsersTabScreen(){
        settingsPage.selectUsersTab()
        usersTab.verifyTotalTestUserAreTwo()
        usersTab.selectSecondTestUser()
        Assert.assertTrue(usersTab.verifyRequestSentBtnIsDisabled())
    }
}
