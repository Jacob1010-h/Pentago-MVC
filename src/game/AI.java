package game;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.*;
import java.io.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class AI extends Player{
    public AI(int color){
        super(color);
    }

    public Map getPosibleMoves(Trinary num) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(
                        new URI("https://us-central1-naml-148801.cloudfunctions.net/pentago/"+num.toTrinary()))
                .GET()
                .build();
        java.net.http.HttpResponse<String> response = client.send(
                request,
                java.net.http.HttpResponse.BodyHandlers.ofString());
        return parseResponse(response.body());
    }

    private Map parseResponse(String response) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, Map.class);
    }
}
