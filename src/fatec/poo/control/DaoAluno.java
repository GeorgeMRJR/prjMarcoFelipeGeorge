package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Aluno;

public class DaoAluno {
    
    private Connection conn;
    
    public DaoAluno (Connection conn) {
        this.conn = conn;
    }
    
    public void inserir (Aluno aluno){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO tbAluno(cpf,Nome,DataNasc,Endereco,Numero,Bairro,Cidade,Estado,CEP,Telefone,Celular,Sexo,EstadoCivil,RG,Email,Escolaridade) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, aluno.getCPF());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getDataNasc());
            ps.setString(4, aluno.getEndereco());
            ps.setInt(5, aluno.getNumero());
            ps.setString(6, aluno.getBairro());
            ps.setString(7, aluno.getCidade());
            ps.setString(8, aluno.getEstado());
            ps.setString(9, aluno.getCEP());
            ps.setString(10, aluno.getTelefone());
            ps.setString(11, aluno.getCelular());
            ps.setString(12, aluno.getSexo());
            ps.setString(13, aluno.getEstadoCivil());
            ps.setString(14, aluno.getRG());
            ps.setString(15, aluno.getEmail());
            ps.setString(16, aluno.getEscolaridade());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Aluno aluno){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE tbAluno set Nome = ?,DataNasc = ?,Endereco = ?,Numero = ?,Bairro = ?,Cidade = ?,Estado = ?,CEP = ?,Telefone = ?,Celular = ?,Sexo = ?,EstadoCivil = ?,RG = ?,Email = ?,Escolaridade = ?" + "where cpf = ?");
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getDataNasc());
            ps.setString(3, aluno.getEndereco());
            ps.setInt(4, aluno.getNumero());
            ps.setString(5, aluno.getBairro());
            ps.setString(6, aluno.getCidade());
            ps.setString(7, aluno.getEstado());
            ps.setString(8, aluno.getCEP());
            ps.setString(9, aluno.getTelefone());
            ps.setString(10, aluno.getCelular());
            ps.setString(11, aluno.getSexo());
            ps.setString(12, aluno.getEstadoCivil());
            ps.setString(13, aluno.getRG());
            ps.setString(14, aluno.getEmail());
            ps.setString(15, aluno.getEscolaridade());
            ps.setString(16, aluno.getCPF());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Aluno consultar (String cpf) {
        Aluno a = null;
        
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT * from tbAluno where " + "cpf = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next() == true){          
                a = new Aluno(cpf, rs.getString("Nome"));
                a.setDataNasc(rs.getString("DataNasc"));
                a.setEndereco(rs.getString("Endereco"));
                a.setNumero(Integer.parseInt(rs.getString("Numero")));
                a.setBairro(rs.getString("Bairro"));
                a.setCidade(rs.getString("Cidade"));
                a.setEstado(rs.getString("Estado"));
                a.setCEP(rs.getString("CEP"));
                a.setTelefone(rs.getString("Telefone"));
                a.setCelular(rs.getString("Celular"));            
                a.setSexo(rs.getString("Sexo"));            
                a.setEstadoCivil(rs.getString("EstadoCivil"));            
                a.setRG(rs.getString("RG"));            
                a.setEmail(rs.getString("Email"));            
                a.setEscolaridade(rs.getString("Escolaridade"));            
            }     
        } catch (SQLException ex) {
            System.out.println(ex.toString()); 
        }
        return (a);
    }
    public void excluir(Aluno aluno){
            PreparedStatement ps = null;
            try{
                ps = conn.prepareStatement("DELETE FROM tbAluno where cpf = ?");
                
                ps.setString(1, aluno.getCPF());
                
                ps.execute();
            } catch (SQLException ex) {
                System.out.println(ex.toString());   
            }
    }
}
