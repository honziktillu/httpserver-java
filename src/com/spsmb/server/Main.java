package com.spsmb.server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Server server = new Server(3000);
            server.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}