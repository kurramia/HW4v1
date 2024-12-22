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
public class GetUserErrorTests {

    @DisplayName("Ошибочный тест поиска несуществующего пользователя")
    @Description("Проверка, удастся ли найти несуществующего пользователя.")
    @Test
    public void shouldFailGettingNonExistentUser() {
        int userId = 9999;

        given().
                when().
                get("https://reqres.in/api/users/" + userId).
                then().
                statusCode(404).
                body("error", equalTo("Resource not found"));
    }
}