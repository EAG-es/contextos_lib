/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.contextos;

/**
 *
 * @author emilio
 */
public class enteros extends elems<Long> {
    public enteros(long value) {
        a = new Long(value);
    }
    public enteros(enteros value) {
        a = new Long(value.a);
    }
    public enteros(String s) {
        a = new Long(s);
    }
    public enteros(textos t) {
        a = new Long(t.a);
    }
    public enteros(Long l) {
        a = l;
    }    
    public static int bitCount(long i) {
        return Long.bitCount(i);
    }
    public byte byteValue() {
        return a.byteValue();
    }
    public static int compare(long x, long y) {
        return Long.compare(x, y);
    }
    public static int bitCount(enteros i) {
        return Long.bitCount(i.a);
    }
    public static int compare(enteros x, enteros y) {
        return Long.compare(x.a, y.a);
    }
    public int compareTo(Long anotherLong) {
        return a.compareTo(anotherLong);
    }
    public static enteros decode(String nm) {
        enteros entero = new enteros(0);
        entero.a = Long.decode(nm);
        return entero;
    }
    public static enteros decode(textos nm) {
        return enteros.decode(nm.a);
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
    public static enteros getEnteros(String nm) {
        return new enteros(Long.getLong(nm));
    }
    public static enteros getEnteros(textos nm) {
        return new enteros(Long.getLong(nm.a));
    }
    public static enteros getEnteros(String nm, long val) {
        return new enteros(Long.getLong(nm, val));
    }
    public static enteros getEnteros(String nm, enteros val) {
        return new enteros(Long.getLong(nm, val.a));
    }
    public static enteros getEnteros(textos nm, long val) {
        return new enteros(Long.getLong(nm.a, val));
    }
    public static enteros getEnteros(textos nm, enteros val) {
        return new enteros(Long.getLong(nm.a, val.a));
    }
    public static enteros getEnteros(String nm, Long val) {
        return new enteros(Long.getLong(nm, val));
    }
    public static enteros getEnteros(textos nm, Long val) {
        return new enteros(Long.getLong(nm.a, val));
    }
    public int intValue() {
        return a.intValue();
    }
    public long longValue() {
        return a.longValue();
    }
    public static enteros parseEnteros(String s) {
        return new enteros(Long.parseLong(s));
    }
    public static enteros parseEnteros(textos s) {
        return new enteros(Long.parseLong(s.a));
    }
    public static enteros parseEnteros(String s, int radix) {
        return new enteros(Long.parseLong(s, radix));
    }
    public static enteros parseEnteros(String s, enteros radix) {
        return new enteros(Long.parseLong(s, radix.intValue()));
    }
    public static enteros parseEnteros(textos s, int radix) {
        return new enteros(Long.parseLong(s.a, radix));
    }
    public static enteros parseEnteros(textos s, enteros radix) {
        return new enteros(Long.parseLong(s.a, radix.intValue()));
    }
    public static int signum(long i) {
        return Long.signum(i);
    }
    public static String toBinaryString(long i) {
        return Long.toBinaryString(i);
    }
    public static String toHexString(long i) {
        return Long.toHexString(i);
    }
    public static String toOctalString(long i) {
        return Long.toOctalString(i);
    }
    public static int signum(enteros i) {
        return Long.signum(i.a);
    }
    public static String toBinaryString(enteros i) {
        return Long.toBinaryString(i.a);
    }
    public static String toHexString(enteros i) {
        return Long.toHexString(i.a);
    }
    public static String toOctalString(enteros i) {
        return Long.toOctalString(i.a);
    }
    public String toString() {
        return a.toString();
    }
    public static String toString(long i) {
        return Long.toString(i);
    }
    public static String toString(long i, int radix) {
        return Long.toString(i, radix);
    }
    public static textos toBinaryTextos(long i) {
        return new textos(Long.toBinaryString(i));
    }
    public static textos toHexTextos(long i) {
        return new textos(Long.toHexString(i));
    }
    public static textos toOctalTextos(long i) {
        return new textos(Long.toOctalString(i));
    }
    public static String toString(enteros i) {
        return Long.toString(i.a);
    }
    public static String toString(enteros i, enteros radix) {
        return Long.toString(i.a, radix.intValue());
    }
    public static textos toBinaryTextos(enteros i) {
        return new textos(Long.toBinaryString(i.a));
    }
    public static textos toHexTextos(enteros i) {
        return new textos(Long.toHexString(i.a));
    }
    public static textos toOctalTextos(enteros i) {
        return new textos(Long.toOctalString(i.a));
    }
    public textos toTextos() {
        return new textos(a.toString());
    }
    public static textos toTextos(long i) {
        return new textos(Long.toString(i));
    }
    public static textos toTextos(long i, int radix) {
        return new textos(Long.toString(i, radix));
    }
    public static Long valueOf(long l) {
        return Long.valueOf(l);
    }
    public static textos toTextos(enteros i) {
        return new textos(Long.toString(i.a));
    }
    public static textos toTextos(enteros i, enteros radix) {
        return new textos(Long.toString(i.a, radix.intValue()));
    }
    public static Long valueOf(enteros l) {
        return Long.valueOf(l.a);
    }
    public static Long valueOf(String s) {
        return Long.valueOf(s);
    }
    public static Long valueOf(textos s) {
        return Long.valueOf(s.a);
    }
    public static Long valueOf(String s, int radix)  {
        return Long.valueOf(s, radix);
    }   
    public static Long valueOf(textos s, int radix)  {
        return Long.valueOf(s.a, radix);
    }
    public enteros set(enteros entero) {
        a = entero.a;
        return this;
    }
    public enteros set(Long ll) {
        a = ll;
        return this;
    }
    public enteros set(long l) {
        a = l;
        return this;
    }
    public Long getLong() {
        return a;
    }
}
