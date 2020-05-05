package com.udemy.currencyexchangeservice.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiResource {
    String description() default "";
    String name() default "api-name";
    String developer() default "Saurav-Kumar";
    boolean required() default true;

}
