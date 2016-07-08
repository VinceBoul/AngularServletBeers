# AngularServletBeers
MongoDB + Servlet JAVA + AngularJS 

## Lancement base de donnée MongoDB

1. Configurer la variable %PATH% pour utiliser les commandes de MongoDB
  
   ```
   C:\Program Files\MongoDB\Server\3.2\bin
   ```

2. Créer un **répertoire** pour la base de donnée MongoDB
3. Initialiser la base de données en pointant vers ce dossier

```
mongod --dbpath REPERTOIRE
```

## Lancement du serveur Tomcat

Si des ports sont occupés au lancement de Tomcat, lancer l'invte de commande.

Lister les ports
Pour windows : 

```
netstat -aon
```

Identifier ceux qui finissent par ':<PORT OCCUPÉ>'

Tuer le processus : 

```
taskkill /f /pid <PROCESS ID>
```

## Problème de librairie Servlet
Prendre la version 3.0 : http://www.java2s.com/Code/Jar/s/Downloadservlet3apijar.htm
