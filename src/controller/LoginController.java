package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.LoginView;
import view.MenuView;

public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
       // buscar um usuario da view
      // verificar se existe no banco de dados
      // se existir direciona ao menu
      
      String usuario = view.getjTextFieldUsuario().getText();
      String senha = view.getjPasswordFieldSenha().getText();
      
      Usuario usuarioautenticar = new Usuario(usuario,senha);
       // verificar se existe no banco de dados
       
       Connection conexao = new Conexao().getConnection();
       UsuarioDAO usuariodao = new UsuarioDAO(conexao);
      
       boolean existe = usuariodao.existeNoBancoPorUsuarioESenha(usuarioautenticar);
       
        if (existe) {
        MenuView teladeMenu = new MenuView();
        teladeMenu.setVisible(true);            
        }else{
            JOptionPane.showMessageDialog(view, "Usuario ou senha invalidos");
        }

    }
    
    
}
