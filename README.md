# Kochbuch

27.06.2025
made by: `Silas`, `Fatlind`, `Noah`, `Remo`

## Anforderung:

### Backend

- API: CRUD Springboot api welche via postman gesteuert wird und auf db zugreift. (POST, GET, PUT,DELETE)
- API design: endpoints: `rezept`, `rezept/{id},`, `rezept/get-by-category`
- **GET:** get all rezepte `/rezept`, get rezept by id `/rezept/{id}`, get rezept by category `rezept/get-by-category`
- **POST:** erstelle rezept `/rezept`
- **PUT:** bearbeite rezept `/rezept/{id}`
- **DELETE:** lösche rezept `/rezept/{id}`

### Database:

- DB: collections: Rezepte (beinhaltet: zutaten, zubereitung step by step), Kategorien (Dessert, hauptspeisen, vorspeisen)
- port for DB: 8088:8081

Docker: db dockerized mit docker-compose.yml

### Go On

zukünftige features wenn zeit passt:
...
