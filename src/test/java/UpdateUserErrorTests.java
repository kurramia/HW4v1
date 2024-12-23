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
public class UpdateUserErrorTests {

    @DisplayName("Ошибка в обновлении пользователя")
    @Description("Проверка ошибки обновления несуществующего пользователя")

    @Test
    public void shouldFailUpdatingNonExistentUser() {
        int userId = 9999;
        String name = "morpheus";
        String job = "zion resident";

        given().
                contentType(ContentType.JSON).
                body("{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}").
                when().
                put("https://reqres.in/api/users/" + userId).
                then().
                statusCode(404).
                body("error", equalTo("Resource not found"));
    }
}