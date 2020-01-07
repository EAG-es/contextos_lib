/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.contextos;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Lista enlazada con limitación de tamaño
 */
public class filas extends LinkedList<a_eles> {
    public int max_tam = 0;
    /**
     * Mapa de entidades con el que estender los atributos de la instancia.
     */
    public entes con_su = null;
    /**
     * Crea un nuevo objeto, clona los componentes del LikedHashMap actual y los asigna al nuevo.
     * @return El nuevo objeto
     */
    @Override
    public filas clone() {
        filas fila = new filas();
        try {
            for (a_eles entrada : this) {
                fila.add(entrada.clone());
            }
            if (con_su != null) {
                fila.con_su = con_su.clone();
            }
            fila.max_tam = max_tam;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return fila;
    }    
    /**
     * Poner el tamaño máximo
     * @param max_tam Tamaño máximo.
     */
    public void poner_max_tam(int max_tam) {
        this.max_tam = max_tam;
    }
    /**
     * Igual que addFirst
     * @param e elemento
     */
    @Override
    public void push(a_eles e) {
        addFirst(e);
    }
    /**
     * Añade un elemento al principio (y elimina uno del final si se alcanza max_tam (si no es 0))
     * @param e elemento
     */
    @Override
    public void addFirst(a_eles e) {
        int tam = size();
        if (tam > max_tam
                && tam != 0) {
            pollLast();
        }
        super.addFirst(e);
    }
    /**
     * Añade un elemento al final (y elimina uno del inicio si se alcanza max_tam (si no es 0))
     * @param e elemento
     */
    @Override
    public void addLast(a_eles e) {
        int tam = size();
        if (tam > max_tam
                && tam != 0) {
            pollFirst();
        }
        super.addLast(e);
    }
    /**
     * Igual que addLast
     * @param e elemento
     * @return true
     */
    @Override
    public boolean add(a_eles e) {
        addLast(e);
        return true;
    }
    /**
     * Añade un elemento en la posición i (dentro de max_tam si no es 0)
     * @param index posicion
     * @param e elemento
     */
    @Override
    public void add(int index, a_eles e) {
        int tam = size();
        if (index < max_tam 
                || tam == 0) {
            if (tam > max_tam
                    && tam != 0) {
                remove(index);
            }
            super.add(index, e);
        }
    }
    /**
     * Igual que addLast
     * @param e elemento
     * @return true
     */
    @Override
    public boolean offer(a_eles e) {
        addLast(e);
        return true;
    }
    /**
     * Igual que addFirst
     * @param e elemento
     * @return true
     */
    @Override
    public boolean offerFirst(a_eles e) {
        addFirst(e);
        return true;
    }
    /**
     * Igual que addLast
     * @param e elemento
     * @return true
     */
    @Override
    public boolean offerLast(a_eles e) {
        addLast(e);
        return true;
    }
    /**
     * Añade o reemplaza un elemento en la posición i (dentro de max_tam si no es 0)
     * @param index posicion
     * @param e elemento
     * @return el elemento del parámetro, o a_eles.nulo() si el indice no es valido
     */
    @Override
    public a_eles set(int index, a_eles e) {
        a_eles ret = a_eles.nulo();
        int tam = size();
        if (index < max_tam 
                || tam == 0) {
            ret = super.set(index, e);
        }
        return ret;
    }
    /**
     * Utiliza add para los elementos de una coleccion
     * @param c coleccion
     * @return true
     */
    @Override
    public boolean addAll(Collection<? extends a_eles> c) {
        for (a_eles elemento: c) {
            add(elemento);
        }
        return true;
    }
}
