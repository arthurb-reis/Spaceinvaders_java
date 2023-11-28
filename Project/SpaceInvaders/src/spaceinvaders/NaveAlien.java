package spaceinvaders;

public class NaveAlien extends Nave{
    public NaveAlien(int posX, int posY, int tipo){
        vida = 1; //tem uma vida so
        saude = vida;
        this.posX = posX;
        this.posY = posY;
        this.tipo = tipo;
    }
    
    //funcao que mata alien quando for atingido
    public void morreAlien(){
        saude = 0;
    }
}
