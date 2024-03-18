package org.example;

public class Go2Web {

    public static void main(String[] args) {
        // Parse command-line arguments
        CliParameter urlParam = new CliParameter(args, "-u", true);
        CliParameter searchParam = new CliParameter(args, "-s", true);
        CliParameter helpParam = new CliParameter(args, "-h", false);

        // Check which operation to perform
        if (helpParam.isFound()) {
            printHelp();
        } else if (urlParam.isFound()) {
            makeHttpRequest(urlParam.getValue());
        } else if (searchParam.isFound()) {
            searchInSearchEngine(searchParam.getValue());
        } else {
            System.out.println("Invalid command. Use -h for help.");
        }
    }

    // Implement methods for performing HTTP request and search
    // These methods will be implemented using socket programming

    private static void printHelp() {
        System.out.println("go2web -u <URL>         # make an HTTP request to the specified URL and print the response");
        System.out.println("go2web -s <search-term> # make an HTTP request to search the term using your favorite search engine and print top 10 results");
        System.out.println("go2web -h               # show this help");
    }

    private static void makeHttpRequest(String url) {
        // Implement HTTP request using socket programming
    }

    private static void searchInSearchEngine(String searchTerm) {
        // Implement search functionality using socket programming
    }
}
