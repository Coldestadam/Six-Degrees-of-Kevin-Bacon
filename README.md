# Six-Degrees-of-Kevin-Bacon

# Runtime Analysis

Runtime of Breadth-First-Search is Θ(|V| + |E|)

# Compiling and Running

Run this to compile and run the program

```bash
javac -cp json-simple-1.1.1.jar *.java
java -cp .:json-simple-1.1.1.jar CS245A2 tmdb_5000_credits.csv
```

This is an example of an output:
```bash
Actor 1 name: Adam Driver
Actor 2 name: Michael Jackson
The Path between Adam Driver and Michael Jackson: 
Adam Driver --> Tommy Lee Jones --> Michael Jackson
```
