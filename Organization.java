class Organization{
    private String name;

    public String getName(){
        return name;
    }

    Organization(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name can't be null");
        }
        this.name = name;
    }

}