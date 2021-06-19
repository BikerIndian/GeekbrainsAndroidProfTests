package net.svishch.github.automator

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import com.geekbrains.tests.TEST_NUMBER_OF_RESULTS_MINUS_1
import com.geekbrains.tests.TEST_NUMBER_OF_RESULTS_PLUS_1
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
class DetailsScreenTest {
    private val uiDevice: UiDevice =
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val packageName = context.packageName
    private lateinit  var changedTextDetails :  UiObject2

    @Before
    fun setup() {

        //сворачиваем все приложения
        uiDevice.pressHome()

        //Запускаем наше приложение
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)

        //Чистим бэкстек от запущенных Активити
        intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)

        //Ждем, когда приложение откроется
        uiDevice.wait(Until.hasObject(By.pkg(packageName).depth(0)), TIMEOUT)
        toActivityDetails()
    }

    private fun toActivityDetails() {
        // Кнопка перехода на Details
        val toDetails: UiObject2 = getObjectId("toDetailsActivityButton")

        // Переходим на Details
        toDetails.click()

        //Ожидаем конкретного события: появления текстового поля totalCountTextView_details.
        //Это будет означать, что DetailsScreen открылся и это поле видно на экране.
        changedTextDetails =
            uiDevice.wait(
                Until.findObject(By.res(packageName, "totalCountTextView_details")),
                TIMEOUT
            )
    }

    @Test
    fun activityButtonIncrement() {
        // Кнопка increment
        val btnIncrement = getObjectId("incrementButton")
        btnIncrement.click()
        Assert.assertEquals(changedTextDetails.text.toString(), TEST_NUMBER_OF_RESULTS_PLUS_1)

    }

    @Test
    fun activityButtonDecrement() {
        // Кнопка decrement
        val btnDecrement =  getObjectId("decrementButton")
        btnDecrement.click()
        Assert.assertEquals(changedTextDetails.text.toString(), TEST_NUMBER_OF_RESULTS_MINUS_1)

    }


    fun getObjectId(btnId : String) : UiObject2 {
    return    uiDevice.findObject(By.res(packageName, btnId))
    }


    companion object {
        private const val TIMEOUT = 5000L
    }
}