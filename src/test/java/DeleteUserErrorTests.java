import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Feature("Функция управления пользователями")
public class DeleteUserErrorTests {

    @DisplayName("Ошибочный тест на удаление пользователя")
    @Description("Проверка, не удастся ли удалить несуществующего пользователя.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void shouldFailDeletingNonExistentUser() {
        int userId = 9999;
        RestAssured.defaultParser = Parser.JSON;
        given()
                .when()
                .delete("https://reqres.in/api/users/" + userId)
                .then()
                .statusCode(404)
                .assertThat()
                .body("error", equalTo("No Content"));
    }
}
