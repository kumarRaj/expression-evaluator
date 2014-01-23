Expression Evaluator
--------------------
###To Use :
    git clone this repository.
    Use ant and get a distribution by using
        `ant dist`
    Extract the zip generated in build/expression-evaluator-test into a directory.
    Add this folder to an environment variable.
             Name : `EVALUATOR_HOME`
             Value : The folder where this is extracted.
             Put In Path : `EVALUATOR_HOME\bin`
        _____

    Thats all now you can run and test by typing calculate and expression in quotes.
###Version 0.3
    Added features :
    You can give input without spaces in between numbers.
    e.g. calculate "2+2"
    Bug
###Version 0.2

    Gives new feature of following opoerators.
         - , * , / , ^
    You can subtract, multiply,divide,and find power for 2 operators.
        e.g.calculate "6 - -2"
            calculate "6 * -2"
            calculate "6 / -2"
            calculate "6 ^ 2"
    Bugs :
    Power for negative numbers is not possible.

###Version 0.1

    It takes simple input of 2 numbers and addition operator.
    To be run from the command line.
    Adds them and gives the result.
    Allows integer numbers - positive as well as negative.
    Space in between number and operators.
    
    e.g. calculate "4 + 5"



