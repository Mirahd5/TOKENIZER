```C
digraph AEF {

node [fontsize=6]

// == AEF NAME
  node [shape=plain]
    AEF [fontsize=10, fontcolor=blue, label="(a|b)*.aba"]

// == STATE
  node [shape=circle]

// == ACCEPTING STATE 
  node [peripheries=2]
    ACCEPT [style=filled, fillcolor=green4, fontcolor=white]
    
// == NON ACCEPTING STATE
  node [peripheries=1]
    REJECT [style=filled, fillcolor=black, fontcolor=white]
    INIT

// == INITIAL STATE
  edge [fontsize=12]
    AEF -> INIT
    
// == TRANSITION
  edge [fontcolor=green4]
  INIT -> INIT [label="b"]
  INIT -> A [label="a"]
  A ->  A [label="a"]
  A ->  B [label="b"]
  B -> ACCEPT  [label="a"]
  B -> INIT  [label="b"]
  ACCEPT -> A [label="a"]
  ACCEPT -> B [label="b"]
 


// == COMPLETION   
  edge [color=gray, fontcolor=gray]
    REJECT ,A,B,INIT,ACCEPT-> REJECT [label="(_)"]
}
```
