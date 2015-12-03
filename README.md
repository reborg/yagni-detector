# YAGNI detector

A little for fun a little for real. Feed the [YAGNI](http://c2.com/cgi/wiki?YouArentGonnaNeedIt) detector with plain text and it will return a measure where 10 is total YAGNI and 0 is not YAGNI at all. Use the yagni-detector to point friends and colleagues to a "scientific measure" of the YAGNI factor a discussion is generating. The YAGNI detector will promptly tell you if some idea can wait implementation until there are solid pragmatic reasons to support it. yagni-detector is also helpful for spotting BDUF, KISS and DRY issues.

The measure is done by matching the input text for typical YAGNI assertions like "what if" or "if we were to" clauses and so on. The configuration file contains all the YAGNI combinations and their weights. Customize it at will.

## Install with brew

    > brew tap reborg/taps
    > brew install yagni
    > yagni some-file.txt

Or upgrade:

    > brew update
    > brew unlink yagni
    > brew install yagni

## From the sources

    lein uberjar
    java -jar target/yagni.jar some-input.txt

or with the provided wrapping script (you still need to uberjar it at least once):

    YAGNI_HOME=. ./bin/yagni some-input.txt

To change the default options:

    "-t" "--test" "just echoes the argument list and exits"

## Configure

The matching keywords and their weights are available in resources/config.local.

## Reinstall

* do changes and bump version
* lein uberjar
* git commit
* goto github and cut a new release
* goto homebrew-taps project
* vi yagni.rb and bump version there
