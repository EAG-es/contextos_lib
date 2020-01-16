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
public class filas extends LinkedList<i_eles> implements i_eles {
    /**
     * Atributo que trata a esta instancia de entes como un i_ele
     */
    public i_eles i_ele;
    /**
     * Tamaño máximo que se guarda. 0: no hay límite.
     */
    public int max_tam = 0;
    /**
     * Mapa de entidades con el que extender los atributos de la instancia.
     */
    public entes con_su = null;
    /**
     * Construye el objeto y se lo asigna a i_ele.
     */
    public filas() {
        i_ele = a_eles.crear(this);
    }
    /**
     * Crea un nuevo objeto, clona los componentes del LikedHashMap actual y los asigna al nuevo.
     * @return El nuevo objeto
     */
    @Override
    public filas clone() {
        filas fila = new filas();
        try {
            for (i_eles entrada : this) {
                fila.add(entrada.clone());
            }
            if (con_su != null) {
                fila.con_su = (entes) con_su.clone();
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
    public void push(i_eles e) {
        addFirst(e);
    }
    /**
     * Añade un elemento al principio (y elimina uno del final si se alcanza max_tam (si no es 0))
     * @param e elemento
     */
    @Override
    public void addFirst(i_eles e) {
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
    public void addLast(i_eles e) {
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
    public boolean add(i_eles e) {
        addLast(e);
        return true;
    }
    /**
     * Añade un elemento en la posición i (dentro de max_tam si no es 0)
     * @param index posicion
     * @param e elemento
     */
    @Override
    public void add(int index, i_eles e) {
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
    public boolean offer(i_eles e) {
        addLast(e);
        return true;
    }
    /**
     * Igual que addFirst
     * @param e elemento
     * @return true
     */
    @Override
    public boolean offerFirst(i_eles e) {
        addFirst(e);
        return true;
    }
    /**
     * Igual que addLast
     * @param e elemento
     * @return true
     */
    @Override
    public boolean offerLast(i_eles e) {
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
    public i_eles set(int index, i_eles e) {
        i_eles ret = a_eles.nulo();
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
    public boolean addAll(Collection<? extends i_eles> c) {
        for (i_eles elemento: c) {
            add(elemento);
        }
        return true;
    }

    @Override
    public <tipos> tipos dar() {
        return i_ele.dar();
    }

    @Override
    public <tipos> tipos dar(i_eles ret) {
        return i_ele.dar(ret);
    }

    @Override
    public i_eles poner(Object dato) {
        return i_ele.poner(dato);
    }

    @Override
    public String leer_texto() {
        return i_ele.leer_texto();
    }

    @Override
    public Long leer_entero() {
        return i_ele.leer_entero();
    }

    @Override
    public Double leer_decimal() {
        return i_ele.leer_decimal();
    }

    @Override
    public Character leer_letra() {
        return i_ele.leer_letra();
    }

    @Override
    public Boolean es_nulo() {
        return i_ele.es_nulo();
    }

    @Override
    public Boolean es() {
        return i_ele.es();
    }

    @Override
    public Boolean no_es() {
        return i_ele.no_es();
    }

    @Override
    public i_eles si_o_no(Long umbral_si) {
        return i_ele.si_o_no(umbral_si);
    }

    @Override
    public Boolean leer_bool() {
        return i_ele.leer_bool();
    }

    @Override
    public acciones leer_accion() {
        return i_ele.leer_accion();
    }

    @Override
    public i_eles poner(double dato) {
        return i_ele.poner(dato);
    }

    @Override
    public i_eles poner(float dato) {
        return i_ele.poner(dato);
    }

    @Override
    public i_eles poner(int dato) {
        return i_ele.poner(dato);
    }

    @Override
    public i_eles poner(byte dato) {
        return i_ele.poner(dato);
    }

    @Override
    public i_eles poner(char dato) {
        return i_ele.poner(dato);
    }

    @Override
    public i_eles poner(boolean dato) {
        return i_ele.poner(dato);
    }

    @Override
    public i_eles si() {
        return i_ele.si();
    }

    @Override
    public i_eles si(Long valor) {
        return i_ele.si(valor);
    }

    @Override
    public i_eles y(i_eles ele) {
        return i_ele.y(ele);
    }

    @Override
    public i_eles o(i_eles ele) {
        return i_ele.o(ele);
    }

    @Override
    public i_eles xor(i_eles ele) {
        return i_ele.xor(ele);
    }

    @Override
    public i_eles no() {
        return i_ele.no();
    }

    @Override
    public i_eles no(Long valor) {
        return i_ele.no(valor);
    }

    /**
     * alias de add, con retorno distinto.
     * @param ele
     * @return ele si tiene éxito; a_eles.nulo si hay error.
     */
    @Override
    public i_eles poner(i_eles ele) {
        if (add(ele)) {
            return ele;
        } else {
            return a_eles.nulo();
        }
    }

    @Override
    public String leer_nombre() {
        return i_ele.leer_nombre();
    }

    @Override
    public i_eles poner_nombre(String nombre) {
        return i_ele.poner_nombre(nombre);
    }

    @Override
    public <crear_tipos> i_eles crear_nuevo() {
        return i_ele.crear_nuevo();
    }
    
}
