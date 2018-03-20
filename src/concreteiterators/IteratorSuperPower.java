/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concreteiterators;

import com.sun.xml.internal.ws.util.StringUtils;
import java.util.Iterator;
import interfaces.IIterator;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;

/**
 *
 * @author Win-7
 */
public class IteratorSuperPower implements java.util.Iterator {

    private ArrayList<Aluno> list;
    private String property;
    private String operation;
    private String value;
    private int position = 0;
    private Method method;
    
    public IteratorSuperPower(ArrayList<Aluno> list, String property, String operation, String value) {
        this.list = list;
        this.property = property;
        this.operation = operation;
        this.value = value; 
        
        try { 
            this.method = Aluno.class.getMethod("get" + (property.substring(0, 1).toUpperCase() + property.substring(1)));
        } catch (NoSuchMethodException | SecurityException ex) {
            ex.printStackTrace();
        }
    }
        
    private boolean operate(String operation, String methodValue, String value) {
        switch(operation) {
            case "==" :  return methodValue.equalsIgnoreCase(value); 
            case ">"  :  return methodValue.compareTo(value) > 0; 
            case "<"  :  return methodValue.compareTo(value) < 0; 
            case "!"  :  return ! methodValue.equalsIgnoreCase(value); 
        }
        return false;
    }

    private Aluno evaluate(Aluno aluno) {
        try {           
            String returnedValue = (String) method.invoke(aluno);

            if(this.operate(operation, returnedValue, value))
                return aluno;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }   
    
    @Override
    public boolean hasNext() {
        Aluno aluno = null;
        
        if(position > list.size())
            return false;
        
        while(position < list.size())
            if((aluno = evaluate(list.get(position++))) != null) {
                position--;
                return true;
            }
        
        return false;
    }

    @Override
    public Object next() {
        return list.get(position++);
    }
}