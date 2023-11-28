package spaceinvaders;

public class NaveJogador extends Nave{
    public boolean parado; //jogador morto
    public boolean jogoComecou; //jogo ja comecou
    
    public NaveJogador(){
        vida = 3; //comeca com 3 vidas
        saude = vida;
        
        //posicao inicial
        posX = 30; 
        posY = 23;
        tipo = 2; //nave do jogador eh do tipo 2
        parado = false; //comeca vivo
        jogoComecou = false; //jogador nasce com jogo ainda nao inciado
    }

    //desloca jogador recebendo a tecla pressionada
    public void deslocaJogador(int caso) {
        if(caso == 1) //esta pressionando 'a'
            if(getPosX() > 1)
                alterarX(getPosX() - 1);
        
        if(caso == 2) //esta pressionando 'd'
            if(getPosX() < 140)
                alterarX(getPosX() + 1);
    }
    
    //retorna quantas vidas ainda tem
    public int vidas(){
        return saude;
    }
    
    //perde vida quando atingida
    public void perdeSaude(){
        parado = true; //nave morreu, bloqueia cenario
        saude--;
    }
    

}
