package innui.contextos;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class grupos extends LinkedHashSet<a_eles> implements Cloneable {
    public Iterator<a_eles> iterador_valor = null;
    public Long posicion_valor = 0L;
    public Long tam = 0L;
    public entes con_su = null;

    @Override
    public grupos clone() {
        grupos grupo = new grupos();
        try {
            for (a_eles entrada : this) {
                add(entrada.clone());
            }
            if (iterador_valor != null) {
                grupo.iterador_valor = (Iterator<a_eles>) a_eles.clonar_objeto(iterador_valor);
            }
            grupo.posicion_valor = posicion_valor;
            grupo.tam = tam;
            if (con_su != null) {
                grupo.con_su = con_su.clone();
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
    public a_eles poner(a_eles ele) {
        add(ele);
        return ele;
    }
    /**
     * Alias de addAll
     * @param eles_array
     * @return 
     */
    public a_eles poner_grupo(a_eles ... eles_array)
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
    public a_eles leer_siguiente() {
        a_eles retorno = elems.nulo();
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
    public a_eles leer(long pos) {
        a_eles retorno = elems.nulo();
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

}