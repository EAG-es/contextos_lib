package innui.contextos;


import java.time.Instant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class entes extends LinkedHashMap<String, a_eles> implements Cloneable {
    public Iterator<a_eles> iterador_valor = null;
    public Long posicion_valor = 0L;
    public Long tam_valor = 0L;
    public Iterator<String> iterador_clave = null;
    public Long posicion_clave = 0L;
    public Long tam_clave = 0L;
    public entes con_su = null;

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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ente;
    }
    
    public a_eles put(String clave, a_eles ele) {
        return poner(clave, ele);
    }
    
    public a_eles get(String clave) {
        a_eles ele = super.get(clave);
        if (ele != null) {
            return ele;
        } else {
            return a_eles.nulo();
        }
    }
    
    public a_eles leer(String clave) {
        return get(clave);
    }

    public a_eles poner(String clave, a_eles ele) {
        a_eles ele_encontrado = leer(clave);
        ele_encontrado.poner(ele);
        super.put(clave, ele_encontrado);
        return ele_encontrado;
    }

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

    public void iniciar() {
        iterador_valor = this.values().iterator();
        posicion_valor = 0L;
        tam_valor = Long.valueOf(size());
    }

    public a_eles leer_siguiente() {
        a_eles retorno = elems.nulo();
        if (iterador_valor == null) {
            iterador_valor = this.values().iterator();
            posicion_valor = 0L;
            tam_valor = Long.valueOf(size());
        }
        if (iterador_valor.hasNext()) {
            retorno = iterador_valor.next();
            posicion_valor = posicion_valor + 1;
        }
        return retorno;
    }
    
    public a_eles leer(long pos) {
        a_eles retorno = elems.nulo();
        if (pos >= 0
                || pos < size()) {
            if (iterador_valor != null) {
                if (tam_valor != size()
                        || pos < posicion_valor) {
                    iterador_valor = null;
                }
            }
            if (iterador_valor == null) {
                iterador_valor = this.values().iterator();
                posicion_valor = 0L;
                tam_valor = Long.valueOf(size());
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

    public String leer_clave (long pos){
        String retorno = null;
        if (pos >= 0
                || pos < size()) {
            if (iterador_clave != null) {
                if (tam_clave != size()
                        || pos < posicion_clave) {
                    iterador_clave = null;
                }
            }
            if (iterador_clave == null) {
                iterador_clave = this.keySet().iterator();
                posicion_clave = 0L;
                tam_clave = Long.valueOf(size());
            }
            for (String clave : this.keySet()) {
                if (posicion_clave == pos) {
                    retorno = clave;
                } else {
                    posicion_clave = posicion_clave + 1;
                }
            }
        }
        return retorno;
    }
}