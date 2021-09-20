# Mediscreen

## Launch postgresql server on docker

```bash
docker run --name mediscreen-postgres -p 5432:5432 -e POSTGRES_PASSWORD=mediscreen -e POSTGRES_USER=mediscreen -e POSTGRES_DB=mediscreen -d postgres
```