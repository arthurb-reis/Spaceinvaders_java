package spaceinvaders;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//classe que verifica as teclas acionadas
class MKeyListener extends KeyAdapter {
    NaveJogador jogador;
    TiroPlayer tiro;
    
    //recebe os objetos que ela irá modificar
    public MKeyListener(NaveJogador n, TiroPlayer t){
        jogador = n;
        tiro = t;
    }
  
  @Override
    public void keyPressed(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case 65 -> jogador.deslocaJogador(1); //vai para a esquerda
            case 68 -> jogador.deslocaJogador(2); //vai para a direita
            case 67 -> {
                if(jogador.jogoComecou){ //se o jogo ja comecou
                    if(jogador.parado){ //se o jogador estiver morto/parado
                        jogador.alterarX(30); //vai para a posicao inicial
                        jogador.parado = false; //jogador nao esta mais parado/morto e esta vivo
                    }else //se o jogador estiver vivo/ativo
                        tiro.atiraPlayer(jogador.getPosX()); //atira
                } else //se o jogo nao comecou
                    jogador.jogoComecou = true; //comeca o jogo
            }
            default -> {
            }
        }
    }
  
}
