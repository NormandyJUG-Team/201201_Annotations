package com.zenika.presentation.annotations.compilation.serializable;

import java.lang.annotation.*;


@Target(value = ElementType.PACKAGE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface SerializableClasses {
}

