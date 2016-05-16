-injars bin/qingdewad.jar
-outjars bin/qingdewad1.0.jar

-libraryjars /Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Classes/classes.jar
-libraryjars libs/android-support-v4.jar
-libraryjars libs/asmack.jar
-libraryjars /Users/guang/Documents/work/adt/sdk/platforms/android-19/android.jar

-dontshrink
-useuniqueclassmembernames
-keeppackagenames
-keepattributes Exceptions,InnerClasses,Signature,Deprecated,SourceFile,LineNumberTable,LocalVariable*Table,*Annotation*,Synthetic,EnclosingMethod
-keepparameternames
-dontwarn


-keep public class * extends android.app.Fragment

-keep public class * extends android.app.Activity

-keep public class * extends android.app.Application

-keep public class * extends android.app.Service

-keep public class * extends android.content.BroadcastReceiver

-keep public class * extends android.content.ContentProvider

-keep public class * extends android.app.backup.BackupAgentHelper

-keep public class * extends android.preference.Preference

-keep public class * extends android.support.v4.**

-keep public class com.android.vending.licensing.ILicensingService

-keep class * extends com.novell.sasl.**

-keep class * extends de.measite.smack.**

-keep class * extends org.jivesoftware.**

-keep class * extends org.apache.**

-keep class * extends android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

-keep class android.support.v4.** {
    <fields>;
    <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context);
}

-keep class com.qinglu.QLAdController {
    public <fields>;
    public <methods>;
    *** set*(***);
    *** get*();
}

-keep class com.novell.** {
    *;
}

-keep class de.measite.** {
   *;
}

-keep class org.jivesoftware.** {
    *;
}

-keep class org.apache.** {
    *;
}


-keepclasseswithmembers,allowshrinking class * {
    public <init>(android.content.Context,android.util.AttributeSet);
}

-keepclasseswithmembers,allowshrinking class * {
    public <init>(android.content.Context,android.util.AttributeSet,int);
}

# Also keep - Enumerations. Keep the special static methods that are required in
# enumeration classes.
-keepclassmembers enum  * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Keep names - Native method names. Keep all native class/method names.
-keepclasseswithmembers,allowshrinking class * {
    native <methods>;
}
