package rozetkapages.element;

import org.openqa.selenium.WebElement;

public class TextInput extends Element {
    public TextInput(WebElement element) {
        super(element);
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        element.clear();
        element.sendKeys(charSequences);
    }
}