package de.mf.algo.inversion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberInversionTest {

    @ParameterizedTest
    @MethodSource("generate")
    void number_of_inversions(int[] numbers, int inversions) {
        int[] sorted = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sorted);

        assertEquals(inversions, NumberInversion.countInversions(numbers));
        assertArrayEquals(sorted, numbers);
    }

    static Stream<Arguments> generate() {
        return Stream.of(
                arguments(new int[]{8, 7, 6, 5, 4, 3, 2, 1}, 28),
                arguments(new int[]{4, 1, 5, 2, 7, 10, 6}, 5)
                );
    }

}