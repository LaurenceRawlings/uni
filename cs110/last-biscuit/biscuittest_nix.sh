javac LastBiscuit.java
java LastBiscuit < $1.txt > output.txt
diff $1output.txt output.txt
