﻿# Rotas-de-Reciclagem

# Configurando e Executando um Workflow do GitHub Actions

Este repositório utiliza **GitHub Actions** para automação de workflows, como CI/CD (Integração Contínua e Entrega Contínua). Este guia mostra como configurar e executar um arquivo de workflow YAML para o GitHub Actions.

## Estrutura do Diretório

O arquivo YAML do workflow deve estar localizado dentro da pasta `.github/workflows` no repositório. A estrutura de diretórios deve se parecer com a seguinte:

.github/ 
└── workflows/ 
    └── firstbuild.yaml

Esse workflow será acionado automaticamente quando houver um push ou pull request para a branch main.

### Como Configurar e Executar

Verifique se o arquivo YAML está no diretório correto:
O arquivo deve ser colocado em .github/workflows/. Certifique-se de que o nome do arquivo termina com .yaml ou .yml.
Suba o arquivo para o repositório:
Faça commit do seu arquivo de workflow e envie-o para o GitHub:

git add .github/workflows/seu-workflow.yaml
git commit -m "Adiciona workflow de CI/CD"
git push origin main

Acompanhe a execução do Workflow:
Assim que o arquivo for enviado, o GitHub Actions será automaticamente acionado para rodar o workflow de acordo com os eventos configurados (como push ou pull_request na branch main). Você pode acompanhar a execução do workflow na aba Actions do repositório.

Vá até o seu repositório no GitHub.
Clique na aba Actions.
Veja a lista de execuções de workflows e clique para visualizar detalhes.

