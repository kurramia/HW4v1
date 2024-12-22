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
import static org.hamcrest.Matchers.*;

@Feature("Регистрация пользователей")
public class RegisterTests {
    @DisplayName("Успешный регистрационный тест")
    @Description("Проверка регистрации нового пользователя")
    @Test
    public void shouldRegisterUserSuccessfully() {
        String email = "eve.holt@reqres.in";
        String password = "pistol";

        given().
                contentType(ContentType.JSON).
                body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}").
                when().
                post("https://reqres.in/api/register").
                then().
                statusCode(200).
                body("$", hasKey("token"));
    }
}
