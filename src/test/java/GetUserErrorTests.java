import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@Feature("Функция поиска пользователей")
public class GetUserErrorTests {

    @DisplayName("Ошибочный тест поиска несуществующего пользователя")
    @Description("Проверка, удастся ли найти несуществующего пользователя.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void shouldFailGettingNonExistentUser() {
        int userId = 9999;

        given()
                .when()
                .get("https://reqres.in/api/users/" + userId)
                .then()
                .statusCode(404)
                .assertThat()
                .body("error", equalTo("Resource not found"));
    }
}