import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;

@Feature("Регистрация пользователей")
public class RegisterErrorTests {

    @DisplayName("Неудачная регистрация без проверки пароля")
    @Description("Проверка, удастся ли зарегистрироваться без ввода пароля")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void shouldFailRegistrationWithoutPassword() {
        String email = "eve.holt@reqres.in";

        given().
                contentType(ContentType.JSON).
                body("{\"email\": \"" + email + "\"}").
                when().
                post("https://reqres.in/api/register").
                then().
                statusCode(400).
                body("error", equalTo("Missing password"));
    }
}
