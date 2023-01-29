package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyCarsListScreen extends BaseScreen{
    public MyCarsListScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@text='My Cars']")
    MobileElement titlePage;
    @FindBy(id = "com.telran.ilcarro:id/LinearLayout")
    List<MobileElement> cars;
    @FindBy (xpath = "//*[@text='YES']")
    MobileElement yesButton;

    public MyCarsListScreen removeCar() {
        should(titlePage,5);
        MobileElement car = cars.get(0);
        Rectangle rect = car.getRect();

        int xFrom= rect.getX()+rect.getWidth()/10;
        int xTo = rect.getX()+(rect.getWidth()/10)*8;
        int y=rect.getY()+rect.getHeight()/2;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,y))
                .moveTo(PointOption.point(xTo,y))
                .release()
                .perform();
        should(yesButton,5);
        yesButton.click();

        Dimension size = driver.manage().window().getSize();
        System.out.println("Width ---" +  size.getWidth());
        System.out.println("Height ---" + size.getHeight());

        return this;
    }

}
