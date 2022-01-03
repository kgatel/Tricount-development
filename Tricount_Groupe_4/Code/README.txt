Bonjour,

Voici les instructions pour lancer notre modeste application. ☺️

Pour lancer le serveur:

Dans le dossier Serveur,
Pour compiler:
- make java
- javac *.java

Pour exécuter:
- rmiregisrty& (pour lancer le RMI)
Puis:
- java Serveur
Ou
- java Serveur 156 (pour lancer avec le port 156)

Pour lancer le Client:

Dans le dossier Client,
Pour compiler:
- make java
Ou
- javac *.java

!Attention le Serveur doit être lancé avent le Client!  

Pour exécuter:
- java Client (dans ce cas il vous demandera votre nom)
Ou
- java Client Paul (pour lancer avec le nom Paul)
Ou
- java Client Paul 127.0.0.1 (pour lancer avec le nom Paul et une IP Perso)
Ou
- java Client Paul 127.0.0.1 156 (pour lancer avec le nom Paul et une IP Perso avec le port 156)

L'IP perso et le port s'affichent sur le terminal Serveur.

Je vous laisse vous balader sur l'application pour la prendre en main. 
Normalement c'est instinctif.

PS: pour supprimer les fichiers *.class je vous invite à faire un "make clean" dans chaque dossier.

Bonne Balade et Bonne Journée! 🙂️

Signé le Groupe 4 😁️
