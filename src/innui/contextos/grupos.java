package innui.contextos;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class grupos extends LinkedHashSet<i_eles> implements i_eles {
    /**
     * Atributo que trata a esta instancia de entes como un i_ele
     */
    public i_eles i_ele;
    /**
     * Iterador del grupo
     */
    public Iterator<i_eles> iterador_valor = null;
    /**
     * Posición actual del iterador
     */
    public Long posicion_valor = 0L;
    /**
     * Número de elementos del gruppo
     */
    public Long tam = 0L;
    /**
     * Mapa de entidades con el que extender los atributos de la instancia.
     */
    public entes con_su = null;
    /**
     * Construye el objeto y se lo asigna a i_ele.
     */
    public grupos() {
        i_ele = a_eles.crear(this);
    }
    @Override
    public grupos clone() {
        grupos grupo = new grupos();
        try {
            for (i_eles entrada : this) {
                add(entrada.clone());
            }
            if (iterador_valor != null) {
                grupo.iterador_valor = (Iterator<i_eles>) a_eles.clonar_objeto(iterador_valor);
            }
            grupo.posicion_valor = posicion_valor;
            grupo.tam = tam;
            if (con_su != null) {
                grupo.con_su = (entes) con_su.clone();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return grupo;
    }
    /**
     * Alias de add
     * @param ele
     * @return 
     */
    public i_eles poner(i_eles ele) {
        add(ele);
        return ele;
    }
    /**
     * Alias de addAll
     * @param eles_array
     * @return 
     */
    public i_eles poner_grupo(i_eles ... eles_array)
    {
        addAll(Arrays.asList(eles_array));
        return elems.verdad();
    }
    /**
     * Reinicia los valores de los atributos utilizados para el recorrido del mapa con claves numéricas.
     */
    public void iniciar() {
        iterador_valor = this.iterator();
        posicion_valor = 0L;
        tam = Long.valueOf(size());
    }
    /**
     * Lee el siguiente elemento del mapa. con el último iterador generado.
     * @return El siguiente elemento o a_eles.nulo()
     */
    public i_eles leer_siguiente() {
        i_eles retorno = a_eles.nulo();
        if (iterador_valor == null) {
            iniciar();
        }
        if (iterador_valor.hasNext()) {
            retorno = iterador_valor.next();
            posicion_valor = posicion_valor + 1;
        }
        return retorno;
    }
    /**
     * Lee el elemento del mapa en la posición indicada
     * @param pos Posición donde leer.
     * @return El elemento buscado o a_eles.nulo
     */
    public i_eles leer(long pos) {
        i_eles retorno = elems.nulo();
        if (pos >= 0
                || pos < size()) {
            if (tam != size()) {
                iniciar();
            }
            if (iterador_valor != null) {
                if (pos < posicion_valor) {
                    iterador_valor = null;
                }
            }
            if (iterador_valor == null) {
                iniciar();
            }
            while (true) {
                if (iterador_valor.hasNext()) {
                    if (posicion_valor == pos) {
                        retorno = iterador_valor.next();
                        break;
                    } else {
                        posicion_valor = posicion_valor + 1;
                        iterador_valor.next();
                    }
                } else {
                    break;
                }
            }
        }
        return retorno;
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