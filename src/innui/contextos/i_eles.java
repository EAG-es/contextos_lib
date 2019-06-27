package innui.contextos;

import java.io.Serializable;

public interface i_eles extends Cloneable, Serializable {
    /**
     * Entrega el elemento encapsulado, adaptado al tipo indicado
     * @param <tipos> tipo al qeu adaptar, si se puede.
     * @return el elemento encapsulado
     */
    <tipos> tipos dar();
    /**
     * Entrega el elemento encapsulado, adaptado al tipo indicado
     * @param <tipos> tipo al qeu adaptar, si se puede.
     * ret cotntiene verdad si el valor del elemento es así evaluado; falso, en caso contrario
     * @return el elemento encapsulado
     */    
    <tipos> tipos dar(a_eles ret);
    /**
     * Pone dato en el elemento encapsulado.
     * @param dato
     * @return el propio contenedor que implementa a_eles.
     */
    a_eles poner(Object dato);
     /**
      * Extrae el String del objeto encapsulado, o lo adapta a ese tipo-
      * @return el elemento adaptado
      */ 
    public String toString();
     /**
      * Extrae el String del objeto encapsulado, o lo adapta a ese tipo.
      * @return el elemento adaptado
      */ 
    public String leer_texto ();
     /**
      * Extrae el Long del objeto encapsulado, o lo adapta a ese tipo, si es posible.
      * @return el elemento adaptado o null
      */ 
    public Long leer_entero ();
     /**
      * Extrae el Double del objeto encapsulado, o lo adapta a ese tipo, si es posible.
      * @return el elemento adaptado o null
      */ 
    public Double leer_decimal ();
     /**
      * Extrae el Character del objeto encapsulado, o lo adapta a ese tipo, si es posible.
      * @return el elemento adaptado o null
      */ 
    public Character leer_letra();
     /**
      * Indica si el elemento encapsulado es nulo o no
      * @return true si el elemento encapsulado es nulo.
      */ 
    public Boolean es_nulo();
     /**
      * Indica si el elemento encapsulado es (se identifica como) verdad o no.
      * @return true si el elemento encapsulado es verdad o no.
      */     
    public Boolean es();
     /**
      * Extrae el Boolean del objeto encapsulado, o lo adapta a ese tipo, si es posible.
      * @return el elemento adaptado o null
      */     
    public Boolean leer_bool ();
     /**
      * Extrae el acciones del objeto encapsulado, o lo adapta a ese tipo, si es posible.
      * @return el elemento adaptado o null
      */     
    public acciones leer_accion ();
    /**
     * Asigna el dato al elemento encapsulado.
     * @param dato que asignar
     * @return el propio objeto
     */
    public a_eles poner(a_eles dato);
    /**
     * Asigna el dato al elemento encapsulado.
     * @param dato que asignar
     * @return el propio objeto
     */
    public a_eles poner(double dato);
    /**
     * Asigna el dato al elemento encapsulado.
     * @param dato que asignar
     * @return el propio objeto
     */    
    public a_eles poner(float dato);
    /**
     * Asigna el dato al elemento encapsulado.
     * @param dato que asignar
     * @return el propio objeto
     */    
    public a_eles poner(int dato);
    /**
     * Asigna el dato al elemento encapsulado.
     * @param dato que asignar
     * @return el propio objeto
     */    
    public a_eles poner(byte dato);
    /**
     * Asigna el dato al elemento encapsulado.
     * @param dato que asignar
     * @return el propio objeto
     */    
    public a_eles poner(char dato);
    /**
     * Asigna el dato al elemento encapsulado.
     * @param dato que asignar
     * @return el propio objeto
     */    
    public a_eles poner(boolean dato);
    /**
     * Asigna un valor, equivalente a verdad, al elemento encapsulado.
     * @return el propio objeto
     */
    public a_eles si();
    /**
     * Pone un valor, evaluable como verdad, al elemento encapsulado.
     * valor: 0 = false, no 0 = verdad
     * @return el propio objeto
     */    
    public a_eles si(Long valor);
    /**
     * Se asigna el resultado del operador y, valorando los datos en su equivalencia a verdad o falso.
     * ele: segundo operando del operador y
     * @return el propio objeto
     */   
    public a_eles y(a_eles ele);
    /**
     * Se asigna el resultado del operador o, valorando los datos en su equivalencia a verdad o falso.
     * ele: segundo operando del operador o
     * @return el propio objeto
     */     
    public a_eles o(a_eles ele);
    /**
     * Se asigna el resultado del operador xor, valorando los datos en su equivalencia a verdad o falso.
     * ele: segundo operando del operador xor
     * @return el propio objeto
     */      
    public a_eles xor(a_eles ele);
    /**
     * Asigna un valor, equivalente a falso, al elemento encapsulado.
     * @return el propio objeto
     */    
    public a_eles no();
    /**
     * Pone un valor, evaluable como falso, al elemento encapsulado.
     * valor: 0 = false, no 0 = verdad
     * @return el propio objeto
     */      
    public a_eles no(Long valor);
    /**
     * Clonado del elemento
     * @return el nuevo elemento, clonado.
     * @throws CloneNotSupportedException 
     */
    public a_eles clone() throws CloneNotSupportedException;  

}