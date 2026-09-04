package Binaria;

import ListaEncadeada.Lista;

public class No {
    private char chave;
    private Lista nomes; // Inserção de O(1), sempre se coloca no inicio.
    private No esq;
    private No dir;
    
    public No(char chave){
        this.chave = chave;
        this.nomes = new Lista();
        this.esq = null;
        this.dir = null;
    }


    public int getChave() {
        return chave;
    }

    public void setChave(char chave) {
        this.chave = chave;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public Lista getNomes() {
        return nomes;
    }

    public void setNomes(Lista nomes) {
        this.nomes = nomes;
    }
}
