package spaceinvaders;

public class Barreira {
    private int posX; //posicao horizontal
    private int posY; //posicao vertical
    private boolean [][] matrizTijolos; //matriz que ve quais tijolos ainda nao foram destruidos
    
    public Barreira(int indice){
        posX = ((indice + 1) * 25) - 5; //cria cada uma das 5 barreiras na sua posicao certa de acordo com seu indice
        posY = 18; //altura das barreiras
        
        //inicia a matriz de tijolos
        matrizTijolos = new boolean [2][10]; 
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 10; j++)
                matrizTijolos[i][j] = true; //inicia com todos os tijolos inteiros
    }
    
    //desenha uma linha da barreira
    public void desenhaBarreiraLinha(int linha){
        for(int i = 0; i < 10; i++){
            if(matrizTijolos[linha][i])
                System.out.print("0"); //tijolo inteiro
            else
                System.out.print(" "); //tijolo destruido
        }
    }
    
    //retorna posicao vertical
    public int posY(){
        return posY;
    }
    
    //retorna posicao horizontal
    public int posX(){
        return posX;
    }
    
    //quando a barreira for atingida
    public void atingida(int linha, int coluna){
        matrizTijolos[linha][coluna] = false;
    }
    
    //verifica se o tijolo foi destruido
    public boolean verificaTijolo(int linha, int coluna){
        return matrizTijolos[linha][coluna];
    }
}
