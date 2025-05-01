import subprocess
import sys
import os


PACKAGE_NAME = "arbitraryarithmetic"
MAIN_CLASS = "MyInfArith"
SRC_DIR = "./"  
JAR_NAME = "aarithmetic.jar"


def compile_java():
    print(" Compiling Java files...")
    java_files = []
    for root, dirs, files in os.walk(SRC_DIR):
        for file in files:
            if file.endswith(".java"):
                java_files.append(os.path.join(root, file))

    compile_cmd = ["javac", "-d", ".", *java_files]
    result = subprocess.run(compile_cmd)

    if result.returncode != 0:
        print("Compilation failed.")
        sys.exit(1)
    print("Compilation successful.")

# === Step 2: Create JAR file ===
def create_jar():
    print(" Creating JAR file...")
    manifest_content = "Main-Class: " + MAIN_CLASS + "\n"
    with open("manifest.txt", "w") as f:
        f.write(manifest_content)

    jar_cmd = ["jar", "cfm", JAR_NAME, "manifest.txt", PACKAGE_NAME + "/", MAIN_CLASS + ".class"]
    result = subprocess.run(jar_cmd)

    if result.returncode != 0:
        print(" Failed to create JAR.")
        sys.exit(1)
    print(" JAR created as", JAR_NAME)


def run_java(args):
    print("Running MyInfArith with args:", args)
    run_cmd = ["java", "-cp", ".", MAIN_CLASS] + args
    result = subprocess.run(run_cmd)

    if result.returncode != 0:
        print("❌ Execution failed.")
        sys.exit(1)


if __name__ == "__main__":
    if len(sys.argv) != 5:
        print("Usage: python3 run_project.py <int/float> <add/sub/mul/div> <operand1> <operand2>")
        sys.exit(1)

    compile_java()
    create_jar()
    run_java(sys.argv[1:])
