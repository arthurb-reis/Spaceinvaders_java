package spaceinvaders;

abstract class Bala {
    protected boolean visivel; //bala foi atirada
    protected int posX; //posicao horizintal
    protected int posY; //posicao vertical
    
    //retorna a posicao horizontal
    public int getPosX(){
        return posX;
    }
    
    //retorna a posicao vertical
    public int getPosY(){
        return posY;
    }
    
    //altera a posicao horizontal
    public void alterarX(int posX){
        this.posX = posX;
    }
    
    //altera a posicao vertical
    public void alterarY(int posY){
        this.posY = posY;
    }
    
    //desenha a bala na tela
    public void desenhaBala(){
        System.out.print("|");
    }
    
    //funcao que faz o tiro andar (depende de quem atirou)
    abstract public void andaTiro(int time);
    
}
