/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Aluno - Gti-Ads
 */
public class Instrutor extends Pessoa
{
    private String Formacao;
    private String AreaAtuacao;
    private ArrayList<Turma> turmas = new ArrayList<Turma>();

    public Instrutor(String CPF, String Nome) {
        super(CPF, Nome);
    }


    public void setFormacao(String Formacao) {
        this.Formacao = Formacao;
    }

    
    public void setAreaAtuacao(String AreaAtuacao) {
        this.AreaAtuacao = AreaAtuacao;
    }
    
    public void addTurma(Turma turma)
    {
        turmas.add ( turma );
    }

    public String getFormacao() {
        return Formacao;
    }

    public String getAreaAtuacao() {
        return AreaAtuacao;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }
    
    
    
    
}
