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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'minimo'");
    }

    @Override
    public int maximo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maximo'");
    }

    @Override
    public int predecessor(int valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'predecessor'");
    }

    @Override
    public int sucessor(int valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sucessor'");
    }

    @Override
    public void insereElemento(int valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insereElemento'");
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insereElementoPosicao'");
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

        for (int i = indice_fim; i >= 0; i--) {
            novoArray[i + 1] = array[i];
        }
        novoArray[0] = valor;
        array = novoArray;
        indice_fim += 1;
    }

    @Override
    public void insereFim(int valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insereFim'");
    }

    @Override
    public void remove(int valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void removeIndice(int indice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeIndice'");
    }

    @Override
    public void removeInicio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeInicio'");
    }

    @Override
    public void removeFim() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFim'");
    }

}
