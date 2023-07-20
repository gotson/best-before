package com.github.gotson.bestbefore.processor.kotlin

import com.google.auto.service.AutoService
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.google.devtools.ksp.symbol.KSAnnotated

class DeprecatedKotlinProcessor(private val environment: SymbolProcessorEnvironment) : SymbolProcessor {
  override fun process(resolver: Resolver): List<KSAnnotated> {
    resolver.getSymbolsWithAnnotation("kotlin.Deprecated").forEach {
      environment.logger.error("Deprecated code should be removed", it)
    }
    return emptyList()
  }
}

@AutoService(SymbolProcessorProvider::class)
class DeprecatedProcessorProvider : SymbolProcessorProvider {
  override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
    return DeprecatedKotlinProcessor(environment)
  }
}