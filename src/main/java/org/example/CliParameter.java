package org.example;

class CliParameter {
    private final String name;
    private final boolean withValue;
    private String value;
    private boolean found;

    public CliParameter(String[] args, String name, boolean withValue) {
        this.name = name;
        this.withValue = withValue;
        parseArgs(args);
    }

    private void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(name)) {
                found = true;
                if (withValue && i < args.length - 1 && !args[i + 1].startsWith("-")) {
                    value = args[i + 1];
                }
                break;
            }
        }
    }

    public boolean isFound() {
        return found;
    }

    public String getValue() {
        return value;
    }
}
