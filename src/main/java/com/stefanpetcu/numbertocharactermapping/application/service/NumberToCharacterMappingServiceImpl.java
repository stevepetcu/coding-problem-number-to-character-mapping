package com.stefanpetcu.numbertocharactermapping.application.service;

import com.stefanpetcu.numbertocharactermapping.application.dto.DigitToCharactersRecord;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NumberToCharacterMappingServiceImpl implements NumberToCharacterMappingService {
    @Override
    public List<String> getCharacterCombinationsFor(List<DigitToCharactersRecord> digitToCharactersMap, Integer number) {
        /**
         * TODO: in the while loop filter below, handle digits that do not exist in the map
         *  (e.g., 0 for the map defined in {@link NumberToCharacterMappingServiceImplTest#getCharacterCombinationsFor_returns_combinations_of_letters_given_a_number}
         */
        // 1. Create an array of the desired size, filled with empty strings.
        // 1.1 Assuming all digits are mapped to the same number of possible characters.
        var numberOfCharsPerDigit = digitToCharactersMap.get(0).characters().length;
        // 1.2 Create an array filled with distinct instances of StringBuilder.
        var result = Stream.generate(StringBuilder::new).limit((int) Math.pow(numberOfCharsPerDigit, String.valueOf(number).length())).toArray(StringBuilder[]::new);
        // 1.3 Keep track of iterations to know how many times we must repeat a character.
        var iterationNumber = 0;

        // 2. Add the actual strings to the previously created array.
        while (number > 0) {
            // 2.1 Take digits one-by-one from the end of the number.
            var digit = number % 10;
            number = number / 10;

            // 2.2 Find the map record.
            var mapRecord = digitToCharactersMap.stream().filter(record -> record.digit() == digit).findFirst().orElse(null);
            assert mapRecord != null; // TODO: handle null cases (related to the TODO above).
            var repeatEachCharacter = (int) Math.pow(numberOfCharsPerDigit, iterationNumber);

            // 2.3 Build the final result.
            var i = 0;
            var repeated = 0;
            for (StringBuilder stringBuilder : result) {
                stringBuilder.insert(0, mapRecord.characters()[i]);
                repeated++;

                if (repeated == repeatEachCharacter) {
                    i++;
                    repeated = 0;
                }

                if (i == numberOfCharsPerDigit) {
                    i = 0;
                }
            }
            iterationNumber++;
        }

        return Arrays.stream(result).map(StringBuilder::toString).toList();
    }
}
