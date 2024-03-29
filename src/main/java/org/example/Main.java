package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        CliParameter urlParam = new CliParameter(args, "-u", true);
        CliParameter searchParam = new CliParameter(args, "-s", true);
        CliParameter helpParam = new CliParameter(args, "-h", false);

        if (helpParam.isFound()) {
            printHelp();
        } else if (urlParam.isFound()) {
            makeHttpRequest(urlParam.getValue());
        } else if (searchParam.isFound()) {
            searchInSearchEngine(searchParam.getValue());
        }
    }

    private static void printHelp() {
        System.out.println("go2web -u <URL>         # make an HTTP request to the specified URL and print the response");
        System.out.println("go2web -s <search-term> # make an HTTP request to search the term using your favorite search engine and print top 10 results");
        System.out.println("go2web -h               # show this help");
    }

    private static void makeHttpRequest(String url) {
        try {
            Socket socket = new Socket("example.com", 80);
            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.write("GET " + url + " HTTP/1.1\r\n");
            out.write("Host: example.com\r\n");
            out.write("\r\n");
            out.flush();

            String response;
            while ((response = in.readLine()) != null) {
                System.out.println(response);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void searchInSearchEngine(String searchTerm) {
        // Implement search functionality
        System.out.println("Search functionality not implemented yet.");
    }
}

