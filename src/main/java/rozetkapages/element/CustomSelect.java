package rozetkapages.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomSelect extends Element{
    public CustomSelect(WebElement element) {
        super(element);
    }

    public void selectByVisibleText(String sortingType){
        Select sortingTypeDropdown = new Select(element);
        sortingTypeDropdown.selectByVisibleText(sortingType);
    }
}
