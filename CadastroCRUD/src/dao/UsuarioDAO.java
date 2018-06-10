package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Usuario;


/**
 * @author Francisco Chaves
 * 
 */
public class UsuarioDAO {

    public UsuarioDAO() {
        File file = arquivo;
        file.mkdir();
    }

    private final String diretorio = System.getProperty("user.home");
    // String userDir = System.getProperty("user.dir");// Uns dos caminhos padrão oferecidos pela JVM 
    private final String separator = System.getProperty("file.separator"); //SEPARADOR DO SISTEMA OPERACIONAL ATUAL  
    // File arquivo = new File(userDir + separator + "guardarJogo");
    private final File arquivo = new File(diretorio + separator + "guardarUsuer");
    private final String caminho = arquivo + separator + "objeto.ser";

    public void salvarUsuarios(ArrayList<Usuario> usuarios) {
        try {
            FileOutputStream fos = new FileOutputStream(caminho);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(usuarios);
            oos.close();

        } catch (Exception ex) {
            throw new DAOException();
        }
    }

    public ArrayList<Usuario> recuperarUsuario(){

        ArrayList<Usuario> leitura = new ArrayList<Usuario>();

        try {
            FileInputStream in = new FileInputStream(caminho);
            ObjectInputStream reader = new ObjectInputStream(in);
            
            leitura = (ArrayList<Usuario>) reader.readObject();
            
            reader.close();
            
        } catch (Exception ex) {
            
            System.out.print(ex.getMessage());
            
        } 
        return leitura;
    }
}
