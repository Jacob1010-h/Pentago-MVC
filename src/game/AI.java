package game;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigInteger;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Map;

public class AI extends Player{
    public AI(int color){
        super(color);
    }

    public Map getPosibleMoves(BigInteger num, boolean blackToMove) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        // http get request to the server
        // if blackToMove is true this means that 'm' should be appended to the end of the url
        // if there is a 'm' this means that the current player will rotate a marble next
        System.out.println("Input: "+"https://us-central1-naml-148801.cloudfunctions.net/pentago/"+num.toString()+(!blackToMove ? "" : "m"));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://us-central1-naml-148801.cloudfunctions.net/pentago/"+num.toString()+(!blackToMove ? "" : "m")))
                .setHeader("Accept-Encoding", "identity")
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .build();

        java.net.http.HttpResponse<String> response = client.send(
                request,
                java.net.http.HttpResponse.BodyHandlers.ofString());
        return parseResponse(response.body());
    }

    private Map parseResponse(String response) throws Exception {
        JsonFactory factory = new JsonFactory();
        factory.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
        ObjectMapper mapper = new ObjectMapper(factory);
        return mapper.readValue(response, Map.class);

    }
}
