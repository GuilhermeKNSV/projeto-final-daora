# BarberShop

Sistema de agendamento de horários para uma barbearia.

| Campo | Informação |
|---|---|
| Aluno(a) | |
| Turma | |
| Opção escolhida | Agendamento de Serviços |
| Versão atual | 0.1.0 |

---

## 1. Visão geral

O **BarberShop** é um projeto de agenda online para barbearia. A ideia é que o cliente entre no site, escolha o barbeiro, veja os horários disponíveis e marque seu corte sem precisar ficar trocando mensagens para confirmar um horário.

O administrador vai ter uma área para acompanhar os agendamentos, cancelar horários quando necessário e identificar os atendimentos que ficaram atrasados.

### 1.1 Problema

Quando os horários são combinados só por mensagem ou anotados manualmente, pode acontecer de duas pessoas marcarem com o mesmo barbeiro no mesmo horário. Também fica mais difícil saber quem está agendado, quais horários estão livres e quais atendimentos estão atrasados.

### 1.2 Canvas do projeto

| Bloco | Resposta |
|---|---|
| Usuários (quem usa o sistema) | Clientes que querem agendar um corte e o administrador da barbearia, que organiza os horários. |
| Problema (dor atual) | Agendamentos por mensagem ou papel podem gerar confusão, horários repetidos e dificuldade para acompanhar a agenda. |
| Proposta de valor (o que melhora com o sistema) | O cliente consegue marcar um horário disponível sozinho, e a barbearia consegue organizar os atendimentos em um só lugar. |
| Funcionalidades principais | Cadastro de clientes e serviços, escolha do barbeiro, agendamento por dia e horário, bloqueio de horários ocupados e painel para o administrador acompanhar e cancelar reservas. |
| Informações que o sistema guarda | Dados dos clientes, serviços oferecidos, barbeiros, data e horário de cada agendamento e situação do atendimento. |
| Indicadores (o que o gestor quer acompanhar) | Agendamentos do dia, agendamentos cancelados e atendimentos atrasados. |
| Restrições (prazo, tecnologia, equipe) | Projeto solo, Java 21, previsto para 24/02/2027 |

---

## 2. Requisitos

### 2.1 Requisitos funcionais (o que o sistema faz)

| ID | Requisito | Nível |
|---|---|---|
| RF01 | O sistema deve permitir cadastrar, listar, editar e excluir clientes e serviços da barbearia. | Essencial |
| RF02 | O cliente deve conseguir escolher um barbeiro e consultar os dias e horários disponíveis para ele. | Completo |
| RF03 | O sistema deve registrar um agendamento com cliente, serviço, barbeiro, data e horário, mostrando a confirmação da reserva. | Essencial, com escolha de barbeiro no nível completo |
| RF04 | O administrador deve conseguir consultar os agendamentos, identificar os atrasados e cancelar reservas. | Essencial, com acompanhamento de atrasos como melhoria do BarberShop |

### 2.2 Requisitos não funcionais (como o sistema deve ser)

| ID | Requisito |
|---|---|
| RNF01 | O sistema deve funcionar pelo navegador, tanto no computador quanto no celular. |
| RNF02 | A área administrativa deve exigir login e senha, com as senhas armazenadas de forma segura (criptografadas). |

### 2.3 Regras de negócio

| ID | Regra |
|---|---|
| RN01 | Um barbeiro não pode ter dois agendamentos ativos no mesmo horário ou em horários que se sobreponham, considerando a duração do serviço. Se um agendamento futuro for cancelado, o horário volta a ficar disponível. |
| RN02 | Não pode ser feito agendamento para uma data ou horário que já passou. |

Para a lista de atrasados, a ideia é considerar o agendamento que já passou do horário marcado e continua pendente, sem estar concluído ou cancelado.

---

## 3. Histórias de usuário

**HU01 — Escolher um barbeiro**

Como cliente, quero escolher o barbeiro e ver os horários livres, para conseguir marcar meu corte com quem eu prefiro.

- Critério de aceite 1: ao escolher um barbeiro e uma data, o sistema mostra apenas os horários em que ele pode atender.
- Critério de aceite 2: um horário já reservado para aquele barbeiro não aparece como disponível para outra reserva.

**HU02 — Fazer um agendamento**

Como cliente, quero agendar um serviço em um dia e horário, para garantir meu atendimento na barbearia.

- Critério de aceite 1: não é possível confirmar um agendamento em um horário que já passou.
- Critério de aceite 2: depois de confirmar, o agendamento fica registrado com o serviço, barbeiro, data, horário e situação da reserva.

**HU03 — Acompanhar a agenda**

Como administrador, quero ver os horários marcados e cancelar agendamentos, para manter a agenda organizada.

- Critério de aceite 1: o administrador consegue consultar os agendamentos e identificar quais estão atrasados.
- Critério de aceite 2: quando o administrador cancela um agendamento futuro, ele muda para cancelado e deixa de bloquear o horário.

---


## 4. Como executar

### No computador (VS Code)

1. Instale o **JDK 21** e o **Extension Pack for Java** no VS Code.
2. Abra a pasta do projeto no VS Code.
3. Localize `src/main/java/br/senai/sistema/SistemaApplication.java`.
4. Clique em **Run** acima do método `main` e espere o Spring Boot iniciar.
5. Acesse `http://localhost:8080` no navegador.

### No GitHub Codespaces

1. No repositório, clique em **Code → Codespaces → Create codespace on main** (ou abra o Codespace existente).
2. Espere o ambiente carregar.
3. No terminal, execute:

   ```bash
   mvn spring-boot:run
   ```

4. Abra a aplicação na porta **8080**.

### Acesso de teste

O projeto modelo já traz estes usuários de exemplo:

| Usuário | Senha | Perfil |
|---|---|---|
| `admin` | `admin123` | Administrador |
| `operador` | `operador123` | Operador |

**Observação:** o login ainda não é exigido nesta etapa. A segurança será ativada no Encontro 7. Esses dados são apenas para testes e não devem ser usados em produção.

---

## 5. Tecnologias

Java 21, Spring Boot 4, Spring MVC, Thymeleaf, Bootstrap 5, Spring Data JPA, H2 (desenvolvimento), MySQL (produção), Spring Security, Git e GitHub.

---

## 6. Uso de inteligência artificial

Usei o ChatGPT como apoio para organizar as ideias do projeto e para verificar erros, nenhum codigo sera escrito com ele

---

## 7. Histórico de versões

| Versão | Data | Descrição |
|---|---|---|
| 0.1.0 | | Projeto inicial criado a partir do modelo do curso, com ambiente configurado e documentação do BarberShop. |
