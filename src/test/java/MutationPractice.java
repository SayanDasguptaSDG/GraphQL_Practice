import static io.restassured.RestAssured.given;

public class MutationPractice {
    public static void main(String[] args) {
        String response = given().log().all().header("Content-Type", "application/json")
                .body("{\"query\":\"mutation {\\n    createLocation(location: {\\n        name: \\\"Aachen\\\",\\n        type: \\\"West\\\",\\n        dimension: \\\"143\\\"\\n    }) {\\n        id\\n    }\\n    createCharacter(character: {\\n        name: \\\"Melody\\\",\\n        type: \\\"Macho\\\",\\n        status: \\\"alive\\\",\\n        species: \\\"human\\\",\\n        gender: \\\"male\\\",\\n        image: \\\"jpeg\\\",\\n        originId: 112,\\n        locationId: 13145\\n    }) {\\n        id\\n    }\\n    createEpisode(episode: {\\n        name: \\\"Funny Man\\\",\\n        air_date: \\\"1999-08-09\\\",\\n        episode: \\\"1\\\"\\n    }) {\\n        id\\n    }\\n    deleteLocations(locationIds: [13139]) {\\n        locationsDeleted\\n    }\\n}\",\"variables\":null}")
                .when().post("https://rahulshettyacademy.com/gq/graphql")
                .then().extract().response().asString();
        System.out.println(response);
    }
}
