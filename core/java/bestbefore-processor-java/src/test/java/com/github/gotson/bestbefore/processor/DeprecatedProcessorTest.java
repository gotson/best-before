package com.github.gotson.bestbefore.processor;

import com.karuslabs.elementary.Results;
import com.karuslabs.elementary.junit.JavacExtension;
import com.karuslabs.elementary.junit.annotations.Classpath;
import com.karuslabs.elementary.junit.annotations.Processors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(JavacExtension.class)
@Processors({DeprecatedProcessor.class})
class DeprecatedProcessorTest {
    @Test
    @Classpath("testdata.DeprecatedCase")
    void givenDeprecatedAnnotationThenResultsAreNotEmpty(Results results) {
        assertThat(results.errors).isNotEmpty();
    }
}