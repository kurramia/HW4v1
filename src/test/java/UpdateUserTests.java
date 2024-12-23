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
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

@Feature("Регистрация пользователей")
public class UpdateUserTests {

    @DisplayName("Успешный тест обновления пользователя")
    @Description("Проверка успешного обновления существующего пользователя")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void shouldUpdateUserSuccessfully() {
        int userId = 2;
        String name = "morpheus";
        String job = "zion resident";

        given().
                contentType(ContentType.JSON).
                body("{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}").
                when().
                put("https://reqres.in/api/users/" + userId).
                then().
                statusCode(200).
                body("$", hasKey("updatedAt"));
    }
}
