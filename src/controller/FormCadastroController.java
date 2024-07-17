package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FormCadastroView;

public class FormCadastroController {
    
    private FormCadastroView view;

    public FormCadastroController(FormCadastroView view) {
        this.view = view;
    }

    public FormCadastroView getView() {
        return view;
    }

    public void setView(FormCadastroView view) {
        this.view = view;
    }
    
    public void salvaUsuario(){
        
      String usuario = view.getjTextFieldUsuario().getText();
       String senha = view.getjPasswordFieldSenha().getText();
        
        
        Usuario usuarioXandi = new Usuario(usuario, senha);
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuariodao = new UsuarioDAO(conexao);
            usuariodao.insert(usuarioXandi);
            
            JOptionPane.showMessageDialog(null, "Uusario Salvo Com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastroView.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
