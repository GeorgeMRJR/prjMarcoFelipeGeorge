package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Instrutor;
import fatec.poo.model.Pessoa;
import java.util.ArrayList;

public class DaoInstrutor {

    private Connection conn;

    public DaoInstrutor(Connection conn) {
        this.conn = conn;
    }

    public void Inserir(Instrutor instrutor) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO tbInstrutor(cpf,NomeInstrutor,SexoInstrutor,EnderecoInstrutor,BairroInstrutor,CidadeInstrutor,EstadoInstrutor,RgInstrutor,FormacaoInstrutor,AreaAtuacaoInstrutor,EmailInstrutor,DataNascto,EstadoCivilProfessor,NumeroInstrutor,CEPInstrutor,TelInstrutor,CelularInstrutor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, instrutor.getCPF());
            ps.setString(2, instrutor.getNome());
            ps.setString(3, instrutor.getSexo());
            ps.setString(4, instrutor.getEndereco());
            ps.setString(5, instrutor.getBairro());
            ps.setString(6, instrutor.getCidade());
            ps.setString(7, instrutor.getEstado());
            ps.setString(8, instrutor.getRG());
            ps.setString(9, instrutor.getFormacao());
            ps.setString(10, instrutor.getAreaAtuacao());
            ps.setString(11, instrutor.getEmail());
            ps.setString(12, instrutor.getDataNasc());
            ps.setString(13, instrutor.getEstadoCivil());
            ps.setInt(14, instrutor.getNumero());
            ps.setString(15, instrutor.getCEP());
            ps.setString(16, instrutor.getTelefone());
            ps.setString(17, instrutor.getCelular());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Instrutor instrutor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbInstrutor set NomeInstrutor = ?,SexoInstrutor = ?,EnderecoInstrutor = ?,BairroInstrutor = ?,CidadeInstrutor = ?,EstadoInstrutor = ?,RgInstrutor = ?,FormacaoInstrutor = ?,AreaAtuacaoInstrutor = ?,EmailInstrutor = ?,DataNascto = ?,EstadoCivilProfessor = ?,NumeroInstrutor = ?,CEPInstrutor = ?,TelInstrutor = ?,CelularInstrutor = ?"
                    + "where cpf = ?");

            ps.setString(1, instrutor.getNome());
            ps.setString(2, instrutor.getSexo());
            ps.setString(3, instrutor.getEndereco());
            ps.setString(4, instrutor.getBairro());
            ps.setString(5, instrutor.getCidade());
            ps.setString(6, instrutor.getEstado());
            ps.setString(7, instrutor.getRG());
            ps.setString(8, instrutor.getFormacao());
            ps.setString(9, instrutor.getAreaAtuacao());
            ps.setString(10, instrutor.getEmail());
            ps.setString(11, instrutor.getDataNasc());
            ps.setString(12, instrutor.getEstadoCivil());
            ps.setInt(13, instrutor.getNumero());
            ps.setString(14, instrutor.getCEP());
            ps.setString(15, instrutor.getTelefone());
            ps.setString(16, instrutor.getCelular());
            ps.setString(17, instrutor.getCPF());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Instrutor consultar(String cpf) {
        Instrutor i = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbInstrutor where "
                    + "cpf = ?");

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) 
            {
                i = new Instrutor(cpf, rs.getString("NomeInstrutor"));
                i.setDataNasc(rs.getString("DataNascto"));
                i.setEndereco(rs.getString("EnderecoInstrutor"));
                i.setNumero(Integer.parseInt(rs.getString("NumeroInstrutor")));
                i.setBairro(rs.getString("BairroInstrutor"));
                i.setCidade(rs.getString("CidadeInstrutor"));
                i.setEstado(rs.getString("EstadoInstrutor"));
                i.setCEP(rs.getString("CEPInstrutor"));
                i.setTelefone(rs.getString("TelInstrutor"));
                i.setCelular(rs.getString("CelularInstrutor"));
                i.setSexo(rs.getString("SexoInstrutor"));
                i.setEstadoCivil(rs.getString("EstadoCivilProfessor"));
                i.setRG(rs.getString("RgInstrutor"));
                i.setEmail(rs.getString("EmailInstrutor"));
                i.setFormacao(rs.getString("FormacaoInstrutor"));
                i.setAreaAtuacao(rs.getString("AreaAtuacaoInstrutor"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (i);
    }

    public void excluir(Instrutor instrutor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbInstrutor where cpf = ?");

            ps.setString(1, instrutor.getCPF());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
         public ArrayList<String> ListarInstrutores()
    {
     ArrayList<String> instrutores = new ArrayList<String>();
     PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT NomeInstrutor from tbInstrutor"); 

            ResultSet rs = ps.executeQuery();

            while (rs.next() == true) 
            {
                instrutores.add(rs.getString("NomeInstrutor"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
     
     return instrutores;
    }
}
