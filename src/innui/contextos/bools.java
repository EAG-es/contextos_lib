/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.contextos;

/**
 * Recubrimiento de la clase Boolean para que sus instancias puedan ser tratados como objeto mutable.
 */
public class bools extends elems<Boolean> {
    
    public bools(boolean value) {
        a = value;
    }
    public bools(String s) {
        a = Boolean.valueOf(s);
    }
    public bools(textos s) {
        a = Boolean.valueOf(s.a);
    }
    public bools(Boolean b) {
        a = b;
    }      
    public bools(bools b) {
        a = b.a;
    }
    public boolean booleanValue() {
        return a;
    }
    public static int compare(boolean x, boolean y) {
        return Boolean.compare(x, y);
    }
    public static int compare(bools x, bools y) {
        return Boolean.compare(x.a, y.a);
    }
    public int compareTo(Boolean b) {
        return a.compareTo(b);
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
        return Boolean.toString(b.a);
    }
    public static textos toTextos(boolean b) {
        return new textos(bools.toString(b));
    }
    public static textos toTextos(bools b) {
        return new textos(bools.toString(b.a));
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
        a = bb;
        return this;
    }
    public bools set(boolean b) {
        a = b;
        return this;
    }
    public Boolean getBoolean() {
        return a;
    }
}
