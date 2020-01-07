package innui.contextos;

import static innui.contextos.a_eles.clonar_objeto;
import java.time.Instant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * Implementación de LinkedHashMap que agrega iteradores que permiten accesos por clave numérica.
 */
public class entes extends LinkedHashMap<String, a_eles> {
    /**
     * Iterador para recorrer los valores de las entes
     */
    public Iterator<a_eles> iterador_valor = null;
    /**
     * Posición actual en el iterador de valores
     */
    public Long posicion_valor = 0L;
    /**
     * Tamaño del ente cuando se obtuvo el iterador (detectar incrementos de tamaño para regenerar el iterador)
     */
    public Long tam = 0L;
    /**
     * Mapa de entidades con el que estender los atributos de la instancia.
     */
    public entes con_su = null;

    /**
     * Crea un nuevo objeto, clona los componentes del LikedHashMap actual y los asigna al nuevo.
     * @return El nuevo objeto
     */
    @Override
    public entes clone() {
        entes ente = new entes();
        try {
            for (Entry<String, a_eles> entrada : entrySet()) {
                ente.put(entrada.getKey(), entrada.getValue().clone());
            }
            if (con_su != null) {
                ente.con_su = con_su.clone();
            }
            ente.iterador_valor = (Iterator<a_eles>) clonar_objeto(iterador_valor);
            ente.posicion_valor = posicion_valor;
            ente.tam = tam;
            ente.con_su = con_su.clone();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ente;
    }
    /**
     * Alias de poner
     * @param clave Clave que poner
     * @param ele Dato que poner
     * @return El elemento que poner
     */
    public a_eles put(String clave, a_eles ele) {
        return poner(clave, ele);
    }
    /**
     * Localiza el elemento de la clave indicada
     * @param clave Clave que buscar
     * @return El dato correspondiente con la clave buscada o a_eles.nulo().
     */
    public a_eles get(String clave) {
        a_eles ele = super.get(clave);
        if (ele != null) {
            return ele;
        } else {
            return a_eles.nulo();
        }
    }
    /**
     * Alias de get
     * @param clave Clave que buscar
     * @return El dato correspondiente con la clave buscada o a_eles.nulo().
     */
    public a_eles leer(String clave) {
        return get(clave);
    }
    /**
     * Llama al método poner del elemento encontrado, o de un elemento eles.nulo(), y lo almacena en el mapa.
     * @param clave Clave que guardar del elemento existente en el mapa, o del nuevo elemento.
     * @param ele Elemento que guardar
     * @return El elemento que se ha puesto en el mapa
     */
    public a_eles poner(String clave, a_eles ele) {
        a_eles ele_encontrado = leer(clave);
        ele_encontrado.poner(ele);
        super.put(clave, ele_encontrado);
        return ele_encontrado;
    }
    /**
     * Almacena un elemento en el mapa con una clave de texto a partir del Instant.now() en el que se pone.
     * @param ele
     * @return 
     */
    public a_eles poner(a_eles ele) {
        Instant instant = Instant.now();
        String clave = instant.toString();
        int i = 1;
        while (true) {
            if (containsKey(clave)) {
                clave = clave + "-" + i;
            } else {
                poner(clave, ele);
                break;
            }
            i = i + 1;
        }
        return ele;
    }
    /**
     * Reinicia los valores de los atributos utilizados para el recorrido del mapa con claves numéricas.
     */
    public void iniciar() {
        iterador_valor = this.values().iterator();
        posicion_valor = 0L;
        tam = Long.valueOf(size());
    }
    /**
     * Lee el siguiente elemento del mapa. con el último iterador generado.
     * @return El siguiente elemento o a_eles.nulo()
     */
    public a_eles leer_siguiente() {
        a_eles retorno = a_eles.nulo();
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
        a_eles retorno = a_eles.nulo();
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
            for (a_eles valor : this.values()) {
                if (posicion_valor == pos) {
                    retorno = valor;
                } else {
                    posicion_valor = posicion_valor + 1;
                }
            }
        }
        return retorno;
    }
}