# Working with Spring's `MessageSource` interface

Spring's documentation has [this](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/MessageSource.html) description for the `MessageSource` interface:

> Strategy interface for resolving messages, with support for the parameterization and internationalization of such messages.

Ok, so that's a big word: ***internationalization***
    
If that eight syllable word isn't for you, try it's five syllable sidekick: ***localization***, which is only a little bit less of a mouthful.

Wikipedia has [this](https://en.wikipedia.org/wiki/Internationalization_and_localization) to say about the two of them:

> Internationalization and localization are means of adapting computer software to different languages, regional peculiarities and technical requirements of a target locale.
>
> Internationalization is the process of designing a software application so that it can be adapted to various languages and regions without engineering changes. 
>
> Localization is the process of adapting internationalized software for a specific region or language by translating text and adding locale-specific components. 
>
>Localization (which is potentially performed multiple times, for different locales) uses the infrastructure or flexibility provided by internationalization (which is ideally performed only once before localization, or as an integral part of ongoing development).

As web developers, we know that our work will be accessed and viewed by people from all over the world, each speaking one or more various languages. Should make custom views for every locale and them based upon the user's locale? Surely, there must be a better way.

The problem is then: 

 > How can we ensure that the content displayed by our web app is appropriate based upon the end user's specified locale?

The answer: ***internationalization***

By providing a layer of abstraction between the view itself and the content which gets rendered within the view, we are able to manipulate the content based upon the end user's specified locale.

This demo focuses simply on the functionality of one of Spring's out-of-the-box implementations of the `MessageSource` interface: `ResourceBundleMessageSource`. Another project will illustrate how you can practically leverage other classes/interfaces provided by Spring (e.g. `LocaleResolver` and `LocaleChangeInterceptor`) along with its MVC architecture to internationalize your web applications.

Spring's `ResourceBundleMessageSource` implementation works by looking for "resource bundles" on the project's classpath - by default, Spring looks in `src/main/resources` for `.properties` files containing internationalization keys and values. These files will contain locale-specific data that can be used to render static content on the page based upon the specified locale. Here, as a proof of concept, we are simple using this implementation simply print the content, which is requested by its key and a specified `Locale` object (note that the `Locale` object is provided by the Java platform).

## Project structure

```
spring-message-source-demo
|
|__src
|  |__main
|     |__java
|     |  |__dev
|     |     |__innov8
|     |        |__config
|     |        |  |__AppConfig.java
|     |        |
|     |        |__services
|     |        |  |__MessageTranslator.java
|     |        |
|     |        |__AppDriver.java
|     |
|     |__resources
|     |  |__messages
|     |     |__demo_en.properties
|     |     |__demo_es.properties
|     |
|     |__logback.xml  
|  
|__pom.xml
|__README.md
```