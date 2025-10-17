[![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/gotson/best-before/ci.yml?branch=main&style=flat-square)](https://github.com/gotson/best-before/actions/workflows/ci.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.gotson.bestbefore/bestbefore-processor-kotlin?color=blue&style=flat-square)](https://search.maven.org/search?q=g:com.github.gotson.bestbefore)
![Maven Snapshots](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Fcom%2Fgithub%2Fgotson%2Fbestbefore%2Fbestbefore-processor-kotlin%2Fmaven-metadata.xml&style=flat-square&label=maven%20snapshot&color=blue
)

# Best Before

An annotation processor for Java and Kotlin that will throw an error if `@Deprecated` code is found.

## But why?

Deprecated code is usually removed on major releases. It can happen that we forget to remove deprecated code before shipping a new major version.

Best Before is here to handle those cases. By enabling the annotation processor during major versions, and failing the build if some deprecated code is found, one can ensure major versions are free of deprecated code.

## How to use?

Best Before is composed of two annotation processors:
- `bestbefore-processor-java` which handles `java.lang.Deprecated`
- `bestbefore-processor-kotlin` which handles `kotlin.Deprecated`, and needs to be used with KSP

Apply the dependency only if the version is a major version:

### Gradle (Groovy)

```groovy
if (version.toString().contains(".0.0")) {
    annotationProcessor 'com.github.gotson.bestbefore:bestbefore-processor-java:0.1.0'
    ksp 'com.github.gotson.bestbefore:bestbefore-processor-kotlin:0.1.0'
}
```

### Gradle (Kotlin DSL)

```kotlin
if (version.toString().contains(".0.0")) { 
  annotationProcessor("com.github.gotson.bestbefore:bestbefore-processor-java:0.1.0")
  ksp("com.github.gotson.bestbefore:bestbefore-processor-kotlin:0.1.0")
}
```