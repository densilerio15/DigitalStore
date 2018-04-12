# Product Service
Currently uses an in-memory DB(H2) to store the products.

## End points

| HTTP Method  | Path |Description |
| ------------- | ------------- | ------------- |
| POST  | /products/  | Creates a single product  |
| POST  | /products/batch  | Create multiple product with one request  |
| GET  | /products/{id} | Get single product with the ID specified  |
| GET  | /products/all  | Get All products |
