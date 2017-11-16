package com.fredericboisguerin.insa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ContactsManager {

    public ArrayList<Contact> listofcontact;

    public ContactsManager() {
        listofcontact = new ArrayList<Contact>();
    }

    public void addContact(String name, String email, String phoneNumber) throws InvalidContactNameException, InvalidEmailException, IOException {
        if (name == null) {
            throw new InvalidContactNameException("le contact n'a pas de nom!!!");
        }
        if (name == "") {
            throw new InvalidContactNameException("l'espace vide n'est pas un nom");
        }
        if (email != null) {
            String verifemail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}$";
            Pattern pattern = Pattern.compile(verifemail);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                throw new InvalidEmailException("Error format email!!!");
            }
        }
        Contact newcontact = new Contact(name, email, phoneNumber);

        if (listofcontact.isEmpty()) {
            listofcontact.add(0, newcontact);

        } else {
            listofcontact.add(newcontact);
        }
    }

    public void printAllContacts() {
        if (listofcontact.isEmpty()) {
            System.out.println("la liste des contacts est vide!!!!");
        } else {
            for (Contact affichage : listofcontact) {
                System.out.println(affichage.toString());
            }
        }
    }

    public void searchContactByName(String name) {
        boolean vraiSiTrouveAuMoinsUnContact = false;

        for (Contact courant : listofcontact) {
            String nomAcompare = courant.name;
            nomAcompare = nomAcompare.toLowerCase();
            if (nomAcompare.contains(name)) {
                System.out.println(courant.toString());
                vraiSiTrouveAuMoinsUnContact = true;
            }
        }
        if (!vraiSiTrouveAuMoinsUnContact) {
            System.out.println("Aucun contact trouvé");
        }

    }
    public void removeContactByName(int index){
        this.listofcontact.remove(index);
    }
    public void modifyContactByName(String name, String newName, String newEmail, String newPhoneNumber) throws InvalidContactNameException, InvalidEmailException {
        boolean vraiSiTrouveAuMoinsUnContact =  false;
        for( Contact courant : this.listofcontact){
            String nomAcompare = courant.modifyName();
            nomAcompare = nomAcompare.toLowerCase();
             if( nomAcompare.contains(name)){
               if(newName =="identique"){
                   newName = courant.modifyName();
                 }
                if(newEmail=="identique"){
                  newEmail = courant.modifyemail();
                }
                if(newPhoneNumber == "identique"){
                   newPhoneNumber = courant.modifyPhoneNumber();
                }
                if (newEmail == null) {
                     throw new InvalidContactNameException("Le champ nom est null!!!");
                }
                if (newEmail == "") {
                  throw new InvalidContactNameException("Le champ nom est vide!!!");
                }
               if (null != newEmail) {
                   String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(newEmail);
                   if (!matcher.matches()) {
                       throw new InvalidEmailException("Email not valid!!!");
                  }
                }
               System.out.println(courant.toString());
               courant.modifyContact(newName, newEmail, newPhoneNumber);
               vraiSiTrouveAuMoinsUnContact = true;
            }
        }
        if(!vraiSiTrouveAuMoinsUnContact){
             System.out.println("Le contact que vous voulez modifier n'existe pas!!!");
        }
    }

}


