# Conception OO d'automates reconnaisseurs

#### Objectif du TP

Le but du TP est d'écrire en OO un _Tokenizer_ qui utilise des AEF pour catégoriser en _Token_ les différents constituants d'un texte.

* On propose dans ce TP d'exploiter cette catégorisation en _Token_ pour afficher les 
constituants d'un texte en couleur comme le fait un éditeur de texte.

* Pour effectuer l'affichage en couleur, le _Tokenizer_ émet des notifications 
à l'intention d'un `PrettyPrinter` via un `Listener`. 

#### Rendu de TP avant le `mercredi 26 novembre 23h59`

---
> __IMPORTANT__ : Passé(e) cette date, vous aurez 0 si vous n'avez pas déposé sur le site les dernières versions des fichiers à rendre :
---
  * `Ident.dot`, `RecIdent.java`
  * `Comment.dot`, `RecComment.java`
  * `String.dot`, `RecString.java`


#### Contenu de l'enseignement

1. description d'automates au format `.dot`
2. implémentation d'AEF dans un langage OO
3. application à la colorisation dans un éditeur de code


# Installation
---
> __IMPORTANT__ : commencez par cliquer sur `Update Fork` pour récupérer les dernières modifications.
---


#### I. Clonez le dépôt distant dans votre workspace eclipse 

  * Faîtes un `git clone` du projet `TOKENIZER` pour lequel vous avez reçu une invitation.

  * Le projet est hébergé sur le dépôt distant [gricad-gitlab](https://gricad-gitlab.univ-grenoble-alpes.fr/) donc la commande sera de la forme

  `git clone https://gricad-gitlab.univ-grenoble-alpes.fr/michael_perin_private_project/aeg_2025/`_votre_login_gricad_`/TOKENIZER.git`

  en remplaçant la partie en italic par votre _votre_login_gricad_

  * Vous obtenez un répertoire `TOKENIZER` qui contient un projet java

  
#### II. Dans le répertoire `Tokenizer/` 

* Ouvrez le fichier [Makefile](Makefile) et ajustez les variables si nécessaire
  * `login_gricad :=` _votre_login_gricad_ 
  * `workspace` à votre organisation de fichiers 

* Dans un terminal dans le répertoire `Tokenizer/` : 
  testez le `Makefile` à dans le répertoire `Tokenizer/` en exécutant les commandes suivantes

  1. `make`
      * vérifiez le positionnement des variables avant de continuer
      * vérifiez la présence des outils `sed`, `tar` et `dot` qui seront nécessaires
     
  2. `make jpg` : génère les images des automates à partir des fichiers `.dot`

  3. `make exec` : génère les `.class` à partir des fichiers `.java`
 
  4. `make demo` : exécute `java -cp bin/ Recognizer.Tokenizer README.md` qui lance le Tokenizer sur ce fichier README.

  5. `make clean` : supprime les fichiers générés


#### III. Créez les templates à compléter et une branche qui porte le nom avec votre login gricad

 Vous êtes invité dans le projet `TOKENIZER` en tant que `Developer` gitlab ce qui ne vous donne *pas le droit* de modifier la branche `master`. Vous devez donc créer puis travailler sur votre branche.

---
> __IMPORTANT__ : la commande `make template` finalise l'installation
---

* elle crée une branche portant votre nom de _login_gricad_ 
  * `git branch` _votre_login_gricad_
  * `git switch` _votre_login_gricad_
* elle crée les fichiers à compléter et exécute les commandes `git` : add, commit de ces fichiers
  
* elle transmet la branche au dépôt distant `gricad-gitlad` avec la commande
  * `git push origin` _votre_login_gricad_

#### IV. Créez un projet Java sous Eclipse ou VSCode et commencez à travailler

Testez vos reconnaisseurs avec les commandes 

  * `make test` : lance l'exécutable sur les fichiers du répertoire `TEST/OK/`

  * `make error` : lance l'exécutable sur les fichiers du répertoire `TEST/ERROR/`


#### V. Vous devez rendre le TP avant le 26 novembre 23h59 (sinon c'est 0) 

* `git push` après avoir fait les `add` et les `commit` de vos fichiers

---

# Travail à réaliser

## Étudiez les reconnaisseurs fournis en `.dot` et `.java` (30min)

* `RecAny.java` est l'implémentation en `.java` 
  * de l'automate `any.dot` qui reconnaît tous les mots de longueur 1
  * émet la notification `void any(String recognized)` en cas de reconnaissance

* `RecABC.java` est l'implémentation en `.java` 
  * de l'automate `abc.dot` qui reconnaît les mots du langage `a.(b.b*|c)`
  * émet la notification `void abc(String recognized)` en cas de reconnaissance

* `RecCommand.java`est l'implémentation en `.java` 
  * de l'automate `Command.dot` qui reconnaît les commandes entre `\`` (sans saut de ligne `\n`)
  * émet la notification `void command(String recognized)` en cas de reconnaissance
  * émet la notification `void error(String consumed, String explanation)` en cas d'erreur

* chaque reconnaisseur notifie le `PrettyPrinter` qui affiche le contenu reconnu dans un couleur appropriée

## Les reconnaisseurs à écrire en `.dot` puis en `.java`

#### Consignes 

> Pour chaque reconnaisseur, 
  * faîtes valider l'automate `.dot` avant de passer à son implémentation en `.java`
  * modifiez `Tokenizer.java` pour ajouter votre nouveau reconnaisseur
  * testez avec `make test` pour vérifier que vous reconnaissez correctement les tokens
  * testez avec `make error` pour vérifier que vous détectez les erreurs

### Exercice 1 : `(a|b)*.aba` (5min)

* Complétez le fichier `_aba.dot.md` pour décrire un AEF qui reconnaît les mots de la forme `(a|b)*.aba`
* `make jpg` pour visualiser le résultat


### Exercice 2 : `Identificateurs` (30min)

Complétez `Ident.dot.md` afin de décrire un AEF qui reconnaît les identificateurs 
  * de longueur &geq;1, 
  * formés de lettres (minuscules et majuscules), de `_` et de digits (`0` à `9`) 
  * mais ne commençant pas par un digit.

Complétez `RecIdent.java` qui implémente l'AEF et émet les notifications 
  * `void ident(String recognized)` 
  * ou `void keyword(String recognized)` si l'identificateur est un mot-clef
  * ou `void type(String recognized)` si l'identificateur commence par une majuscule

Exemples :
  * «_, x, _ABC» sont des identificateurs valides
  * «Object, Recognizer» sont des identifcateurs valides qui sont en fait des types
  * «if, then, else, return» sont des identificateurs valides, certains sont en fait des mots-clefs
  * «1_x» n'est pas un ident valide

### Exercice 3 : `String` (40min)

Complétez `String.dot.md` afin de décrire un AEF qui 
reconnaît les String entre `"` (sans saut de ligne `\n`).

Complétez `RecString.java` qui implémente cet AEF et notifie, via `void string(String recognized)`, le `PrettyPrinter` qui les affiche.

Exemples :  
  * "une string"
  * "une string contenant 3 caractères _escaped_ : [\"] [\\] [\n]"

### Exercice 4 : `Comment` (60min)

Complétez `Comment.dot.md` afin de décrire un AEF qui reconnaît les commentaires à la `C/Java`

Complétez `RecComment.java` implémente cet AEF et notifie, via `void comment(String recognized)`, le `PrettyPrinter` qui les affiche.

Exemples:

```C
/* un commentaire sur
 * deux lignes 
 */

// un commentaire sur une seule ligne
```

<PRE>
/* un commentaire qui contient la string "*/" pose t'il un problème? */
</PRE>