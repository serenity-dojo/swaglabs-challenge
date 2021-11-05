package swaglabs.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.SoftlyEnsure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.ui.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import swaglabs.model.Swagger;
import swaglabs.tasks.authentication.Login;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class LoginStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @ParameterType(".*")
    public Actor actor(String name) {
        return OnStage.theActorCalled(name);
    }

    @Given("{actor} is a registered user")
    public void is_a_registered_user(Actor actor) {

        actor.attemptsTo(
                Open.url("https://www.saucedemo.com/inventory.html")
        );
    }

    @When("{actor} logs in using valid credentials")
    public void logs_in_using_valid_credentials(Actor actor) {
        Swagger swaggerUser = Swagger.valueOf(actor.getName());
        actor.attemptsTo(Login.as(swaggerUser));
    }

    @Then("{actor} should be presented with the catalog")
    public void should_be_presented_with_the_catalog(Actor actor) {
        actor.attemptsTo(
                Ensure.that(PageElement.called("inventory_list")).isDisplayed()
        );
    }
}
