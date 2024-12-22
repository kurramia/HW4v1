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
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.emptyString;

@Feature("Функция управления пользователями")
public class DeleteUserTests {

    @DisplayName("Успешный тест на удаление пользователя")
    @Description("Проверка успешного удаления существующего пользователя.")
    @Test
    public void shouldDeleteUserSuccessfully() {
        int userId = 2;

        given().
                when().
                delete("https://reqres.in/api/users/" + userId).
                then().
                statusCode(204).
                body(is(emptyString()));
    }
}
