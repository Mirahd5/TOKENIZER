# VARIABLES

DOT_FILES := $(wildcard *.dot.md)

TEMPLATE := Ident.dot.md String.dot.md Comment.dot.md
 
# COMMANDS

.PHONY: jpg all clean template

jpg: $(DOT_FILES:%.dot.md=%.jpg)

all: jpg md

clean:
	@rm -f $(DOT_FILES:%.dot.md=%.jpg)
	@rm -f $(DOT_FILES:%.dot.md=%.dot)

template: $(TEMPLATE)
	git add $(TEMPLATE)
	git commit -a -m "ADDED: $(TEMPLATE)"
	git push

# REGLES GENERIQUES

%.jpg: %.dot
	@dot -T jpg $< > $@

%.dot: %.dot.md
	sed -e "s|\`\`\`C||g ; s|\`\`\`||g" $< > $@ 

%.dot.md: 
	@sed -e "s|TEMPLATE|$*|g" TEMPLATE.dot.md > $@