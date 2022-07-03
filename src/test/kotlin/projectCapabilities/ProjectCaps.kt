package projectCapabilities

import org.openqa.selenium.remote.DesiredCapabilities

class ProjectCaps {
    companion object {
        fun AndroidBaseCapabilities(): DesiredCapabilities {
            val caps = DesiredCapabilities()
            caps.setCapability("platformName", "Android")
            caps.setCapability("platformVersion", "12")
            caps.setCapability("automationName", "UiAutomator2")
            caps.setCapability("deviceName", "Pixel 5")
            caps.setCapability("app", "/Users/harshitjain/Desktop/chatBot-TestAutomation/project-apk/chatBot.apk")
            caps.setCapability("udid", "emulator-5554")
            return caps
        }
    }
}