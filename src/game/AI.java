package game;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigInteger;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Map;
import java.util.Optional;

import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS;

public class AI extends Player{
    public AI(int color){
        super(color);
    }

    public Map getPosibleMoves(BigInteger num, boolean blackToMove) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        // http get request to the server
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
