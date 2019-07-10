# spring-rest-and-rabbitMQ

Api rest para cadastrar produtos, clientes, e realizar pedidos. A partir de um pedido realizado notifica o serviço RabbitMQ para uma fila de entregas. O sistema irá ler essas filas e inserir automaticamente as entregas de cada pedido.

#### API CONTEXT

/api

##### PARÂMETROS DE PROPRIEDADE

Porta do servidor |	--port	| 9090 (Padrão)

#### GET

/api/clientes - Lista todos os clientes
/api/clientes/{id} - Busca um cliente por id

/api/entregas - Lista todas as entregas

/api/pedidos - Lista todos os pedidos
/api/pedidos/{id} - Busca um pedido por id

/api/produtos - Lista todos os produtos
/api/produdos/{id} - Busca um produto por id

#### POST

/api/clientes - Adiciona um novo cliente

/api/pedidos - Adciona um novo pedido (Com serviço interno para inserir uma entrega)

/api/produtos - Adciona um novo produto

#### PUT

/api/clientes - Atualiza um cliente

/api/pedidos - Atualiza um pedido

/api/produtos - Atualiza um produto

#### DELETE

/api/clientes/{id} - Remove um cliente por id

/api/pedidos/{id} - Remove um pedido por id

/api/produdos/{id} - Remove um produto por id

