```C
digraph AEF {

node [fontsize=6]

// == AEF NAME
  node [shape=plain]
    AEF [fontsize=10, fontcolor=blue, label="Comment"]

// == STATE
  node [shape=circle]

// == ACCEPTING STATE 
  node [peripheries=2]
    ACCEPT [style=filled, fillcolor=green4, fontcolor=white]
    SINGLELINE 
    
// == NON ACCEPTING STATE
  node [peripheries=1]
    REJECT [style=filled, fillcolor=black, fontcolor=white]
    ENTRY

// == ERROR STATE
  node [fontcolor=red]  
    //ERROR [style=filled, fillcolor=red, fontcolor=white]

// == INITIAL STATE
  edge [fontsize=12]
    AEF -> ENTRY
    
// == TRANSITIONS
  edge [fontcolor=green4]
  ENTRY -> OPEN [label="/"]
  OPEN -> SINGLELINE [label="/"]
  OPEN -> ETOILE [label="*"]
  SINGLELINE -> SINGLELINE [label="(_)"]
  SINGLELINE -> ACCEPT [label="\\n"]
  ETOILE  -> ETOILE [label="(_)"]
  ETOILE  -> CLOSE [label="*"]
  CLOSE -> ACCEPT [label="/"]
  CLOSE -> CLOSE [label="*"]
  CLOSE -> ETOILE [label="(_)"]
 

// == NOT CONSUMED
  edge [color=gray, fontcolor=gray]

// == COMPLETION   
    ENTRY, REJECT,OPEN -> REJECT [label="(_)"]
 
}
```
