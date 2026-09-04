import Binaria.Arvore;

void main() {
    Arvore indice = new Arvore();
    char letras[] = {'N', 'G', 'U', 'D', 'J', 'R', 'X', 'B', 'F', 'H',
            'L', 'P', 'T', 'V', 'Z', 'A', 'C', 'E', 'I', 'K', 'M', 'O', 'Q',
            'S', 'W', 'Y'};
    for (int i = 0; i < letras.length; i++) {
        indice.inserir(letras[i]);
    }
    indice.inOrder();

    String[] nomes = {
            "Natalia", "Gabriel", "Ursula", "Diego", "Julia", "Rafaela", "Xavier",
            "Bruno", "Fernanda", "Heitor", "Lucas", "Pedro", "Thiago", "Vinicius",
            "Zilda", "Ana", "Carla", "Eduardo", "Isabela", "Kevin", "Mariana",
            "Olivia", "Quenia", "Sofia", "Wagner", "Yuri", "Arthur", "Beatriz",
            "Carlos", "Daniela", "Elena", "Felipe", "Gustavo", "Helena", "Igor",
            "Joao", "Karina", "Luana", "Matheus", "Nicolas", "Otavio", "Patricia",
            "Quintino", "Rodrigo", "Samuel", "Tatiana", "Uriel", "Vanessa", "Yasmin",
            "Ximena", "Yara", "Zeca"
    };

    for (String nome : nomes) {
        indice.inserirNome(nome);
    }

    indice.inOrder();
}