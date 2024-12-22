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

@Feature("Функция управления пользователями")
public class DeleteUserErrorTests {

    @DisplayName("Ошибочный тест на удаление пользователя")
    @Description("Проверка, не удастся ли удалить несуществующего пользователя.")
    @Test
    public void shouldFailDeletingNonExistentUser() {
        int userId = 9999;

        given().
                when().
                delete("https://reqres.in/api/users/" + userId).
                then().
                statusCode(404).
                body("error", equalTo("Resource not found"));
    }
}
