/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.contextos;

/**
 * Recubrimiento de la clase Double para poder que sus instancias puedan ser tratados como objeto mutable.
 */
public class decimales extends elems<Double> {
    public decimales(double value) {
        a = value;
    }
    public decimales(String s) {
        a = new Double(s);
    }  
    public decimales(Double value) {
        a = value;
    }
    public decimales(decimales value) {
        a = value.a;
    }
    public byte byteValue() {
        return a.byteValue();
    }
    public static int compare(double d1, double d2) {
        return Double.compare(d1, d2);
    }
    public static int compare(decimales d1, decimales d2) {
        return Double.compare(d1.a, d2.a);
    }
    public int compareTo(Double anotherDouble) {
        return a.compareTo(anotherDouble);
    }
    public int compareTo(decimales anotherDouble) {
        return a.compareTo(anotherDouble.a);
    }
    public static long doubleToLongBits(double value) {
        return Double.doubleToLongBits(value);
    }
    public static enteros doubleToLongBits(decimales value) {
        return new enteros(Double.doubleToLongBits(value.a));
    }
    public static long doubleToRawLongBits(double value) {
        return Double.doubleToRawLongBits(value);
    }
    public static enteros doubleToRawLongBits(decimales value) {
        return new enteros(Double.doubleToRawLongBits(value.a));
    }
    public double doubleValue() {
        return a.doubleValue();
    }
    public boolean equals(Object obj) {
        return a.equals(obj);
    }
    public float floatValue() {
        return a.floatValue();
    }
    public int intValue() {
        return a.intValue();
    }
    public boolean isInfinite() {
        return a.isInfinite();
    }
    public static boolean isInfinite(double v) {
        return Double.isInfinite(v);
    }
    public static boolean isInfinite(decimales v) {
        return Double.isInfinite(v.a);
    }
    public boolean isNaN() {
        return a.isNaN();
    }
    public static boolean isNaN(double v) {
        return Double.isNaN(v);
    }
    public static double longBitsToDouble(long bits) {
        return Double.longBitsToDouble(bits);
    }
    public static double longBitsToDouble(enteros bits) {
        return Double.longBitsToDouble(bits.a);
    }
    public long longValue() {
        return a.longValue();
    }
    public static double parseDouble(String s) {
        return Double.parseDouble(s);
    }
    public static double parseDouble(textos s) {
        return Double.parseDouble(s.a);
    }
    public short shortValue() {
        return a.shortValue();
    }
    public static String toHexString(double d) {
        return Double.toHexString(d);
    }
    public static String toHexString(decimales d) {
        return Double.toHexString(d.a);
    }
    public static textos toHexTextos(double d) {
        return new textos(Double.toHexString(d));
    }
    public static textos toHexTextos(decimales d) {
        return new textos(Double.toHexString(d.a));
    }
    public String toString() {
        return a.toString();
    }
    public static String toString(double d) {
        return Double.toString(d);
    }
    public static String toString(decimales d) {
        return Double.toString(d.a);
    }
    public static decimales valueOf(double d) {
        return new decimales(d);
    }
    public static decimales valueOf(decimales d) {
        return new decimales(d.a);
    }
    public static decimales valueOf(String s)  {
        return new decimales(s);
    }   
    public static decimales valueOf(textos s)  {
        return new decimales(s.a);
    }   
    public decimales set(decimales entero) {
        a = entero.a;
        return this;
    }
    public decimales set(Double dd) {
        a = dd;
        return this;
    }
    public decimales set(double d) {
        a = d;
        return this;
    }
    public decimales set(float f) {
        a = new Double(f);
        return this;
    }
    public Double getDouble() {
        return a;
    }
}
