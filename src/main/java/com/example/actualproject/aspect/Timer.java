package com.example.actualproject.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // here means we are going to put this annotation on methods
@Retention(RetentionPolicy.RUNTIME) // here if we want this annoatation to work on runtime or compile time
public @interface Timer {

}
