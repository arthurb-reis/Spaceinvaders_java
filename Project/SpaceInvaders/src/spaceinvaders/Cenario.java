package spaceinvaders;

import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Cenario extends KeyAdapter{
    private ExercitoInimigo inimigos; //possui um exercito de aliens
    private NaveJogador player; //possui um jogador
    private TiroPlayer tiroJogador; //um tiro do jogador
    private TiroAlien tiroInimigo; //um tiro de alien
    private ArrayList<Barreira> muros; //as barreiras
    private int pontos; //pontuacao
    
    public Cenario(){
        inimigos = new ExercitoInimigo();
        player = new NaveJogador();
        tiroJogador = new TiroPlayer();
        tiroInimigo = new TiroAlien();
        muros = new ArrayList<>(); //lista com 5 muros
        for(int i = 0; i < 5; i++){
            Barreira aux = new Barreira(i); //cada muroreceb um indice de acordo com sua localizacao
            muros.add(aux);
        }
        pontos = 0; //pontuacao inicia zerada
        
        //mecanismos para verificacao de tecla acionada
        JTextField component = new JTextField();
        component.addKeyListener(new MKeyListener(player, tiroJogador));
        JFrame f = new JFrame();
        f.add(component);
        f.setSize(300, 300);
        f.setVisible(true);
        
        //cada nave sera 9x1
        //sao 55 naves
    }
    
    //desenha o cenario quando perde
    public void desenhaCenarioPerdeu(){
        //desenha borda superior
        for(int j = 0; j < 150; j++){
            System.out.print("_");
        }
        System.out.println();
        
        int numLinha = 0;
        for(; numLinha < 10; numLinha++)
            desenhaLinha();
        
        for(int i = 0; i < 50; i++)
            System.out.print(" ");
        
        System.out.print("Voce perdeu :(         Ate a proxima!!");
        
        for(int i = 38 + 50; i < 150; i++)
            System.out.print(" ");
        numLinha++;
        
        for(; numLinha < 20; numLinha++)
            desenhaLinha();
        
        for(int i = 0; i < 30; i++)
            System.out.print(" ");
        
        System.out.print("Aluno: Arthur Breno dos Reis Paula - 12547382");
        
        for(int i = 45 + 30; i < 150; i++)
            System.out.print(" ");
        numLinha++;
        
        for(; numLinha < 25; numLinha++)
            desenhaLinha();
        
        //desenha borda superior
        for(int j = 0; j < 150; j++){
            System.out.print("_");
        }
        System.out.println();
    }
    
    //desenha o cenario quando ganha
    public void desenhaCenarioGanhou(){
        //desenha borda superior
        for(int j = 0; j < 150; j++){
            System.out.print("_");
        }
        System.out.println();
        
        int numLinha = 0;
        for(; numLinha < 10; numLinha++)
            desenhaLinha();
        
        for(int i = 0; i < 50; i++)
            System.out.print(" ");
        
        System.out.print("Voce ganhou :)         Ate a proxima!!");
        
        for(int i = 38 + 50; i < 150; i++)
            System.out.print(" ");
        numLinha++;
        
        for(; numLinha < 20; numLinha++)
            desenhaLinha();
        
        for(int i = 0; i < 30; i++)
            System.out.print(" ");
        
        System.out.print("Aluno: Arthur Breno dos Reis Paula - 12547382");
        
        for(int i = 45 + 30; i < 150; i++)
            System.out.print(" ");
        numLinha++;
        
        for(; numLinha < 25; numLinha++)
            desenhaLinha();
        
        //desenha borda superior
        for(int j = 0; j < 150; j++){
            System.out.print("_");
        }
        System.out.println();
    }
    
    //desenha o cenario inicial com algumas instrucoes do jogo
    public void desenhaCenarioInicial(){
        //desenha borda superior
        for(int j = 0; j < 150; j++){
            System.out.print("_");
        }
        System.out.println();
        
        desenhaLinha(); //Space Invaders
        System.out.println("         ##########                                             ###########                                                                           ");
        System.out.println("        ###########                                             ###########                                                                           ");
        System.out.println("         ###         ######      ####      ######  ########         ###      ##    ##  ##    ##    ####    ####    ########  ######     ######        ");
        System.out.println("          ###        ##   ##    ##  ##    ######   #######          ###      ####  ##  ##    ##   ##  ##   #####   #######   ##   ##   #######        ");
        System.out.println("           ###       ##    ##  ##    ##  ##        ##               ###      ## ## ##  ##    ##  ##    ##  ##  ##  ##        ##    ##   ##            ");
        System.out.println("            ###      ##   ##   ##    ##  ##        ######           ###      ##  ####  ##    ##  ##    ##  ##  ##  ######    ##   ##     ##           ");
        System.out.println("             ###     ######    ########  ##        ######           ###      ##   ###  ##    ##  ########  ##  ##  ######    ######       ##          ");
        System.out.println("              ####   ##        ##    ##  ##        ##               ###      ##    ##   ##  ##   ##    ##  ##  ##  ##        ## ##         ##         ");
        System.out.println("          #########  ##        ##    ##   ######   #######      ###########  ##    ##    ####    ##    ##  #####   #######   ##  ##     #######       ");
        System.out.println("         #########   ##        ##    ##    ######  ########     ###########  ##    ##     ##     ##    ##  ####    ########  ##   ##   #######        ");
        System.out.println("                                                                                                                                                      ");
        System.out.println("        Aluno: Arthur Breno dos Reis Paula - 12547382                                          DIGITE 'C' PARA COMECAR O JOGO!!                       ");
        System.out.println("                                                                                                                                                      ");
        System.out.println("        Instrucoes:                                                                                                                                   ");
        System.out.println("            .O jogo funciona no terminal printando varias vezes, entao nao eh bom usar o scroll porque pode ser que voce perca o ultimo frame         ");
        System.out.println("            .Esta aberta uma janela externa, eh la que voce ira digitar os comandos                                                                   ");
        System.out.println("                                                                                                                                                      ");
        System.out.println("        Como jogar:                                                    Modo de jogo:                                                                  ");
        System.out.println("                            <-----  'C' ----->                            .Voce tera 3 vidas, caso fique com 0, voce perdeu                           ");
        System.out.println("                              'A'        'D'                              .Caso os aliens cheguem perto das barreiras, voce perdeu                    ");
        System.out.println("        Atirar: tecla 'C'                                                 .Caso voce mate todos os alien, voce ganhou!!                               ");
        System.out.println("        Ir para a esquerda: tecla 'A'                                                                                                                 ");
        System.out.println("        Ir para a diretira: tecla 'D'                                                                           BOM JOGO!!!                           ");
        System.out.println("                                                                                                                                                      ");
        
        //desenha borda superior
        for(int j = 0; j < 150; j++){
            System.out.print("_");
        }
        System.out.println();
        
        while(!player.jogoComecou){
            System.out.print("");
        }
    }
    
    //desenha cada frame durante o jogo
    public int desenhaCenario(){
        int inicioDoExercitoX = inimigos.retornaPosX(); //posicao horizontal dos inimigos
        int inicioDoExercitoY = inimigos.retornaPosY(); //posicao vertical dos inimigos
        int numLinha = 0; //numero da linha desenhada
        verificaBarreira(); //funcao que verifica se nenhuma bala atingiu a barreira
        verificaBalaJogador(); //funcao que verifica se o tiro do jogador atingiu algum alien
        verificaBalaAlien(); //funcao que verifica se o tiro do alien atingiu o jogador ou o tiro do jogador
            
        //comeca o desenho
        //desenha borda superior
        for(int j = 0; j < 150; j++){
            System.out.print("_");
        }
        System.out.println();
        
        //desenha as 25 linhas da tela
        while(numLinha < 25){
            if(numLinha == inicioDoExercitoY){ //desenha o exercito
                //desenha fundo + exercito
                for(int j = 0; j < 5; j++){ //exercito tem 5 linhas
                    for(int i = 0; i < inicioDoExercitoX; i++){
                        System.out.print(' ');
                    }
                    inimigos.desenhaLinhaExercito(j); //desenha cada linha do exercito
                    for(int i = inicioDoExercitoX + 9*11; i < 150; i++){
                        System.out.print(' ');
                    }
                    numLinha++;
                    System.out.println();
                }
            }else if(numLinha == muros.get(0).posY()){ //desenha os muros
                //desenha fundo + exercito
                for(int j = 0; j < 2; j++){
                    int coluna = 0;
                    for(int k = 0; k < 5; k++){
                        for(; coluna < muros.get(k).posX(); coluna++){
                            System.out.print(' ');
                        }
                        muros.get(k).desenhaBarreiraLinha(j); //desenha cada linha da barreira
                        coluna += 10;
                    }
                    numLinha++;
                    System.out.println();
                }
            } else if(numLinha == player.getPosY()){ //desenha o jogador
                for(int j = 0; j < player.getPosX(); j++){
                    System.out.print(' ');
                }
                player.desenha();
                for(int j = player.getPosX() + 9; j < 150; j++){
                    System.out.print(' ');
                }
                numLinha++;
                System.out.println();
            } else if(numLinha == tiroJogador.getPosY() && tiroJogador.visivel){ //desenha o tiro do jogador
                //desenha fundo + bala
                for(int i = 0; i < tiroJogador.getPosX(); i++){
                    System.out.print(' ');
                }
                tiroJogador.desenhaBala();
                for(int i = tiroJogador.getPosX() + 1; i < 150; i++){
                    System.out.print(' ');
                }
                numLinha++;
                System.out.println();
            } else if(numLinha == tiroInimigo.getPosY() && tiroInimigo.visivel){ //desenha o tiro do inimigo
                //desenha fundo + bala
                for(int i = 0; i < tiroInimigo.getPosX(); i++){
                    System.out.print(' ');
                }
                tiroInimigo.desenhaBala();
                for(int i = tiroInimigo.getPosX() + 1; i < 150; i++){
                    System.out.print(' ');
                }
                numLinha++;
                System.out.println();
            } else { //desenha linha vazia
                desenhaLinha();
                numLinha++;
            }
        }

        //desenha borda inferior
        System.out.print("Vidas: " + player.vidas());
        
        int colunasRestantes = 133;
        if(pontos >= 10 && pontos < 100)
            colunasRestantes--;
        if(pontos >= 100 && pontos < 1000)
            colunasRestantes--;
        if(pontos >= 1000 && pontos < 10000)
            colunasRestantes--;
        
        for(int j = 0; j < 133; j++){
            System.out.print("_");
        }
        
        System.out.print("Pontos: " + pontos);
        System.out.println();

        //acabou o desenho
        
        if(!JogadorVivo())
            return 2; //retorna 2 se o jogador morreu
        return 0;
    }
    
    //denha varias linhas vazias
    public void apagaCenario(){
        for(int i = 0; i < 30; i++){
            System.out.println();
        }
    }
    
    //espera o tempo para que se possa desenhar o proximo frame
    public void sleepCenario() throws InterruptedException{
        Thread.sleep(100);
    }
    
    //atualiza o cenario
    public int atualizaCenario(int time){
        //move os tiros
        tiroJogador.andaTiro(time);
        tiroInimigo.atiraAlien(player.getPosX() + 5, inimigos); //alien atira automaticamente sempre quepossivel
        tiroInimigo.andaTiro(time);
        
        //verificacoes
        if(inimigos.desloca(time) == 1)
            return 1; //inimigos chegaram
        if(player.saude == 0)
            return 1; //jogador morreu
        if(inimigos.verificaSeGanhou())
            return 2; //ganhou!!
        return 0; //jogo segue normal
    }
    
    //desenha linha vazia
    private void desenhaLinha(){
        for(int j = 0; j < 150; j++){
            System.out.print(' ');
        }
        System.out.println();
    }
    
    //verifica se a bala do jogador nao atingiu algum inimigo
    private int verificaBalaJogador(){
        boolean flagAltura = (tiroJogador.getPosY() <= inimigos.retornaPosY() + 5) && (tiroJogador.getPosY() > inimigos.retornaPosY());
        boolean flagHorizontal = ((tiroJogador.getPosX() - inimigos.retornaPosX()) > 0) && ((tiroJogador.getPosX() - inimigos.retornaPosX()) < 99);
        
        if(flagAltura && flagHorizontal && tiroJogador.visivel){ //se ele chegou na "nuvem" de inimigos
            int aux = tiroJogador.getPosX() - inimigos.retornaPosX();
            int naveAtingida = aux / 9; //ve qual a nave possivelmente atingida
            int altura = - inimigos.retornaPosY() + tiroJogador.getPosY() - 1; //ve a altura da nave
            if(inimigos.matrizInimiga[altura][naveAtingida].getSaude() != 0){ //se ela estava viva
                inimigos.matrizInimiga[altura][naveAtingida].morreAlien(); //alien dessa posicao morre
                switch (altura) { //soma os pontos
                    case 4, 3 -> pontos += 10;
                    case 2, 1 -> pontos += 20;
                    case 0 -> pontos += 30;
                    default -> {
                    }
                }
                tiroJogador.visivel = false; //bala deixa de estar ativa
                return 1; //matou alguem
            }
        }
        return 0; //matou ninguem
    }
    
    //verifica se bala do alienigena atingiu o jogador ou a bala do jogador
    private int verificaBalaAlien(){
        if(((tiroInimigo.getPosY() == tiroJogador.getPosY()) || (tiroInimigo.getPosY() == tiroJogador.getPosY() + 1)) && (tiroInimigo.getPosX() == tiroJogador.getPosX()) && tiroInimigo.visivel && tiroJogador.visivel){
            //desativa as duas balas de elas se atingiram
            tiroInimigo.visivel = false;
            tiroJogador.visivel = false;
            return 1; //bala atingiu a outra bala
        }
        
        boolean flagAltura = (tiroInimigo.getPosY() == player.posY);
        boolean flagHorizontal = ((tiroInimigo.getPosX() > player.posX + 1) && ((tiroInimigo.getPosX() < player.posX + 8)));
        
        if(flagAltura && flagHorizontal && tiroInimigo.visivel){ //verifica as condicoes para atingir o jogador
            tiroInimigo.visivel = false; //desativa a bala
            player.perdeSaude(); //perde vida
            return 2; //bala atingiu o jogador
        }
        return 0; //nada aconteceu
    }
    
    //verifica se alguma bala atingiu a barreira
    private int verificaBarreira(){
        //as barreiras estao entre 20 e 30, entre 45 e 55, entre 70 e 80, entre 95 e 105, entre 120 e 130
        int indiceBarreira = -1; //barreira que pode ter sido atingida, se igual a -1 nenhuma foi
        if(tiroInimigo.getPosX() >= 20 && tiroInimigo.getPosX() < 30)
            indiceBarreira = 0;
        else if(tiroInimigo.getPosX() >= 45 && tiroInimigo.getPosX() < 55)
            indiceBarreira = 1;
        else if(tiroInimigo.getPosX() >= 70 && tiroInimigo.getPosX() < 80)
            indiceBarreira = 2;
        else if(tiroInimigo.getPosX() >= 95 && tiroInimigo.getPosX() < 105)
            indiceBarreira = 3;
        else if(tiroInimigo.getPosX() >= 120 && tiroInimigo.getPosX() < 130)
            indiceBarreira = 4;
        
        if(tiroInimigo.getPosY() == muros.get(0).posY()){ //altura do tiro do inimigo igual a altura da barreira
            if(indiceBarreira != -1){
                int tijoloAtingido = tiroInimigo.getPosX() - (indiceBarreira * 25) - 20; //verifica o tijolo atingido
                if(muros.get(indiceBarreira).verificaTijolo(0, tijoloAtingido)){
                    muros.get(indiceBarreira).atingida(0, tijoloAtingido); //destroi o tijolo se ele estava inteiro
                    tiroInimigo.visivel = false; //bala nao eh mais ativa
                    return 1; //atingiu um tijolo
                }
            }
        } else if(tiroInimigo.getPosY() == muros.get(0).posY() + 1){ //mesma idei, mas para a segunda linha da barreira
            if(indiceBarreira != -1){
                int tijoloAtingido = tiroInimigo.getPosX() - (indiceBarreira * 25) - 20;
                if(muros.get(indiceBarreira).verificaTijolo(1, tijoloAtingido)){
                    muros.get(indiceBarreira).atingida(1, tijoloAtingido);
                    tiroInimigo.visivel = false;
                    return 1;
                }
            }
        }
        
        //agora, mesma ideia, mas com o tiro do jogdor
        indiceBarreira = -1;
        if(tiroJogador.getPosX() >= 20 && tiroJogador.getPosX() < 30)
            indiceBarreira = 0;
        else if(tiroJogador.getPosX() >= 45 && tiroJogador.getPosX() < 55)
            indiceBarreira = 1;
        else if(tiroJogador.getPosX() >= 70 && tiroJogador.getPosX() < 80)
            indiceBarreira = 2;
        else if(tiroJogador.getPosX() >= 95 && tiroJogador.getPosX() < 105)
            indiceBarreira = 3;
        else if(tiroJogador.getPosX() >= 120 && tiroJogador.getPosX() < 130)
            indiceBarreira = 4;
        
        if(tiroJogador.getPosY() == muros.get(0).posY() + 1){
            if(indiceBarreira != -1){
                int tijoloAtingido = tiroJogador.getPosX() - (indiceBarreira * 25) - 20;
                if(muros.get(indiceBarreira).verificaTijolo(1, tijoloAtingido)){
                    muros.get(indiceBarreira).atingida(1, tijoloAtingido);
                    tiroJogador.visivel = false;
                    return 1;
                }
            }
        } else if(tiroJogador.getPosY() == muros.get(0).posY()){
            if(indiceBarreira != -1){
                int tijoloAtingido = tiroJogador.getPosX() - (indiceBarreira * 25) - 20;
                if(muros.get(indiceBarreira).verificaTijolo(0, tijoloAtingido)){
                    muros.get(indiceBarreira).atingida(0, tijoloAtingido);
                    tiroJogador.visivel = false;
                    return 1;
                }
            }
        }
        return 0;
    }
    
    //retorna se o jogador esta vivo/nao parado
    public boolean JogadorVivo(){
        return !player.parado;
    }
}
