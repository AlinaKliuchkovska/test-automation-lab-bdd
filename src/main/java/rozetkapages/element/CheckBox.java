package rozetkapages.element;

import org.openqa.selenium.WebElement;

public class CheckBox extends Element {
    public CheckBox(WebElement element) {
        super(element);
    }

    public void setChecked(boolean shouldBeChecked) {
        if ((element.isSelected() && !shouldBeChecked) || (!element.isSelected() && shouldBeChecked)) {
           element.click();
        }
    }
}