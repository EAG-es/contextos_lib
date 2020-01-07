package innui.contextos;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;

/**
 * 
 */
public class contextos implements Cloneable, Serializable {
    /**
     * Prefijo para designar los nombre del contexto que son opcionales-
     */
    public static String k_op = "op:\""; //NOI18N
    /**
     * Mapa que almacena los elementos de nivel superior del contexto.
     */
    public entes mapa = null;
    /**
     * Lista con los siguientes niveles del contexto. Los niveles más altos son los más recientes (últimos).
     */
    public LinkedList<entes> mapas_pila = new LinkedList<>();
    /**
     * Mapa de entidades con el que estender los atributos de la instancia.
     */
    public entes con_su = null;
    /**
     * Clona el contexto
     * @return El nuevo objeto clonado
     * @throws CloneNotSupportedException 
     */
    @Override
    public contextos clone() throws CloneNotSupportedException {
        contextos contexto = new contextos();
        if (mapa != null) {
            for (Map.Entry<String, a_eles> entrada : mapa.entrySet()) {
                contexto.mapa.poner(entrada.getKey(), entrada.getValue().clone());
            }
        }
        for (entes submapa: mapas_pila) {
            contexto.mapas_pila.addLast(submapa.clone());
        }
        if (con_su != null) {
            contexto.con_su = (entes) con_su.clone();
        }
        return contexto;
    }
    /**
     * Pone un objeto de tipos en el contexto, si no es null (en ese caso lo elimina). Si ya existía, lo reemplaza.
     * @param <tipos> Tipo del dato
     * @param nombre nombre del elemento
     * @param dato valor del elemento
     * @return null si ha eliminado el elemento, o hay error al crearlo. retorna el elemento a_eles, si este se ha incorporado en el contexto
     */
    public <tipos> a_eles superponer(String nombre, tipos dato) {
        a_eles dato_eles = a_eles.nulo();
        if (mapa == null) {
            mapa = new entes();
        }
        if (dato == null) {
            mapa.remove(nombre);
        } else {
            if (dato instanceof a_eles) {
                mapa.poner(nombre, (a_eles) dato);
            } else {
                dato_eles = mapa.leer(nombre);
                if (dato_eles.es_nulo()) {
                    dato_eles = a_eles.<tipos>crear(nombre, dato);
                } else {
                    dato_eles.nombre = nombre;
                    dato_eles.poner(dato);
                }
                mapa.poner(nombre, dato_eles);
            }
        }
        return dato_eles;
    }
    /**
     * Pone un grupo de objetos de tipos en el contexto, si no es null (en ese caso lo elimina). Si ya existía, lo reemplaza.
     * @param <tipos> Tipo del dato
     * @param nombre nombre del grupo
     * @param tipos_array valores del grupo
     * @return a_eles.verdad() si tiene exito. else.falso() si hay errores.
     */
    public <tipos> a_eles superponer_grupo(String nombre, tipos ... tipos_array)
    {
        grupos grupo = new grupos();
        int i = 0;
        String nombre_en_grupo = ""; //NOI18N
        for (tipos tipo: tipos_array) {
            nombre_en_grupo = nombre + "[" + i + "]"; //NOI18N
            a_eles ele = a_eles.crear(tipo);
            ele.nombre = nombre_en_grupo;
            grupo.poner(ele);
            i = i + 1;
        }
        a_eles ele = a_eles.crear(grupo);
        a_eles retorno = superponer(nombre, ele);
        if (retorno == null) {
            return a_eles.falso();
        } else {
            return a_eles.verdad();
        }
    }
    /**
     * Pone un grupo de objetos a_eles en el contexto, si no es null (en ese caso lo elimina). Si ya existía, lo reemplaza.
     * @param nombre nombre del grupo
     * @param eles_array valores del grupo
     * @return a_eles.verdad() si tiene exito. else.falso() si hay errores.
     */
    public a_eles superponer_grupo(String nombre, a_eles ... eles_array)
    {
        grupos grupo = new grupos();
        grupo.poner_grupo(eles_array);
        a_eles ele = a_eles.crear(grupo);
        a_eles retorno = superponer(nombre, ele);
        if (retorno == null) {
            return a_eles.falso();
        } else {
            return a_eles.verdad();
        }
    }
    /**
     * pone elementos en el contexto
     * @param eles_array Array con claves (par) y valores (impar)
     * Las posiciones pares son el nombre.
     * Las posiciones impares son el valor. 
     * Si un nombre no existe en el contexto, se crea; a menos que el a superponer valor sea null
     * @return true si es correcto, false si hay error.
     */
    public a_eles superponer(Object ... eles_array) {
        a_eles retorno = a_eles.falso();
        String clave = ""; //NOI18N
        int tam = eles_array.length;
        if (tam % 2 == 0) {
            int i = 0;
            while (true) {
                if (i >= tam) {
                    break;
                }
                if (eles_array[i + 1] != null) {
                    if (eles_array[i] instanceof String) {
                        clave = (String) eles_array[i];
                    } else {
                        clave = a_eles.crear(eles_array[i]).dar();
                    }
                    superponer(clave, eles_array[i + 1]);
                }
                i = i + 2;
            }
            retorno = a_eles.verdad();
        } else {
            throw new RuntimeException(java.util.ResourceBundle.getBundle("in/innui/contextos/in").getString("PONER ({NOMBRE, VALOR}); NÚMERO DE PARÁMETROS INCORRECTO. "));
        }
        return retorno;
    }
    /**
     * Leer un elemento en el contexto
    * @param nombre elemento a leer
    * @return el elemento buscado, o a_eles.nulo().
    */
    public a_eles leer(String nombre) {
        a_eles dato = a_eles.nulo();
        if (mapa != null) {
            dato = mapa.leer(nombre);
        }
        if (dato.es_nulo()) {
            for (entes submapa: mapas_pila) {
                dato = submapa.leer(nombre);
                if (dato.es_nulo() == false) {
                    break;
                }
            }
        }
        return dato;
    }
    /**
     * Leer un elemento en el contexto
    * @param nombre elemento a leer
    * @param por_defecto elemento qeu ofrecer, si no se encuentra.
    * @return el elemento buscado, o el elemento por defecto.
    */
    public a_eles leer(String nombre, a_eles por_defecto) {
        a_eles dato = leer(nombre);
        if (dato.es_nulo()) {
            return por_defecto;
        } else {
            return dato;
        }
    }

