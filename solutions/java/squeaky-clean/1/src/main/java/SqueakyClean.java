class SqueakyClean {
    static String clean(String identifier) {
        String newString = "";
        boolean toCamel = false;
        identifier = identifier.replaceAll("\\p{Cntrl}", "CTRL").replaceAll("[α-ω]","");
        for (int i = 0; i < identifier.length(); i++) {
            if (identifier.charAt(i) == ' ') {
                newString += "_";
            } else if (identifier.charAt(i) == '-') {
                toCamel = true;
            } else if (Character.isAlphabetic(identifier.charAt(i))) {
                if (toCamel) {
                    newString += Character.toUpperCase(identifier.charAt(i));
                    toCamel = false;
                } else {
                    newString += identifier.charAt(i);
                }
            }
        }
        return newString;
    }
}
