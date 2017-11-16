package com.fredericboisguerin.insa;

import java.io.IOException;
import java.util.Scanner;


public class UserInterface {
    public UserInterface() throws InvalidEmailException, InvalidContactNameException, IOException {
        Scanner sc = new Scanner(System.in);
        boolean inMenu = true;
        ContactsManager monContactmanager = new ContactsManager();
        opencsv monContactcsv = new opencsv();
        while (inMenu) {
            //System.out.println("--------------------\n 1-Créer un nouveau contact\n 2-Chercher un contact \n 3-Afficher les contacts\n 4-Enregistrement des données \n 5-Recuperation des contacts \n 6-Quitter le menu \n  ---------------------");
            System.out.println("--------------------\n 1-Créer un nouveau contact\n 2-Chercher un contact \n 3-Afficher les contacts\n 4-Enregistrement des données \n 5-Recuperation des contacts \n 6-Modification d'un contact \n 7-Suppression d'un Contact \n 8-Quitter le menu \n  ---------------------");
            System.out.println("Faite votre choix:");
            int choixMenuUser = sc.nextInt();
            switch (choixMenuUser) {
                case 1:
                    System.out.println("Entrez le nouveau nom:");
                    String nomnewContact = sc.next();
                    System.out.println("Entrez le nouveau email:");
                    String emailnewContact = sc.next();
                    System.out.println("Entrez le numéro de téléphone du nouveau contact:");
                    String phonenumbernewContact = sc.next();
                    monContactmanager.addContact(nomnewContact, emailnewContact, phonenumbernewContact);
                    break;

                //chercher contact

                case 2:
                    System.out.println("Entrez le nom du contact à chercher:");
                    String nomAchercher = sc.next();
                    monContactmanager.searchContactByName(nomAchercher);
                    break;
                case 3:
                    monContactmanager.printAllContacts();
                    break;
                case 4:
                    monContactcsv.write_Contacts_in_CSV_File(monContactmanager);
                    break;
                case 5:
                    monContactcsv.read_Contacts_in_CSV_File(monContactmanager);
                    break;
                case 6:
                    System.out.println("Entrez le nom du contact à modifier:");
                    String nomAmodifier = sc.next();
                    System.out.println("Voulez vous modifier tous les champs?\n 1-Si modif nom + email + numéro de tel\n 2- Si modif nom + email\n 3- Si modif email + numéro de tel\n 4- Si modif nom + numéro de tel\n 5- Si modif Nom\n 6- Si modif Email\n 7- Si modif Numero de tel");
                    System.out.println("Faite votre choix:");
                    int choixMenumodif = sc.nextInt();
                    switch (choixMenumodif) {
                        case 1:
                            System.out.println("Entrez le nouveau nom:");
                            String nouveauNomsaisie1 = sc.next();
                            System.out.println("Entrez le nouvel email:");
                            String nouveauEmailsaisie1 = sc.next();
                            System.out.println("Entrez le nouveau  numero de telephone:");
                            String nouveauPhoneNumbersaisie1 = sc.next();
                            monContactmanager.modifyContactByName(nomAmodifier, nouveauNomsaisie1, nouveauEmailsaisie1, nouveauPhoneNumbersaisie1);
                            break;

                        case 2:
                            System.out.println("Entrez le nouveau nom:");
                            String nouveauNomsaisie2 = sc.next();
                            System.out.println("Entrez le nouvel email:");
                            String nouveauEmailsaisie2 = sc.next();
                            monContactmanager.modifyContactByName(nomAmodifier, nouveauNomsaisie2, nouveauEmailsaisie2, "identique");
                            break;


                        case 3:
                            System.out.println("Entrez le nouvel email:");
                            String nouveauEmailsaisie3 = sc.next();
                            System.out.println("Entrez le nouveau  numero de telephone:");
                            String nouveauPhoneNumbersaisie3 = sc.next();
                            monContactmanager.modifyContactByName(nomAmodifier, "identique", nouveauEmailsaisie3, nouveauPhoneNumbersaisie3);
                            break;

                        case 4:
                            System.out.println("Entrez le nouveau nom:");
                            String nouveauNomsaisie4 = sc.next();
                            System.out.println("Entrez le nouveau  numero de telephone:");
                            String nouveauPhoneNumbersaisie4 = sc.next();
                            monContactmanager.modifyContactByName(nomAmodifier, nouveauNomsaisie4, "identique", nouveauPhoneNumbersaisie4);
                            break;
                        case 5:
                            System.out.println("Entrez le nouveau nom:");
                            String nouveauNomsaisie5 = sc.next();
                            monContactmanager.modifyContactByName(nomAmodifier, nouveauNomsaisie5, "identique", "identique");
                            break;

                        case 6:
                            System.out.println("Entrez le nouvel email:");
                            String nouveauEmailsaisie6 = sc.next();
                            monContactmanager.modifyContactByName(nomAmodifier, "identique", nouveauEmailsaisie6, "identique");
                            break;
                    }
                    break;
                case 7:
                    if(monContactmanager.listofcontact.size() > 0) {
                        monContactmanager.printAllContacts();
                        System.out.println("Entrez le numéro correspondant aux contact du contact à supprimer:");
                        int indexnomAsupprimer = sc.nextInt();
                        monContactmanager.removeContactByName(indexnomAsupprimer);
                        System.out.println("Contact supprimé quand vous aurez enregistré!!!");

                    }else{
                        System.out.println("La liste est vide!!!");
                    }
                    break;
                case 8:
                    inMenu = false;
                    System.out.println("Vous avez quitté le menu !!!");
                    break;
            }


        }


    }


    public static void main(String[] args) {
        try {
            UserInterface runUserInterface = new UserInterface();
        } catch (InvalidContactNameException e) {
            System.out.println("--------------\nAttention :" + e.getMessage() + "\n--------------------");
        } catch (InvalidEmailException emailException) {
            System.out.println("--------------\nAttention :" + emailException.getMessage() + "\n---------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}