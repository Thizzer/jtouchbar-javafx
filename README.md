[![Build Status](https://travis-ci.com/Thizzer/jtouchbar-javafx.svg?branch=master)](https://travis-ci.com/Thizzer/jtouchbar-javafx)

# jtouchbar-javafx
Library adding convenience utils for adding JavaFX support to JTouchBar

## Support the Developers!

Please take a look at the other stuff the developers are working on and support them in other ways.

* [ttveldhuis](https://github.com/ttveldhuis)
  * Buy ttveldhuis a coffee - https://ko-fi.com/ttveldhuis
  * Patreon Page - https://www.patreon.com/ttveldhuis  
  * Blog - https://www.thizzer.com

#### Maven

```xml
<dependency>
	<groupId>com.thizzer.jtouchbar</groupId>
	<artifactId>jtouchbar-javafx</artifactId>
	<version>1.0.0-SNAPSHOT</version>
</dependency>
```

#### Gradle

```gradle
implementation group: 'com.thizzer.jtouchbar', name: 'jtouchbar-javafx', version: '1.0.0-SNAPSHOT'
```

#### JavaFX Example

```java
Stage stage = ...

JTouchBar jTouchBar = new JTouchBar();
jTouchBar.setCustomizationIdentifier("MyJavaFXJavaTouchBar");

// Customize your touchbar

JTouchBarJavaFX.show(jTouchBar, shell);
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details