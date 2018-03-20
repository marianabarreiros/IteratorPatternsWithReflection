/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import concreteiterators.IteratorSuperPower;
import interfaces.IIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Aluno;

/**
 *
 * @author Win-7
 */
public class RunApp {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList();
        
        alunos.add(new Aluno("Alex",'M',10));
        alunos.add(new Aluno("Mariana",'F',9));
        alunos.add(new Aluno("Flavia",'F',9.5));
        alunos.add(new Aluno("Henrique",'M',5));
        
        Iterator i = new IteratorSuperPower((ArrayList<Aluno>) alunos, "nome", ">", "Alex");

        while(i.hasNext()) {
            Aluno a = (Aluno) i.next();
            System.out.println(a.getNome());
        }
    }
}
