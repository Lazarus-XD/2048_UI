# 2048 UI

**This is a remake of the game 2048, built using Java.**

To run the game type in terminal:
```{r, engine='bash', count_lines}
java -jar 2048.jar
```

## Doxygen
The entire code has doxygen comments. Doxygen is a documentation generator and static analysis tool for software source trees. When used as a documentation generator, Doxygen extracts information from specially-formatted comments within the code. There is a Makefile that is used to generate the pdf and html produced by doxygen.

To generate the doxygen file run in terminal:
```{r, engine='bash', count_lines}
make doc
```
This will create 2 new folders called html and latex.
- To view the generated pdf, go to latex and view refman.pdf
- To view the generated webpage, go to html and view index.html

## Video Demo
![2048](https://media.giphy.com/media/unaRnvg4A1LFpbbjpO/giphy.gif)
