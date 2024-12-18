class Print {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    static void red(Object text) {
        System.out.print(ANSI_RED + text + ANSI_RESET);
    }
    
    static void green(Object text) {
        System.out.print(ANSI_GREEN + text + ANSI_RESET);
    }

    static void redln(Object text) {
        System.out.println(ANSI_RED + text + ANSI_RESET);
    }
    
    static void greenln(Object text) {
        System.out.println(ANSI_GREEN + text + ANSI_RESET);
    }
    public static void main(String[] args) {
        Print.red("RED");
        System.out.println();
        Print.green("GREEN");
        System.out.println();
    }
}

