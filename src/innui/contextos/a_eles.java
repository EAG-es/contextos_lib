package innui.contextos;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class a_eles implements i_eles {
    public static Long verdad = 1L;
    public static Long falso = 0L;
    public static Long leve = -1L;
    public static Long aviso = -2L;
    public static Long comentario = -3L;
    
    public String nombre = null;
    public contextos con_su = null;
    public static elems factoria = new elems();

    public a_eles() {
    }

    public abstract <tipos> tipos dar();
    
    public abstract <tipos> tipos dar(a_eles ret);

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
    
    public String toString() {
        return leer_texto();
    }

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

    public Boolean es_nulo() {
        Object object = dar();
        if (object == null) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
    
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

    public Boolean no_es() {
        return ! es();
    }
    
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
    
    public Boolean leer_bool () {
        if (dar() == null) {
            return null;
        } else
            return es();
    }

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

    public a_eles poner(a_eles dato) {
        poner ((Object)dato.dar());
        return this;
    }

    public a_eles poner(double dato) {
        return poner(Double.valueOf(dato));
    }
    
    public a_eles poner(float dato) {
        return poner(Float.valueOf(dato));
    }
    
    public a_eles poner(int dato) {
        return poner(Integer.valueOf(dato));
    }
    
    public a_eles poner(byte dato) {
        return poner(Byte.valueOf(dato));
    }
    
    public a_eles poner(char dato) {
        return poner(Character.valueOf(dato));
    }
    
    public a_eles poner(boolean dato) {
        return poner(Boolean.valueOf(dato));
    }

    public a_eles si() {
        return poner(1);
    }
    
    public a_eles si(Long valor) {
        return poner(valor);
    }
    
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
    
    public a_eles xor(a_eles ele) {
        boolean a = es();
        boolean b = ele.es();
        return poner((a && !b) || (!a && b));
    }
    
    public a_eles no() {
        return poner(falso);
    }
    
    public a_eles no(Long valor) {
        return poner(valor);
    }
    
    public a_eles clone() throws CloneNotSupportedException {
        return (a_eles) a_eles.clonar_objeto(this);
    }

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

    public final static a_eles falso() {
        return elems.crear(falso);
    }

    public final static a_eles verdad() {
        return elems.crear(verdad);
    }
    
    public final static a_eles texto() {
        return elems.crear("");
    }
    
    public final static a_eles nulo() {
        return elems.crear(null);
    }
    
    public final static a_eles binario() {
        return elems.crear((byte) 0);
    }    

    public static <nuevos_tipos> a_eles crear(nuevos_tipos objeto) {
        if (objeto instanceof a_eles) {
            return (a_eles) objeto;
        } else {
            a_eles ele = a_eles.<nuevos_tipos>crear();
            ele.poner(objeto);
            return ele;
        }
    }

    public static <nuevos_tipos> a_eles crear(String nombre, nuevos_tipos objeto) {
        a_eles ele = a_eles.<nuevos_tipos>crear(objeto);
        ele.nombre = nombre;
        return ele;
    }
}