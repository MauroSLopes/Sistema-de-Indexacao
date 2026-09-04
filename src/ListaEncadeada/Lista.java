package ListaEncadeada;

public class Lista {

    private No inicio;

    public Lista() {
        inicio = null;
    }

    public void inserir(String valor) {
        No novo = new No();
        novo.valor = valor;
        if (inicio == null) {
            inicio = novo;
            return;
        }

        novo.prox = inicio;
        inicio = novo;
    }

    public void listarElementos() {
        No aux = inicio;
        while (aux != null) {
            System.out.print(aux.valor + (aux.prox == null ? "" : ", "));
            aux = aux.prox;
        }
        System.out.println(";");
    }

    public No removerInicio() {
        if (inicio == null) {
            return null;
        }
        No aux = inicio;
        inicio = inicio.prox;
        aux.prox = null;
        return aux;
    }

    public No removerNoFim() {
        if (inicio == null) {
            return null;
        }
        if (inicio.prox == null) {
            No aux = inicio;
            inicio = null;
            return aux;
        }
        No ant = inicio;
        No aux = inicio;
        while (aux.prox != null) {
            ant = aux;
            aux = aux.prox;
        }
        ant.prox = null;
        return aux;

    }
}
