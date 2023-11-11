package array;

import list.EstruturaElementar;

public class ListaArray implements EstruturaElementar {

    private int[] array;
    private int indice_fim;

    public ListaArray() {
        this.array = new int[0];
        this.indice_fim = -1;
    }

    @Override
    public boolean buscaElemento(int valor) {
        if (indice_fim >= 0) {
            for (int i = 0; i <= indice_fim; i++) {
                int aux = array[i];
                if (array[i] == valor)
                    return true;
            }
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        if (indice_fim >= valor) {
            return array[valor];
        } else {
            return -1;
        }

    }

    @Override
    public int minimo() {
        int min = array[0];
        for (int i : array) {
            if (min > i)
                min = i;
        }
        return min;
    }

    @Override
    public int maximo() {
        int max = array[0];
        for (int i : array) {
            if (max < i)
                max = i;
        }
        return max;
    }

    @Override
    public int predecessor(int valor) {
        if (indice_fim >= valor && valor > 0) {
            return array[valor - 1];
        }
        return -1;
    }

    @Override
    public int sucessor(int valor) {
        if (indice_fim > valor && valor <= 0) {
            return array[valor + 1];
        }
        return -1;
    }

    @Override
    public void insereElemento(int valor) {
        insereFim(valor);
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        int[] novoArray;
        if (indice_fim >= 0) {
            novoArray = new int[indice_fim + 2]; // criando um novo array de tamanho maior para encaixar o
                                                 // elemento novo
        } else {
            novoArray = new int[1]; // estou usando indice_fim como -1 caso ele não tenha nenhum elemento ainda
        }

        for (int i = indice_fim + 1; i >= 0; i--) {
            if (i > buscaIndice) {
                novoArray[i] = array[i - 1];
            } else if (i == buscaIndice) {
                novoArray[i] = valor;
            } else {
                novoArray[i] = array[i];
            }
        }
        array = novoArray;
        indice_fim += 1;
    }

    @Override
    public void insereInicio(int valor) {
        int[] novoArray;
        if (indice_fim >= 0) {
            novoArray = new int[indice_fim + 2]; // criando um novo array de tamanho maior para enCaixar o
                                                 // elemento novo
        } else {
            novoArray = new int[1]; // estou usando indice_fim como -1 caso ele não tenha nenhum elemento ainda
        }

        for (int i = indice_fim + 1; i > 0; i--) {
            novoArray[i] = array[i - 1];
        }
        novoArray[0] = valor;
        array = novoArray;
        indice_fim += 1;
    }

    @Override
    public void insereFim(int valor) {
        int[] novoArray;
        if (indice_fim >= 0) {
            novoArray = new int[indice_fim + 2]; // criando um novo array de tamanho maior para enCaixar o
                                                 // elemento novo
        } else {
            novoArray = new int[1]; // estou usando indice_fim como -1 caso ele não tenha nenhum elemento ainda
        }

        for (int i = indice_fim; i >= 0; i--) {
            novoArray[i] = array[i];
        }
        indice_fim += 1;
        novoArray[indice_fim] = valor;
        array = novoArray;

    }

    @Override
    public void remove(int valor) {
        int indiceRemovido = -1;
        for (int i = 0; i <= indice_fim; i++) {
            if (array[i] == valor) {
                indiceRemovido = i;
            }
        }
        if (indiceRemovido >= 0) {
            for (int j = indiceRemovido; j <= indice_fim - 1; j++) {
                array[j] = array[j + 1];
            }
            indice_fim -= 1;
        }
    }

    @Override
    public void removeIndice(int indice) {
        if (indice >= 0) {
            for (int j = indice; j <= indice_fim - 1; j++) {
                array[j] = array[j + 1];
            }
            indice_fim -= 1;
        }
    }

    @Override
    public void removeInicio() {
        if (indice_fim >= 0)
            for (int j = 0; j <= indice_fim - 1; j++) {
                array[j] = array[j + 1];
            }
        indice_fim -= 1;
    }

    @Override
    public void removeFim() {
        if (indice_fim >= 0)
            indice_fim -= 1;
    }

}
