class User {
    private String name;
    private String email;
    private Organization organization;

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public Organization getOrganization(){
        return organization;
    }




    User(String name, String email, Organization organization){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name can't be Empty");
        }
        if(email == null || !email.contains("@")){
            throw new IllegalArgumentException("email can't be accepted");
        }

        if(organization == null){
            throw new IllegalArgumentException("organization can't be accepted");
        }





        this.name = name;

        this.email = email;

        this.organization = organization;

    }
}

