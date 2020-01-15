package innui.contextos;

import static innui.contextos.a_eles.clonar_objeto;
import java.time.Instant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * Implementación de LinkedHashMap que agrega iteradores que permiten accesos por clave numérica.
 */
public class entes extends LinkedHashMap<String, i_eles> implements i_eles {
    /**
     * Atributo que trata a esta instancia de entes como un i_ele
     */
    public i_eles i_ele;
    /**
     * Iterador para recorrer los valores de las entes
     */
    public Iterator<i_eles> iterador_valor = null;
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
     * Construye el objeto ente y se lo asigna a i_ele.
     */
    public entes() {
        i_ele = a_eles.crear(this);
    }
    /**
     * Crea un nuevo objeto, clona los componentes del LikedHashMap actual y los asigna al nuevo.
     * @return El nuevo objeto
     */
    @Override
    public i_eles clone() {
        entes ente = new entes();
        try {
            for (Entry<String, i_eles> entrada : entrySet()) {
                ente.put(entrada.getKey(), entrada.getValue().clone());
            }
            if (con_su != null) {
                ente.con_su = (entes) con_su.clone();
            }
            ente.iterador_valor = (Iterator<i_eles>) clonar_objeto(iterador_valor);
            ente.posicion_valor = posicion_valor;
            ente.tam = tam;
            ente.con_su = (entes) con_su.clone();
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
    public i_eles put(String clave, i_eles ele) {
        return poner(clave, ele);
    }
    /**
     * Localiza el elemento de la clave indicada
     * @param clave Clave que buscar
     * @return El dato correspondiente con la clave buscada o i_eles.nulo().
     */
    public i_eles get(String clave) {
        i_eles ele = super.get(clave);
        if (ele != null) {
            return ele;
        } else {
            return a_eles.nulo();
        }
    }
    /**
     * Alias de get
     * @param clave Clave que buscar
     * @return El dato correspondiente con la clave buscada o i_eles.nulo().
     */
    public i_eles leer(String clave) {
        return get(clave);
    }
    /**
     * Llama al método poner del elemento encontrado, o de un elemento eles.nulo(), y lo almacena en el mapa.
     * @param clave Clave que guardar del elemento existente en el mapa, o del nuevo elemento.
     * @param ele Elemento que guardar
     * @return El elemento que se ha puesto en el mapa
     */
    public i_eles poner(String clave, i_eles ele) {
        i_eles ele_encontrado = leer(clave);
        ele_encontrado.poner(ele);
        super.put(clave, ele_encontrado);
        return ele_encontrado;
    }
    /**
     * Almacena un elemento en el mapa con una clave de texto a partir del Instant.now() en el que se pone.
     * @param ele
     * @return 
     */
    public i_eles poner(i_eles ele) {
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
     * @return El siguiente elemento o i_eles.nulo()
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
     * @return El elemento buscado o i_eles.nulo
     */
    public i_eles leer(long pos) {
        i_eles retorno = a_eles.nulo();
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
            for (i_eles valor : this.values()) {
                if (posicion_valor == pos) {
                    retorno = valor;
                } else {
                    posicion_valor = posicion_valor + 1;
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

}