/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouseclick;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import config.Config;
import catchtigerchess.ChessWindow;
import catchtigerchess.ChessPieces;
import catchtigerchess.ChessBoardCanvas;
import java.awt.Point;
/**
 *
 * @author heyanbai
 */
public class ChessClick extends MouseAdapter{
    @Override
    public void mouseClicked(MouseEvent arg){
        int x = arg.getX();
        int y = arg.getY();
        x = (x - Config.startX)/Config.distPoint2Point;
        y = (y - Config.startY)/Config.distPoint2Point;
        System.out.println("x = " + x + ", y = " + y);
        if(x < 0 || x > 4 || y < 0 || y > 6){
            return;
        }else{
            if (ChessWindow.chessBoarder.getPoint(0) == null) {
                ChessWindow.chessBoarder.setPoint(0, new Point(x, y));
                System.out.println("无选中棋子");
            }
            else{
                System.out.println("有选中棋子");
                ChessPieces[][] pieces = ChessWindow.getChessPieces();
                Point p1 = ChessWindow.chessBoarder.getPoint(0);
                if (pieces[p1.y][p1.x] == null) {
                    ChessWindow.chessBoarder.setPoint(0, new Point(x, y));
                    System.out.println("选中棋子为空");
                }
                else{
                    
                    if (pieces[p1.y][p1.x].name.toString() == (ChessWindow.getPlayer())) {
                        ChessWindow.chessBoarder.setPoint(0, new Point(x, y));
                        System.out.println("选中的是非本方棋子");
                        System.out.println(pieces[p1.y][p1.x].name);
                        System.out.println(ChessWindow.getPlayer());
                    }
                    else{
                        System.out.println("选中的是本方棋子");
                        if (ChessWindow.chessBoarder.getPoint(1) == null) {
                            System.out.println("第二次选中为空");
                            ChessWindow.chessBoarder.setPoint(1, new Point(x, y));
                            Point p2 = ChessWindow.chessBoarder.getPoint(1);
                            if(ChessWindow.chessBoarder.pieceMove(p1, p2) == true){
                                System.out.println("棋子可以移动");
                                ChessWindow.chessBoarder.setPoint(0, null);
                                ChessWindow.chessBoarder.setPoint(1, null);
                                swapPlayer();
                            }
                        }
                        else{
                            System.out.println("棋子不能移动");
                            ChessWindow.chessBoarder.setPoint(0, new Point(x, y));
                            ChessWindow.chessBoarder.setPoint(1, null);
                        }
                    }
                }
            }
        }
        ((ChessBoardCanvas)arg.getSource()).repaint();
        int height = ((ChessBoardCanvas)arg.getSource()).getHeight();
        int width = ((ChessBoardCanvas)arg.getSource()).getWidth();
        ((ChessBoardCanvas)arg.getSource()).paintImmediately(0, 0, width, height);
        System.out.println("Repaint Down");
    }
    static public void swapPlayer(){
        ChessWindow.setPlayer();
 
    }
}
