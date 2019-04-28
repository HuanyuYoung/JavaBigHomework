/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchtigerchess;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
/**
 * 
 * @author heyanbai
 */
public class ChessPieces {
    public String name;
    public Integer id;
    public Image Icon;
    
    public ChessPieces(int id){
        this.id = id;
        String fileName = null;
        if(this.id == 0){
            this.name = new String("Tiger");
            fileName = new String("tiger.png");
        }else{
            this.name = new String("Dog");
            fileName = new String("dog.png");
        }
        
        this.Icon = Toolkit.getDefaultToolkit().getImage("src/images/" + fileName);
    }
}
