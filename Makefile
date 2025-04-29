### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS = 

### REGLES ESSENTIELLES ###

Main.class : Main.java Fenetre.class Accueil.class
	${JC} ${JCFLAGS} Main.java

Fenetre.class : Fenetre.java
	${JC} ${JCFLAGS} Fenetre.java

Grid.class : Grid.java Remplifile.class	Gravite.class AleaGrid.class EcranJeu.class
	${JC} ${JCFLAGS} Grid.java

Remplifile.class : Remplifile.java ChoixFichier.class Verification.class
	${JC} ${JCFLAGS} Remplifile.java

ChoixFichier.class : ChoixFichier.java
	${JC} ${JCFLAGS} ChoixFichier.java

Verification.class : Verification.java
	${JC} ${JCFLAGS} Verification.java

Accueil.class : Accueil.java PaintAccueil.class Fenetre.class ListenerGlobal.class
	${JC} ${JCFLAGS} Accueil.java

EcranJeu.class : EcranJeu.java Fenetre.class PaintJeu.class ListenerJeu.class
	${JC} ${JCFLAGS} EcranJeu.java

PaintAccueil.class : PaintAccueil.java
	${JC} ${JCFLAGS} PaintAccueil.java

PaintChoix.class : PaintChoix.java
	${JC} ${JCFLAGS} PaintChoix.java

PaintJeu.class : PaintJeu.java 
	${JC} ${JCFLAGS} PaintJeu.java

PaintFin.class : PaintFin.java
	${JC} ${JCFLAGS} PaintFin.java

ListenerGlobal.class : ListenerGlobal.java Choix.class 
	${JC} ${JCFLAGS} ListenerGlobal.java
	
ListenerJeu.class : ListenerJeu.java Gravite.class EcranFin.class
	${JC} ${JCFLAGS} ListenerJeu.java

Gravite.class : Gravite.java GraviteGauche.class
	${JC} ${JCFLAGS} Gravite.java

GraviteGauche.class : GraviteGauche.java
	${JC} ${JCFLAGS} GraviteGauche.java

AleaGrid.class : AleaGrid.java
	${JC} ${JCFLAGS} AleaGrid.java

Choix.class : Choix.java PaintChoix.class Grid.class
	${JC} ${JCFLAGS} Choix.java

EcranFin.class : EcranFin.java PaintFin.class
	${JC} ${JCFLAGS} EcranFin.java

### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###
