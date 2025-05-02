
##  Project Java

This library allows you to perform basic arithmetic operations—addition, subtraction, multiplication, and division—on arbitrarily large integers and floating-point numbers using custom classes `Ainteger` and `AFloat` located in the `arbitraryarithmetic` package.

---

##  Running from the Command Line

You can run the library using the provided `MyInfArith` class.

###  Syntax

```bash
java MyInfArith <type> <operation> <operand1> <operand2>
```

- `<type>`: `int` or `float`  
- `<operation>`: `add`, `sub`, `mul`, or `div`  
- `<operand1>`, `<operand2>`: Strings representing the numbers

###  Example

```bash
java MyInfArith int add 12345678901234567890 98765432109876543210
# Output: 111111111011111111100
```

```bash
java MyInfArith float div 1.23456789 3.21
# Output: 0.384627414330218068535825545171
```

---

##  Using the Python Script

To simplify building and running the program, use the `python_script.py`.

###  Syntax

```bash
python3 python_script.py <int|float> <add|sub|mul|div> <operand1> <operand2>
```

This script handles:
- Compiling Java files
- Creating the JAR file
- Executing `MyInfArith` with the provided arguments

###  Example

```bash
python3 python_script.py int mul 123456789 987654321
# Output: 121932631112635269
```

---

##  Building with Apache Ant

You can also compile and run the project using `build.xml` and Ant.

###  Commands

```bash
ant compile                                 # Compile the Java source files
ant jar                                     # Create aarithmetic.jar
ant run -Dargs="int sub 94562782633337846 293372829208367"   # Run with arguments
ant clean                                   # Clean up build artifacts
```

###  Example

```bash
# Output: 65225499712501146
```

---

##  Running with Docker

This project includes a Docker image configured to use Ant for execution.

###  Steps

1. **Pull the Docker image**:
   ```bash
   docker pull akash00code/myinfarith
   ```

2. **Run a calculation**:
   ```bash
   docker run --rm akash00code/myinfarith ant run -Dargs="<type> <operation> <operand1> <operand2>"
   ```

###  Example

```bash
docker run --rm akash00code/myinfarith ant run -Dargs="float mul 3.14 2.71"
# Output: 8.5094
```

> 🔹 No need to install Java or Ant locally—Docker does it all!
