```C
digraph AEF {

node [fontsize=6]

// == AEF NAME
  node [shape=plain]
    AEF [fontsize=10, fontcolor=blue, label="String"]

// == STATE
  node [shape=circle]

// == ACCEPTING STATE 
  node [peripheries=2]
    ACCEPT [style=filled, fillcolor=green4, fontcolor=white]
    
// == NON ACCEPTING STATE
  node [peripheries=1]
    REJECT [style=filled, fillcolor=black, fontcolor=white]
    ENTRY

// == ERROR STATE
  node [fontcolor=red]  
    ERROR [style=filled, fillcolor=red, fontcolor=white]
    BODY
    FORBIDDEN

// == INITIAL STATE
  edge [fontsize=12]
    AEF -> ENTRY
    
// == TRANSITIONS
  edge [fontcolor=green4]
    ENTRY -> BODY [label="\""]
 
    BODY -> ACCEPT [label="\""] 
    BODY -> ESCAPE [label="\\"]
    BODY -> FORBIDDEN [label="\\n"]
    BODY -> BODY [label="(_)"]
    ESCAPEF -> FORBIDDEN [label="(_)"]
    ESCAPE -> BODY [label="(_)"]
    FORBIDDEN -> ESCAPEF [label="\\"]
    FORBIDDEN -> ERROR [label="\""]
    FORBIDDEN -> FORBIDDEN [label="(_)"]

// == NOT CONSUMED
  edge [color=gray, fontcolor=gray]

// == COMPLETION   
    ENTRY, REJECT -> REJECT [label="(_)"]
 
}
```
