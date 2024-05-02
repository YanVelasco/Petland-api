
Documentação da API Petland Animal
Este documento descreve as funcionalidades da API Petland Animal.

A API fornece funcionalidades para gerenciar animais, incluindo:

Criar novas entradas de animais.
Obter uma lista de todos os animais registrados.
Atualizar informações existentes de animais.
Excluir entradas de animais.
Modelo de Dados
A entidade de dados principal que representa um animal é AnimalEntity. Possui as seguintes propriedades:

id: Identificador único (UUID) do animal (gerado automaticamente).
nome: Nome do animal.
dataDeNascimento: Data de nascimento do animal (LocalDateTime).
especie: Espécie do animal (enum: GATO, CACHORRO, COBRA).
Endpoints
1. Listar todos os animais:

Método: GET
URI: /animal
Resposta: Retorna uma lista de objetos AnimalResponseDTO contendo detalhes de todos os animais registrados.
2. Criar um novo animal:

Método: POST
URI: /animal
Corpo da Solicitação: Aceita um objeto do tipo AnimalRequestDTO contendo detalhes do novo animal.
Resposta: Retorna o identificador único gerado (UUID) do animal criado.
3. Atualizar um animal existente:

Método: PUT
URI: /animal/{id} (onde {id} é o UUID do animal a ser atualizado)
Corpo da Solicitação: Aceita um objeto do tipo AnimalRequestDTO contendo as informações atualizadas para o animal.
Resposta: Nenhum conteúdo de resposta é retornado, mas um código de status indica sucesso (200 OK) ou falha.
4. Excluir um animal:

Método: DELETE
URI: /animal/{id} (onde {id} é o UUID do animal a ser excluído)
Resposta: Nenhum conteúdo de resposta é retornado, mas um código de status indica sucesso (200 OK) ou falha.
Observações Adicionais
Esta API utiliza JPA para persistência de dados e Lombok para redução de código repetitivo.
Spring Boot é o framework utilizado para construir esta API.

Documentação da API Petland - Serviços para Clientes
Este documento descreve as funcionalidades da API Petland para Serviços ao Cliente.

A API fornece funcionalidades para gerenciar serviços prestados a clientes, incluindo:

Criar novos registros de serviços para clientes.
Obter uma lista de todos os serviços prestados a clientes.
Atualizar informações de serviços existentes.
Excluir registros de serviços.
Modelo de Dados
A entidade de dados principal que representa um serviço ao cliente é CustomerServiceEntity. Possui as seguintes propriedades:

id: Identificador único (UUID) do serviço ao cliente (gerado automaticamente).
type: Tipo de serviço realizado (Enum: CONSULTA, VACINA, CHECKUP, BANHO).
status: Situação do serviço (Enum: AGENDADO, EM ANDAMENTO, FINALIZADO, CANCELADO).
description: Descrição do serviço realizado.
dateRealized: Data de realização do serviço (LocalDate).
timeRealized: Hora de realização do serviço (LocalDate).
emergency: Indica se o serviço foi de emergência (boolean).
registrationEntity: Entidade relacionada ao registro do cliente (relacionamento Muitos-para-Um).
serviceEntity: Entidade relacionada ao produto utilizado no serviço (relacionamento Muitos-para-Um).
patientEntity: Entidade relacionada ao animal atendido (relacionamento Muitos-para-Um).
value: Valor total do serviço prestado.
Endpoints
1. Listar todos os serviços ao cliente:

Método: GET
URI: /product-service (embora o nome do endpoint sugira serviços de produtos, ele trata de serviços ao cliente)
Resposta: Retorna uma lista de objetos CustomerServiceResponseDTO contendo detalhes de todos os serviços prestados a clientes registrados.
2. Criar um novo serviço ao cliente:

Método: POST
URI: /product-service
Corpo da Solicitação: Aceita um objeto do tipo CustomerServiceRequireDTO contendo detalhes do novo serviço ao cliente.
Resposta: Retorna o identificador único gerado (UUID) do serviço criado.
3. Atualizar um serviço ao cliente existente:

Método: PUT
URI: /product-service/{id} (onde {id} é o UUID do serviço a ser atualizado)
Corpo da Solicitação: Aceita um objeto do tipo CustomerServiceRequireDTO contendo as informações atualizadas para o serviço.
Resposta: Nenhum conteúdo de resposta é retornado, mas um código de status indica sucesso (200 OK) ou falha.
4. Excluir um serviço ao cliente:

Método: DELETE
URI: /product-service/{id} (onde {id} é o UUID do serviço a ser excluído)
Resposta: Nenhum conteúdo de resposta é retornado, mas um código de status indica sucesso (200 OK) ou falha.

Observações Adicionais
Esta API utiliza JPA para persistência de dados e Lombok para redução de código repetitivo.
Spring Boot é o framework utilizado para construir esta API.

