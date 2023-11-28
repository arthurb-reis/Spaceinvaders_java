package spaceinvaders;

public class TiroAlien extends Bala{
    
    public TiroAlien(){
        visivel = false; //tiro comeca nao visivel
    }
    
    public void atiraAlien(int posXNave, ExercitoInimigo i){
        if(!visivel){ //se o tiro ainda nao foi atirado
            if(posXNave > i.retornaPosX() && posXNave < i.retornaPosX() + 99){ //se existir um alien acima da nave do jogador
                int naveAcima = (posXNave - i.retornaPosX()) / 9; //verifica qual nave esta acima
                for(int j = 4; j >= 0; j--){ //passa por todas as naves acima
                    if(i.matrizInimiga[j][naveAcima].saude != 0){ //verifica se existe alguma com vida e se sim, faz...
                        visivel = true; //tiro foi atirado
                        posY = i.retornaPosY() + j; //posicao vertical do tiro eh a posicao vertical da nave
                        posX = i.retornaPosX() + naveAcima*9 + 5; //posicao horizontal do tiro eh o centro da nave
                        break;
                    }
                }
            }
        }
    }
     
    
    @Override //funcao ja declara na classe abstrata bala
    public void andaTiro(int time){
        if(visivel && time % 2 == 0){ //se o tiro estiver visivel (foi atirado) e a cada 2 unidades de tempo
            posY++; //anda para baixo
            if(posY > 25)
                visivel = false; //chegou na borda inferior
        }
    }
}
