package Binaria;

public class Arvore {
    private No raiz;

    public Arvore() { raiz = null; }

    public void inserir(char chave){
        No novo = new No(chave);

        if (raiz == null){
            raiz = novo;
            return;
        }

        No aux = raiz;
        No atual = raiz;

        while (aux != null) {
            atual = aux;

            if (chave < aux.getChave()){
                aux = aux.getEsq();
            } else {
                aux = aux.getDir();
            }
        }

        if (chave < atual.getChave()){
            atual.setEsq(novo);
        } else {
            atual.setDir(novo);
        }
    }

    public void inserirNome(String nome){
        char chave = nome.charAt(0);

        if (raiz == null){
            return;
        }
        No atual = raiz;

        while (atual.getChave() != chave){
            if (chave < atual.getChave()){
                atual = atual.getEsq();
            } else {
                atual = atual.getDir();
            }

            if (atual == null) {
                return;
            }
        }

        atual.getNomes().inserir(nome);
    }

    public boolean deletar(int chave){
        No atual = raiz;
        No pai = raiz;
        boolean eFilhoDaEsq = true;

        while (atual.getChave() != chave){
            pai = atual;
            if (chave < atual.getChave()){
                eFilhoDaEsq = true;
                atual = atual.getEsq();
            } else {
                eFilhoDaEsq = false;
                atual = atual.getDir();
            }

            if (atual == null) {
                return false;
            }
        }

        if (atual.getEsq() == null && atual.getDir() == null) { // é uma folha?
            if (atual == raiz) { // Se a raiz é uma folha, delete a raiz;
                raiz = null;
            } else if (eFilhoDaEsq){ // Se é folha da esquerda, delete a folha da esquerda;
                pai.setEsq(null);
            } else { // Se é folha da direita, delete a folha da direita;
                pai.setDir(null);
            }
         } else { // possui apenas 1 filho
            if (atual.getDir() == null) { // Se não possui filho a direita;
                if (atual == raiz) { // se for a raiz substitui a raiz pela subarvore da esquerda
                    raiz = atual.getEsq();
                } else if (eFilhoDaEsq) { // se for filho da esquerda substitui pela subarvore da esquerda;
                    pai.setEsq(atual.getEsq());
                } else { // se for filho da direita substitui pela subarvore da esquerda;
                    pai.setDir(atual.getEsq());
                }
            } else {
                if (atual.getEsq() == null) { // Se não possui filho a esquerda;
                    if (atual == raiz) { // se for a raiz substitui a raiz pela subarvore da direita
                        raiz = atual.getDir();
                    } else if (eFilhoDaEsq) { // se for filho da esquerda substitui pela subarvore da direita;
                        pai.setEsq(atual.getDir());
                    } else { // se for filho da direita substitui pela subarvore da direita;
                        pai.setDir(atual.getDir());
                    }
                } else { // Possui os dois filhos
                    No sucessor = getSucessor(atual);
                    if (atual == raiz) { // se for deletar a raiz, define o sucessor como
                        raiz = sucessor;
                    } else if(eFilhoDaEsq) {
                        pai.setEsq(sucessor);
                    } else {
                        pai.setDir(sucessor);
                    }
                    sucessor.setEsq(atual.getEsq());
                }
            }
        }
        return true;
    }

    public void inOrder() {
        No localRoot = raiz;
        this.inOrder(localRoot);
    }

    private void inOrder(No localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.getEsq());
            System.out.print((char)localRoot.getChave() + " : ");
            localRoot.getNomes().listarElementos();
            inOrder(localRoot.getDir());
        }
    }

    private No getSucessor(No noDeletar){
        No paiSucessor = noDeletar;
        No sucessor = noDeletar;
        No atual = noDeletar.getDir();

        while (atual != null) { // procura o menor valor da direita
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsq();
        }

        if (sucessor != noDeletar.getDir()) { // Se o imediato valor da minha direita não for o meu menor valor
            paiSucessor.setEsq(sucessor.getDir()); // Defino o valor a direita do meu menor valor no lugar do meu menor valor
            sucessor.setDir((noDeletar.getDir())); // Defino a direita do meu menor valor como a direita do valor a ser deletado
        }

        return sucessor;
    }
}
