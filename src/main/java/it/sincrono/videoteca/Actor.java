package it.sincrono.videoteca;

public class Actor {

    // Classe utilizzata per definire i nomi e cognomi degli attori dei film che verranno inseriti.

    private String name;
    private String surname;


    //costruttore che inizializza gli attributi della classe actor

    public Actor() {
        name="";
        surname="";
    }



    //costruttore che inizializza un array String al cui interno verranno inseriti nomi e cognomi degli attori
    //separati da uno spazio.

    public Actor(String actor){
        String[] sos = actor.split(" ");
        this.name=sos[0];
        surname="";

        if(sos.length>1){
            for (int i = 1; i < sos.length; i++) {
                surname += sos[i]+" ";

            }
        }

        surname = surname.trim();
    }

    public Actor(String name,String surname) {
        this.name = name;
        this.surname = surname;

    }

    // metodi get & set degli attributi della classe Actor


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    //metodo tostring della classe

    @Override
    public String toString() {
        return name +" "+ surname;
    }
}
