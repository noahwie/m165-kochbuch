# Kochbuch
27.06.2025
made by: `Silas`, `Fatlin`, `Noah`, `Remo`

## Anforderung:
### Backend
- API: CRUD Springboot api welche via postman gesteuert wird und auf db zugreift. (POST, GET, PUT,DELETE)
- API design: endpoints: `rezept`, `rezept/{id},` `kategorie`, `kategorie/{id}`  
- **GET:** get all rezepte `/rezept`, get rezept by id `/rezept/{id}`, get all kategorien `/kategorie`, get kategorie by id `/kategorie/{id}`
- **POST:** erstelle rezept `/rezept`, erstelle kategorie `/kategorie`
- **PUT:** bearbeite rezept `/rezept/{id}`, bearbeite kategorie `/kategorie/{id}`
- **DELETE:** lösche rezept `/rezept/{id}`, lösche kategorie `/rezept/{id}`
### Database:
 - DB: collections: Rezepte (beinhaltet: zutaten, zubereitung step by step), Kategorien (Dessert, hauptspeisen, vorspeisen)
- collection constraints: kategorie kann mehrere rezepte enthalten. rezept kann nur in einer kategorie sein. 
 
Docker: db dockerized mit docker-compose.yml
 
### Go On
zukünftige features wenn zeit passt:
...