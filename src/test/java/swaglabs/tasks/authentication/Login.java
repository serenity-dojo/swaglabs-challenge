package swaglabs.tasks.authentication;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import swaglabs.model.Swagger;

public class Login {
    public static Performable as(Swagger swaggerUser) {
        return Task.where("{0} logs on with username " + swaggerUser.getUsername() + " and password " + swaggerUser.getPassword(),
                Enter.theValue(swaggerUser.getUsername()).into(LoginForm.USERNAME),
                Enter.theValue(swaggerUser.getPassword()).into(LoginForm.PASSWORD),
                Click.on(LoginForm.LOGIN_BUTTON)
        );
    }
}
