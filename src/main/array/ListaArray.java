package array;

import list.EstruturaElementar;

public class ListaArray implements EstruturaElementar {

    private int[] array;
    private int indice_fim;

    public ListaArray() {
        this.array = new int[100];
        this.indice_fim = -1;
    }

    @Override
    public boolean buscaElemento(int valor) {
        if (indice_fim >= 0) {
            for (int i = 0; i <= indice_fim; i++) {
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
        if (isFull()) {
            aumentaArray();
        }

        for (int i = indice_fim + 1; i >= 0; i--) {
            if (i > buscaIndice) {
                array[i] = array[i - 1];
            } else if (i == buscaIndice) {
                array[i] = valor;
            }
        }
        indice_fim += 1;
    }

    @Override
    public void insereInicio(int valor) {
        if (isFull()) {
            aumentaArray();
        }
        for (int i = indice_fim; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = valor;
        indice_fim += 1;
    }

    @Override
    public void insereFim(int valor) {
        if (isFull()) {
            aumentaArray();
        }
        indice_fim += 1;
        array[indice_fim] = valor;
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

    private boolean isFull() {
        if (indice_fim >= array.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    private void aumentaArray() {
        int[] novoArray = new int[array.length + 100];

        for (int i = 0; i <= array.length - 1; i++) {
            novoArray[i] = array[i];
        }
        array = novoArray;
    }

}
