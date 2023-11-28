package spaceinvaders;

public class TiroPlayer extends Bala{
    public TiroPlayer(){
        posY = 23; //a posicao vertical sempre inicia na altura do jogador
        visivel = false; //inicia nao atirado
    }
    
    //atria
    public void atiraPlayer(int posXNave){
        if(!visivel){ //se o tiro ainda nao foi atirado
            visivel = true;
            posY = 23;
            posX = posXNave + 4; //posicao horizontal eh o centro da nave
        }
    }
      
    @Override //funcao declarada na classe abstrata bala
    public void andaTiro(int time){
        if(visivel && time % 1 == 0){ //a cada unidade de tempo e se o tiro foi atirado
            posY -= 1; //vai para cima
            if(posY < 0) 
                visivel = false; //chagou na borda superior
        }
    }
}
