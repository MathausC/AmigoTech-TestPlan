# AmigoTech-TestPlan

*Este é o Test Plan para a desafio prático para a vaga de Analista de testes Jr. na AmigoTech.*

## Resumo

Plano de testes para a garantia das funcionalidades da plataforma de compras em desemvolvimento.

## Objetivo

Garantir as funcionalidades de adição de item ao carrinho e efetuação de compras.

## Tipo de teste

Testes funcionais

## Escopo

**Itens a serem testados:**

* Função de adicionar ao carrinho
* Função de remover do carrinho

**Itens a não serem testados:**

* Pesquisa de items
* Quantidade de items na página
* Ordem de exibição dos items na página
* Função de finalização de compras

## Cenário de testes

### Verificar que ao adicionar um item ao carrinho o mesmo deve ser visto no carrinho

**Prerequisitos do teste:**

* Usuário já está logado no sistema

**Passos dos testes:**

1. Click no botão de adicionar um item ao carrinho.
2. Vá até o carrinho
3. Verifique que o item selecionado está presente no carrinho.

### Verificar que ao remover um item do carrinho o mesmo não deve estar presente no carrinho

**Prerequisitos do teste:**

* Usuário já está logado no sistema

**Passos dos testes:**

1. Click no botão de adicionar um item ao carrinho.
2. Click no botão para remover o mesmo item do carrinho.
3. Verifique que o item selecionado não está presente no carrinho.

### Verificar que a quantidade de itens adicionados é correspondente no carrinho

**Prerequisitos do teste:**

* Usuário já está logado no sistema

**Passos dos testes:**

1. Click no botão de adicionar um item ao carrinho.
2. Click no botão de adicionar um item diferente ao carrinho.
3. Vá até o carrinho.
4. Verifique que ambos os item selecionado estão presentes no carrinho.

### Verificar que a remoção de um item ao carrinho só afeta o item removido

**Prerequisitos do teste:**

* Usuário já está logado no sistema

**Passos dos testes:**

1. Click no botão de adicionar um item ao carrinho.
2. Click no botão de adicionar um item diferente ao carrinho.
3. Click no botão de remover o primeiro item selecionado anteriormenete.
4. Verifique somente o segundo item selecinado está presente no carrinho.

## Cronograma

**Inicio dos testes:** Após as modificações estarem presentes no ambiente de teste (26/01/2024)

**Criar a espeficicação de teste:** 2 horas

**Execução de testes:** 1 hora

**Relatório de testes:** 2 hora

**Entrega de testes:** 2 horas

## Recursos

* Chrome Browser
* Firefox browser

## Levantamento de riscos

* Pesquisa de itens não foi verificada
* Compras de itens não foi verificada

## Documentação dos fluxos

* Jira
* Plano de testes
