# YAGNI detector

Feed the [YAGNI](http://c2.com/cgi/wiki?YouArentGonnaNeedIt) detector with plain text and it will return a measure where 10 is totally YAGNI and 0 is not YAGNI at all. The measure is done by matching the input text for typical YAGNI asserts like "future developers" or "very generic" or "if" clauses and so on. The configuration file contains all the YAGNI combinations and their weights.

## Install with brew

    > brew tap reborg/taps
    > brew install yagni
    > yagni some-file.txt

## From the sources

    lein uberjar
    java -jar target/yagni.jar some-input.txt

or with the provided wrapping script (you still need to uberjar it at least once):

    YAGNI_HOME=. ./bin/yagni some-input.txt

To change the default options:

    "-t" "--test" "just echoes the argument list and exits"

## Configure

The matching keywords and their weights are available in resources/config.local.
