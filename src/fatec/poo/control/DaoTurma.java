/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;
import fatec.poo.model.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fatec.poo.model.Curso;
import java.util.ArrayList;

/**
 *
 * @author nobum
 */
public class DaoTurma 
{

    private Connection con;

    public DaoTurma(Connection con)
    {
        this.con = con;
    }

    public void inserir(Turma turma, Curso curso)
    {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO tbTurma(SiglaTurma, DescricaoTurma, QtdeVagasTurma, PeriodoTurma, DataInicioTurma , DataTerminoTurma, SiglaCursoTurma) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, turma.getSiglaTurma());
            ps.setString(2, turma.getDescricao());
            ps.setInt(3, turma.getQtdVagas());
            ps.setString(4, turma.getPeriodo());
            ps.setString(5, turma.getDataInicio());
            ps.setString(6, turma.getDataTermino());
            ps.setString(7, curso.getSigla());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
        public void alterar(Turma turma) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE tbTurma set  DescricaoTurma =?, QtdeVagasTurma =?, PeriodoTurma =?, DataInicioTurma =?, DataTerminoTurma =?"
                    + "where SiglaTurma = ?");

            ps.setString(1, turma.getDescricao());
            ps.setInt(2, turma.getQtdVagas());
            ps.setString(3, turma.getPeriodo());
            ps.setString(4, turma.getDataInicio());
            ps.setString(5, turma.getDataTermino());
            ps.setString(6, turma.getSiglaTurma());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Turma consultar(String sigla) {
        Turma t = null;

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT * from tbTurma where "
                    + "SiglaTurma = ?");

            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) 
            {
                t = new Turma(sigla, rs.getString("DescricaoTurma"));
                t.setPeriodo(rs.getString("PeriodoTurma"));
                t.setQtdVagas(rs.getInt("QtdeVagasTurma"));
                t.setDataInicio(rs.getString("DataInicioTurma"));
                t.setDataTermino(rs.getString("DataTerminoTurma"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (t);
    }

    public void excluir(Turma turma) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("DELETE FROM tbTurma where SiglaTurma = ?");

            ps.setString(1, turma.getSiglaTurma());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
         public ArrayList<String> ListarTurmas()
    {
     ArrayList<String> turmas = new ArrayList<String>();
     PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT SiglaTurma from tbTurma"); 

            ResultSet rs = ps.executeQuery();

            while (rs.next() == true) 
            {
                turmas.add(rs.getString("SiglaTurma"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
     
     return turmas;
    }
        
}

