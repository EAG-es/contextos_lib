/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.contextos.anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotación que indica un dato de contexto que es nuevo; y se baja al nivel superior, que queda al finalizar el método
 */
@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.METHOD)
@Repeatable(baja_array.class)
public @interface baja {
    String value();
    String tipo() default "Object";
    String comentario() default "";
    boolean es_requerido() default true;
}
