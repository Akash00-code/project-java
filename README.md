##project java
This library allows you to perform basic arithmetic operations—addition, subtraction, multiplication, and division—on arbitrarily large integers and floating-point numbers using custom classes Ainteger and AFloat located in the arbitraryarithmetic package.
##RUNNING FROM THE COMMAND LINE
you can run the library provided MyInfArith class
SYNTAX
java MyInfArith <type> <operation> <operand1> <operand2>
<type>--> int or float
<operation>--> add,sub,mul or div
<operand1>,<operand2>--> string representing the numbers
###Example
java MyInfArith int add 12345678901234567890 98765432109876543210
#### Output: 11111111101111111110
java MyInfArith float div 1.23456789 3.21
#### Output: 0.384627414330218068535825545171
## Using Python Script
To build and run the program more easily, use the python_script.py
SYNTAX
python3 python_script.py <int|float> <add|sub|mul|div> <operand1> <operand2>
It handles:
Java compilation
JAR creation
Execution of MyInfArith
###Example
python3 python_script.py int mul 123456789 987654321
#### Output: 121932631112635269
## Building with Ant
You can also build and run the project using Ant
SYNTAX
ant compile  -->  Compiles the project
ant jar      -->  Creates aarithmetic.jar
ant run -Dargs="int sub 94562782633337846 293372829208367"  --> Runs with arguments
ant clean -->   clean up build directories
#### Output: 65225499712501146
## Using docker 
my docker file uses ant to run this project
first pull the docker image and run it
SYNTAX
docker pull akash00code/myinfarith
docker run --rm akash00code/myinfarith ant -Dargs="<type> <operation> <operand1> <operand2>"





