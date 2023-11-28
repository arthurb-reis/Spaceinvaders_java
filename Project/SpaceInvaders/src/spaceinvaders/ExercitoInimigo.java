package spaceinvaders;

public class ExercitoInimigo {
    public NaveAlien[][] matrizInimiga; //matriz de naves
    private boolean indoParaADireita; //booleano que diz se esta indo para a direita
    
    public ExercitoInimigo(){
        matrizInimiga = new NaveAlien[5][11]; //inicia a matriz
        indoParaADireita = true; //comeca indo para a direita
        
        //inicia as naves do tipo 1
        for(int i = 0; i < 11; i++){
            matrizInimiga[0][i] = new NaveAlien(9*i, 2, 1); 
        }
        
        //inicia as naves do tipo 2
        for(int i = 0; i < 11; i++){
            matrizInimiga[1][i] = new NaveAlien(9*i, 3, 2); 
            matrizInimiga[2][i] = new NaveAlien(9*i, 4, 2);
        }
        
        //inicia as naves do tipo 3
        for(int i = 0; i < 11; i++){
            matrizInimiga[3][i] = new NaveAlien(9*i, 5, 3);
            matrizInimiga[4][i] = new NaveAlien(9*i, 6, 3);
        }
    }
    
    //retorna o lado mais para a direita do exercito
    private int retornaPosLadoDireito(){
        for(int i = 10; i >= 0; i--){
            for(int j = 0; j < 5; j++){
                if(matrizInimiga[j][i].getSaude() != 0)
                    return (matrizInimiga[j][i].getPosX() + 10);
            }
        }
        return 0;
    }
    
    //retorna o lado mais para a esquerda do exercito
    private int retornaPosLadoEsquerdo(){
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 5; j++){
                if(matrizInimiga[j][i].getSaude() != 0)
                    return (matrizInimiga[j][i].getPosX());
            }
        }
        return 0;
    }
    
    //retorna o lado mais embaixo do exercito
    private int retornaPosEmbaixo(){
        for(int i = 0; i < 11; i++){
            for(int j = 4; j >= 0; j--){
                if(matrizInimiga[j][i].getSaude() != 0)
                    return (matrizInimiga[j][i].getPosY());
            }
        }
        return 0;
    }
    
    //move o exercito para baixo
    private void vaiParaBaixo(){
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 5; j++){
                matrizInimiga[j][i].alterarY(matrizInimiga[j][i].getPosY() + 1);
            }
        }
    }
    
    //move o exercito para a direita
    private void vaiParaDireita(){
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 5; j++){
                matrizInimiga[j][i].alterarX(matrizInimiga[j][i].getPosX() + 1);
            }
        }
    }
    
    //move o exercito para a esquerda
    private void vaiParaEsquerda(){
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 5; j++){
                matrizInimiga[j][i].alterarX(matrizInimiga[j][i].getPosX() - 1);
            }
        }
    }
    
    //funcao que move o exercito para onde ele deve ir
    public int desloca(int time){
        if(time % 3 == 0){ //a cada 3 unidades de tempo
            if(indoParaADireita){ //se esta indo para a direita
                if(retornaPosLadoDireito() >= 148){ //chegou na borda esquerda
                    indoParaADireita = !indoParaADireita; //muda a direcao
                    if(retornaPosEmbaixo() >= 20) //chegou na barreira
                        return 1;
                    vaiParaBaixo(); //vai para baixo
                    return 0;
                }
                vaiParaDireita(); //vai para a direita
            } else { //esta indo para a esquerda
                if(retornaPosLadoEsquerdo() <= 2){ //chegou na borda esquerda
                    indoParaADireita = !indoParaADireita; //muda a direcao
                    if(retornaPosEmbaixo() >= 20) //chegou na barreira
                        return 1;
                    vaiParaBaixo(); //vai para baixo
                    return 0;
                }
                vaiParaEsquerda(); //vai para a esquerda
            }
        }
        return 0;
    }
    
    //retorna posicao horizontal
    public int retornaPosX(){
        return retornaPosLadoEsquerdo();
    }
    
    //retorna posicao vertical
    public int retornaPosY(){
        return retornaPosEmbaixo() - 5;
    }
    
    //desenha linha do exercito
    public void desenhaLinhaExercito(int linha){
        for(int i = 0; i < 11; i++){
            matrizInimiga[linha][i].desenha();
        }
    }
    
    //verifica se ganhou: todas as naves com saude = 0
    public boolean verificaSeGanhou(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 11; j++){
                if(matrizInimiga[i][j].saude != 0)
                    return false;
            }
        }
        return true;
    }
    
}
