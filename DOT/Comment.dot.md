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
    ERROR [style=filled, fillcolor=red,fontcolor=white]

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
  ETOILE  -> CLOSE [label="*" ]
  ETOILE  -> BODYS [label="\""]
  BODYS  -> ETOILE [label="\""]
  BODYS -> ESCAPES [label="\\"]
  BODYS -> FORBIDDENS [label="\\n"]
  BODYS -> BODYS [label="(_)"]
  ESCAPEF -> FORBIDDENS [label="(_)"]
  ESCAPES -> BODYS [label="(_)"]
  FORBIDDENS -> ESCAPEF [label="\\"]
  FORBIDDENS -> ERROR [label="\""]
  FORBIDDENS -> FORBIDDENS [label="(_)"]
  ETOILE  -> BODYC [label="`"]
  BODYC  ->  ETOILE [label="`"]
  BODYC -> ESCAPEC [label="'\\'"]
  BODYC -> FORBIDDEN [label="'\\n'"]
  BODYC -> BODYC [label="(_)"]
  ESCAPEC -> BODYC [label="(_)"]
  FORBIDDENC -> ERROR [label="'`'"]
  FORBIDDENC -> FORBIDDENC [label="(_)"]
  CLOSE -> ACCEPT [label="/"]
  CLOSE -> CLOSE [label="*"]
  CLOSE -> ETOILE [label="(_)"]
 

// == NOT CONSUMED
  edge [color=gray, fontcolor=gray]

// == COMPLETION   
    ENTRY, REJECT,OPEN -> REJECT [label="(_)"]
 
}
```
