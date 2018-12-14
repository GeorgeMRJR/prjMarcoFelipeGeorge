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
public class Aluno extends Pessoa
{
   private String Escolaridade;

    public Aluno(String CPF, String Nome) {
        super(CPF, Nome);
    }


    public void setEscolaridade(String Escolaridade) {
        this.Escolaridade = Escolaridade;
    }

    public String getEscolaridade() {
        return Escolaridade;
    }

    
   
    
}
