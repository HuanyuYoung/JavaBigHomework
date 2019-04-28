/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchtigerchess;
import java.awt.Point;
import java.lang.Math;
import catchtigerchess.ChessWindow;
/**
 *
 * @author heyanbai
 */
public class ChessBoarder {
    private static ChessPieces[][] chessPieces;
    private boolean isRealDes(int x,int y){
        if(x>=0&&x<=4&&y>=2&&y<=6) return true;
        else if(y == 0 && x == 2) return true;
        else if(y == 1 && x >= 1 && x <= 3) return true;
        else return false;
    }
    private boolean isInDistance(Point src, Point des){
        int dx = Math.abs(src.x - des.x);
        int dy = Math.abs(src.y - des.y);
        if(dx == 1 && dy == 1) return true;
        else if(dx == 1 && dy == 0) return true;
        else if(dy == 0 && dx == 1) return true;
        else return false;
    }
    public ChessBoarder(){
        chessPieces = new ChessPieces[7][5];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                chessPieces[i][j] = null;
            }
        }
        chessPieces[4][2] = new ChessPieces(0);
        chessPieces[2][0] = new ChessPieces(1);
        chessPieces[2][1] = new ChessPieces(2);
        chessPieces[2][2] = new ChessPieces(3);
        chessPieces[2][3] = new ChessPieces(4);
        chessPieces[2][4] = new ChessPieces(5);
        chessPieces[3][0] = new ChessPieces(6);
        chessPieces[3][4] = new ChessPieces(7);
        chessPieces[4][0] = new ChessPieces(8);
        chessPieces[4][4] = new ChessPieces(9);
        chessPieces[5][0] = new ChessPieces(10);
        chessPieces[5][4] = new ChessPieces(11);
        chessPieces[6][0] = new ChessPieces(12);
        chessPieces[6][1] = new ChessPieces(13);
        chessPieces[6][2] = new ChessPieces(14);
        chessPieces[6][3] = new ChessPieces(15);
        chessPieces[6][4] = new ChessPieces(16);
    }
    /**
    * 
    * @param src Source Point
    * @param des Destination Point
    */
    public boolean pieceMove(Point src, Point des){
        if (chessPieces[src.y][src.x] == null){
            return false;
        }else{
            if(isRealDes(des.x,des.y)){
                if(chessPieces[des.y][des.x] != null) return false;
                if (isInDistance(src,des)){
                    chessPieces[des.y][des.x] = chessPieces[src.y][src.x];
                    chessPieces[src.y][src.x] = null;
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
    }
    public ChessPieces[][] getChessPieces(){
        return chessPieces.clone();
    }
}
