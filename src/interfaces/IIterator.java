/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Win-7
 */
public interface IIterator {
    void first();
    Object next();
    boolean hasNext();
    boolean isDone();
    Object currentItem();
    
}
