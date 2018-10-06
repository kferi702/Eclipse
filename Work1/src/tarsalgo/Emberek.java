/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarsalgo;
/**
 *
 * @author Kovács Ferenc
 */
public class Emberek {

    private int ora;
    private int perc;
    private int azonosito;
    private String irany;
    private boolean be;
    private int ido;
    

    public Emberek(String sor) {
        String[] tmp = sor.split(" ");
        this.ora = Integer.parseInt(tmp[0]);
        this.perc = Integer.parseInt(tmp[1]);
        this.azonosito = Integer.parseInt(tmp[2]);
        this.irany = tmp[3];
        be=tmp[3].equals("be");
        this.ido=(Integer.parseInt(tmp[0])*60)+Integer.parseInt(tmp[1]);
    }

    public int getIdo(){
        return ido;
    }
    public int getOra(){
        return ora;
    }
        public int getPerc(){
        return perc;
    }
    public String getIrany() {
        return irany;
    }

    public int getAzonosito() {
        return azonosito;
    }
    public boolean isBe(){
        return be;
    }
}
