class Badge {

    private int id;
    private String name;
    private String department;
    
    public String print(Integer id, String name, String department) {
        if (id != null && department != null) {
            return String.format("[%d] - %s - %s", id, name, department.toUpperCase());
        } else if (id == null && department != null) {
            return String.format("%s - %s", name, department.toUpperCase());
        } else if (id != null && department == null) {
            return String.format("[%d] - %s - OWNER", id, name);
        } else {
            return String.format("%s - OWNER", name);
        }
    }
}
