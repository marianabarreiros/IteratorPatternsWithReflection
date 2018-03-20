/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Win-7
 */
public class Aluno {
    private String nome;
    private char genero;
    private double nota;

    public Aluno(String nome, char genero, double nota) {
        this.nome = nome;
        this.genero = genero;
        this.nota = nota;
    }

    public String getNome() {return nome;}
    public char getGenero() {return genero;}
    public double getNota() {return nota;}
    
    
}
