package api.streamApi;

import org.junit.jupiter.api.Test;
import pojoClases.TicketsShort;

import java.util.*;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class StreamApiExamplesTests extends TestStreamApiConfig {

    public List<TickerItem> getTickers() {
        return given()
                .when()
                .get("/market/allTickers")
                .then()
                .log().all()
                .extract().jsonPath().getList("data.ticker", TickerItem.class);
    }



    @Test
    public void checkCripto() {
        List<TickerItem> usdt = getTickers().stream()
                .filter(v -> v.getSymbol().contains("USDT"))
                .collect(Collectors.toList());

        int a = 9;
    }

    @Test
    public void checkCriptoSort() {
        Comparator<TickerItem> comp = (v1, v2) -> v2.getChangeRate().compareTo(v1.getChangeRate());

        List<TickerItem> usdt = getTickers().stream()
                .filter(v -> v.getSymbol().contains("USDT"))
                .sorted(comp).collect(Collectors.toList());


        int a = 9;
    }

    @Test
    public void testMap() {
        Map<String, Float> floatMap = new HashMap<>();
        List<String> lowerCases = getTickers().stream().map(x -> x.getSymbol().toLowerCase())
                .collect(Collectors.toList());
        // наполнение мапы с помощью foreach
        getTickers().forEach(x -> floatMap.put(x.getSymbol(), Float.parseFloat(x.getChangeRate())));

        // создаю класс и наполняю list с помощью него
        List<TicketsShort> ticketsShorts = new ArrayList<>();
         getTickers().forEach(x -> ticketsShorts.add(new TicketsShort(x.getSymbol(), Float.parseFloat(x.getChangeRate()))));
        System.out.println(ticketsShorts);

        int a = 9;

    }
}
