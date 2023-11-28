package spaceinvaders;

import java.util.logging.Level;
import java.util.logging.Logger;

//Aluno: Arthur Breno dos Reis Paula - 12547382
public class SpaceInvaders {

    public static void main(String[] args) {
        //inicia o cenario
        Cenario tela = new Cenario();
        int time = 0; //variavel que simula um relogio
        int situacaoDoJogo = 0; //esta jogando
        
        tela.desenhaCenarioInicial(); //desenha a tlea inicial
        
        while(true){
            if(tela.desenhaCenario() == 2) //se o jogador morreu
                while(!tela.JogadorVivo()){} //espera o jogador reviver (usuario digitar 'c')
            
            situacaoDoJogo = tela.atualizaCenario(time); //1 para perdeu, 2 para ganhou e 0 para se esta jogando ainda
            if(situacaoDoJogo != 0){ //se perdeu ou ganhou
                break;
            }
                
            //tela fica paralizada por um tempo
            try {
                tela.sleepCenario();
            } catch (InterruptedException ex) {
                Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //apaga a tela para que possa ser desenhada a outra
            tela.apagaCenario();
            time++; //incrementa o relogio
        }
        
        if(situacaoDoJogo == 1) //se ganhou
            tela.desenhaCenarioPerdeu();
        else if(situacaoDoJogo == 2) //se perdeu
            tela.desenhaCenarioGanhou();
    }    
}
