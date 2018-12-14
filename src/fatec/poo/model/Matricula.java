/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

/**
 *
 * @author Aluno - Gti-Ads
 */
public class Matricula {

    private String Data;
    private int QtdeFaltas;
    private double Nota;
    private Turma turma;

    public Matricula(String Data) {
        this.Data = Data;
    }

    public void setQtdeFaltas(int QtdeFaltas) {
        this.QtdeFaltas = QtdeFaltas;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getData() {
        return Data;
    }

    public int getQtdeFaltas() {
        return QtdeFaltas;
    }

    public double getNota() {
        return Nota;
    }

    public Turma getTurma() {
        return turma;
    }
    
    
    
    public void EmitirCarne(){
    
    }
    
}