    /**
     * Subir el nivel de la pila que permite la recursividad
     * eles_array a_eles que subir en la pila
     * Solo deben subir pila aquellos elementos que se van a crear nuevos (directa o indirectamente).
     * O que son inmutables, como los números o los String.
     * @param eles_array Los elementos que subir.
     * @return a_eles.verdad()
     */
    public a_eles subir(a_eles ... eles_array) {
        if (mapa != null) {
            mapas_pila.addLast(mapa);
        }
        mapa = new entes();
        for (a_eles ele: eles_array) {
            superponer(ele.nombre, ele);
        }
        return a_eles.verdad();
    }
    /**
     * Subir el nivel de la pila que permite la recursividad, Y deben reemplazar a los antiguos, al bajar.
     * @param eles_array array de a_eles que subir (incluyen su nombre), que se suben, porque van a ser nuevos..
     * @param nombres_array nombres de elementos que comprobar que existen en el contexto
     * @return 
     */
    public a_eles subir(a_eles [] eles_array, String ... nombres_array) {
        subir(eles_array);
        return es(nombres_array);
    }

    /**
     * Pasa los elementos al nivel de pila inferior.
     * @param eles_array Array con claves (par) y valores (impar)
     * Las posiciones pares son el nombre.
     * Las posiciones impares son el valor. Si el valor en null, se toma el que ya haya en el contexto y se baja.
     * Si un nombre no existe en el contexto, se crea; a menos que el valor a superponer valor sea null
     * @return true si es correcto, false si hay error.
     */
    public a_eles bajar_con_datos(Object ... eles_array) {
        a_eles dato = null;
        String clave = ""; //NOI18N
        entes submapa = null;
        int tam = eles_array.length;
        if (tam > 0
                && tam % 2 == 0) {
            if (mapas_pila.isEmpty() == false) {
                submapa = mapas_pila.getFirst();
                int i = 0;
                while (true) {
                    if (i >= tam) {
                        break;
                    }
                    if (eles_array[i] instanceof String) {
                        clave = (String) eles_array[i];
                    } else {
                        clave = a_eles.crear(eles_array[i]).dar();
                    }
                    if (eles_array[i + 1] != null) {
                        if (eles_array[i + 1] instanceof a_eles) {
                            dato = (a_eles) eles_array[i + 1];
                        } else {
                            dato = a_eles.crear(eles_array[i + 1]);
                        }
                        dato.nombre = clave;
                        submapa.poner(clave, dato);
                    } else {
                        dato = mapa.leer(clave);
                        if (dato.es_nulo() == false) {
                            submapa.poner(clave, dato);
                        }
                    }
                    i = i + 2;
                }
            }
        } else {
            throw new RuntimeException(java.util.ResourceBundle.getBundle("in/innui/contextos/in").getString("BAJAR_DATOS ({NOMBRE, VALOR (NUEVO) O NULL (LO QUE HAY)}); NÚMERO DE PARÁMETROS INCORRECTO. "));
        }
        return bajar();
    }
    
