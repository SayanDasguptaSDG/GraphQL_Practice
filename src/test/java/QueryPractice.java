import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class QueryPractice {
    public static void main(String[] args) {
        String response = given().log().all().header("Content-Type", "application/json")
                .body("{\"query\":\"query($characterId: Int!, $locationId: Int!, $episodeId: Int!) {\\n    character(characterId: $characterId) {\\n        name\\n        gender\\n        status\\n        id\\n    }\\n    location(locationId: $locationId) {\\n        name\\n        dimension\\n    }\\n    episode(episodeId: $episodeId) {\\n        name\\n        air_date\\n        episode\\n    }\\n    episodes(filters: {\\n        name: \\\"Funny Man\\\"\\n    }) {\\n        result {\\n            id\\n            name\\n            air_date\\n            episode\\n        }\\n    }\\n}\",\"variables\":{\"characterId\":8680,\"episodeId\":10094,\"locationId\":13145}}")
                .when().post("https://rahulshettyacademy.com/gq/graphql")
                .then().extract().response().asString();
        System.out.println(response);

        JsonPath js = new JsonPath(response);
        String characterName = js.getString("data.character.name");
        Assert.assertEquals(characterName, "Melody");
    }
}
