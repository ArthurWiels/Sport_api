package com.example.sport_api.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImportNflService {

    public JsonNode getTeams(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://nfl-api-data.p.rapidapi.com/nfl-team-listing/v1/data")
                .get()
                .addHeader("x-rapidapi-key", "cad6d07075mshacce1234a3860b9p1223acjsn34d2acefb576")
                .addHeader("x-rapidapi-host", "nfl-api-data.p.rapidapi.com")
                .build();

        JsonNode json;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Response response = client.newCall(request).execute();
            json = objectMapper.readTree(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}
