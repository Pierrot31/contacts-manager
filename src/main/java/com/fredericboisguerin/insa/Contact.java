package com.fredericboisguerin.insa;

public class Contact {
    String name;
    String email;
    String phoneNumber;
    String chaine_retour;

    /**
     * @param name
     * @param email
     * @param phoneNumber
     */
    public Contact(String name,String email, String phoneNumber){
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        if (this.email == null && this.phoneNumber != null) {
            chaine_retour =  this.name + ", " + this.phoneNumber;
        }
        if (this.email != null && this.phoneNumber == null) {
            chaine_retour =  this.name + ", " + this.email;
        }
        if (this.email == null && this.phoneNumber == null) {
            chaine_retour =  this.name;
        }
        if (this.email != null && this.phoneNumber != null) {
            chaine_retour =  this.name + ", " + this.email + ", " + this.phoneNumber;
        }
        return chaine_retour;
    }

    public void modifyName(String name){
        this.name = name;
    }
    public void modifyemail(String email){
        this.email = email;
    }
    public void modifyPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

}
