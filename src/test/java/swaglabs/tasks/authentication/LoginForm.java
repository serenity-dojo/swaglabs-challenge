package swaglabs.tasks.authentication;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;

class LoginForm {
    static final Target USERNAME = InputField.called("Username");
    static final Target PASSWORD = InputField.called("Password");
    static final Target LOGIN_BUTTON = Button.called("Login");
}
