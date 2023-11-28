package spaceinvaders;

abstract class Nave {
    protected int vida; //vida maxima da nave
    protected int saude; //quantas vidas ela ainda tem
    protected int posX;
    protected int posY;
    protected int tipo; //tipo de nave
    
    //retorna tipo
    public int getTipo(){
        return tipo;
    }
    
    //retorna posicao horizontal
    public int getPosX(){
        return posX;
    }
    
    //retorna posicao vertical
    public int getPosY(){
        return posY;
    }
    
    //retorna saude
    public int getSaude(){
        return saude;
    }
    
    //altera a posicao horizontal
    public void alterarX(int posX){
        this.posX = posX;
    }
    
    //altera a posicao vertical
    public void alterarY(int posY){
        this.posY = posY;
    }
    
    //desenha a nave de acordo com seu tipo e se ela estiver viva
    public void desenha(){
        String formato = "         ";
        if(saude > 0){ //se estiver viva
            switch (tipo) {
                case 1 -> formato = "   ***   ";
                case 2 -> formato = "  *****  ";
                case 3 -> formato = " ******* ";
                default -> {
                }
            }
        }
        System.out.print(formato);
    }
    
}
