/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.contextos;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Implementación de la clase abstracta a_eles
 * @param <tipos> Tipo que utilizar al instanciar la clase
 */
public class elems <tipos> extends a_eles {
    public tipos a = null;
    
    public <crear_tipos> a_eles crear_nuevo() {
        return new elems<> ();
    }    
    
    @Override
    public tipos dar() {
        return a;
    }
           
    @Override
    public tipos dar(a_eles ret) {
        ret.poner(es());
        return a;
    }
           
    @Override
    public a_eles poner(Object dato) {
        if (a == null) {
            a = (tipos) dato;
        } else if (a.getClass().isInstance(dato)) {
            a = (tipos) dato;
        } else if (dato.getClass().isInstance(a)) {
            a = (tipos) dato;
        } else {
            a_eles dato_eles = a_eles.crear(dato);
            if (a instanceof String) {
                a = (tipos) dato_eles.leer_texto();
            } else if (a instanceof BigInteger
                    || a instanceof Long
                    || a instanceof Integer
                    || a instanceof Byte) {
                a = (tipos) dato_eles.leer_entero();
            } else if (a instanceof BigDecimal
                    || a instanceof Double
                    || a instanceof Float) {
                a = (tipos) dato_eles.leer_decimal();
            } else if (a instanceof Character) {
                a = (tipos) dato_eles.leer_letra();
            } else if (a instanceof Boolean) {
                a = (tipos) dato_eles.es();
            } else if (a instanceof acciones) {
                a = (tipos) dato_eles.leer_accion();
            } else {
                a = null;
                throw new RuntimeException(java.util.ResourceBundle.getBundle("in/innui/contextos/in").getString("RESTRICCIÓN DE FUERTE TIPADO: NO SE PERMITE QUE UN ELEMENTO CAMBIE SU CONTENIDO A UNA CLASE NO COMPATIBLE. "));
            }
        }
        return this;
    }

}
