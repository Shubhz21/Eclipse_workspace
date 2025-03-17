package mypkg;

import java.lang.Process;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ccompiler {
    public static void main(String[] args) {
        try {
            String sourceFile = "cprogramfortest.c"; // C program 
            String outputFile = "output/cprogramfortest.exe"; // Compiled output

            // Compile the C Program using GCC
            Process compileProcess = Runtime.getRuntime().exec("gcc " + sourceFile + " -o " + outputFile);
            compileProcess.waitFor();

            if (compileProcess.exitValue() == 0) {
                System.out.println("✅ Compilation Successful!\nRunning the program...\n");

                // Execute the compiled C program
                Process runProcess = Runtime.getRuntime().exec(outputFile);

                // Read the output of the C program
                BufferedReader reader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                runProcess.waitFor();
            } else {
                System.out.println("❌ Compilation Failed!");
                printErrors(compileProcess);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printErrors(Process process) throws IOException {
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;
        while ((line = errorReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
