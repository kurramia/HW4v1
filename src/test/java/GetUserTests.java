import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;

@Feature("Функция поиска пользователей")
public class GetUserTests {

    @DisplayName("Успешный тест поиска пользователя")
    @Description("Проверка получения данных существующего пользователя")
    @Test
    public void shouldGetUserDetailsSuccessfully() {
        int userId = 2;

        given().
                when().
                get("https://reqres.in/api/users/" + userId).
                then().
                statusCode(200).
                body("data.id", equalTo(userId));
    }
}