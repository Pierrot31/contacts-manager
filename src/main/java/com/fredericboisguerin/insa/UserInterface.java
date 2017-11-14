package com.fredericboisguerin.insa;

import java.io.IOException;
import java.util.Scanner;


public class UserInterface {
    public UserInterface() throws InvalidEmailException, InvalidContactNameException,  IOException  {
        Scanner sc = new Scanner(System.in);
        boolean inMenu = true;
        ContactsManager monContact = new ContactsManager();
        opencsv monContactcsv = new opencsv();
        while (inMenu) {
            System.out.println("--------------------\n 1-Créer un nouveau contact\n 2-Chercher un contact \n 3-Afficher les contact\n 4-Enregistrement des données \n 5-Recuperation des contacts \n 6-Quitter le menu \n  ---------------------");
            System.out.println("Faites votre choix:");
            int choixMenuUser = sc.nextInt();
            switch (choixMenuUser) {
                //créer contect
                case 1:
                    System.out.println("Entrez le nom du nouveau contact:");
                    String nomnewContact = sc.next();
                    System.out.println("Entrez l'email du nouveau contact:");
                    String emailnewContact = sc.next();
                    System.out.println("Entrez le numéro de téléphone du nouveau contact:");
                    String phonenumbernewContact = sc.next();
                    monContact.addContact(nomnewContact, emailnewContact, phonenumbernewContact);
                    break;

                //chercher contact
                case 2:
                    System.out.println("Entrez le nom du contact recherché:");
                    String nomACherche = sc.next();
                    monContact.searchContactByName(nomACherche);
                    break;

                //afficher liste
                case 3:
                    monContact.printAllContacts();
                    break;
                case 4:
                    System.out.println("Données enregistrées  !!!");
                    monContactcsv.write_Contacts_in_CSV_File(monContact);
                    break;
                case 5:
                    System.out.println("Données extraites du fichier  !!!");
                    monContactcsv.read_Contacts_in_CSV_File(monContact);
                    break;

                case 6:
                    inMenu = false;
                    System.out.println("Vous avez quitté le menu !!!");
                    break;
                //default

                default:
                    System.out.println("Attention : Votre choix n'appartient pas au menu !!!");
                    break;

            }

        }

    }

    public static void main(String[] args) {
        try {
            UserInterface runUserInterface = new UserInterface();
        } catch (InvalidContactNameException nameException) {
            System.out.println(nameException.getMessage());
        } catch (InvalidEmailException emailException) {
            System.out.println(emailException.getMessage());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
