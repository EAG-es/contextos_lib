package innui.contextos;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Clase Abstracta implementando i_eles
 */
public abstract class a_eles implements i_eles {
    /**
     * Valor numérico de: verdad
     */
    public static Long verdad = 1L;
    /**
     * Valor numérico de: falso, o de error.
     */
    public static Long falso = 0L;
    /**
     * Valor numérico del nivel de error: leve
     */
    public static Long leve = -1L;
    /**
     * Valor numérico del nivel de error: aviso
     */
    public static Long aviso = -2L;
    /**
     * Valor numérico del nivel de error: comentario
     */
    public static Long comentario = -3L;
    /**
     * Nombre del elemento
     */
    public String nombre = null;
    /**
     * Atributo de contexto para añadir atributos a la clase
     */
    public contextos con_su = null;
    /**
     * Atribuyo estático con la factoria de a_eles por defecto.
     */
    public static elems factoria = new elems();
    /**
     * Constructor
     */
    public a_eles() {
    }
    @Override
    public abstract <tipos> tipos dar();
    
    @Override
    public abstract <tipos> tipos dar(a_eles ret);
    @Override
    public abstract a_eles poner(Object dato);

    public static void poner_factoria(elems factoria) {
        a_eles.factoria = factoria;
    }
    
    public static <crear_tipos> a_eles crear() {
        if (factoria != null) {
            return factoria.crear_nuevo();
        } else {
            return null;
        }
    }
    @Override    
    public String toString() {
        return leer_texto();
    }
    @Override
    public String leer_texto () {
        Object object = dar();
        if (object == null) {
            return null;
        } else if (object instanceof String) {
            return (String) object;
        } else {
            return String.valueOf(object);
        }
    }
    @Override
    public Long leer_entero () {
        Object object = dar();
        if (object == null) {
            return null;
        } else if (object instanceof Number) {
            return ((Number) object).longValue();
        } else if (object instanceof Character) {
            return (Long.valueOf(((Character) object).compareTo('\0')));
        } else if (object instanceof Boolean) {
            if ((Boolean)object) {
                return 1L;
            } else {
                return 0L;
            }
        } else if (object instanceof String) {
            return Long.valueOf((String) object);
        } else {
            return null;
        }
    }
    @Override
    public Double leer_decimal () {
        Object object = dar();
        if (object == null) {
            return null;
        } else if (object instanceof Number) {
            return ((Number) object).doubleValue();
        } else if (object instanceof Character) {
            return (Double.valueOf(((Character) object).compareTo('\0')));
        } else if (object instanceof Boolean) {
            if ((Boolean) object) {
                return 1.0;
            } else {
                return 0.0;
            }
        } else if (object instanceof String) {
            return Double.valueOf((String) object);
        } else {
            return null;
        }
    }
    @Override
    public Character leer_letra() {
        Object object = dar();
        if (object == null) {
            return null;
        } else if (object instanceof Character) {
            return (Character) object;
        } else if (object instanceof Number) {
            return (Character)(char)((Number) object).intValue();
        } else if (object instanceof String) {
            return (Character)(char)((String) object).indexOf(0);
        } else if (object instanceof Boolean) {
            if ((Boolean)object) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return null;
        }
    }
    @Override
    public Boolean es_nulo() {
        Object object = dar();
        if (object == null) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
    @Override    
    public Boolean es() {
        Object object = dar();
        if (object == null) {
            return Boolean.FALSE;
        } else if (object instanceof Boolean) {
            return (Boolean) object;
        } else if (object instanceof Number) {
            return ((Number) object).intValue() > falso; // verdad o gran verdad
        } else if (object instanceof CharSequence) {
            String texto = leer_texto();
            if (texto == null
                    || texto.isEmpty()) {
                return Boolean.FALSE;
            } else {
                return Boolean.TRUE;
            }
        } else {
            return Boolean.TRUE;
        }
    }
    @Override
    public Boolean no_es() {
        return ! es();
    }
    @Override    
    public a_eles si_o_no(Long umbral_si) {
        Object object = dar();
        if (object instanceof Number) {
            Long este = leer_entero();
            if (este > falso // verdad o gran verdad
                    || este <= umbral_si) { // algo falso (igual o bajo el umbral)
                return si(); // verdad
            } else {
                return no(); // falso
            }
        } else {
            return no();
        }
    }
    @Override
    public Boolean leer_bool () {
        if (dar() == null) {
            return null;
        } else
            return es();
    }
    @Override
    public acciones leer_accion () {
        Object object = dar();
        if (object == null) {
            return null;
        } else if (object instanceof acciones) {
            return (acciones) object;
        } else {
            return null;
        }
    }
    @Override
    public a_eles poner(a_eles dato) {
        poner ((Object)dato.dar());
        return this;
    }
    @Override
    public a_eles poner(double dato) {
        return poner(Double.valueOf(dato));
    }
    @Override
    public a_eles poner(float dato) {
        return poner(Float.valueOf(dato));
    }
    @Override
    public a_eles poner(int dato) {
        return poner(Integer.valueOf(dato));
    }
    @Override
    public a_eles poner(byte dato) {
        return poner(Byte.valueOf(dato));
    }
    @Override
    public a_eles poner(char dato) {
        return poner(Character.valueOf(dato));
    }
    @Override
    public a_eles poner(boolean dato) {
        return poner(Boolean.valueOf(dato));
    }
    @Override
    public a_eles si() {
        return poner(1);
    }
    @Override
    public a_eles si(Long valor) {
        return poner(valor);
    }
    @Override
    public a_eles y(a_eles ele) {
        Long este = leer_entero();
        Long aquel = ele.leer_entero();
        if (este > falso) { // verdad o gran verdad
            if (aquel > falso) { // verdad o gran verdad
                poner(Math.min(aquel, este)); // lo menos bueno
            } else { // falso o algo falso
                poner(aquel); // manda aquel
            }
        } else if (este < falso) { // algo falso
            if (aquel < falso) { // algo falso
                poner(Math.max(aquel, este)); // lo menos bueno
            } else if (aquel == falso) { // falso
                poner(aquel); // manda aquel
            } //  verdad o gran verdad (no se hace nada)
        } // falso (no se hace nada)
        return this;
    }
    @Override
    public a_eles o(a_eles ele) {
        Long este = leer_entero();
        Long aquel = ele.leer_entero();
        if (este == falso) { // falso
            poner(aquel); // manda aquel.
        } else if (este < falso) { // algo falso
            if (aquel < falso) { // algo falso
                poner(Math.max(aquel, este)); // lo menos bueno
            } else if (aquel > falso) { // verdad o gran verdad
                poner(aquel);
            } // falso (no se hace nada)
        } else { // verdad o gran verdad
            if (aquel > falso) { // verdad o gran verdad
                poner(Math.min(aquel, este)); // lo menos bueno
            } // falso o algo falso (no se hace nada)
        }
        return this;
    }
    @Override
    public a_eles xor(a_eles ele) {
        boolean a = es();
        boolean b = ele.es();
        return poner((a && !b) || (!a && b));
    }
    @Override
    public a_eles no() {
        return poner(falso);
    }
    @Override
    public a_eles no(Long valor) {
        return poner(valor);
    }
    @Override
    public a_eles clone() throws CloneNotSupportedException {
        return (a_eles) a_eles.clonar_objeto(this);
    }
    /**
     * Método estático para realizar clonado profundo mediante refactorización
     * @param obj Objeto que clonar
     * @return Un nuevo objeto en memeoria con los datos del antiguo.
     * @throws CloneNotSupportedException Si hay error clonando.
     */
    public static Object clonar_objeto(Object obj) throws CloneNotSupportedException {
        Object clone = null;
        try {
            clone = obj.getClass().newInstance();
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(obj) != null
                        && Modifier.isFinal(field.getModifiers()) == false) {
                    if (field.getType().isPrimitive()
                            || field.getType().isInstance(CharSequence.class)
                            || field.getType().isInstance(Number.class)
                            || field.getType().isInstance(Boolean.class)) {
                        field.set(clone, field.get(obj));
                    } else {
                        Object childObj = field.get(obj);
                        if (childObj == obj) {
                            field.set(clone, clone);
                        } else {
                            field.set(clone, clonar_objeto(field.get(obj)));
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new CloneNotSupportedException(e.getLocalizedMessage());
        }
        return clone;
    }
    /**
     * Método estático para crear un a_eles con el valor: falso
     * @return El nuevo objeto a_eles.
     */
    public final static a_eles falso() {
        return crear(falso);
    }
    /**
     * Método estático para crear un a_eles con el valor: verdad
     * @return El nuevo objeto a_eles.
     */
    public final static a_eles verdad() {
        return crear(verdad);
    }
    /**
     * Método estático para crear un a_eles con el valor: ""
     * @return El nuevo objeto a_eles.
     */    
    public final static a_eles string() {
        return crear(""); //NOI18N
    }
    /**
     * Método estático para crear un a_eles con el valor: null
     * @return El nuevo objeto a_eles.
     */
    public final static a_eles nulo() {
        return crear(null);
    } 
    /**
     * Crea un objeto a_eles con un valor inicial (lo que condiciona su tipo interno)
     * @param <nuevos_tipos> Tipo interno del objeto a_eles
     * @param objeto Dato que contendrá
     * @return El nuevo objeto a_eles creado.
     */
    public static <nuevos_tipos> a_eles crear(nuevos_tipos objeto) {
        if (objeto instanceof a_eles) {
            return (a_eles) objeto;
        } else {
            a_eles ele = a_eles.<nuevos_tipos>crear();
            ele.poner(objeto);
            return ele;
        }
    }
    /**
     * Crea un objeto a_eles con un valor inicial (lo que condiciona su tipo interno)
     * @param <nuevos_tipos> Tipo interno del objeto a_eles
     * @param nombre Nombre que utilizar como clave de almacenamiento.
     * @param objeto Dato que contendrá
     * @return El nuevo objeto a_eles creado.
     */
    public static <nuevos_tipos> a_eles crear(String nombre, nuevos_tipos objeto) {
        a_eles ele = a_eles.<nuevos_tipos>crear(objeto);
        ele.nombre = nombre;
        return ele;
    }
}