package jp.itohiro.playground.regx;

import org.eclipse.collections.impl.string.immutable.CodePointAdapter;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SurrogateTest {

    @Test
    public void surrogateRegx(){
        Pattern regex = Pattern.compile("[\\p{InLowSurrogates}]");
        Matcher matcher = regex.matcher("\ud800\udc00");  // U+010000
        System.out.println(matcher.find());   // => true
        System.out.println(matcher.start());  // => 1
        System.out.println(matcher.end());
        Pattern regex2 = Pattern.compile("[\\p{InHighSurrogates}]");
        Matcher matcher2 = regex2.matcher("\ud800\uDC00");  // U+010000
        System.out.println(matcher2.find());   // => false
//        System.out.println(matcher2.start());  // => 1
//        System.out.println(matcher2.end());

        System.out.println("EC: Complete surrogate pair: " + CodePointAdapter.adapt("\ud800\uDC00").anySatisfy(i -> Character.isLowSurrogate((char)i)));
        System.out.println("EC: High surrogate (ill-formed): " + CodePointAdapter.adapt("\ud800").anySatisfy(i -> Character.isLowSurrogate((char)i)));
        System.out.println("EC: Low surrogate (ill-formed): " + CodePointAdapter.adapt("\uDC00").anySatisfy(i -> Character.isLowSurrogate((char)i)));
        System.out.println("EC: Complete surrogate pair: " + CodePointAdapter.adapt("\ud800\uDC00").anySatisfy(i -> Character.isHighSurrogate((char)i)));
        System.out.println("EC: High surrogate (ill-formed): " + CodePointAdapter.adapt("\ud800").anySatisfy(i -> Character.isHighSurrogate((char)i)));
        System.out.println("EC: Low surrogate (ill-formed): " + CodePointAdapter.adapt("\uDC00").anySatisfy(i -> Character.isHighSurrogate((char)i)));
//        EC: Complete surrogate pair: false
//        EC: High surrogate (ill-formed): false
//        EC: Low surrogate (ill-formed): true

        System.out.println("Stream API: Complete surrogate pair: " + "\ud800\uDC00".codePoints().anyMatch(i -> Character.isLowSurrogate((char)i)));
        System.out.println("Stream API: High surrogate (ill-formed): " + "\uD800".codePoints().anyMatch(i -> Character.isLowSurrogate((char)i)));
        System.out.println("Stream API: Low surrogate (ill-formed): " + "\uDC00".codePoints().anyMatch(i -> Character.isLowSurrogate((char)i)));
        // Stream API: Complete surrogate pair: false
        // Stream API: High surrogate (ill-formed): false
        // Stream API: Low surrogate (ill-formed): true

    }
}