    /**
     * Pasa los elementos al nivel de pila inferior.
     * @param nombres_array Array con claves
     * Si un nombre no existe en el contexto, se crea; a menos que el valor a superponer sea null, que es ignorado.
     * @return true si es correcto, false si hay error.
     */
    public a_eles bajar(String ... nombres_array) {
        a_eles dato = null;
        String clave = ""; //NOI18N
        int tam = nombres_array.length;
        entes submapa = null;
        if (tam > 0) {
            if (mapas_pila.isEmpty() == false) {
                submapa = mapas_pila.getLast();
                int i = 0;
                while (true) {
                    if (i >= tam) {
                        break;
                    }
                    clave = nombres_array[i];
                    if (mapa != null) {
                        dato = mapa.leer(clave);
                        if (dato.es_nulo() == false) {
                            submapa.poner(clave, dato);
                        }
                    }
                    i = i + 1;
                }
            }
        }
        if (mapas_pila.isEmpty() == false) {
            mapa = mapas_pila.removeLast();
        } else {
            mapa = null;
        }
        return a_eles.verdad();
    }
    /**
     * Pone un elemento en el fondo del contexto.
     * @param eles_array Array con claves
     * Las posiciones pares son el nombre.
     * Las posiciones impares son el valor. Si el valor en null, se toma el que ya haya en el contexto y se baja.
     * @return a_eles.verdad().
     */
    public a_eles fondear_con_datos(Object ... eles_array) {
        a_eles dato = null;
        String clave = ""; //NOI18N
        int tam = eles_array.length;
        entes submapa = null;
        if (tam > 0) {
            if (mapas_pila.isEmpty() == false) {
                submapa = mapas_pila.getFirst();
            } else {
                submapa = mapa;
            }
            int i = 0;
            while (true) {
                if (i >= tam) {
                    break;
                }
                if (eles_array[i] instanceof String) {
                    clave = (String) eles_array[i];
                } else {
                    clave = a_eles.crear(eles_array[i]).dar();
                }
                if (eles_array[i + 1] != null) {
                    if (eles_array[i + 1] instanceof a_eles) {
                        dato = (a_eles) eles_array[i + 1];
                    } else {
                        dato = a_eles.crear(clave, eles_array[i + 1]);
                    }
                    dato.nombre = clave;
                    submapa.poner(clave, dato);
                } else {
                    submapa.poner(clave, dato);
                }
                i = i + 2;
            }           
        }
        return a_eles.verdad();
    }
    /**
     * Comprueba que los nombres de elementos están en el contexto.
     * @param strings_array nombres de elementos
     * @return verdad si está o es opcional, falso si no está y es obligatorio
     */
    public a_eles es(String ... strings_array) {
        a_eles ret = subir();
        String error = "";  //NOI18N
        try {
            for (String nombre: strings_array) {
                if (leer(nombre).es() == false) {
                    if (nombre.startsWith(k_op) == false) {
                        error += nombre + ". "; //NOI18N
                        ret.no();
                    }
                }
            }
            if (error.isEmpty() == false) {
                error = java.text.MessageFormat.format(java.util.ResourceBundle.getBundle("in/innui/contextos/in").getString("NO EN CONTEXTO: {0}"), new Object[] {error});
            }
        } finally {
            bajar_con_datos("error", error); //NOI18N
        }
        return ret;
    }

}