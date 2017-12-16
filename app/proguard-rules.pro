-keepattributes Signature, *Annotation*, SourceFile, LineNumberTable, Exceptions
-keepattributes MethodParameters

# Kotlin
-keep class kotlin.** { *; }
-keep class org.jetbrains.** { *; }

# Android support
-keep interface android.support.** { *; }
-keep class android.support.** { *; }