package object;

public class GameField {
    private int size;
    private String[][] gameField;

    public GameField(int size) {
        this.size = size;
        gameField = new String[size][size];
    }
    public boolean setCellValue(int i, int j, String value){
        try {
            if (!(gameField[i][j] == null)){
                return false;
            }
            gameField[i][j] = value;
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean checkingWinner(String icon){

        int d1 = 0;
        int d2 = 0;

        for (int i = 0; i < size; i++){
            if (!(gameField[i][i] == null) && gameField[i][i].equals(icon)){
                d1++;
            }
            if (!(gameField[size-i-1][i] == null) && gameField[size-i-1][i].equals(icon)){
                d2++;
            }
        }
        if (d1 == size || d2 == size){
            return true;
        }


        int v = 0;
        int h = 0;

        for (int i = 0; i < size; i++){
            v = 0;
            h = 0;
            for (int j = 0; j < size; j++){
                if (!(gameField[i][j] == null) && gameField[i][j].equals(icon)){
                    h++;
                }
                if (!(gameField[j][i] == null) && gameField[j][i].equals(icon)){
                    v++;
                }
            }
            if (h == size || v == size){
                return true;
            }
        }


        return false;
    }
    public boolean checkingDrawGame(){
        int isfull = 0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (!(gameField[i][j] == null)){
                    isfull++;
                }
                if (isfull == size*size){
                    return true;
                }
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }
}
