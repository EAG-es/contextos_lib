/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innui.contextos;

import java.nio.charset.Charset;
import java.util.Locale;

/**
 * Recubrimiento de la clase String para que sus instancias puedan ser tratados como objeto mutable.
 */
public class textos extends elems<String> {
    
    public textos() {
        a = new String();
    }
    public textos(byte[] bytes) {
        a = new String(bytes);
    }
    public textos(byte[] bytes, Charset charset) throws Exception {
        a = new String(bytes, charset);
    }
    public textos(byte[] bytes, int offset, int length) {
        a = new String(bytes, offset, length);
    }
    public textos(byte[] bytes, int offset, int length, String charsetName) throws Exception {
        a = new String(bytes, offset, length, charsetName);
    }
    public textos(byte[] bytes, String charsetName) throws Exception  {
        a = new String(bytes, charsetName);
    }
    public textos(char[] value) {
        a = new String(value);
    }
    public textos(char[] value, int offset, int count) {
        a = new String(value, offset, count);
    }
    public textos(int[] codePoints, int offset, int count) {
        a = new String(codePoints, offset, count);
    }
    public textos(String original) {
        a = original;
    }
    public textos(textos original) {
        a = original.a;
    }
    public textos(StringBuffer buffer) {
        a = new String(buffer);
    }
    public textos(StringBuilder builder) {
        a = new String(builder);
    }
    public char charAt(int index) {
        return a.charAt(index);
    }
    public int codePointAt(int index) {
        return a.codePointAt(index);
    }
    public int codePointBefore(int index) {
        return a.codePointBefore(index);
    }
    public int codePointCount(int beginIndex, int endIndex) {
        return a.codePointCount(beginIndex, endIndex);
    }
    public char charAt(enteros index) {
        return a.charAt(index.intValue());
    }
    public int codePointAt(enteros index) {
        return a.codePointAt(index.intValue());
    }
    public int codePointBefore(enteros index) {
        return a.codePointBefore(index.intValue());
    }
    public int codePointCount(enteros beginIndex, enteros endIndex) {
        return a.codePointCount(beginIndex.intValue(), endIndex.intValue());
    }
    public int compareTo(String anotherString) {
        return a.compareTo(anotherString);
    }
    public int compareToIgnoreCase(String str) {
        return a.compareToIgnoreCase(str);
    }
    public textos concat(String str) {
        a = a.concat(str);
        return this;
    }
    public boolean contains(CharSequence s) {
        return a.contains(s);
    }
    public boolean contentEquals(CharSequence cs) {
        return a.contentEquals(cs);
    }
    public boolean contentEquals(StringBuffer sb) {
        return a.contentEquals(sb);
    }
    public static textos copyValueOf(char[] data) {
        textos ret = new textos();
        ret.a = String.copyValueOf(data);
        return ret;
    }
    public static textos copyValueOf(char[] data, int offset, int count) {
        textos ret = new textos();
        ret.a = String.copyValueOf(data, offset, count);
        return ret;        
    }
    public static textos copyValueOf(char[] data, enteros offset, enteros count) {
        textos ret = new textos();
        ret.a = String.copyValueOf(data, offset.intValue(), count.intValue());
        return ret;        
    }
    public boolean endsWith(String suffix) {
        return a.endsWith(suffix);
    }
    public boolean endsWith(textos suffix) {
        return a.endsWith(suffix.a);
    }
    public boolean equals(Object anObject) {
        return a.equals(anObject);
    }
    public boolean equalsIgnoreCase(String anotherString) {
        return a.equalsIgnoreCase(anotherString);
    }
    public boolean equalsIgnoreCase(textos anotherString) {
        return a.equalsIgnoreCase(anotherString.a);
    }
    public static textos format(Locale l, String format, Object... args) {
        textos ret = new textos();
        ret.a = String.format(l, format, args);
        return ret;         
    }
    public static textos format(Locale l, textos format, Object... args) {
        textos ret = new textos();
        ret.a = String.format(l, format.a, args);
        return ret;         
    }
    public static textos format(String format, Object... args) {
        textos ret = new textos();
        ret.a = String.format(format, args);
        return ret;
    }
    public static textos format(textos format, Object... args) {
        textos ret = new textos();
        ret.a = String.format(format.a, args);
        return ret;
    }
    public byte[] getBytes() {
        return a.getBytes();
    }
    public byte[] getBytes(Charset charset) {
        return a.getBytes(charset);
    }
    public byte[] getBytes(String charsetName) throws Exception {
        return a.getBytes(charsetName);
    }
    public byte[] getBytes(textos charsetName) throws Exception {
        return a.getBytes(charsetName.a);
    }
    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        a.getChars(srcBegin, srcEnd, dst, dstBegin);
    }
    public void getChars(enteros srcBegin, enteros srcEnd, char[] dst, enteros dstBegin) {
        a.getChars(srcBegin.intValue(), srcEnd.intValue(), dst, dstBegin.intValue());
    }
    public int indexOf(int ch) {
        return a.indexOf(ch);
    }
    public int indexOf(enteros ch) {
        return a.indexOf(ch.intValue());
    }
    public int indexOf(int ch, int fromIndex) {
        return a.indexOf(ch, fromIndex);
    }
    public int indexOf(enteros ch, enteros fromIndex) {
        return a.indexOf(ch.intValue(), fromIndex.intValue());
    }
    public int indexOf(String str) {
        return a.indexOf(str);
    }
    public int indexOf(textos str) {
        return a.indexOf(str.a);
    }
    public int indexOf(String str, int fromIndex) {
        return a.indexOf(str, fromIndex);
    }
    public int indexOf(textos str, enteros fromIndex) {
        return a.indexOf(str.a, fromIndex.intValue());
    }
    public textos intern() {
        a = a.intern();
        return this;
    }
    public boolean isEmpty() {
        return a.isEmpty();
    }
    public int lastIndexOf(int ch) {
        return a.lastIndexOf(ch);
    }
    public int lastIndexOf(enteros ch) {
        return a.lastIndexOf(ch.intValue());
    }
    public int lastIndexOf(int ch, int fromIndex) {
        return a.lastIndexOf(ch, fromIndex);
    }
    public int lastIndexOf(enteros ch, enteros fromIndex) {
        return a.lastIndexOf(ch.intValue(), fromIndex.intValue());
    }
    public int lastIndexOf(String str) {
        return a.lastIndexOf(str);
    }
    public int lastIndexOf(textos str) {
        return a.lastIndexOf(str.a);
    }
    public int lastIndexOf(String str, int fromIndex) {
        return a.lastIndexOf(str, fromIndex);
    }
    public int lastIndexOf(textos str, enteros fromIndex) {
        return a.lastIndexOf(str.a, fromIndex.intValue());
    }
    public int length() {
        return a.length();
    }
    public boolean matches(String regex) {
        return a.matches(regex);
    }
    public boolean matches(textos regex) {
        return a.matches(regex.a);
    }
    public int offsetByCodePoints(int index, int codePointOffset) {
        return a.offsetByCodePoints(index, codePointOffset);
    }
    public int offsetByCodePoints(enteros index, enteros codePointOffset) {
        return a.offsetByCodePoints(index.intValue(), codePointOffset.intValue());
    }
    public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
        return a.regionMatches(ignoreCase, toffset, other, ooffset, len);
    }
    public boolean regionMatches(bools ignoreCase, enteros toffset, textos other, enteros ooffset, enteros len) {
        return a.regionMatches(ignoreCase.es(), toffset.intValue(), other.a, ooffset.intValue(), len.intValue());
    }
    public boolean regionMatches(int toffset, String other, int ooffset, int len) {
        return a.regionMatches(toffset, other, ooffset, len);
    }
    public boolean regionMatches(enteros toffset, textos other, enteros ooffset, enteros len) {
        return a.regionMatches(toffset.intValue(), other.a, ooffset.intValue(), len.intValue());
    }
    public textos replace(char oldChar, char newChar) {
        a = a.replace(oldChar, newChar);
        return this;
    }
    public textos replace(CharSequence target, CharSequence replacement) {
        a = a.replace(target, replacement);
        return this;        
    }
    public textos replaceAll(String regex, String replacement) {
        a = a.replaceAll(regex, replacement);
        return this;
    }
    public textos replaceAll(textos regex, textos replacement) {
        a = a.replaceAll(regex.a, replacement.a);
        return this;
    }
    public textos replaceFirst(String regex, String replacement) {
        a = a.replaceFirst(regex, replacement);
        return this;
    }
    public textos replaceFirst(textos regex, textos replacement) {
        a = a.replaceFirst(regex.a, replacement.a);
        return this;
    }
    public String[] split(String regex) {
        return a.split(regex);
    }
    public String[] split(textos regex) {
        return a.split(regex.a);
    }
    public String[] split(String regex, int limit) {
        return a.split(regex, limit);
    }
    public String[] split(textos regex, enteros limit) {
        return a.split(regex.a, limit.intValue());
    }
    public boolean startsWith(String prefix) {
        return a.startsWith(prefix);
    }
    public boolean startsWith(textos prefix) {
        return a.startsWith(prefix.a);
    }
    public boolean startsWith(String prefix, int toffset) {
        return a.startsWith(prefix, toffset);
    }
    public boolean startsWith(textos prefix, enteros toffset) {
        return a.startsWith(prefix.a, toffset.intValue());
    }
    public CharSequence subSequence(int beginIndex, int endIndex) {
        return a.subSequence(beginIndex, endIndex);
    }
    public CharSequence subSequence(enteros beginIndex, enteros endIndex) {
        return a.subSequence(beginIndex.intValue(), endIndex.intValue());
    }
    public textos substring(int beginIndex) {
        a = a.substring(beginIndex);
        return this;
    }
    public textos substring(enteros beginIndex) {
        a = a.substring(beginIndex.intValue());
        return this;
    }
    public textos substring(int beginIndex, int endIndex) {
        a = a.substring(beginIndex, endIndex);
        return this;
    }
    public textos substring(enteros beginIndex, enteros endIndex) {
        a = a.substring(beginIndex.intValue(), endIndex.intValue());
        return this;
    }
    public char[] toCharArray() {
        return a.toCharArray();
    }
    public textos toLowerCase() {
        a = a.toLowerCase();
        return this;
    }
    public textos toLowerCase(Locale locale) {
        a = a.toLowerCase(locale);
        return this;
    }
    @Override
    public String toString() {
        return a;
    }
    public textos toUpperCase() {
        a = a.toUpperCase();
        return this;
    }
    public textos toUpperCase(Locale locale) {
        a = a.toUpperCase(locale);
        return this;
    }
    public textos trim() {
        a = a.trim();
        return this;
    }
    public static textos valueOf(boolean b) {
        textos ret = new textos();
        ret.a = String.valueOf(b);
        return ret;
    }
    public static textos valueOf(bools b) {
        textos ret = new textos();
        ret.a = String.valueOf(b.a);
        return ret;
    }
    public static textos valueOf(char c) {
        textos ret = new textos();
        ret.a = String.valueOf(c);
        return ret;
    }
    public static textos valueOf(char[] data) {
        textos ret = new textos();
        ret.a = String.valueOf(data);
        return ret;
    }
    public static textos valueOf(char[] data, int offset, int count) {
        textos ret = new textos();
        ret.a = String.valueOf(data, offset, count);
        return ret;
    }
    public static textos valueOf(char[] data, enteros offset, enteros count) {
        textos ret = new textos();
        ret.a = String.valueOf(data, offset.intValue(), count.intValue());
        return ret;
    }
    public static textos valueOf(double d) {
        textos ret = new textos();
        ret.a = String.valueOf(d);
        return ret;
    }
    public static textos valueOf(float f) {
        textos ret = new textos();
        ret.a = String.valueOf(f);
        return ret;
    }
    public static textos valueOf(int i) {
        textos ret = new textos();
        ret.a = String.valueOf(i);
        return ret;
    }
    public static textos valueOf(long l) {
        textos ret = new textos();
        ret.a = String.valueOf(l);
        return ret;
    }
    public static textos valueOf(enteros l) {
        textos ret = new textos();
        ret.a = String.valueOf(l.a);
        return ret;
    }
    public static textos valueOf(Object obj) {
        textos ret = new textos();
        ret.a = String.valueOf(obj);
        return ret;
    }    
    public textos(byte[] bytes, int offset, int length, textos charsetName) throws Exception {
        a = new String(bytes, offset, length, charsetName.a);
    }
    public textos(byte[] bytes, textos charsetName) throws Exception  {
        a = new String(bytes, charsetName.a);
    }
    public int compareTo(textos anotherString) {
        return a.compareTo(anotherString.a);
    }
    public int compareToIgnoreCase(textos str) {
        return a.compareToIgnoreCase(str.a);
    }
    public textos concat(textos str) {
        a = a.concat(str.a);
        return this;
    }
    public textos set(textos texto) {
        a = texto.a;
        return this;
    }
    public textos set(String s) {
        a = s;
        return this;
    }
    public String getString() {
        return a;
    }
}
