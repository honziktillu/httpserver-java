package com.spsmb.server;

import com.spsmb.server.routes.About;
import com.spsmb.server.routes.Article;
import com.spsmb.server.routes.Index;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {

    private int port;
    private HttpServer httpServer;

    public Server(int port) {
        this.port = port;
    }

    public void run() throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(port), 0);
        httpServer.createContext("/", new Index());
        httpServer.createContext("/about", new About());
        httpServer.createContext("/article", new Article());
        httpServer.start();
        System.out.println("Server is running on " + port);
    }


}
