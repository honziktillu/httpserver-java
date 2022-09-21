package com.spsmb.server.routes;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;

public class Article implements HttpHandler {
    @Override
    public void handle(HttpExchange e) throws IOException {
        switch (e.getRequestMethod().toUpperCase()) {
            case "GET" -> getHandler(e);
            case "POST" -> postHandler(e);
            case "PUT" -> putHandler(e);
            case "PATCH" -> patchHandler(e);
            case "DELETE" -> deleteHandler(e);
            default -> {
                String r = "Server error";
                e.sendResponseHeaders(501, r.getBytes().length);
                OutputStream os = e.getResponseBody();
                os.write(r.getBytes());
                os.close();
            }
        }
    }

    private String readRequestBody(InputStream i) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(i));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    private void getHandler(HttpExchange e) throws IOException {
        System.out.println(e.getRequestURI().getPath());
        String nameOfArticle = e.getRequestURI().getPath().split("/")[2];
        //Regex
        //Db query
        String r = "GET /article/" + nameOfArticle;
        e.sendResponseHeaders(200, r.getBytes().length);
        OutputStream os = e.getResponseBody();
        os.write(r.getBytes());
        os.close();
    }

    private void postHandler(HttpExchange e) throws IOException {
        String convertedData = readRequestBody(e.getRequestBody());
        String r = "POST /article\nPayload: " + convertedData;
        e.sendResponseHeaders(201, r.getBytes().length);
        OutputStream os = e.getResponseBody();
        os.write(r.getBytes());
        os.close();
    }

    private void putHandler(HttpExchange e) throws IOException {
        String convertedData = readRequestBody(e.getRequestBody());
        String r = "PUT /article\nPayload: " + convertedData;
        e.sendResponseHeaders(200, r.getBytes().length);
        OutputStream os = e.getResponseBody();
        os.write(r.getBytes());
        os.close();
    }

    private void patchHandler(HttpExchange e) throws IOException {
        String convertedData = readRequestBody(e.getRequestBody());
        String r = "PATCH /article\nPayload: " + convertedData;
        e.sendResponseHeaders(200, r.getBytes().length);
        OutputStream os = e.getResponseBody();
        os.write(r.getBytes());
        os.close();
    }

    private void deleteHandler(HttpExchange e) throws IOException {
        String convertedData = readRequestBody(e.getRequestBody());
        String r = "DELETE /article\nPayload: " + convertedData;
        e.sendResponseHeaders(200, r.getBytes().length);
        OutputStream os = e.getResponseBody();
        os.write(r.getBytes());
        os.close();
    }
}
