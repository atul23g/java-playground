class User {

    private Integer id;
    private String name;
    private String email;
    private Organization organization;
    private boolean active;

    public Integer getId() {
    return id;
   }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public Organization getOrganization(){
        return organization;
    }

    public boolean isActive(){
        return active;
    }




    User(Integer id, String name, String email, Organization organization, boolean active ){
        if(id == null || id <=0 ||name == null || name.isBlank()){
            throw new IllegalArgumentException("ID cannot be null and name cannot be blank");
        }
        if(email == null || !email.contains("@")){
            throw new IllegalArgumentException("email can't be accepted");
        }

        if(organization == null){
            throw new IllegalArgumentException("organization can't be accepted");
        }




        this.id = id;
        this.name = name;

        this.email = email;

        this.organization = organization;
        this.active = active;

    }

    
}

