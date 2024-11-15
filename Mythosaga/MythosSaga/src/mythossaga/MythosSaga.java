/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mythossaga;

import java.io.IOException;

/**
 *
 * @author guill
 */
public class MythosSaga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        GameManager gameManager = new GameManager();
        
        gameManager.run();
    }
    
}
