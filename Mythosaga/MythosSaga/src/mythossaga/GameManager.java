
package mythossaga;


import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameManager {
    public void run() throws IOException, ClassNotFoundException {
        Sistema system = new Sistema();
        Database data;
        File file = new File("database/data.data");

        if(file.exists()) {
            data = this.loadData();
        } else {
            data = new Database();
            data.inicializarDatabase();
        }

        try {
            system.menuInicio(data);
        } catch (IOException ex) {
            Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            data.saveData();
        }
        
    }

    public Database loadData() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("database/data.data"));
        Database data = (Database) in.readObject();
        in.close();
        return data;
    }

}
