package com.jeff.pokemon.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpHelper {
    //TODO criar technical exception
    public HttpResponse<String> doGet(String url) throws Exception{
        var request = HttpRequest.newBuilder(new URI(url)).GET().build();
        return HttpClient.newBuilder().build().send(request, BodyHandlers.ofString());
    }
}
