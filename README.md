# README - API Message avec Spring Boot

## Prérequis
- Docker et Docker Compose installés
- Java (JDK 17 ou supérieur) installé
- Maven Wrapper inclus dans le projet

## Démarrage du projet

1. Lancer les conteneurs Docker :
   ```sh
   docker compose up -d
   ```

2. Se connecter à MongoDB avec `mongosh` :
   ```sh
   docker exec -it mongo-container mongosh -u root -p rootpassword --authenticationDatabase admin
   ```

3. Démarrer l'application Spring Boot :
   ```sh
   ./mvnw spring-boot:run
   ```

4. Vérifier la connexion à l'API en accédant à :
   ```
   http://localhost:8080/hello/testConnection
   ```

## Tester la création d'un message

Pour tester l'ajout d'un message dans la base de données, exécutez la commande suivante dans un terminal :

```sh
curl -X POST http://localhost:8080/api/messages \
     -H "Content-Type: application/json" \
     -d '{
       "texte": "Ceci est un message test.",
       "sujet": "Test de création",
       "etudiantId": 12345
     }'
```

### Réponse attendue

Une réponse similaire à celle-ci devrait être retournée :

```json
{
  "id": "67c95f5ef9fe1b5956d89237",
  "texte": "Ceci est un message test.",
  "lu": false,
  "sujet": "Test de création",
  "etudiantId": 12345,
  "dateCreation": "2025-03-06T09:39:58.783631584"
}
```

## Vérification dans la base de données

Vous pouvez ensuite vérifier que le message a bien été inséré dans MongoDB avec la commande suivante dans `mongosh` :

```sh
db.messages.find();
```

Cela devrait retourner l'élément inséré dans la base de données.
