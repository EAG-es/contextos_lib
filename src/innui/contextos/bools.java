/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.contextos;

/**
 * Recubrimiento de la clase Boolean usando la clase Byte para que sus instancias puedan ser tratados como objeto mutable.
 */
public class bools extends elems<Byte> {
    
    public bools(boolean value) {
        a = (value)?(byte)1:(byte)0;
    }
    public bools(String s) {
        a = Byte.valueOf(s);
    }
    public bools(textos s) {
        a = Byte.valueOf(s.a);
    }
    public bools(Boolean b) {
        this(b.booleanValue());
    }      
    public bools(bools b) {
        a = b.a;
    }
    public boolean booleanValue() {
        return es();
    }
    public static int compare(boolean x, boolean y) {
        return Boolean.compare(x, y);
    }
    public static int compare(bools x, bools y) {
        return Byte.compare(x.a, y.a);
    }
    public int compareTo(Boolean b) {
        return a.compareTo((b)?(byte)1:(byte)0);
    }
    public int compareTo(bools b) {
        return a.compareTo(b.a);
    }
    public boolean equals(Object obj) {
        return a.equals(obj);
    }
    public static boolean getBoolean(String name) {
        return Boolean.getBoolean(name);
    }
    public static boolean getBoolean(textos name) {
        return Boolean.getBoolean(name.a);
    }
    public static boolean parseBoolean(String s) {
        return Boolean.parseBoolean(s);
    }
    public static boolean parseBoolean(textos s) {
        return Boolean.parseBoolean(s.a);
    }
    @Override
    public String toString() {
        return a.toString();
    }
    public textos toTextos() {
        return new textos(a.toString());
    }
    public static String toString(boolean b) {
        return Boolean.toString(b);
    }
    public static String toString(bools b) {
        return Byte.toString(b.a);
    }
    public static textos toTextos(boolean b) {
        return new textos(bools.toString(b));
    }
    public static textos toTextos(bools b) {
        return new textos(b.toString());
    }
    public static bools valueOf(boolean b) {
        return new bools(b);
    }
    public static bools valueOf(Boolean b) {
        return new bools(b);
    }
    public static bools valueOf(String s) {
        return new bools(s) ;
    }
    public static bools valueOf(textos s) {
        return new bools(s.a) ;
    }
    public bools set(bools bool) {
        a = bool.a;
        return this;
    }
    public bools set(Boolean bb) {
        set(bb.booleanValue());
        return this;
    }
    public bools set(boolean b) {
        a = (b)?(byte)1:(byte)0;
        return this;
    }
    public Boolean getBoolean() {
        return es();
    }
}
